package ebd.globalUtils.etcsPacketToProfileConverters;

import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.messageLibrary.packet.trackpackets.Packet_21;

import java.util.List;

public class GradientProfileConverter {

    /**
     * This method converts a {@link Packet_21} and returns a profile that contains distances in [m] and acceleration in [m/s^2].
     * Uphill values are positive, downhill values are negative. In other words, gradients that speed the train up are negative,
     * because they reduce the breaking power of the train. In accordance, gradients that slow the train down are positive.<br>
     *
     * The conversion is a simple factor based on ideal acceleration through gravity and slope.
     *
     * @param p21
     * 		{@link Packet_21}
     * @param refGradient
     * 		Gradient at the referenz location of {@link Packet_21} from an existing gradient profile or default value. In [0/00] (also called per mille).
     * @return
     * 		Returns a gradient profile that contains distances in [m] and acceleration in [m/s�].
     *
     * @author Lars Schulze-Falck
     */
    public static ForwardSpline package21ToAccGP(Packet_21 p21, double refGradient) {

        double totalDistance = 0d;
        double distanceFactor = Math.pow(10, p21.Q_SCALE - 1);
        double gradToAccFactor = 9.81 * 0.001;

        /*
         * We add the gradient into the list of all gradients
         */
        List<Packet_21.Packet_21_Gradient> gradients = p21.gradients;
        gradients.add(0,p21.gradient);

        ForwardSpline gp = new ForwardSpline(0);

        /*
         * Should D_GRADIENT not be 0, the first knot is based on the current gradient, see SRS 3.6.3.2.2
         */
        if (p21.gradient.D_GRADIENT != 0) {gp.addKnotToCurve(new Knot(0d, refGradient * gradToAccFactor));}

        /*
         * We generate the spline out of the packet values. A G_A of 255 is a end marker.
         */
        for (Packet_21.Packet_21_Gradient gradient : gradients) {
            totalDistance += gradient.D_GRADIENT * distanceFactor;
            if (gradient.G_A < 255) {
                if (!gradient.Q_GDIR) 	{gp.addKnotToCurve(new Knot(totalDistance, - gradient.G_A * gradToAccFactor));}
                else 							{gp.addKnotToCurve(new Knot(totalDistance, gradient.G_A * gradToAccFactor));}

            }
            else {
                gp.addKnotToCurve(new Knot(totalDistance, -Double.MAX_VALUE));
                break; //TODO Better way to represent G_A = 255 (see 7.5.1.37)
            }
        }
        return gp;
    }

    /**
     * This method converts a {@link Packet_21} and returns a profile that contains distances in [m] and gradients in [0/00].
     * Uphill values are positive, downhill values are negative. In other words, gradients that speed the train up are negative,
     * because they reduce the breaking power of the train. In accordance, gradients that slow the train down are positive.<br>
     *
     * @param p21
     * 		{@link Packet_21}
     * @param refGradient
     * 		Gradient at the referenz location of {@link Packet_21} from an existing gradient profile or default value. In [0/00] (also called per mille).
     * @return
     * 		Returns a gradient profile that contains distances in [m] and gradients in [0/00] (also called per mille).
     *
     * @author Lars Schulze-Falck
     */
    public static ForwardSpline package21ToGP(Packet_21 p21, double refGradient) {

        double totalDistance = 0d;
        double distanceFactor = Math.pow(10, p21.Q_SCALE - 1);

        /*
         * We add the gradient into the list of all gradients
         */
        List<Packet_21.Packet_21_Gradient> gradients = p21.gradients;
        gradients.add(0,p21.gradient);

        ForwardSpline gp = new ForwardSpline(0);

        /*
         * Should D_GRADIENT not be 0, the first knot is based on the current gradient, see SRS 3.6.3.2.2
         */
        if (p21.gradient.D_GRADIENT != 0) {gp.addKnotToCurve(new Knot(0d, refGradient));}

        /*
         * We generate the spline out of the packet values. A G_A of 255 is a end marker.
         */
        for (Packet_21.Packet_21_Gradient gradient : gradients) {
            totalDistance += gradient.D_GRADIENT * distanceFactor;
            if (gradient.G_A < 255) {
                if (!gradient.Q_GDIR) 	{gp.addKnotToCurve(new Knot(totalDistance, - gradient.G_A * 1.0));}
                else 					{gp.addKnotToCurve(new Knot(totalDistance, gradient.G_A * 1.0));}

            }
            else {
                gp.addKnotToCurve(new Knot(totalDistance, -Double.MAX_VALUE));
                break; //TODO Better way to represent G_A = 255 (see 7.5.1.37)
            }
        }
        return gp;
    }

    /**
     * Converts a p21 into an array containing total distance values in [m] and gradients in [0/00]
     * @param p21 A {@link Packet_21}
     * @param refGradient radient at the referenz location of {@link Packet_21} from an existing gradient profile or default value. In [0/00] (also called per mille).
     * @return A array in the format {totalDistance in [m], grad in [0/00], totalDistance2, grad2 ...}.
     *          The distance values are always in reference to the start of the profile.
     */
    public static double[] package21ToGradArray(Packet_21 p21, double refGradient) {

        double totalDistance = 0d;
        double distanceFactor = Math.pow(10, p21.Q_SCALE - 1);

        /*
         * We add the gradient into the list of all gradients
         */
        List<Packet_21.Packet_21_Gradient> gradients = p21.gradients;
        gradients.add(0,p21.gradient);

        int extraValue = p21.gradient.D_GRADIENT != 0 ? 1 : 0;

        double[] gradientArray = new double[(gradients.size() + extraValue) * 2];
        int currentIndex = 0;

        if (p21.gradient.D_GRADIENT != 0) {
            gradientArray[currentIndex++] = 0;
            gradientArray[currentIndex++] = refGradient;
        }

        for(Packet_21.Packet_21_Gradient gradient : gradients){
            totalDistance += gradient.D_GRADIENT * distanceFactor;
            if (gradient.G_A < 255) {
                if (!gradient.Q_GDIR) 	{
                    gradientArray[currentIndex++] = totalDistance;
                    gradientArray[currentIndex++] = - gradient.G_A * 1.0;
                }
                else {
                    gradientArray[currentIndex++] = totalDistance;
                    gradientArray[currentIndex++] = gradient.G_A * 1.0;
                }

            }
            else {
                gradientArray[currentIndex++] = totalDistance;
                gradientArray[currentIndex] = -Double.MAX_VALUE;
                break; //TODO Better way to represent G_A = 255 (see 7.5.1.37)
            }
        }
        return gradientArray;
    }


}
