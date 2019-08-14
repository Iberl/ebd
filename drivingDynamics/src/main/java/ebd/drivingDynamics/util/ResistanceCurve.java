package ebd.drivingDynamics.util;

import ebd.globalUtils.spline.ForwardSpline;

/**
 * Always negative
 */
public class ResistanceCurve extends ForwardSpline {
    public ResistanceCurve(int degree, String id) {
        super(degree, id);
    }

    public ResistanceCurve(int degree) {
        super(degree);
    }
}
