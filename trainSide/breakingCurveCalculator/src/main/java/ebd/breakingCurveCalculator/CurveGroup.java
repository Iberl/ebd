package ebd.breakingCurveCalculator;


import ebd.globalUtils.breakingCurveType.BreakingCurveType;
import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;

public class CurveGroup {

    private final String id;

    private BackwardSpline emergencyInterventionCurve;
    /**
     * From EBD
     */
    private BackwardSpline serviceInterventionCurve2;
    /**
     * From SBD
     */
    private BackwardSpline serviceInterventionCurve1;
    /**
     * Also called GUI (guidance) Curve
     */
    private BackwardSpline normalBreakingCurve;
    private BackwardSpline warningCurve;
    private BackwardSpline permittedSpeedCurve;
    private BackwardSpline indicationCurve;
    /**
     * As required by DB convention to allow a ~30 second coasting phase before breaking
     */
    private BackwardSpline c30Curve;

    public CurveGroup() {
        this.id = "noID";
        initCurves();
    }

    public CurveGroup(String id) {
        this.id = id;
        initCurves();
    }

    public BackwardSpline getCurveFromType(BreakingCurveType bct){
        return switch (bct){
            case C30_CURVE -> getC30Curve();
            case NORMAL_CURVE -> getNormalBreakingCurve();
            case INDICATION_CURVE -> getIndicationCurve();
            case PERMITTED_SPEED -> getPermittedSpeedCurve();
            case WARNING_CURVE -> getWarningCurve();
            case SERVICE_INTERVENTION_CURVE_1 -> getServiceInterventionCurve1();
            case SERVICE_INTERVENTION_CURVE_2 -> getServiceInterventionCurve2();
            case EMERGENCY_INTERVENTION_CURVE -> getEmergencyInterventionCurve();
            default -> throw new IllegalStateException("Curve type not known: " + bct);
        };
    }

    private void initCurves() {
        BackwardSpline nullCurve = new BackwardSpline(1, "ERROR");
        nullCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
        nullCurve.addKnotToCurve(new Knot(Double.MAX_VALUE, new double[]{0d,0d}));

        this.emergencyInterventionCurve = nullCurve;
        this.serviceInterventionCurve2 = nullCurve;
        this.serviceInterventionCurve1 = nullCurve;
        this.normalBreakingCurve = nullCurve;
        this.warningCurve = nullCurve;
        this.permittedSpeedCurve = nullCurve;
        this.indicationCurve = nullCurve;
        this.c30Curve = nullCurve;
    }

    /*
    getter
     */

    public String getId() {
        return id;
    }

    public BackwardSpline getEmergencyInterventionCurve() {
        return emergencyInterventionCurve;
    }

    /**
     * ServiceInterventionCurve2 is based on the EmergencyDecelerationCurve
     * @return BackwardSpline
     */
    public BackwardSpline getServiceInterventionCurve2() { return serviceInterventionCurve2; }

    /**
     * ServiceInterventionCurve1 is based on the ServiceDecelerationCurve
     * @return BackwardSpline
     */
    public BackwardSpline getServiceInterventionCurve1() {
        return serviceInterventionCurve1;
    }

    public BackwardSpline getNormalBreakingCurve() {
        return normalBreakingCurve;
    }

    public BackwardSpline getWarningCurve() {
        return warningCurve;
    }

    public BackwardSpline getPermittedSpeedCurve() {
        return permittedSpeedCurve;
    }

    public BackwardSpline getIndicationCurve() {
        return indicationCurve;
    }

    public BackwardSpline getC30Curve() {return c30Curve; }

    /*
    setter
     */

    void setEmergencyInterventionCurve(BackwardSpline emergencyInterventionCurve) {
        this.emergencyInterventionCurve = emergencyInterventionCurve;
    }

    void setNormalBreakingCurve(BackwardSpline normalBreakingCurve) {
        this.normalBreakingCurve = normalBreakingCurve;
    }

    void setServiceInterventionCurve2(BackwardSpline serviceInterventionCurve) {
        this.serviceInterventionCurve2 = serviceInterventionCurve;
    }

    void setServiceInterventionCurve1(BackwardSpline serviceInterventionCurve) {
        this.serviceInterventionCurve1 = serviceInterventionCurve;
    }

    void setWarningCurve(BackwardSpline warningCurve) {
        this.warningCurve = warningCurve;
    }

    void setPermittedSpeedCurve(BackwardSpline permittedSpeedCurve) {
        this.permittedSpeedCurve = permittedSpeedCurve;
    }

    void setIndicationCurve(BackwardSpline indicationCurve) {
        this.indicationCurve = indicationCurve;
    }

    void setC30Curve(BackwardSpline c30Curve){
        this.c30Curve = c30Curve;
    }
}
