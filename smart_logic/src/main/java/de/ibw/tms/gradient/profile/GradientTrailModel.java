package de.ibw.tms.gradient.profile;

import de.ibw.tms.plan.elements.Rail;
/**
 * Noch nicht implementiert
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-10
 */
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
