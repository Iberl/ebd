package ebd.globalUtils.etcsPacketToProfileConverters;

import ebd.globalUtils.spline.ForwardSpline;
import ebd.messageLibrary.packet.trackpackets.Packet_21;
import ebd.messageLibrary.util.ETCSVariables;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class GradientProfileConverterTest {

    static Packet_21 p21_1;
    static Packet_21 p21_2;
    static final double GRAD_TO_ACC_FACTOR = 9.81 * 0.001;

    @BeforeAll
    static void setup(){
        Packet_21.Packet_21_Gradient g1 = new Packet_21.Packet_21_Gradient();
        g1.D_GRADIENT = 0;
        g1.G_A = 1;
        g1.Q_GDIR = ETCSVariables.Q_GDIR_DOWNHILL;
        Packet_21.Packet_21_Gradient g2 = new Packet_21.Packet_21_Gradient();
        g2.D_GRADIENT = 100;
        g2.G_A = 1;
        g2.Q_GDIR = ETCSVariables.Q_GDIR_UPHILL;
        Packet_21.Packet_21_Gradient g3 = new Packet_21.Packet_21_Gradient();
        g3.D_GRADIENT = 200;
        g3.G_A = 2;
        g3.Q_GDIR = ETCSVariables.Q_GDIR_DOWNHILL;

        List<Packet_21.Packet_21_Gradient> gradientList_1 = new ArrayList<>();
        gradientList_1.add(g2);
        gradientList_1.add(g3);

        List<Packet_21.Packet_21_Gradient> gradientList_2 = new ArrayList<>();
        gradientList_2.add(g3);

        p21_1 = new Packet_21();
        p21_1.gradient = g1;
        p21_1.gradients = gradientList_1;
        p21_1.Q_SCALE = 1;

        p21_2 = new Packet_21();
        p21_2.gradient = g2;
        p21_2.gradients = gradientList_2;
        p21_2.Q_SCALE = 1;
    }

    @Test
    void package21ToAccGP() {
        ForwardSpline accGP_1 = GradientProfileConverter.package21ToAccGP(p21_1,0);
        assertEquals(-1 * GRAD_TO_ACC_FACTOR, accGP_1.getPointOnCurve(10d));
        assertEquals(1 * GRAD_TO_ACC_FACTOR, accGP_1.getPointOnCurve(105d));
        assertEquals(-2 * GRAD_TO_ACC_FACTOR, accGP_1.getPointOnCurve(305d));

        ForwardSpline accGP_2 = GradientProfileConverter.package21ToAccGP(p21_2,0);
        assertEquals(0, accGP_2.getPointOnCurve(10d));
        assertEquals(1 * GRAD_TO_ACC_FACTOR, accGP_2.getPointOnCurve(105d));
        assertEquals(-2 * GRAD_TO_ACC_FACTOR, accGP_2.getPointOnCurve(305d));
    }

    @Test
    void package21ToGP() {
        ForwardSpline gp_1 = GradientProfileConverter.package21ToGP(p21_1,0);
        assertEquals(-1, gp_1.getPointOnCurve(10d));
        assertEquals(1, gp_1.getPointOnCurve(105d));
        assertEquals(-2, gp_1.getPointOnCurve(305d));

        ForwardSpline gp_2 = GradientProfileConverter.package21ToGP(p21_2,0);
        assertEquals(0, gp_2.getPointOnCurve(10d));
        assertEquals(1, gp_2.getPointOnCurve(105d));
        assertEquals(-2, gp_2.getPointOnCurve(305d));
    }

    @Test
    void package21ToGradArray() {
        double[] gradArr_1 = GradientProfileConverter.package21ToGradArray(p21_1, 0);
        double[] expected_1 = {0,-1,100,1,300,-2};
        assertArrayEquals(expected_1, gradArr_1);

        double[] gradArr_2 = GradientProfileConverter.package21ToGradArray(p21_2, 0);
        double[] expected_2 = {0,0,100,1,300,-2};
        assertArrayEquals(expected_2, gradArr_2);
    }
}