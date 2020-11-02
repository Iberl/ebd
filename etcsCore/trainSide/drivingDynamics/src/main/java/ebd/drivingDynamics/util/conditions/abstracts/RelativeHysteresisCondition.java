package ebd.drivingDynamics.util.conditions.abstracts;


import org.json.simple.JSONObject;
import ebd.drivingDynamics.util.exceptions.DDBadDataException;
import org.greenrobot.eventbus.EventBus;

public abstract class RelativeHysteresisCondition extends CurveBasedCondition{


    protected boolean raising;
    protected double vLowPercentage;
    protected double vHighPercentage;

    /**
     * @param localEventBus The local {@link EventBus} of the train.
     */
    public RelativeHysteresisCondition(EventBus localEventBus, JSONObject jsonObject) throws DDBadDataException {
        super(localEventBus);
        fromJSON(jsonObject);
    }

    @Override
    protected void fromJSON(JSONObject jsonObject) throws DDBadDataException {

        if(jsonObject.containsKey("v_Low")){
            Object tempObject = jsonObject.get("v_Low");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                vLowPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                vLowPercentage = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("RelativeHysteresisCondition v_Low was not a number");

            if(vLowPercentage < 0 || vLowPercentage > 2){
                throw new DDBadDataException("RelativeHysteresisCondition v_Low was not in the range [0, 200]");
            }
        }
        else throw new DDBadDataException("The key 'v_Low' was missing for a RelativeSpeedCondition");

        if(jsonObject.containsKey("v_High")){
            Object tempObject = jsonObject.get("v_High");
            String tempObjectName = tempObject.getClass().getSimpleName();
            if(tempObjectName.equals("Long")){
                vHighPercentage = (Long)tempObject / 100d;
            }
            else if(tempObjectName.equals("Double")){
                vHighPercentage = (Double)tempObject / 100;
            }
            else throw new DDBadDataException("RelativeHysteresisCondition v_High was not a number");

            if(vHighPercentage < 0 || vHighPercentage > 2){
                throw new DDBadDataException("RelativeHysteresisCondition v_High was not in the range [0, 200]");
            }
        }
        else throw new DDBadDataException("The key 'v_High' was missing for a RelativeSpeedCondition");

        if(jsonObject.containsKey("curveBase")){
            switch ((String) jsonObject.get("curveBase")){
                case "c30":
                    curveBase = CurveBase.C30;
                    break;
                case "trip":
                    curveBase = CurveBase.TRIP_PROFILE;
                    break;
                default:
                    curveBase = CurveBase.NOT_SET;
                    throw new DDBadDataException(String.format("Condition was formatted wrong, %s is not a valid curve base", jsonObject.get("curveBase")));
            }
        }
        else throw new DDBadDataException("The key curveBase was missing from a Condition");
    }

}

