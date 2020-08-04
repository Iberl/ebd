package de.ibw.tms.speed.profile.controller;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.speed.profile.model.SpeedSegmentViewModel;
import de.ibw.tms.speed.profile.view.AddSegmentDialog;
import de.ibw.tms.speed.profile.view.SpeedPanel;
import de.ibw.util.UtilFunction;

import javax.swing.*;
import java.util.ArrayList;

public class SegmentAddController {
    private SpeedSegmentViewModel Model;
    private AddSegmentDialog View;
    private ArrayList<String> errorList = new ArrayList();

    private Integer iTempBeginMeter;
    private Integer iTempEndMeter;

    public void setModel(SpeedSegmentViewModel model) {
        Model = model;
    }

    public void setView(AddSegmentDialog view) {
        View = view;
    }

    public void submitSegment(String sBeginMeter, String sEndMeter, String stringSpeed) {
        iTempBeginMeter = null;
        iTempEndMeter = null;
        validateInput(sBeginMeter, sEndMeter, stringSpeed);
        if(this.errorList.isEmpty()) {
            SpeedPanel.OpenAddDialog = null;
            this.View.getContentPane().removeAll();
            this.View.dispose();
            SpeedPanel.CurrentSpeedPanel.addSpeedSegment(Model.getSegment());



        } else {
            StringBuilder s = new StringBuilder("<HTML>");
            for(String sError: errorList) {
                s.append(sError).append("<br />");
            }
            s.append("</HTML>");
            this.errorList = new ArrayList<>();
            JOptionPane.showMessageDialog(this.View,
                    s.toString(),
                    "Segment Not Added",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validateInput(String sBeginMeter, String sEndMeter, String stringSpeed) {
        ArrayList<String> checkList = new ArrayList<>();
        checkList.add(sBeginMeter);
        checkList.add(sEndMeter);
        checkList.add(stringSpeed);

        for(int i = 0; i < checkList.size(); i++) {
            try {
                int iResult = UtilFunction.formatStringToInt(checkList.get(i));
                checkRange(i,iResult);
            } catch (NumberFormatException NFE) {
                markNumberError(i, checkList.get(i));
            }
        }
        if(this.iTempBeginMeter != null && this.iTempEndMeter != null) {
            if(iTempBeginMeter >= iTempEndMeter) {
                this.errorList.add("Beginn is after End. Check Input please.");
            }
        }



    }

    private void markNumberError(int i, String sInput) {
        switch (i) {
            case 0: {
                String sMsg = "You entered no Number for start of Segment: "
                        + sInput;
                this.errorList.add(sMsg);
                break;
            }
            case 1: {
                String sMsg = "You entered no Number for end of Segment: "
                        + sInput;
                this.errorList.add(sMsg);
                break;
            }
            case 2: {
                String sMsg = "You entered no Number for speed-value of Segment: "
                        + sInput;
                this.errorList.add(sMsg);
                break;
            }
        }
    }

    private void checkRange(int i, int iResult) {

        switch (i) {

            case 0: {
                Chainage MinC = this.Model.getMinChainage();

                if(iResult < MinC.getiMeters()) {
                    markRangeError(i, iResult, MinC.getiMeters());
                } else {
                    this.Model.setStartMeter(iResult);
                    this.iTempBeginMeter = iResult;
                }
                break;
            }
            case 1: {
                Chainage MaxC = this.Model.getMaxChainage();
                if(iResult > MaxC.getiMeters()) {
                    markRangeError(i, iResult, MaxC.getiMeters());
                } else {
                    this.Model.setEndMeter(iResult);
                    this.iTempEndMeter = iResult;
                }
                break;
            }
            case 2: {
                if(!(0 <= iResult && iResult <= 350 )) {
                    // iSpeed is not in interval
                    markRangeError(i, iResult, null);
                    break;
                } else {
                    this.Model.setSpeed(iResult);
                }
            }

        }
    }

    private void markRangeError(int i, int iResult, Integer shalValue) {
        switch (i) {
            case 0: {
                String sMsg = "You entered for start of Segment: '"
                        + iResult + "', please type in a value greater than " + shalValue;
                this.errorList.add(sMsg);
                break;
            }
            case 1: {
                String sMsg = "You entered for end of Segment: '"
                        + iResult + "', please type in a value less than " + shalValue;
                this.errorList.add(sMsg);
                break;
            }
            case 2: {
                String sMsg = "You entered for speed: '"
                        + iResult + "', please type in a value in range 0-350 km/h";
                this.errorList.add(sMsg);
                break;
            }
        }
    }
}
