package de.ibw.tms.plan_pro.adapter.topology;

import de.ibw.tms.ma.Route;
import de.ibw.tms.ma.dynamic.MOBPositionSection;
import de.ibw.tms.ma.dynamic.RouteSection;
import de.ibw.tms.ma.flanking.FlankArea;
import de.ibw.tms.ma.mob.position.SafeMOBPosition;
import de.ibw.tms.ma.occupation.FlankOccupation;
import de.ibw.tms.ma.occupation.MAOccupation;
import de.ibw.tms.ma.occupation.MARequestOccupation;
import de.ibw.tms.ma.occupation.VehicleOccupation;
import de.ibw.tms.ma.positioned.elements.AllocationSection;
import de.ibw.tms.ma.positioned.elements.AllocationSectionGroup;
import de.ibw.tms.ma.positioned.elements.DangerArea;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TrackAreaHandler {

    private TopologyGraph.Edge E;

    private List<DangerArea> dangerAreas = new ArrayList<>();

    private List<VehicleOccupation> vehicleOccupations = new CopyOnWriteArrayList<>();
    private List<MAOccupation> maOccupations = new CopyOnWriteArrayList<>();
    private List<MARequestOccupation> maRequestOccupations = new CopyOnWriteArrayList<>();
    private List<FlankOccupation> flankOccupations = new CopyOnWriteArrayList<>();


    private List<MOBPositionSection> positionSections = new CopyOnWriteArrayList<>();
    private List<AllocationSectionGroup> allocationSectionGroups = new CopyOnWriteArrayList<>();
    private List<AllocationSection> allocationSections = new CopyOnWriteArrayList<>();
    private List<SafeMOBPosition> safeMOBPositions = new CopyOnWriteArrayList<>();


    private List<FlankArea> flankAreas = new CopyOnWriteArrayList<>();



    public TrackAreaHandler(TopologyGraph.Edge edge) {
        E = edge;
    }

    public List<DangerArea> getDangerAreas() {
        return dangerAreas;
    }

    public void setDangerAreas(List<DangerArea> dangerAreas) {
        this.dangerAreas = dangerAreas;
    }

    public List<VehicleOccupation> getVehicleOccupations() {
        return vehicleOccupations;
    }

    public void setVehicleOccupations(List<VehicleOccupation> vehicleOccupations) {
        this.vehicleOccupations = vehicleOccupations;
    }

    public List<MAOccupation> getMaOccupations() {
        return maOccupations;
    }

    public void setMaOccupations(List<MAOccupation> maOccupations) {
        this.maOccupations = maOccupations;
    }

    public List<MARequestOccupation> getMaRequestOccupations() {
        return maRequestOccupations;
    }

    public void setMaRequestOccupations(List<MARequestOccupation> maRequestOccupations) {
        this.maRequestOccupations = maRequestOccupations;
    }

    public List<FlankOccupation> getFlankOccupations() {
        return flankOccupations;
    }

    public void setFlankOccupations(List<FlankOccupation> flankOccupations) {
        this.flankOccupations = flankOccupations;
    }

    public List<MOBPositionSection> getPositionSections() {
        return positionSections;
    }

    public void setPositionSections(List<MOBPositionSection> positionSections) {
        this.positionSections = positionSections;
    }

    public List<AllocationSectionGroup> getAllocationSectionGroups() {
        return allocationSectionGroups;
    }

    public void setAllocationSectionGroups(List<AllocationSectionGroup> allocationSectionGroups) {
        this.allocationSectionGroups = allocationSectionGroups;
    }

    public List<AllocationSection> getAllocationSections() {
        return allocationSections;
    }

    public void setAllocationSections(List<AllocationSection> allocationSections) {
        this.allocationSections = allocationSections;
    }

    public List<SafeMOBPosition> getSafeMOBPositions() {
        return safeMOBPositions;
    }

    public void setSafeMOBPositions(List<SafeMOBPosition> safeMOBPositions) {
        this.safeMOBPositions = safeMOBPositions;
    }



    public List<FlankArea> getFlankAreas() {
        return flankAreas;
    }

    public void setFlankAreas(List<FlankArea> flankAreas) {
        this.flankAreas = flankAreas;
    }
}
