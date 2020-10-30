package ebd.globalUtils.etcsPacketConverters;

import ebd.globalUtils.position.Position;
import ebd.globalUtils.spline.ForwardSpline;
import ebd.globalUtils.spline.Knot;
import ebd.messageLibrary.packet.trackpackets.Packet_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
    public static ForwardSpline packet21ToAccGP(Packet_21 p21, double refGradient) {

        double totalDistance = 0d;
        double distanceFactor = Math.pow(10, p21.Q_SCALE - 1);
        double gradToAccFactor = 9.81 * 0.001;

        /*
         * We add the gradient into the list of all gradients
         */
        List<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>(p21.gradients); //Speculative fix for concurrent modification exception
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
    public static ForwardSpline packet21ToGP(Packet_21 p21, double refGradient) {

        double totalDistance = 0d;
        double distanceFactor = Math.pow(10, p21.Q_SCALE - 1);

        /*
         * We add the gradient into the list of all gradients
         */
        List<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>(p21.gradients); //Speculative fix for concurrent modification exception
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
                if (!gradient.Q_GDIR) 	{gp.addKnotToCurve(new Knot(totalDistance, -(double)gradient.G_A));}
                else 					{gp.addKnotToCurve(new Knot(totalDistance, (double)gradient.G_A));}

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
    public static double[][] packet21ToGradArray(Packet_21 p21, double refGradient) {

        double totalDistance = 0d;
        double distanceFactor = Math.pow(10, p21.Q_SCALE - 1);

        /*
         * We add the gradient into the list of all gradients
         */
        List<Packet_21.Packet_21_Gradient> gradients = new ArrayList<>(p21.gradients); //Speculative fix for concurrent modification exception
        gradients.add(0,p21.gradient);

        int extraValue = p21.gradient.D_GRADIENT != 0 ? 1 : 0;

        double[][] gradientArray = new double[(gradients.size() + extraValue)][2];
        int currentIndex = 0;

        if (p21.gradient.D_GRADIENT != 0) {
            double[] ta = {0,refGradient};
            gradientArray[currentIndex++] = ta;
        }

        for(Packet_21.Packet_21_Gradient gradient : gradients){
            totalDistance += gradient.D_GRADIENT * distanceFactor;
            if (gradient.G_A < 255) {
                if (!gradient.Q_GDIR){
                    double[] ta = {totalDistance, -gradient.G_A};
                    gradientArray[currentIndex++] = ta;
                }
                else {
                    double[] ta = {totalDistance, gradient.G_A};
                    gradientArray[currentIndex++] = ta;
                }

            }
            else {
                gradientArray[currentIndex] = new double[]{totalDistance, -Double.MAX_VALUE};
                break; //TODO Better way to represent G_A = 255 (see 7.5.1.37)
            }
        }
        return gradientArray;
    }

    public static String packet21ToDMIString(Packet_21 p21, double refGradient, double offsetFromTripStart){
        StringBuilder sb = new StringBuilder("gp ");

        double [][] gp = packet21ToGradArray(p21, refGradient);
        Iterator<double[]> iter = Arrays.stream(gp).iterator();

        while(iter.hasNext()){
            double[] temp = iter.next();
            sb.append(temp[0] + offsetFromTripStart).append(",").append(temp[1]);
            if(iter.hasNext()) sb.append(";");
        }

        return sb.toString();
    }


}
