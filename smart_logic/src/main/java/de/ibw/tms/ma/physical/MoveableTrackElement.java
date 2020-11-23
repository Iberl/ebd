package de.ibw.tms.ma.physical;

import de.ibw.rtm.intf.IRTMEntityLocation;
import de.ibw.tms.ma.Chainage;

import javax.sound.midi.Track;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * Stellbare Elemente wie Weichen
 */
public class MoveableTrackElement extends ControlledElement {
    public static final String CLASS_IDENTIFIER = "Moveable_Track_Element";

    private static ArrayList<TrackElementStatus> DefaultEwStates;
    private static ArrayList<TrackElementStatus> DefaultDkwStates;


    public static ArrayList<TrackElementStatus> getEwPossibleStates() {
        if(DefaultEwStates == null) {
            DefaultEwStates = new ArrayList<>();
            ArrayList<TrackElementStatus.Status> basicStatus = new ArrayList<>();
            basicStatus.add(TrackElementStatus.Status.Unknown);
            basicStatus.add(TrackElementStatus.Status.Left);
            basicStatus.add(TrackElementStatus.Status.Right);

            for(TrackElementStatus.Status Stat : basicStatus) {
                TrackElementStatus S = new TrackElementStatus();
                S.statusList.add(Stat);
                DefaultEwStates.add(S);
            }
        }
        return DefaultEwStates;

    }

    public static ArrayList<TrackElementStatus> getDkwPossibleStates() {
        if(DefaultDkwStates == null) {
            DefaultDkwStates = new ArrayList<>();
            ArrayList<TrackElementStatus.Status> basicStatus = new ArrayList<>();

            basicStatus.add(TrackElementStatus.Status.Left);
            basicStatus.add(TrackElementStatus.Status.Right);
            TrackElementStatus UnknownState = new TrackElementStatus();
            UnknownState.statusList.add(0, TrackElementStatus.Status.Unknown);
            UnknownState.statusList.add(1, TrackElementStatus.Status.Unknown);
            DefaultDkwStates.add(UnknownState);
            for(TrackElementStatus.Status S1 : basicStatus) {
                for(TrackElementStatus.Status S2 : basicStatus) {
                    TrackElementStatus State = new TrackElementStatus();
                    State.statusList.add(0, S1);
                    State.statusList.add(1, S2);
                    DefaultDkwStates.add(State);
                }
            }

        }
        return DefaultDkwStates;
    }


    /**
     * Generiert einen Bewegbares Track-Elment
     * @param sLabel
     * @param operationTime int - in ms
     * @param ChaBeginn
     * @param ChaEnd
     * @param locationList - z.B. Intrinsische Koordinaten
     * @return MoveableTrackElement
     */
    public static MoveableTrackElement genmMoveableElementFactory(String sLabel, int operationTime, Chainage ChaBeginn, Chainage ChaEnd,
                                                              List<IRTMEntityLocation> locationList,
                                                              ArrayList<TrackElementStatus> listOfPossibleStatus,
                                                              TrackElementStatus Current ) {
        guardOpTime(operationTime);
        return new MoveableTrackElement(sLabel, operationTime,ChaBeginn, ChaEnd, locationList, listOfPossibleStatus,
            Current);
    }

    /**
     * Validiert Operation Time of Moveable Track Elements
     * @param operationTime - int in ms
     */
    public static void guardOpTime(int operationTime) {
        if (operationTime <= 0) throw new InvalidParameterException("Operation Time of Element must be greater zero");
    }


    private int operationTime;
    private ArrayList<TrackElementStatus> listOfPossibleStatus;
    private TrackElementStatus currentStatus;
    private TrackElementStatus requestedStatus;




    private MoveableTrackElement(String sLabel, int operationTime, Chainage ChaBeginn, Chainage ChaEnd,
                                List<IRTMEntityLocation> locationList,
                                ArrayList<TrackElementStatus> listOfPossibleStatus,
                                TrackElementStatus Current

    ) {
        super(CLASS_IDENTIFIER);
        this.setLabel(sLabel);
        this.operationTime = operationTime;
        this.setChainageBeginn(ChaBeginn);
        this.setChainageEnd(ChaEnd);
        this.setLocationList(locationList);
        this.setListOfPossibleStatus(listOfPossibleStatus);
        this.setCurrentStatus(Current);


    }

    public int getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(int operationTime) {
        guardOpTime(operationTime);
        this.operationTime = operationTime;
    }

    public ArrayList<TrackElementStatus> getListOfPossibleStatus() {
        return listOfPossibleStatus;
    }

    public void setListOfPossibleStatus(ArrayList<TrackElementStatus> listOfPossibleStatus) {
        this.listOfPossibleStatus = listOfPossibleStatus;
    }

    public TrackElementStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(TrackElementStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public TrackElementStatus getRequestedStatus() {
        return requestedStatus;
    }

    public void setRequestedStatus(TrackElementStatus requestedStatus) {
        this.requestedStatus = requestedStatus;
    }
}
