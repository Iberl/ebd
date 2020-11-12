package ebd.trainData;


import ebd.globalUtils.events.logger.ToLogEvent;
import ebd.globalUtils.events.trainData.TrainDataChangeEvent;
import ebd.globalUtils.events.trainData.TrainDataMultiChangeEvent;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainData.util.dataConstructs.Locomotive;
import ebd.trainData.util.dataConstructs.LocomotiveTrain;
import ebd.trainData.util.dataConstructs.TrainCar;
import ebd.trainData.util.events.NewTrainDataPermaEvent;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import ebd.trainData.util.events.TrainDataExceptionEvent;
import ebd.trainData.util.exceptions.TDBadDataException;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * @custom.shorthand td
 * @author Lars Schulze-Falck
 * @version 0.1
 */
public class TrainData {
    private final EventBus localBus;
    private final int etcsID;
    private final int trainConfigID;
    private final int infrastructureID;
    private TrainDataPerma trainDataPerma;
    private final TrainDataVolatile trainDataVolatile;

    private final String exceptionTarget = "tsm;";
    private final String eventTarget = "all;";

    /**
     * This constructor sets the {@link TrainDataPerma} and {@link TrainDataVolatile} of the class from a url
     * @param localBus The local {@link EventBus} of the train
     * @param etcsID The ETCS ID of the train
     * @param trainConfigID The ID used to request this train from the TrainConfig tool
     * @param infrastructureID The ID of the model train on the infrastructure server
     */
    public TrainData(EventBus localBus, int etcsID, int trainConfigID, int infrastructureID){
        this.localBus = localBus;
        this.localBus.register(this);
        this.etcsID = etcsID;
        this.trainConfigID = trainConfigID;
        this.infrastructureID = infrastructureID;

        try {
            this.trainDataPerma = new TrainDataPerma(this.trainConfigID);
        } catch (IOException | ParseException e) {
            localBus.post(new TrainDataExceptionEvent("td", this.exceptionTarget, new NotCausedByAEvent(), e, ExceptionEventTyp.FATAL));
        } catch (TDBadDataException e) {
            localBus.post(new TrainDataExceptionEvent("td", this.exceptionTarget, new NotCausedByAEvent(), e));
        }
        this.localBus.postSticky(new NewTrainDataPermaEvent("td", this.eventTarget, this.trainDataPerma));
        this.trainDataVolatile = new TrainDataVolatile(etcsID, trainConfigID, infrastructureID, localBus);
        localBus.postSticky(new NewTrainDataVolatileEvent("td", this.eventTarget, this.trainDataVolatile));
        sendToLog();
    }

    /**
     * This is the listener to the {@link TrainDataChangeEvent}.
     * It takes the included data and feeds it to the {@link TrainDataVolatile}
     *
     * @param trainDataChangeEvent {@link TrainDataChangeEvent}
     */
    @Subscribe
    public void changeInTrainData(TrainDataChangeEvent trainDataChangeEvent){

        try {
            changeTrainDataVolatile(trainDataChangeEvent.fieldName,trainDataChangeEvent.fieldValue);
            //this.localBus.postSticky(new NewTrainDataVolatileEvent("td;", this.eventTargets, this.trainDataVolatile));
        } catch (IllegalAccessException e) {
           this.localBus.post(new TrainDataExceptionEvent("td",this.exceptionTarget,trainDataChangeEvent,e));
        }
    }

    /**
     * This is the listener to the {@link TrainDataMultiChangeEvent}.
     * It takes the included data and feeds it to the {@link TrainDataVolatile}
     *
     * @param trainDataMultiChangeEvent {@link TrainDataMultiChangeEvent}
     */
    @Subscribe
    public void changesInTrainData(TrainDataMultiChangeEvent trainDataMultiChangeEvent){
        Map<String,Object> nameToValue = trainDataMultiChangeEvent.fieldNameToFieldValue;
        try{
            for (String key : nameToValue.keySet()){
                changeTrainDataVolatile(key,nameToValue.get(key));
            }
            //this.localBus.postSticky(new NewTrainDataVolatileEvent("td;", this.eventTargets, this.trainDataVolatile));
        }catch (IllegalAccessException | IllegalArgumentException e){
            this.localBus.post(new TrainDataExceptionEvent("td",this.exceptionTarget,trainDataMultiChangeEvent,e));
        }
    }


    /**
     * Takes a field name and a field value and updates {@link TrainDataVolatile}
     *
     * @param fieldName A valid field of {@link TrainDataVolatile}
     * @param fieldValue a valid value for this field
     */
    private void changeTrainDataVolatile(String fieldName, Object fieldValue)
            throws IllegalAccessException, IllegalArgumentException {
        for (Field field : this.trainDataVolatile.getClass().getDeclaredFields()){

            if (field.getName().equals(fieldName)) {
                try {

                    field.set(this.trainDataVolatile, fieldValue);

                } catch (IllegalAccessException e) {
                    String msg = String.format("Field %s was not accessible. %n", fieldName);
                    msg += " " + e.getMessage();
                    IllegalAccessException iAccE = new IllegalAccessException(msg);
                    iAccE.setStackTrace(e.getStackTrace());
                    throw iAccE;
                } catch (IllegalArgumentException e){
                    String msg = String.format("Passed fieldValue with type %s did not match field %s with the type %s.%n", fieldValue.getClass(), field.getName(), field.getType());
                    msg += " " + e.getMessage();
                    IllegalArgumentException iAE = new IllegalArgumentException(msg);
                    iAE.setStackTrace(e.getStackTrace());
                    throw iAE;
                }

                return;
            }
        }
        String msg = String.format("fieldName %s was not found in fields of %s", fieldName, this.trainDataVolatile.getClass());
        throw new IllegalArgumentException(msg);
    }

    private void sendToLog() {
        String msg1;
        StringBuilder msg2 = new StringBuilder();
        double mass = this.trainDataPerma.getTrainWeight() / 1000;
        double length = this.trainDataPerma.getL_train();
        int maxSpeed = this.trainDataPerma.getV_maxtrain();
        int uic = -1;
        String[] carlist = new String[this.trainDataPerma.trainCarList.size()];
        for (TrainCar tc : this.trainDataPerma.trainCarList){
            if(tc.getTypeName() == "Triebzug"){
                uic =  ((LocomotiveTrain)tc).getUicID();
            }
            else if(tc.getTypeName() == "Triebfahrzeug"){
                uic = ((Locomotive)tc).getUicID();
            }
            if(tc.getPositionInTrain() < carlist.length){
                carlist[tc.getPositionInTrain()] = tc.getTypeName();
            }
            else System.err.println("Trainconfigurator data was malformed, traincar has a position outside the train");
        }

        msg1 = String.format("Traindata: ETCS ID = %d; Mass = %.2f t; Length = %.2f m; Max Speed = %d km/h; Type = %d",
                this.etcsID, mass, length, maxSpeed, uic);
        msg2.append("Traincomposition: ");
        for(int i = 0; i < carlist.length; i++){
            if(i == 0){
                msg2.append("<[" + carlist[0] + "]");
            }
            else {
                msg2.append("-[" + carlist[i] + "]");
            }
        }
        this.localBus.post(new ToLogEvent("td", "log", msg1));
        this.localBus.post(new ToLogEvent("td", "log", msg2.toString()));
    }

    /*
    Getter
     */
    public TrainDataVolatile getTrainDataVolatile(){
        return this.trainDataVolatile;
    }

    public TrainDataPerma getTrainDataPerma(){
        return this.trainDataPerma;
    }
}

