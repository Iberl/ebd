package ebd.breakingCurveCalculator;

import ebd.globalUtils.location.InitalLocation;
import ebd.globalUtils.spline.Knot;

public class BreakingCurveGroup {

    private String id;

    private BreakingCurve nullCurve;
    private BreakingCurve emergencyDecelerationCurve;
    private BreakingCurve emergencyInterventionCurve;
    private BreakingCurve serviceDecelerationCurve;
    private BreakingCurve serviceInterventionCurve;
    private BreakingCurve serviceWarningCurve;
    private BreakingCurve servicePermittedSpeedCurve; //Check Name
    private BreakingCurve serviceIndicationCurve;

    public BreakingCurveGroup() {
        this.id = "null curve";

        this.nullCurve = new BreakingCurve(new InitalLocation(),"ERROR");
        this.nullCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
        this.nullCurve.addKnotToCurve(new Knot(Double.MAX_VALUE, new double[]{0d,0d}));

        this.emergencyDecelerationCurve = this.nullCurve;
        this.emergencyInterventionCurve = this.nullCurve;
        this.serviceDecelerationCurve = this.nullCurve;
        this.serviceInterventionCurve = this.nullCurve;
        this.serviceWarningCurve = this.nullCurve;
        this.servicePermittedSpeedCurve = this.nullCurve;
    }

    public BreakingCurveGroup(String id) {
        this.id = id;

        this.nullCurve = new BreakingCurve(new InitalLocation(),"ERROR");
        this.nullCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
        this.nullCurve.addKnotToCurve(new Knot(Double.MAX_VALUE, new double[]{0d,0d}));

        this.emergencyDecelerationCurve = this.nullCurve;
        this.emergencyInterventionCurve = this.nullCurve;
        this.serviceDecelerationCurve = this.nullCurve;
        this.serviceInterventionCurve = this.nullCurve;
        this.serviceWarningCurve = this.nullCurve;
        this.servicePermittedSpeedCurve = this.nullCurve;
        this.serviceIndicationCurve = this.nullCurve;
    }

    /*
    getter
     */

    public BreakingCurve getEmergencyDecelerationCurve() {
        return emergencyDecelerationCurve;
    }

    public BreakingCurve getEmergencyInterventionCurve() {
        return emergencyInterventionCurve;
    }

    public BreakingCurve getServiceDecelerationCurve() {
        return serviceDecelerationCurve;
    }

    public BreakingCurve getServiceInterventionCurve() {
        return serviceInterventionCurve;
    }

    public BreakingCurve getServiceWarningCurve() {
        return serviceWarningCurve;
    }

    public BreakingCurve getServicePermittedSpeedCurve() {
        return servicePermittedSpeedCurve;
    }

    public BreakingCurve getServiceIndicationCurve() {
        return serviceIndicationCurve;
    }

    /*
    setter
     */

    void setEmergencyDecelerationCurve(BreakingCurve emergencyDecelerationCurve) {
        this.emergencyDecelerationCurve = emergencyDecelerationCurve;
    }

    void setEmergencyInterventionCurve(BreakingCurve emergencyInterventionCurve) {
        this.emergencyInterventionCurve = emergencyInterventionCurve;
    }

    void setServiceDecelerationCurve(BreakingCurve serviceDecelerationCurve) {
        this.serviceDecelerationCurve = serviceDecelerationCurve;
    }

    void setServiceInterventionCurve(BreakingCurve serviceInterventionCurve) {
        this.serviceInterventionCurve = serviceInterventionCurve;
    }

    void setServiceWarningCurve(BreakingCurve serviceWarningCurve) {
        this.serviceWarningCurve = serviceWarningCurve;
    }

    void setServicePermittedSpeedCurve(BreakingCurve servicePermittedSpeedCurve) {
        this.servicePermittedSpeedCurve = servicePermittedSpeedCurve;
    }

    void setServiceIndicationCurve(BreakingCurve serviceIndicationCurve) {
        this.serviceIndicationCurve = serviceIndicationCurve;
    }
}
