package ebd.trainStatusManager.util.supervisors;

import ebd.globalUtils.appTime.AppTime;
import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.messageSender.SendETCSMessageEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainStatusMananger.*;
import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.location.Location;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.message.trainmessages.Message_136;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.packet.trainpackets.Packet_1;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.dataConstructs.IncrPosRprtDist;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * This class supervises the issuing of position reports from the train to the rbc.
 *
 * @author Lars Schulze-Falck
 */
public class PositionReportSupervisor {

    //TODO Respect IncrementalPositionReportDistances
    //TODO Fully Respect SRS 3.6.5

    private EventBus localBus;
    private TrainDataVolatile trainDataVolatile;
    private String etcsTrainID;
    private double lengthTrain;
    private int lastLocationID;

    //private int t_cycle = ETCSVariables.T_CYCLOC;
    private double tripTimeAtCycleStart = 0d;

    //private double d_cycle = ETCSVariables.D_CYCLOC;
    private double tripDistanceAtCycleStart = 0d;
    private int d_cycleNumber = 1;

    private double curFullTripTime = 0;
    private String rbcID;

    private IncrPosRprtDist positionReportDistances = null;

    /**
     * Constructor
     * @param localBus the local {@link EventBus}
     * @param etcsTrainID the ETCS ID of the train
     * @param rbcID the current RBC ID
     */
    public PositionReportSupervisor(EventBus localBus, String etcsTrainID, String rbcID){
        this.localBus = localBus;
        this.localBus.register(this);
        this.etcsTrainID = etcsTrainID;

        this.trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        TrainDataPerma trainDataPerma = localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.lengthTrain = trainDataPerma.getL_train();
        this.lastLocationID = (new InitalLocation()).getId();

        this.rbcID = rbcID; //TODO: Make updateable
    }

    /**
     * This method listens to clock tick events and checks on every tick if the requisites for sending a position
     * report are fulfilled and, should this be true, issues such a report.
     * @param cte A {@link ClockTickEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void clockTick(ClockTickEvent cte){
        this.curFullTripTime += cte.deltaT;
        int t_cycle = trainDataVolatile.getT_CYCLOC();
        if(t_cycle != ETCSVariables.T_CYCLOC && t_cycle < ETCSVariables.T_CYCLOC_INFINITY){
            double curTime = this.curFullTripTime - this.tripTimeAtCycleStart;
            //double curCycleNumber = curTime / t_cycle;
            if(curTime > t_cycle){
                //this.t_cycleNumber = (int)curCycleNumber + 1;
                sendPositionReport();
            }
        }

        double distCycleLoc = trainDataVolatile.getDistanceCycleLocation();
        if(distCycleLoc != ETCSVariables.D_CYCLOC && distCycleLoc < Double.MAX_VALUE){
            double curDistance = trainDataVolatile.getCurTripDistance() - this.tripDistanceAtCycleStart;
            double curCylceNumber = curDistance / distCycleLoc;
            if(curCylceNumber > this.d_cycleNumber){
                this.d_cycleNumber = (int)curCylceNumber + 1;
                sendPositionReport();
            }
        }

        if(trainDataVolatile.getM_LOC() == ETCSVariables.M_LOC_NOW){
            sendPositionReport();
            this.localBus.post(new TrainDataChangeEvent("tsm", "td", "M_LOC", ETCSVariables.M_LOC_NOT_AT_BALISE_GROUP));
        }
    }

    /**
     * This method listens to crossed balise group events, checks if this should result in sending a position report and
     * sends it if true.
     * @param cbge A {@link CrossedBaliseGroupEvent}
     */
    @Subscribe
    public void crossedBaliseGroup(CrossedBaliseGroupEvent cbge){
        if(!validTarget(cbge.target)){
            return;
        }

        if(trainDataVolatile.getM_LOC() == ETCSVariables.M_LOC_AT_BALISE_GROUP){
            sendPositionReport();
        }
    }

    /**
     * This method listens to new location events, checks if this should result in sending a position report and
     * sends it if true.
     * @param nle A {@link NewLocationEvent}
     */
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void newLocation(NewLocationEvent nle){
        if(!validTarget(nle.target)) return;

        if(lastLocationID == nle.newLocation.getId()) return;
        if(trainDataVolatile.getM_LOC() == ETCSVariables.M_LOC_AT_BALISE_GROUP){
            sendPositionReport();;
        }
        this.lastLocationID = nle.newLocation.getId();
    }

    /**
     * Listens to new position report parameter events and updates the parameters from {@link TrainDataVolatile}
     * @param nprpe A {@link NewPositionReportParametersEvent}
     */
    @Subscribe
    public void newPositionReportParameters(NewPositionReportParametersEvent nprpe){
        if(!validTarget(nprpe.target)){
            return;
        }

        this.tripDistanceAtCycleStart = trainDataVolatile.getCurTripDistance();
        this.d_cycleNumber = 1;
        this.tripTimeAtCycleStart = this.curFullTripTime;
    }

