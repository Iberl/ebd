package ebd.trainData;


import ebd.globalUtils.events.trainData.*;
import ebd.globalUtils.events.util.ExceptionEventTyp;
import ebd.globalUtils.events.util.NotCausedByAEvent;
import ebd.trainData.util.availableAcceleration.AvailableAcceleration;
import ebd.trainData.util.events.NewTrainDataVolatileEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.simple.parser.ParseException;
import ebd.trainData.util.events.TrainDataExceptionEvent;
import ebd.trainData.util.exceptions.TDBadDataException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @custom.shorthand td
 * @author Lars Schulze-Falck
 * @version 0.1
 */
public class TrainData {
    private EventBus eventBus;
    private TrainDataPerma trainDataPerma;
    private TrainDataVolatile trainDataVolatile = new TrainDataVolatile();

    private List<String> exceptionTargets = new ArrayList<>();
    private List<String> eventTargets = new ArrayList<>();

    /**
     * This constructor sets the {@link TrainDataPerma} and {@link TrainDataVolatile} of the class
     *
     * @param eventBus The local {@link EventBus} of the train
     *
     * @param trainConfiguratorURL The ip to the trainconfigurator tool
     *
     * @param trainID the ETCS-ID of the train
     */
    public TrainData(EventBus eventBus, String trainConfiguratorURL, String trainID){
        this.eventBus = eventBus;
        this.eventBus.register(this);
        this.exceptionTargets.add("tsm;"); //TODO check right recipient
        this.eventTargets.add("all;");
        try {
            this.trainDataPerma = new TrainDataPerma(trainConfiguratorURL, trainID);
        } catch (IOException e) {
            eventBus.post(new TrainDataExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e, ExceptionEventTyp.FETAL));
        } catch (ParseException e) {
            eventBus.post(new TrainDataExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e, ExceptionEventTyp.FETAL));
        } catch (TDBadDataException e) {
            eventBus.post(new TrainDataExceptionEvent("td", this.exceptionTargets, new NotCausedByAEvent(), e));
        }
        this.eventBus.postSticky(this.trainDataPerma);
        this.trainDataVolatile.availableAcceleration = new AvailableAcceleration(eventBus);
        eventBus.postSticky(new NewTrainDataVolatileEvent("td", this.eventTargets, this.trainDataVolatile));
    }

    /**
     * This is the listener to the {@link TrainDataChangeEvent}.
     * It takes the included data and feeds it to the {@link TrainDataVolatile}
     *
     * @param trainDataChangeEvent
     */
    @Subscribe
    public void changeInTrainData(TrainDataChangeEvent trainDataChangeEvent){

        for (Field field : this.trainDataVolatile.getClass().getDeclaredFields()){

            if (field.getName().equals(trainDataChangeEvent.fieldName)) {
                try {

                    field.set(this.trainDataVolatile, trainDataChangeEvent.fieldValue);
                    this.eventBus.postSticky(new NewTrainDataVolatileEvent("ttd;", this.eventTargets, this.trainDataVolatile));

                } catch (IllegalAccessException e) {
                    String msg = String.format("Field %s was not accessible. %n", trainDataChangeEvent.fieldName);
                    msg += " " + e.getMessage();
                    IllegalAccessException exception = new IllegalAccessException(msg);
                    exception.setStackTrace(e.getStackTrace());
                    this.eventBus.post(new TrainDataExceptionEvent("ttd;", this.exceptionTargets, trainDataChangeEvent, exception));
                } catch (IllegalArgumentException e){
                    String msg = String.format("Passed fieldValue with type %s did not match field %s with the type %s.%n", trainDataChangeEvent.fieldValue.getClass(), field.getName(), field.getType());
                    msg += " " + e.getMessage();
                    IllegalArgumentException iAE = new IllegalArgumentException(msg);
                    iAE.setStackTrace(e.getStackTrace());
                    this.eventBus.post(new TrainDataExceptionEvent("ttd;", this.exceptionTargets, trainDataChangeEvent, iAE));
                }

                return;
            }
        }
        String msg = String.format("fieldName %s was not found in fields of %s", trainDataChangeEvent.fieldName, this.trainDataVolatile.getClass());
        IllegalArgumentException iAE = new IllegalArgumentException(msg);
        this.eventBus.post(new TrainDataExceptionEvent("ttd;", this.exceptionTargets, trainDataChangeEvent, iAE));
    }
}

