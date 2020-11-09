package de.ibw.tms.trackplan.viewmodel;

import de.ibw.tms.ma.LinearLocation;
import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.SpotLocation;
import de.ibw.tms.ma.Waypoint;
import de.ibw.tms.ma.physical.*;
import de.ibw.tms.ma.topologie.ApplicationDirection;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.model.PlanData;

import java.util.ArrayList;
import java.util.List;

/**
 * unused
 */
public class DijkstraAffineRoute {

    private ArrayList<Rail> railTrack = new ArrayList<Rail>();
    private ArrayList<TrackElement> track = new ArrayList();
    private Route R;
    private TrackElement EndLocationElement = null;
    private TrackElement StartLocationElement = null;
    private boolean hasTrack = false;
    private TrackElement CurrentElement = null;
    private boolean bIsFinished = false;
    private List<TrackElement> visitedElements = new ArrayList<TrackElement>();

    public DijkstraAffineRoute(Route R) {
        this.R = R;

    }

    public void checkRailWayDefined() {
        initGraph();
    }

    public boolean isPaintable() {
        return hasTrack;
    }
    public ArrayList<Rail> getTrack() {
        return this.railTrack;
    }


    private void initGraph() {
        LinearLocation LinLocation = R.getLocation();

        List currentPositions = null;
        if(LinLocation.getBegin() == null) {
            throw new NullPointerException("Begin Waypoint not set.");
        }
        if(LinLocation.getEnd() == null) {
            throw new NullPointerException("End Waypoint not set.");
        }
        SpotLocation StartLocation = LinLocation.getBegin();
        this.EndLocationElement = LinLocation.getEnd().getTrackElement();
        this.StartLocationElement = LinLocation.getBegin().getTrackElement();
        TrackElement TE = StartLocation.getTrackElement();
        this.track.add(TE);
        if(TE instanceof Trail) {
            this.railTrack.add((Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(TE));
        }
        CurrentElement = TE;
        this.visitedElements.add(CurrentElement);
        bIsFinished = false;
        if (findRoute());
            System.out.println("Route Engine done");

    }

    private boolean findRoute() {
        List currentPositions;
        while(!bIsFinished) {
            System.out.println(CurrentElement);
            currentPositions = CurrentElement.getPositionedRelations();
            for (int i = 0; i < currentPositions.size(); i++) {
                boolean hasNewCurrentElement;
                PositionedRelation Relation = (PositionedRelation) currentPositions.get(i);
                handleEndpointCheck(Relation);
                if (this.hasTrack) return true;
                hasNewCurrentElement = checkRelationForWaypoints(Relation);
                if (hasNewCurrentElement) break;
                else bIsFinished = true;

            }

        }
        return false;
    }


    /*private boolean checkRelationForConnection(PositionedRelation Relation) {
        List wayList = R.getWaypointsList();
        for(Object W: wayList) {
            ControlledTrackElement CTE = ((Waypoint) W).getTrackElement();
            TrackElement From = Relation.getFrom();
            TrackElement To = Relation.getTo();
            TrackElement

            if (checkCteWaypointConnection(CTE, From, To, Via)) return true;
        }
        return false;
    }*/



    private boolean checkRelationForWaypoints(PositionedRelation Relation) {
        List wayList = R.getWaypointsList();

        for(Object W: wayList) {
            TrackElement CTE = ((Waypoint) W).getTrackElement();
            if(this.visitedElements.contains(CTE)) continue;
            TrackElement From = Relation.getFrom();
            TrackElement To = Relation.getTo();
            TrackElement Via = Relation.getVia();

            if(To instanceof Trail) {

                return handleTrails4WapointConnection(CTE, Relation);
            }

            if(To instanceof SingleSlip) {
                To = ((SingleSlip)To).getRemotePoint();
            }
            if(From instanceof SingleSlip) {
                From = ((SingleSlip)From).getRemotePoint();
            }
            if(To instanceof DoubleSlip || From instanceof DoubleSlip ) {
                if(handleDoubleSlip(CTE, From, To, Via)) {
                    if (!this.track.contains(CTE)) {
                        this.track.add(CTE);
                    }
                    return true;
                }
            } else {


                if (checkCteWaypointConnection(CTE, From, To, Via)) {


                    //TrackElement OriginalTarget = Relation.getTo();
                    //if (OriginalTarget instanceof Trail) {
                    //    this.railTrack.add((Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(OriginalTarget));
                    //}
                    if (!this.track.contains(CTE)) {
                        this.track.add(CTE);
                    }
                    return true;

                }
            }
        }
        return false;
    }

    private boolean handleDoubleSlip(TrackElement cte, TrackElement from, TrackElement to, TrackElement via) {
        TrackElement To1 = to;
        TrackElement To2 = null;
        TrackElement From1 = from;
        TrackElement From2 = null;

        if(to instanceof DoubleSlip) {
            DoubleSlip ToTwoSlip = (DoubleSlip) to;
            To2 = ToTwoSlip.getSecondSlipB().getRemotePoint();
            To1 = ToTwoSlip.getFirstSlipA().getRemotePoint();
        }
        if(from instanceof DoubleSlip) {
            DoubleSlip FromTwoSlip = (DoubleSlip) from;
            From2 = FromTwoSlip.getSecondSlipB().getRemotePoint();
            From1 = FromTwoSlip.getFirstSlipA().getRemotePoint();
        }
        if(checkCteWaypointConnection(cte, From1,To1, via)) return true;
        if(To2 != null ) {
            if(checkCteWaypointConnection(cte, From1,To2, via)) return true;
            if(From2 != null) {

                if(checkCteWaypointConnection(cte, From2,To2, via)) return true;
            }
        }
        if(From2 != null) {
            if(checkCteWaypointConnection(cte, From2,To1, via)) return true;
        }


        return false;

    }

    private boolean checkCteWaypointConnection(TrackElement CTE, TrackElement from, TrackElement to, TrackElement via) {
        TrackElement TempVia = null;
        TrackElement CurrentPointer = CurrentElement;
        if(CTE.getPositionedRelations().size() > 0 ) {
            TempVia = CTE.getPositionedRelations().get(0).getVia();
        }



        /*if(CurrentPointer instanceof Point) {
            if(CurrentPointer.getPositionedRelations().size() > 0 ) {
                CurrentPointer = CurrentPointer.getPositionedRelations().get(0).getVia();
            }
        }*/

        if(via == null && from == CurrentPointer && to == TempVia) {

            treatWaypointAsAchieved(CTE, CurrentPointer);
            return true;
        }
        if (CTE == from && !this.visitedElements.contains(from)
            && (via == CurrentPointer)
        ) {


            treatWaypointAsAchieved(CTE, CurrentPointer);

            return true;
        } else if (CTE == to && !this.visitedElements.contains(to) &&
                (via == CurrentPointer)
        )
        {
            treatWaypointAsAchieved(CTE, CurrentPointer);

            return true;
        }
        return false;
    }

    private void treatWaypointAsAchieved(TrackElement CTE, TrackElement currentPointer) {
        //CurrentElement = CTE;
        //this.visitedElements.add(CTE);
        this.bIsFinished = false;
        if (CTE.getPositionedRelations().get(0).getVia() instanceof DoubleSlip) {
            checkIstDoppelWeiche(CTE, currentPointer);

        } else {
            checkIstWeichenSpitze(CTE, currentPointer);
        }

    }

    private void checkIstDoppelWeiche(TrackElement cte, TrackElement currentPointer) {
        PositionedRelation R = cte.getPositionedRelations().get(0);
        DoubleSlip DoubleBranch = (DoubleSlip) R.getVia();
        TrackElement Target = null;



        if (R.getFrom() == currentPointer) {

            Target = R.getTo();
        } else if (R.getTo() == currentPointer) {

            Target = R.getFrom();
        }

        if (Target != null) {
            TrackElement TeOutput = null;
            PositionedRelation RelOutput = Target.getPositionedRelations().get(0);

            this.visitedElements.add(cte);
            if(!this.track.contains(cte))
                this.track.add(cte);

            this.visitedElements.add(Target);

            this.railTrack.add((Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(Target));
            if(!this.track.contains(Target)) {
                this.track.add(Target);
            }


            if (Target == this.EndLocationElement) {
                bIsFinished = true;
                this.hasTrack = true;
                return;
            }
            if(RelOutput.getFrom() == DoubleBranch) {
                TeOutput = RelOutput.getTo();
            } else {
                TeOutput = RelOutput.getFrom();
            }
            if(TeOutput instanceof  SingleSlip) {
                TeOutput = ((SingleSlip) TeOutput).getRemotePoint();
            }

            this.visitedElements.add(TeOutput);
            if(!this.track.contains(TeOutput))
                this.track.add(TeOutput);
            this.CurrentElement = TeOutput;
            if (TeOutput == this.EndLocationElement) {
                bIsFinished = true;
                this.hasTrack = true;

            }
        }
    }


    private void checkIstWeichenSpitze(TrackElement CTE, TrackElement currentPointer) {


        List<PositionedRelation> positionedRelations = CTE.getPositionedRelations();
        TrackElement Target = null;
        // > 1 falls man von der Weichenspitze kommt
        int iCounter = 0;
        for(PositionedRelation R : positionedRelations) {


            if(R.getFrom() == currentPointer) {
                iCounter++;
                Target = R.getTo();
            } else if(R.getTo() == currentPointer) {
                iCounter++;
                Target = R.getFrom();
            }
        }

        if(iCounter > 1) {
            // man kommt von der Spitze und weiß noch nicht welches Geleis zum nächste Waypoint führt

            // hier wäre Target nicht die spitze sondern currentPointer
            CurrentElement = CTE;
            this.visitedElements.add(CTE);
            if(!this.track.contains(CTE))
                this.track.add(CTE);

        } else {
            // hier muss Target das Geleis der Spitze sein
            if(Target != null) {
                // Spitze wird zum rangieren benutzt um auf den anderen Weichenschenkel zu kommen


                this.visitedElements.add(CTE);
                this.visitedElements.add(Target);
                if(!this.track.contains(CTE))
                    this.track.add(CTE);



                this.railTrack.add((Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(Target));



                if(Target == this.EndLocationElement) {
                    bIsFinished = true;
                    this.hasTrack = true;
                } else {
                    initOtherBranchAsCurrent(currentPointer, positionedRelations, Target);
                }
            }
        }



    }

    private void initOtherBranchAsCurrent(TrackElement currentPointer, List<PositionedRelation> positionedRelations, TrackElement target) {
        // set other rail from peek as last visited element
        TrackElement OtherBranch = null;
        for(PositionedRelation R : positionedRelations) {


            if(R.getFrom() != currentPointer && R.getTo() != currentPointer) {
               // right branch
                if(target == R.getFrom()) {
                    OtherBranch = R.getTo();
                } else {
                    OtherBranch = R.getFrom();
                }
                break;

            }
        }
        this.visitedElements.add(OtherBranch);
        if(!this.track.contains(OtherBranch)) this.track.add(OtherBranch);
        this.railTrack.add((Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(OtherBranch));
        CurrentElement = OtherBranch;
    }

    private boolean handleTrails4WapointConnection(TrackElement cte, PositionedRelation originalRelation) {
        //Trail beeing examined having waypoint on other edge
        //Rail Trail
        TrackElement ToOriginal = originalRelation.getTo();
        TrackElement FromOriginal = originalRelation.getFrom();
        /*if(originalRelation.getApplicationDirection().equals(ApplicationDirection.REVERSE)) {
            ToOriginal = originalRelation.getFrom();
        }*/


        if(checkTrailConnection(cte, ToOriginal)) return true;
        if(originalRelation.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
            if(checkTrailConnection(cte, FromOriginal)) return true;
        }
        return false;

    }

    private boolean checkTrailConnection(TrackElement cte, TrackElement toOriginal) {
        for(PositionedRelation R : toOriginal.getPositionedRelations()) {
            boolean bResult = false;
            TrackElement From = R.getFrom();
            TrackElement To = R.getTo();
            //TrackElement Via = R.getVia();
            /*if(R.getApplicationDirection().equals(ApplicationDirection.REVERSE)) {
                TrackElement TempTE = From;
                From = To;
                To = TempTE;
            }*/
            if(From instanceof SingleSlip) {
                From = ((SingleSlip) From).getRemotePoint();
            }
            if(To instanceof SingleSlip) {
                To = ((SingleSlip) To).getRemotePoint();
            }


            bResult = checkCteWaypointConnection(cte, From, To, null);
            if(!bResult && R.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
                bResult = checkCteWaypointConnection(cte, To, From, null);
            }
            if(bResult) {
                /*
                if(!this.track.contains(fromOriginal)) {
                    this.track.add(fromOriginal);
                }
                Rail FromOriginalRail = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(fromOriginal);
                if(!this.railTrack.contains(FromOriginalRail)) {
                    this.railTrack.add(FromOriginalRail);
                }
                if(!this.track.contains(viaOriginal)) {
                    this.track.add(viaOriginal);
                }
                if(!this.track.contains(cte)) {
                    this.track.add(cte);
                }

                 */
                if(!this.track.contains(R.getVia())) {
                    this.track.add(R.getVia());
                }

                this.railTrack.add((Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(R.getVia()));
                if(!this.visitedElements.contains(R.getVia())) {
                    this.visitedElements.add(R.getVia());
                }
                CurrentElement = cte;
                if(!this.visitedElements.contains(cte)) {
                    this.visitedElements.add(cte);
                }
                this.bIsFinished = false;
                return true;
            }
        }
        return false;
    }

    private void handleEndpointCheck(PositionedRelation relation) {
        //TODO determine end connection to target trail
        TrackElement HasEndpointElement = checkEndpointInRelation(relation);
        if(null != HasEndpointElement) {

            if(HasEndpointElement instanceof Trail) {
                TrackElement TeFrom = relation.getFrom();
                Rail RailFrom = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(relation.getFrom());
                TrackElement TeVia = relation.getVia();
                if(TeVia instanceof SingleSlip) {
                    TeVia = ((SingleSlip) TeVia).getRemotePoint();
                }
                if(CurrentElement != StartLocationElement) {
                    if (!this.track.contains(TeFrom)) {
                        this.track.add(TeFrom);
                    }

                    if (!this.railTrack.contains(RailFrom)) {
                        this.railTrack.add(RailFrom);
                    }
                }
                if(!this.track.contains(TeVia)) {
                    this.track.add(TeVia);
                }
                Rail R = null;
                if(CurrentElement != StartLocationElement) {
                    R = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(relation.getFrom());
                    if (!this.railTrack.contains(R)) this.railTrack.add(R);
                }
                R = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(HasEndpointElement);
                if (!this.railTrack.contains(R)) this.railTrack.add(R);

            }
            if(!this.track.contains(HasEndpointElement)) this.track.add(HasEndpointElement);
            this.hasTrack = true;
        }
    }

    /**
     *
     * @param Relation examined to lead to EndLocationElement
     * @return null if its not leading to end
     * or the end element(Waypoint)
     */
    private TrackElement checkEndpointInRelation(PositionedRelation Relation) {
        TrackElement From = Relation.getFrom();
        TrackElement End = Relation.getTo();
        TrackElement Temp = null;
        TrackElement Via = null;
        if(CurrentElement.getPositionedRelations().size() > 0 ) {
            Via = CurrentElement.getPositionedRelations().get(0).getVia();
        }


        TrackElement LastTe = this.track.get(this.track.size() -1 );
        for(PositionedRelation R : LastTe.getPositionedRelations()) {
            if(R.getTo() == this.EndLocationElement && R.getFrom() == CurrentElement) return this.EndLocationElement;
            if(R.getFrom() == this.EndLocationElement && R.getTo() == CurrentElement) return this.EndLocationElement;
        }

        if(Via == null) return null;
        if(Relation.getVia() != Via) return null;
        /*if(Relation.getApplicationDirection().equals(ApplicationDirection.REVERSE)) {
            Temp = End;
            End = From;
            From = Temp;
        }*/

        if(this.EndLocationElement instanceof ControlledTrackElement) {
            List<PositionedRelation> relations = EndLocationElement.getPositionedRelations();
            for(PositionedRelation R : relations) {
                if(R.getFrom() == CurrentElement) {
                    return this.EndLocationElement;
                }
                if(R.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
                    if(R.getTo() == CurrentElement) {
                        return this.EndLocationElement;
                    }
                }

                // check if Relatiorn R leads to EndLocation
                TrackElement FocusedSourceElement = R.getFrom();
                // End is here a trai leading to last waypoint
                if(End == FocusedSourceElement) {
                    Rail RailToPaint = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(FocusedSourceElement);
                    if(!this.railTrack.contains(RailToPaint)) this.railTrack.add(RailToPaint);
                    return this.EndLocationElement;
                }
                if(R.getApplicationDirection().equals(ApplicationDirection.BOTH)) {

                    FocusedSourceElement = R.getTo();
                    if(End == FocusedSourceElement) {
                        Rail RailToPaint = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(FocusedSourceElement);
                        if(!this.railTrack.contains(RailToPaint)) this.railTrack.add(RailToPaint);
                        return this.EndLocationElement;
                    }
                }



                /*if(R.getApplicationDirection().equals(ApplicationDirection.REVERSE)) {
                    // use To Element because Direction is Reverse
                    FocusedSourceElement = R.getTo();
                }*/
                //
                //if(this.visitedElements.contains(FocusedSourceElement)) { continue; }
                // leads to end and from FocustedElement ot last Waypoint
                //if (checkIfFocusedTargetIsInRelation(End, FocusedSourceElement)) return this.EndLocationElement;
                //if(Relation.getApplicationDirection().equals(ApplicationDirection.BOTH)) {

                    // Examined Relation reverse so footpoint leads to end.
                //    if (checkIfFocusedTargetIsInRelation(From, FocusedSourceElement)) return this.EndLocationElement;
                //}
                /*if(R.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
                    // check other way to because its both directed

                    FocusedSourceElement = R.getTo();
                    if(this.visitedElements.contains(FocusedSourceElement)) { continue; }
                    if (checkIfFocusedTargetIsInRelation(End, FocusedSourceElement)) return this.EndLocationElement;
                    if(Relation.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
                        if (checkIfFocusedTargetIsInRelation(From, FocusedSourceElement)) return this.EndLocationElement;
                    }
                }*/
            }
            if(Relation.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
                for(PositionedRelation R : relations) {
                    // check if Relatiorn R leads to EndLocation
                    TrackElement FocusedSourceElement = R.getFrom();
                    // End is here a trai leading to last waypoint
                    if (From == FocusedSourceElement) {
                        Rail RailToPaint = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(FocusedSourceElement);
                        if(!this.railTrack.contains(RailToPaint)) this.railTrack.add(RailToPaint);
                        return this.EndLocationElement;
                    }
                    if (R.getApplicationDirection().equals(ApplicationDirection.BOTH)) {

                        FocusedSourceElement = R.getTo();
                        if (From == FocusedSourceElement) {
                            Rail RailToPaint = (Rail) PlanData.TrackElementPositionCalc.translateTeToGraphic(FocusedSourceElement);
                            if(!this.railTrack.contains(RailToPaint)) this.railTrack.add(RailToPaint);
                            return this.EndLocationElement;
                        }
                    }
                }

            }
        } else {
            if(Relation.getApplicationDirection().equals(ApplicationDirection.BOTH)) {
                if (End == this.EndLocationElement) {
                    if(checkIfTracksLastRailIsGivenOne(From)) return this.EndLocationElement;
                }
                if(From == this.EndLocationElement) {
                    if(checkIfTracksLastRailIsGivenOne(End)) return this.EndLocationElement;
                }
            } else  {
                //reverse no swap necessary
                if (End == this.EndLocationElement) {
                    if(checkIfTracksLastRailIsGivenOne(From)) return this.EndLocationElement;
                }
            }
        }








        //if(From == this.EndLocationElement) return From;

        return null;

    }

    private boolean checkIfTracksLastRailIsGivenOne(TrackElement From) {
        List<PositionedRelation> relations = CurrentElement.getPositionedRelations();



        if(CurrentElement == this.StartLocationElement) {
            return true;
        }

        for(PositionedRelation R : relations) {
            if(R.getFrom() == this.EndLocationElement) return true;
            if(R.getTo() == this.EndLocationElement) return true;
        }




        TrackElement Last = null;
        int iterator = 2;
        if(this.track.isEmpty()) {
            return false;
        }
        Last = this.track.get(this.track.size() - 1);



        for(int i = this.track.size() - 1; i >= 0 && iterator > 0; i-- ) {
            Last = this.track.get(i);
            if(From == Last) return true;
            iterator--;
        }
        return false;
    }

    private boolean checkIfFocusedTargetIsInRelation(TrackElement End, TrackElement focusedSoruceElement) {
        if (CurrentElement == focusedSoruceElement && End == this.EndLocationElement ) {

            return true;
        }
        return false;
    }
}
