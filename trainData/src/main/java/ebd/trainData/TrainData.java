package ebd.trainData;


import ebd.globalUtils.events.trainData.*;
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

    public TrainData(EventBus eventBus, String trainConfiguratorIP, String trainID){
        this.eventBus = eventBus;
        this.eventBus.register(this);
        this.exceptionTargets.add("tsm;");
        this.eventTargets.add("all;");
        try {
            this.trainDataPerma = new TrainDataPerma(trainConfiguratorIP, trainID);
        } catch (IOException e) {
            e.printStackTrace();    //TODO Exceptionhandeling
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (TDBadDataException e) {
            e.printStackTrace();
        }
        this.eventBus.postSticky(trainDataPerma);
    }

    @Subscribe
    public void changeInTrainData(TrainDataChangeEvent trainDataChangeEvent){

        for (Field field : trainDataVolatile.getClass().getDeclaredFields()){

            if (field.getName().equals(trainDataChangeEvent.fieldName)) {
                try {

                    field.set(trainDataVolatile, trainDataChangeEvent.fieldValue);
                    eventBus.postSticky(new NewTrainDataVolatileEvent("ttd;", eventTargets, trainDataVolatile));

                } catch (IllegalAccessException e) {
                    String msg = String.format("Field %s was not accessible. ", trainDataChangeEvent.fieldName);
                    msg += " " + e.getMessage();
                    IllegalAccessException exception = new IllegalAccessException(msg);
                    exception.setStackTrace(e.getStackTrace());
                    eventBus.post(new TrainDataExceptionEvent("ttd;", exceptionTargets, trainDataChangeEvent, exception));
                } catch (IllegalArgumentException e){
                    String msg = String.format("Passed fieldValue with type %s did not match field %s with the type %s.", trainDataChangeEvent.fieldValue.getClass(), field.getName(), field.getType());
                    msg += " " + e.getMessage();
                    IllegalArgumentException iAE = new IllegalArgumentException(msg);
                    iAE.setStackTrace(e.getStackTrace());
                    eventBus.post(new TrainDataExceptionEvent("ttd;", exceptionTargets, trainDataChangeEvent, iAE));
                }

                return;
            }
        }
        String msg = String.format("fieldName %s was not found in fields of %s", trainDataChangeEvent.fieldName, trainDataVolatile.getClass());
        IllegalArgumentException iAE = new IllegalArgumentException(msg);
        eventBus.post(new TrainDataExceptionEvent("ttd;", exceptionTargets, trainDataChangeEvent, iAE));
    }
}

