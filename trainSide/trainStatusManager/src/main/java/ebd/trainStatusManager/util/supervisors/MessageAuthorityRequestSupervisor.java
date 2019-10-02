package ebd.trainStatusManager.util.supervisors;

import ebd.globalUtils.etcsPacketToSplineConverters.MovementAuthorityConverter;
import ebd.globalUtils.events.messageSender.SendMessageEvent;
import ebd.globalUtils.events.trainStatusMananger.ClockTickEvent;
import ebd.globalUtils.events.trainStatusMananger.NewMaMessage;
import ebd.globalUtils.events.trainStatusMananger.NewMaRequest;
import ebd.globalUtils.events.trainStatusMananger.NewMaRequestParametersEvent;
import ebd.globalUtils.position.Position;
import ebd.messageLibrary.message.trainmessages.Message_132;
import ebd.messageLibrary.packet.trackpackets.Packet_15;
import ebd.messageLibrary.packet.trainpackets.Packet_0;
import ebd.messageLibrary.util.ETCSVariables;
import ebd.routeData.RouteDataVolatile;
import ebd.routeData.util.events.NewRouteDataVolatileEvent;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.TrainDataVolatile;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Collections;
import java.util.List;

public class MessageAuthorityRequestSupervisor {

    private EventBus localBus;
    private String etcsTrainID;
    private String rbcID;
    double lengthTrain;

    /**
     * In [s]
     */
    private double timeAtRequest = -1;
    private int lastQ_MARQSTREASON;

    public MessageAuthorityRequestSupervisor(EventBus localBus, String etcsTrainID, String rbcID){
        this.localBus = localBus;
        this.etcsTrainID = etcsTrainID;
        this.rbcID = rbcID;
        this.localBus.register(this);
        TrainDataPerma trainDataPerma = this.localBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.lengthTrain = trainDataPerma.getL_train();
    }

    @Subscribe
    public void clockTick(ClockTickEvent cte){

        TrainDataVolatile trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;
        RouteDataVolatile routeDataVolatile = this.localBus.getStickyEvent(NewRouteDataVolatileEvent.class).routeDataVolatile;

        Packet_15 p15 = routeDataVolatile.getPacket_15();
        double t_mar = trainDataVolatile.getT_MAR();
        double t_timeoutrqst = trainDataVolatile.getT_TIMEOUTRQST();
        double t_cycrqst = trainDataVolatile.getT_CYCRQST();
        //TODO Do the calculation of time to EOL correctly!
        double distanceToEOL = MovementAuthorityConverter.p15ToD_EMA(p15) - trainDataVolatile.getCurTripDistance();
        double curSpeed = trainDataVolatile.getCurrentSpeed();
        double timeToEOL = distanceToEOL / curSpeed;

        if(t_mar != ETCSVariables.T_MAR && t_mar < ETCSVariables.T_MAR_INFINITY){
            if (t_mar <= timeToEOL){
                this.timeAtRequest = System.currentTimeMillis() / 1000d;
                this.lastQ_MARQSTREASON = 2;
                sendMaRequest();
            }
        }

        if(t_timeoutrqst != ETCSVariables.T_TIMEOUTRQST && t_timeoutrqst < ETCSVariables.T_TIMEOUTRQST_INFINITY){
            //TODO Implement
        }

        double deltaT = (System.currentTimeMillis() / 1000d) - this.timeAtRequest;
        if(t_cycrqst != ETCSVariables.T_CYCRQST && t_cycrqst < ETCSVariables.T_TIMEOUTRQST_INFINITY && t_cycrqst < deltaT){
            this.timeAtRequest = System.currentTimeMillis() / 1000d;
            sendMaRequest();
        }
    }

    @Subscribe
    public void newParameter(NewMaRequestParametersEvent nmrpe){
        return;
    }

    @Subscribe
    public void newMaRequest(NewMaRequest nmr){
        this.timeAtRequest = System.currentTimeMillis() / 1000d;
        this.lastQ_MARQSTREASON = nmr.Q_MARQSTREASON;
    }

    @Subscribe
    public void newMaMessage(NewMaMessage nmm){
        this.timeAtRequest = -1;
    }

    private void sendMaRequest(){
        TrainDataVolatile trainDataVolatile = this.localBus.getStickyEvent(NewTrainDataVolatileEvent.class).trainDataVolatile;


        Position curPos = trainDataVolatile.getCurrentPosition();

        Packet_0 packet0 = new Packet_0();
        packet0.NID_LRBG = curPos.getLocation() != null ? curPos.getLocation().getId() : 0;
        packet0.NID_NTC = ETCSVariables.NID_NTC;
        packet0.D_LRBG = (int)(curPos.getIncrement() * 10);
        packet0.Q_SCALE = 0; //All length values have to be in the resolution of 10 cm!
        packet0.Q_DIRLRBG = 1; //TODO Get this value, in fact, remember this value in the first hand
        packet0.Q_DIRTRAIN = curPos.isDirectedForward() ? 1 : 0;
        packet0.Q_LENGTH = ETCSVariables.Q_LENGTH_CONFIRMED_BY_DRIVER; //TODO Get this value!
        packet0.L_TRAININIT = (int)(this.lengthTrain * 10);
        packet0.L_DOUBTOVER = 100; //TODO Get this value, in fact, remember this value in the first hand
        packet0.L_DOUBTUNDER = 100; //TODO Get this value, in fact, remember this value in the first hand
        packet0.V_TRAIN = (int)(trainDataVolatile.getCurrentSpeed() * 3.6) / 5;
        packet0.M_LEVEL = ETCSVariables.M_LEVEL_2;
        packet0.M_MODE = ETCSVariables.M_MODE_FULL_SUPERVISION; //TODO Get this value, in fact, remember this value in the first hand

        Message_132 message132 = new Message_132();
        long curTime = System.currentTimeMillis() / 10L;
        message132.T_TRAIN = curTime % ETCSVariables.T_TRAIN_UNKNOWN;
        message132.Q_MARQSTREASON = this.lastQ_MARQSTREASON;
        message132.NID_ENGINE = Integer.parseInt(this.etcsTrainID);
        message132.PACKET_POSITION = packet0;

        List<String> destinations = Collections.singletonList("mr;R=" + this.rbcID);
        this.localBus.post(new SendMessageEvent("tsm", Collections.singletonList("ms"), message132, destinations));
    }
}
