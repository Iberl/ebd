package ebd.drivingDynamics.util;

import ebd.drivingDynamics.DynamicState;
import ebd.drivingDynamics.util.events.DrivingDynamicsExceptionEvent;
import ebd.globalUtils.events.core.ATOEndEvent;
import ebd.globalUtils.events.core.ATOStartEvent;
import ebd.globalUtils.events.core.ATOToTrainUpdateEvent;
import ebd.globalUtils.events.core.TrainToAtoUpdateEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.enums.MovementState;
import ebd.trainData.TrainDataPerma;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.JSONObject;

public class ATOServerConnector {

    private final EventBus globalEventBus = EventBus.getDefault();
    private final String etcsID;
    private final String source;
    private final TrainDataPerma trainDataPerma;

    private boolean atoOn = false;
    private MovementState curMovementState = MovementState.UNCHANGED;
    private double curModifier = 1;

    public ATOServerConnector(EventBus localEventBus, int etcsID){
        this.globalEventBus.register(this);
        trainDataPerma = localEventBus.getStickyEvent(NewTrainDataPermaEvent.class).trainDataPerma;
        this.etcsID = String.valueOf(etcsID);
        this.source = "dd;T=" + this.etcsID;
    }

    /**
     * Starts ATO and sends TrainDataPerma to ATO
     * @param se a {@link ATOStartEvent}
     */
    @Subscribe
    public void startATO(ATOStartEvent se){
        if(!validTarget(se.target)) return;

        sendTrainJSONToATO();
        this.atoOn = true;
    }

    /**
     * Ends ATO
     * @param ee a {@link ATOEndEvent}
     */
    @Subscribe
    public void endATO(ATOEndEvent ee){
        if(!validTarget(ee.target)) return;
        this.atoOn = false;
    }

    @Subscribe
    public void newAction(ATOToTrainUpdateEvent ttue){
        if(!validTarget(ttue.target)) return;
        IllegalArgumentException iae = new IllegalArgumentException("ATO to Train input was not correctly formated");
        DrivingDynamicsExceptionEvent ddee = new DrivingDynamicsExceptionEvent(this.source, "all", ttue, iae, ExceptionEventTyp.WARNING);

        String[] split = ttue.information.split(" ");
        if(split.length < 2) {
            this.globalEventBus.post(ddee);
            return;
        }
        try{
            this.curMovementState = MovementState.valueOf(split[1]);
            if(split.length > 2) this.curModifier = Double.parseDouble(split[2]);
        }
        catch (ClassCastException | NumberFormatException e){
            this.globalEventBus.post(ddee);
            return;
        }
    }

    /**
     * Sends the dynamicState to ATO
     * @param dynamicState s. {@link DynamicState}
     */
    public void sendDynamicStateToATO(DynamicState dynamicState){
        StringBuilder sb = new StringBuilder();
        sb.append("TripTime=").append(dynamicState.getTime()).append(" ");
        sb.append(dynamicState.getPosition().toString()).append(" ");
        sb.append("SpeedInMS=").append(String.format("%.2f", dynamicState.getSpeed())).append(" ");
        sb.append("AccInMS^2=").append(String.format("%.2f", dynamicState.getAcceleration())).append(" ");
        sb.append("MovementState=").append(dynamicState.getMovementState());
        sendToATO(sb.toString());
    }

    /**
     * Sends the TrainData JSON that underpins TrainDataPerma to the ATOServer
     */
    private void sendTrainJSONToATO(){
        JSONObject jsonObject = trainDataPerma.getJsonObject();
        sendToATO(jsonObject.toString());
    }

    /**
     * Appends the etcsID and send the String to the ATO Server
     * @param string Information to send
     */
    private void sendToATO(String string){
        String msg = etcsID + " " + string;
        this.globalEventBus.post(new TrainToAtoUpdateEvent(this.source, "core", msg));
    }

    /**
     * True if this Instance is a vaild target of the event
     * @param target the target list a the event
     * @return True if this instance is a vaild target of the event
     */
    private boolean validTarget(String target) {

        if (target.contains("dd") || target.contains("all")) {
            if (!target.contains(";")) {
                return true;
            } else return target.contains(";T=" + this.etcsID);
        }
        return false;
    }

    /**
     * Getter
     */
    public boolean isAtoOn(){
        return this.atoOn;
    }

    public double getCurModifier() {
        return curModifier;
    }

    public MovementState getCurMovementState() {
        return curMovementState;
    }
}