    @Subscribe
    public void singleBaliseGroup(SingleBaliseGroupEvent sbge){
        Position curPos = trainDataVolatile.getCurrentPosition();
        Location prevLoc;
        if(curPos.getLocation().getId() == sbge.newLoc.getIdOfPrevious()) prevLoc = curPos.getLocation();
        else prevLoc = curPos.getPreviousLocations().get(sbge.newLoc.getIdOfPrevious());

        Message_136 message136 = new Message_136();
        message136.NID_ENGINE = Integer.parseInt(this.etcsTrainID);
        long curTime = AppTime.currentTimeMillis() / 10L;
        message136.T_TRAIN = curTime % ETCSVariables.T_TRAIN_UNKNOWN;

        Packet_1 packet1 = new Packet_1();
        packet1.NID_LRBG =curPos.getLocation().getId();
        packet1.NID_PRVLRBG = prevLoc.getId();
        packet1.NID_NTC = ETCSVariables.NID_NTC;
        packet1.D_LRBG = (int)curPos.getIncrement() + 1;
        packet1.Q_SCALE = 1; //All length values have to be in the resolution of [m]!
        packet1.Q_DIRLRBG = 1; //TODO Get this value, in fact, remember this value in the first hand
        packet1.Q_DIRTRAIN = curPos.getDirection();
        packet1.Q_LENGTH = ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER; //TODO Get this value!
        packet1.L_TRAININT = (int)this.lengthTrain + 1;
        packet1.L_DOUBTOVER = 10; //TODO Get this value, in fact, remember this value in the first hand
        packet1.L_DOUBTUNDER = 10; //TODO Get this value, in fact, remember this value in the first hand
        packet1.V_TRAIN = (int)(trainDataVolatile.getCurrentSpeed() * 3.6) / 5;
        packet1.M_LEVEL = trainDataVolatile.getCurrentETCSLevel().getValueForETCSPacket();
        packet1.M_MODE = trainDataVolatile.getCurrentETCSMode().getValueForETCSPacket();

        message136.positionPacket = packet1;
        this.localBus.post(new SendETCSMessageEvent("tsm", "ms", message136, "mr;R=" + this.rbcID)); //TODO Message136 has to work
        this.localBus.post(new ToLogEvent("tsm", "log", "Sending Position Report"));
    }

    /**
     * Builds a position report message ({@link Message_136}) and places it on the local {@link EventBus}
     * in a {@link SendETCSMessageEvent} so the local {@link ebd.messageReceiver.MessageReceiver} can send it to the RBC
     */
    private void sendPositionReport() {
        Position curPos = trainDataVolatile.getCurrentPosition();

        Message_136 message136 = new Message_136();
        message136.NID_ENGINE = Integer.parseInt(this.etcsTrainID);
        long curTime = AppTime.currentTimeMillis() / 10L;
        message136.T_TRAIN = curTime % ETCSVariables.T_TRAIN_UNKNOWN;

        Packet_0 packet0 = new Packet_0();
        packet0.NID_LRBG = curPos != null ? curPos.getLocation().getId() : 0;
        packet0.NID_NTC = ETCSVariables.NID_NTC;
        packet0.D_LRBG = (int)curPos.getIncrement() + 1;
        packet0.Q_SCALE = 1; //All length values have to be in the resolution of [m]!
        packet0.Q_DIRLRBG = 1; //TODO Get this value, in fact, remember this value in the first hand
        packet0.Q_DIRTRAIN = curPos.getDirection();
        packet0.Q_LENGTH = ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER; //TODO Get this value!
        packet0.L_TRAININT = (int)this.lengthTrain + 1;
        packet0.L_DOUBTOVER = 10; //TODO Get this value, in fact, remember this value in the first hand
        packet0.L_DOUBTUNDER = 10; //TODO Get this value, in fact, remember this value in the first hand
        packet0.V_TRAIN = (int)(trainDataVolatile.getCurrentSpeed() * 3.6) / 5;
        packet0.M_LEVEL = trainDataVolatile.getCurrentETCSLevel().getValueForETCSPacket();
        packet0.M_MODE = trainDataVolatile.getCurrentETCSMode().getValueForETCSPacket();

        message136.positionPacket = packet0;
        this.localBus.post(new SendETCSMessageEvent("tsm", "ms", message136, "mr;R=" + this.rbcID)); //TODO Message136 has to work
        this.localBus.post(new ToLogEvent("tsm", "log", "Sending Position Report"));
        this.tripTimeAtCycleStart = this.curFullTripTime;
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param target the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(String target){


        if(target.contains("tsm") || target.contains("all")) {
            if (!target.contains(";")) {
                return true;

            } else if (target.contains(";T=" + this.etcsTrainID)) {
                return true;
            }
        }
        return false;
    }

}
