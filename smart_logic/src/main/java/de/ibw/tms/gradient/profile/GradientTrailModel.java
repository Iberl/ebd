package de.ibw.tms.gradient.profile;

import de.ibw.tms.plan.elements.Rail;

public class GradientTrailModel {

    private Rail R;

    @Override
    public String toString() {
        return R.segmentName;

    }

    public GradientTrailModel(Rail R) {
        this.R = R;
    }


    public Rail getR() {
        return R;
    }
}
