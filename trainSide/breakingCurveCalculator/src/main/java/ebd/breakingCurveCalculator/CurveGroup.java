package ebd.breakingCurveCalculator;


import ebd.globalUtils.spline.BackwardSpline;
import ebd.globalUtils.spline.Knot;

public class CurveGroup {

    private final String id;

    private BackwardSpline emergencyInterventionCurve;
    private BackwardSpline serviceInterventionCurve;
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

    private void initCurves() {
        BackwardSpline nullCurve = new BackwardSpline(1, "ERROR");
        nullCurve.addKnotToCurve(new Knot(0d, new double[]{0d,0d}));
        nullCurve.addKnotToCurve(new Knot(Double.MAX_VALUE, new double[]{0d,0d}));

        this.emergencyInterventionCurve = nullCurve;
        this.serviceInterventionCurve = nullCurve;
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

    public BackwardSpline getServiceInterventionCurve() {
        return serviceInterventionCurve;
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

    void setServiceInterventionCurve(BackwardSpline serviceInterventionCurve) {
        this.serviceInterventionCurve = serviceInterventionCurve;
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
