package de.ibw.tms.gradient.profile.viewmodel;

import de.ibw.tms.etcs.ETCS_GRADIENT;
import de.ibw.tms.gradient.profile.GradientTrailModel;
import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.GradientSegment;
import de.ibw.tms.ma.location.SpotLocation;
import de.ibw.tms.plan.elements.model.PlanData;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
/**
 * Noch nicht implementiert
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
public class GradientTableModel {

    private DefaultTableModel TableModel;

    public DefaultTableModel getTableModel() {
        return TableModel;
    }

    private ArrayList<GradientSegment> segmentList;

    public ArrayList<GradientSegment> getSegmentList() {
        return segmentList;
    }

    private Object[][] getSegmentData(GradientTrailModel currentTrailModel) {



        this.segmentList = PlanData.getInstance().GradientMap.get(currentTrailModel);
        if(this.segmentList == null) {
            this.segmentList = new ArrayList<GradientSegment>();

            return  new Object[0][0];
        }

        int iSize = this.segmentList.size();


        System.out.println("Segmentprint" + segmentList.size());
        System.out.println(PlanData.getInstance().GradientMap.values().size());
        Object[][] resultMap = new Object[this.segmentList.size()][4];
        for(int i = 0; i < iSize; i++) {
            GradientSegment Segment = this.segmentList.get(i);
            resultMap[i][0] = Segment.getBegin().getChainage();
            resultMap[i][1] = String.valueOf(Segment.getG_A().bGradient);
            if (Segment.isQ_GDIR()) {
                resultMap[i][2] = "↑";
            } else {
                resultMap[i][2] = "↓";
            }
            resultMap[i][3] = Segment.getEnd().getChainage();

        }
        return resultMap;
    }

    public GradientTableModel(GradientTrailModel CurrentTrailModel) {



        this.TableModel = new DefaultTableModel(this.getSegmentData(CurrentTrailModel), this.getColoumnNames());

    }




    public int getColumnCount() {
        return 4;
    }

    private Object[] getColoumnNames() {
        return new Object[] {
                "Start Meter",
                "Percent Gradient",
                "Up/Down",
                "End Meter"
        };
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0: return "Start Meter";
            case 1: return "Percent Gradient";
            case 2: return "Up/Down";
            case 3: return "End Meter";
            default: return "";
        }
    }


    public Object getValueAt(int row, int column) {
        GradientSegment Segment = segmentList.get(row);
        switch (column) {
            case 0:
                return Segment.getBegin().getChainage();
            case 1:
                return String.valueOf(Segment.getG_A().bGradient);
            case 2:
                if (Segment.isQ_GDIR()) {
                    return "↑";
                } else {
                    return "↓";
                }

            case 3:
                return Segment.getEnd().getChainage().getiMeters();
            default:
                return "";
        }

    }

    public void setValueAt(Object value, int row, int column)
    {
        GradientSegment Segment = segmentList.get(row);
        ETCS_GRADIENT Gradient = Segment.getG_A();
        switch (column) {

            case 0:
                SpotLocation SpLocationBegin = Segment.getBegin();
                SpLocationBegin.setChainage((Chainage) value);
            case 1:
                byte bGradient = (byte) value;

                Gradient.bGradient = bGradient;
                Segment.setGradient(Gradient, Segment.isQ_GDIR());
            case 2:
                String sValue = (String) value;
                if(sValue.equals("↑")) {
                    Segment.setGradient(Gradient, true);
                } else {
                    Segment.setGradient(Gradient, false);
                }


            case 3:
                SpotLocation SpLocationEnd = Segment.getEnd();
                SpLocationEnd.setChainage((Chainage) value);

            default:
                this.TableModel.fireTableCellUpdated(row, column);


        }

    }


    public Class<?> getColumnClass(int columnIndex) {

        switch (columnIndex) {
            case 0:
                return Chainage.class;


            case 3:
                return Chainage.class;
            default:
                return String.class;
        }
    }

    public boolean isCellEditable(int row, int column)
    {
        switch (column)
        {
            //case 2: return true; // only the birth date is editable
            default: return false;
        }
    }

}
