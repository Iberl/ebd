package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.GradientProfile;

import java.util.ArrayList;
import java.util.List;

public class GradientProfileAdapter extends GradientProfile {
    @Expose
    public Integer q_dir;
    @Expose
    public Integer q_scale;
    @Expose
    public List<GradientAdapter> gradients;


    @Override
    public String toString() {
        return "GradientProfileAdapter{" +
                "q_dir=" + q_dir +
                ", q_scale=" + q_scale +
                ", gradients=" + gradients +
                '}';
    }

    public GradientProfileAdapter(GradientProfile gradientProfile) {
        super(gradientProfile.q_dir,gradientProfile.q_scale, gradientProfile.gradients);
        this.q_dir = gradientProfile.q_dir;
        this.q_scale = gradientProfile.q_scale;
        this.gradients = new ArrayList<>();
        List<Gradient> list = gradientProfile.gradients;
        for(Gradient G : list) {
            GradientAdapter GradAdapter = new GradientAdapter(G);
            this.gradients.add(GradAdapter);
        }


    }

    public GradientProfile convert() {
        ArrayList<Gradient> gradList = new ArrayList<>();
        for(GradientAdapter GA: this.gradients) {
            Gradient G = GA.convert();
            gradList.add(G);
        }

        return new GradientProfile(this.q_dir, this.q_scale, gradList);

    }
}
