package de.ibw.tms.ma.positioned.elements;

import de.ibw.tms.ma.Chainage;
import de.ibw.tms.ma.positioned.elements.intf.*;

import java.util.List;

public class SectionOfLine2 extends LinearElement {
    public static final String CLASS_IDENTIFIER = "Section_Of_Line_Extended";

    private int numberOfParallelTracks;
    private int track;
    private Chainage chainageBegin;
    private Chainage chainageEnd;
    private ILineClassification classification;
    private ILineCategory category;
    private IRailwayOperator operator;
    private IOperationMode operationMode;
    private int gauge;
    private IElectrificationSystem electrificationSystem;
    private IRadioType radioType;
    private List<IATP> atp;
    private int channelNR;
    private TableOfBrakingForce brakeCapability;
    private IClearanceGauge clearanceGauge;
    private int maxAxleLoad;
    private int vmax;
    private boolean passengerTrainsAllowed;
    private IRailProfile railProfile;
    private boolean zugschiebefunk;
    private boolean druckertuechtigung;
    private int lauffaehigkeit;


    public SectionOfLine2() {
        super(CLASS_IDENTIFIER);
    }

    public int getNumberOfParallelTracks() {
        return numberOfParallelTracks;
    }

    public void setNumberOfParallelTracks(int numberOfParallelTracks) {
        this.numberOfParallelTracks = numberOfParallelTracks;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public Chainage getChainageBegin() {
        return chainageBegin;
    }

    public void setChainageBegin(Chainage chainageBegin) {
        this.chainageBegin = chainageBegin;
    }

    public Chainage getChainageEnd() {
        return chainageEnd;
    }

    public void setChainageEnd(Chainage chainageEnd) {
        this.chainageEnd = chainageEnd;
    }

    public ILineClassification getClassification() {
        return classification;
    }

    public void setClassification(ILineClassification classification) {
        this.classification = classification;
    }

    public ILineCategory getCategory() {
        return category;
    }

    public void setCategory(ILineCategory category) {
        this.category = category;
    }

    public IRailwayOperator getOperator() {
        return operator;
    }

    public void setOperator(IRailwayOperator operator) {
        this.operator = operator;
    }

    public IOperationMode getOperationMode() {
        return operationMode;
    }

    public void setOperationMode(IOperationMode operationMode) {
        this.operationMode = operationMode;
    }

    public int getGauge() {
        return gauge;
    }

    public void setGauge(int gauge) {
        this.gauge = gauge;
    }

    public IElectrificationSystem getElectrificationSystem() {
        return electrificationSystem;
    }

    public void setElectrificationSystem(IElectrificationSystem electrificationSystem) {
        this.electrificationSystem = electrificationSystem;
    }

    public IRadioType getRadioType() {
        return radioType;
    }

    public void setRadioType(IRadioType radioType) {
        this.radioType = radioType;
    }

    public List<IATP> getAtp() {
        return atp;
    }

    public void setAtp(List<IATP> atp) {
        this.atp = atp;
    }

    public int getChannelNR() {
        return channelNR;
    }

    public void setChannelNR(int channelNR) {
        this.channelNR = channelNR;
    }

    public TableOfBrakingForce getBrakeCapability() {
        return brakeCapability;
    }

    public void setBrakeCapability(TableOfBrakingForce brakeCapability) {
        this.brakeCapability = brakeCapability;
    }

    public IClearanceGauge getClearanceGauge() {
        return clearanceGauge;
    }

    public void setClearanceGauge(IClearanceGauge clearanceGauge) {
        this.clearanceGauge = clearanceGauge;
    }

    public int getMaxAxleLoad() {
        return maxAxleLoad;
    }

    public void setMaxAxleLoad(int maxAxleLoad) {
        this.maxAxleLoad = maxAxleLoad;
    }

    public int getVmax() {
        return vmax;
    }

    public void setVmax(int vmax) {
        this.vmax = vmax;
    }

    public boolean isPassengerTrainsAllowed() {
        return passengerTrainsAllowed;
    }

    public void setPassengerTrainsAllowed(boolean passengerTrainsAllowed) {
        this.passengerTrainsAllowed = passengerTrainsAllowed;
    }

    public IRailProfile getRailProfile() {
        return railProfile;
    }

    public void setRailProfile(IRailProfile railProfile) {
        this.railProfile = railProfile;
    }

    public boolean isZugschiebefunk() {
        return zugschiebefunk;
    }

    public void setZugschiebefunk(boolean zugschiebefunk) {
        this.zugschiebefunk = zugschiebefunk;
    }

    public boolean isDruckertuechtigung() {
        return druckertuechtigung;
    }

    public void setDruckertuechtigung(boolean druckertuechtigung) {
        this.druckertuechtigung = druckertuechtigung;
    }

    public int getLauffaehigkeit() {
        return lauffaehigkeit;
    }

    public void setLauffaehigkeit(int lauffaehigkeit) {
        this.lauffaehigkeit = lauffaehigkeit;
    }
}
