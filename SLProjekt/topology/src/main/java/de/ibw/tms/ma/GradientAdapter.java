package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.rbc_tms.util.GradientProfile;

public class GradientAdapter extends GradientProfile.Gradient {
    @Expose
    public int d_gradient;
    @Expose
    public boolean q_gdir;
    @Expose
    public int g_a;


    public GradientAdapter(GradientProfile.Gradient Grad) {
        super(Grad.d_gradient, Grad.q_gdir, Grad.g_a);
        this.d_gradient = Grad.d_gradient;
        this.q_gdir = Grad.q_gdir;
        this.g_a = Grad.g_a;
    }

    @Override
    public String toString() {
        return "GradientAdapter{" +
                "d_gradient=" + d_gradient +
                ", q_gdir=" + q_gdir +
                ", g_a=" + g_a +
                '}';
    }

    public GradientProfile.Gradient convert() {
        return new GradientProfile.Gradient(this.d_gradient, this.q_gdir, this.g_a);
    }
}
