package de.ibw.tms.speed.profile.model;

import de.ibw.tms.trackplan.ui.Route;
import de.ibw.tms.ma.dynamic.RouteSection;

import java.util.List;

public class DummyRoute extends Route {
    public DummyRoute(List<RouteSection> sectionList) {
        super(sectionList);
    }
    /*
    public DummyRoute() {
        ArrayList<Rail> railList = PlanData.getInstance().railList;
        ArrayList<BranchingSwitch> branchingSwitchList = PlanData.getInstance().branchingSwitchList;
        Rail StartRail = null;
        BranchingSwitch EndSwitch = null;
        for(Rail R : railList) {
            //if(R.segmentName.equals("W11 - W12/13")) {
                StartRail = R;
                break;
            //}
        }
        for(BranchingSwitch BS : branchingSwitchList) {
            if(BS.getViewName().equals("W11")) {
                EndSwitch = BS;
                break;
            }
        }

        this.setStartSpot(StartRail.getTrackSection(), 30);
        //this.setEndSpot(EndSwitch.getBranchingPoint(),EndSwitch.getBranchingPoint().getChainageBeginn().getiMeters());
        Rail R2 = railList.get(railList.size() -1);
        this.setEndSpot(R2.getTrackSection(), 1000);


    }

     */
}
