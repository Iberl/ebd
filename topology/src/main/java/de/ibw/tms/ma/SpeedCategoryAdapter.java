package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.SpeedProfile;

public class SpeedCategoryAdapter extends SpeedProfile.Section.Category {
    @Expose
    public int q_diff;
    @Expose
    public int nc_cddiff;
    @Expose
    public int nc_diff;
    @Expose
    public int v_diff;


    public SpeedCategoryAdapter(SpeedProfile.Section.Category c) {

        super(c.q_diff, c.nc_cddiff, c.nc_diff, c.v_diff);

        this.q_diff = c.q_diff;
        this.nc_cddiff = c.nc_cddiff;
        this.nc_diff = c.nc_diff;
        this.v_diff = c.v_diff;


    }

    @Override
    public String toString() {
        return "SpeedCategoryAdapter{" +
                "q_diff=" + q_diff +
                ", nc_cddiff=" + nc_cddiff +
                ", nc_diff=" + nc_diff +
                ", v_diff=" + v_diff +
                '}';
    }

    public SpeedProfile.Section.Category convert() {
        return new SpeedProfile.Section.Category(this.q_diff,this.nc_cddiff,this.nc_diff,this.v_diff);
    }
}
