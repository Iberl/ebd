package ebd.globalUtils.enums;

public enum CurveType {
    EMERGENCY_INTERVENTION_CURVE(0),
    SERVICE_INTERVENTION_CURVE_2(1),
    SERVICE_INTERVENTION_CURVE_1(2),
    NORMAL_INTERVENTION_CURVE(3),
    WARNING_CURVE(4),
    PERMITTED_SPEED(5),
    INDICATION_CURVE(6),
    C30_CURVE(7);

    private Integer ranking;

    CurveType(int ranking){
        this.ranking = ranking;
    }

    public Integer getRanking() {
        return ranking;
    }
}
