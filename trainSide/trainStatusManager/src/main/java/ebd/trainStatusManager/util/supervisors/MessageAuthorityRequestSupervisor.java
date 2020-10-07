package ebd.trainStatusManager.util.supervisors;

import ebd.breakingCurveCalculator.BreakingCurve;
import ebd.breakingCurveCalculator.utils.events.NewBreakingCurveEvent;
import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * This class supervises the movement authority requests. It takes the movement request parameter
 * received from rbc and stored in {@link TrainDataVolatile} and issues movement requests accordingly.<br>
 * It gets
 *
 * @author Lars Schulze-Falck
 */
public class MessageAuthorityRequestSupervisor {
    private EventBus localBus;
    private TrainDataVolatile trainDataVolatile;
    private String etcsTrainID;
    private String rbcID; //TODO: make updateable

    private boolean waitingOnMA = false;

    /**
     * In [m]
     */
    private double lengthTrain;

    /**
     * In [s]
     */
    private double timeAtRequest = -1;
    private int lastQ_MARQSTREASON;
    private BreakingCurve breakingCurve = null;

    /**
     * Constructor
     * @param localBus the local {@link EventBus}
     * @param etcsTrainID the ETCS ID of the train
     * @param rbcID the current RBC ID
     */
    public MessageAuthorityRequestSupervisor(EventBus localBus, String etcsTrainID, String rbcID){
        this.localBus = localBus;
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.localBus.register(this);
        this.trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.lengthTrain = trainDataPerma.getL_train();
    }

    /**
     * On every clock tick, this methods checks if the prerequisites for a movement request are fulfilled and sends out
     * these requests accordingly
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){

        double t_mar = trainDataVolatile.getT_MAR();
        double t_timeoutrqst = trainDataVolatile.getT_TIMEOUTRQST();
        double t_cycrqst = trainDataVolatile.getT_CYCRQST();
        //TODO Do the calculation of time to EOL with higher precision
        double distanceToEOL = 0;
        if(this.breakingCurve != null){
            distanceToEOL = this.breakingCurve.getHighestXValue();
            distanceToEOL -= trainDataVolatile.getCurTripSectionDistance();
        }

        double curSpeed = trainDataVolatile.getCurrentSpeed();
        double timeToEOL;
        if(distanceToEOL == 0 || curSpeed == 0){
            timeToEOL = 0;
        }
        else {
            timeToEOL = distanceToEOL / curSpeed;
        }
        if(t_mar != ETCSVariables.T_MAR && t_mar < ETCSVariables.T_MAR_INFINITY){
            if (timeToEOL <= t_mar){
                double deltaT = AppTime.currentTimeMillis() / 1000d - timeAtRequest;

                if(!this.waitingOnMA || deltaT > 10){
                this.timeAtRequest = AppTime.currentTimeMillis() / 1000d;
                this.lastQ_MARQSTREASON = 2;
                sendMaRequest();
                }
            }
        }

/*
        if(t_timeoutrqst != ETCSVariables.T_TIMEOUTRQST && t_timeoutrqst < ETCSVariables.T_TIMEOUTRQST_INFINITY){
            //TODO Implement
        }
*/

        double deltaT = (AppTime.currentTimeMillis() / 1000d) - this.timeAtRequest;
        if(t_cycrqst != ETCSVariables.T_CYCRQST && t_cycrqst < ETCSVariables.T_CYCRQST_INFINITY && t_cycrqst < deltaT){
            this.timeAtRequest = AppTime.currentTimeMillis() / 1000d;
            sendMaRequest();
        }
    }

    @Subscribe
    public void newBC(NewBreakingCurveEvent bce){
        this.breakingCurve = bce.curveGroup.getNormalBreakingCurve();
        this.waitingOnMA = false;
    }

    private void sendMaRequest(){


        Position curPos = trainDataVolatile.getCurrentPosition();
        if(curPos == null) return;

        Packet_0 packet0 = new Packet_0();
        packet0.NID_LRBG = curPos.getLocation() != null ? curPos.getLocation().getId() : ETCSVariables.NID_LRBG_UNKNOWN;
        packet0.NID_NTC = ETCSVariables.NID_NTC;
        packet0.D_LRBG = (int)(curPos.getIncrement() * 10);
        packet0.Q_SCALE = 0; //All length values have to be in the resolution of 10 cm!
        packet0.Q_DIRLRBG = 1; //TODO Get this value, in fact, remember this value in the first hand
        packet0.Q_DIRTRAIN = curPos.getDirection();
        packet0.Q_LENGTH = ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER; //TODO Get this value!
        packet0.L_TRAININT = (int)(this.lengthTrain * 10);
        packet0.L_DOUBTOVER = 100; //TODO Get this value, in fact, remember this value in the first hand
        packet0.L_DOUBTUNDER = 100; //TODO Get this value, in fact, remember this value in the first hand
        packet0.V_TRAIN = (int)(trainDataVolatile.getCurrentSpeed() * 3.6) / 5;
        packet0.M_LEVEL = ETCSVariables.M_LEVEL_2;
        packet0.M_MODE = ETCSVariables.M_MODE_FULL_SUPERVISION; //TODO Get this value, in fact, remember this value in the first hand

        Message_132 message132 = new Message_132();
        long curTime = AppTime.currentTimeMillis() / 10L;
        message132.T_TRAIN = curTime % ETCSVariables.T_TRAIN_UNKNOWN;
        message132.Q_MARQSTREASON = this.lastQ_MARQSTREASON;
        message132.NID_ENGINE = Integer.parseInt(this.etcsTrainID);
        message132.positionPacket = packet0;

        String destination = "mr;R=" + this.rbcID;
        this.localBus.post(new SendETCSMessageEvent("tsm", "ms", message132, destination));
        this.localBus.post(new ToLogEvent("tsm", "log", "Sending a MA Request"));

        this.waitingOnMA = true;
    }
}
