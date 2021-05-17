package data

import de.ibw.tms.ma.physical.MoveableTrackElement
import de.ibw.tms.ma.physical.TrackElementStatus
import spock.lang.Specification

import java.security.InvalidParameterException

class ScenarioDataProvider extends Specification {

        public String[] getScenario1Train1List() {
            return new String[]{"11W13", "11W40", "11W41", "11W42", "11W43", "11W45", "13W1", "13W2", "13W3", "13W4"};
        }


        public MoveableTrackElement getElementByDbd(String strScenario, int trainId, String sidSwitch) {
            MoveableTrackElement MTE = Stub(MoveableTrackElement.class);
            TrackElementStatus statusOfSwitch = new TrackElementStatus();
            switch (strScenario) {
                case "CR1": {
                    switch (trainId) {
                        case 1: {
                            switch (sidSwitch) {
                                case "11W13": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.RIGHT);
                                    break;
                                }
                                case "11W40": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.RIGHT);
                                    break;
                                }
                                case "11W41": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }
                                case "11W42": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }
                                case "11W43": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }
                                case "11W45": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.RIGHT);
                                    break;
                                }
                                case "13W1": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }
                                case "13W2": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }
                                case "13W3": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }

                                case "13W4": {
                                    statusOfSwitch.statusList.add(TrackElementStatus.Status.LEFT);
                                    break;
                                }
                            }
                            break;
                        }
                        default: {
                           throw new InvalidParameterException("Scenario (Train " + trainId + "):"  + strScenario +
                                    " not supported");
                        }
                    }
                    break;
                }
                default: {
                    throw new InvalidParameterException("Scenario: ".concat(strScenario).concat(" not supported"));
                }
            }
            MTE.getCurrentStatus() >> statusOfSwitch
            return MTE;
        }

}
