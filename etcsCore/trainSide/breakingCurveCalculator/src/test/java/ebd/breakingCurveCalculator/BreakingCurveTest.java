package ebd.breakingCurveCalculator;

import ebd.breakingCurveCalculator.tests.BCREgeneratorFromDataset;
import ebd.globalUtils.breakingCurveType.CurveType;
import ebd.globalUtils.speedSupervisionState.SpeedSupervisionState;
import org.greenrobot.eventbus.EventBus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BreakingCurveTest {

    List<BreakingCurve> breakingCurves;
    int[] tsp = {0,160,1800,60};
    double[] bp = {0,0.4,100,0.2};
    int[] gp = {0,0};
    int eoa = 3000;

    @BeforeEach
    void setUp() {
        BreakingCurveCalculator breakingCurveCalculator = new BreakingCurveCalculator(EventBus.getDefault());


        BCREgeneratorFromDataset bcreGen = new BCREgeneratorFromDataset(tsp,bp,gp,eoa);

        this.breakingCurves = breakingCurveCalculator.getBreakingCurve(bcreGen.generate());
    }

    @Test
    void getSpeedAtDistance() {
        BreakingCurve eBC = this.breakingCurves.get(0);

        double speedAt0ebi = eBC.getSpeedAtDistance(0, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double speedAt0ps = eBC.getSpeedAtDistance(0, CurveType.PERMITTED_SPEED);
        double speedAt1800ebi = eBC.getSpeedAtDistance(1800, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double speedAt1800ps = eBC.getSpeedAtDistance(1800, CurveType.PERMITTED_SPEED);
        double speedAt3000ebi = eBC.getSpeedAtDistance(3000, CurveType.EMERGENCY_INTERVENTION_CURVE);
        double speedAt3000ps = eBC.getSpeedAtDistance(3000, CurveType.PERMITTED_SPEED);
        double speedAtendebi = eBC.getSpeedAtDistance(eBC.endOfDefinedDistance(), CurveType.EMERGENCY_INTERVENTION_CURVE);
        double speedAtendps = eBC.getSpeedAtDistance(eBC.endOfDefinedDistance(), CurveType.PERMITTED_SPEED);

        assertEquals(43.14, speedAt0ebi, 0.01);
        assertEquals(41.15, speedAt0ps, 0.01);
        assertEquals(18.74, speedAt1800ebi, 0.01);
        assertEquals(tsp[3]/3.6, speedAt1800ps, 0.01);
        assertEquals(14.22, speedAt3000ebi, 0.01);
        assertEquals(11.80, speedAt3000ps, 0.01);
        assertEquals(0, speedAtendebi, 0.01);
        assertEquals(0, speedAtendps, 0.01);
    }

    @Test
    void nextTargetDistance() {
        BreakingCurve eBC = this.breakingCurves.get(0);
        BreakingCurve sBC = this.breakingCurves.get(1);
        BreakingCurve nBC = this.breakingCurves.get(2);

        double targetDistance0eBC = eBC.nextTargetDistance(0);
        double targetDistance0sBC = sBC.nextTargetDistance(0);
        double targetDistance0nBC = nBC.nextTargetDistance(0);
        assertEquals(1800, targetDistance0eBC);
        assertEquals(1800, targetDistance0sBC);
        assertEquals(1800, targetDistance0nBC);

        double targetDistance10eBC = eBC.nextTargetDistance(10);
        double targetDistance10sBC = sBC.nextTargetDistance(10);
        double targetDistance10nBC = nBC.nextTargetDistance(10);
        assertEquals(1800, targetDistance10eBC);
        assertEquals(1800, targetDistance10sBC);
        assertEquals(1800, targetDistance10nBC);

        double targetDistance1800eBC = eBC.nextTargetDistance(1800);
        double targetDistance1800sBC = sBC.nextTargetDistance(1800);
        double targetDistance1800nBC = nBC.nextTargetDistance(1800);
        assertEquals(3200, targetDistance1800eBC);
        assertEquals(3000, targetDistance1800sBC);
        assertEquals(3000, targetDistance1800nBC);
    }

    @Test
    void getSpeedSupervisionState() {
        BreakingCurve eBC = this.breakingCurves.get(0);
        SpeedSupervisionState state10_10 = eBC.getSpeedSupervisionState(10, 10);
        SpeedSupervisionState state2000_10 = eBC.getSpeedSupervisionState(2000, 10);
        SpeedSupervisionState state2000_30 = eBC.getSpeedSupervisionState(2000, 30);

        assertEquals(SpeedSupervisionState.CEILING_SPEED_SUPERVISION, state10_10);
        assertEquals(SpeedSupervisionState.CEILING_SPEED_SUPERVISION, state2000_10);
        assertEquals(SpeedSupervisionState.TARGET_SPEED_SUPERVISION, state2000_30);
    }

    @Test
    void endOfDefinedDistance() {
        BreakingCurve eBC = this.breakingCurves.get(0);
        BreakingCurve sBC = this.breakingCurves.get(1);

        assertEquals(3200, eBC.endOfDefinedDistance());
        assertEquals(3000, sBC.endOfDefinedDistance());
    }

    @Test
    void getDistanceSpeedAlwaysLower() {
        BreakingCurve eBC = this.breakingCurves.get(0);
        assertEquals(3016.66, eBC.getDistanceSpeedAlwaysLower(10, CurveType.PERMITTED_SPEED), 0.01);
    }
}