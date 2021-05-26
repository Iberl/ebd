package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.SpeedProfile;

import java.util.ArrayList;
import java.util.List;

public class SpeedProfileAdapter extends SpeedProfile {
    @Expose
    public Integer q_dir;
    @Expose
    public Integer q_scale;
    @Expose
    public List<SpeedSectionAdapter> sections = new ArrayList();

    public SpeedProfileAdapter(SpeedProfile sp) {
        super(sp.q_dir, sp.q_scale, sp.sections);
        this.q_dir = sp.q_dir;
        this.q_scale = sp.q_scale;
        this.sections = new ArrayList<>();
        for (Section S : sp.sections) {
            SpeedSectionAdapter SpSectionAdapter = new SpeedSectionAdapter(S);
            sections.add(SpSectionAdapter);
        }
    }

    @Override
    public String toString() {
        return "SpeedProfileAdapter{" +
                "q_dir=" + q_dir +
                ", q_scale=" + q_scale +
                ", sections=" + sections +
                '}';
    }

    public SpeedProfile convert() {
        ArrayList<SpeedProfile.Section> sections = new ArrayList<>();
        for(SpeedSectionAdapter SpeedSec: this.sections) {
            ArrayList<Section.Category> categories = new ArrayList<>();
            for(SpeedCategoryAdapter Cat: SpeedSec.categories) {
                categories.add(Cat.convert());
            }
            SpeedProfile.Section S = new Section(SpeedSec.d_static, SpeedSec.v_static, SpeedSec.q_front, categories);
            sections.add(S);
        }



        return new SpeedProfile(this.q_dir, this.q_scale, sections);

    }
}
