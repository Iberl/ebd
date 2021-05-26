package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.SpeedProfile;

import java.util.ArrayList;
import java.util.List;

public class SpeedSectionAdapter extends SpeedProfile.Section {
    @Expose
    public int d_static;
    @Expose
    public int v_static;
    @Expose
    public boolean q_front;
    @Expose
    public List<SpeedCategoryAdapter> categories;

    public SpeedSectionAdapter(SpeedProfile.Section sec) {
        super(sec.d_static, sec.v_static, sec.q_front, sec.categories);
        this.d_static = sec.d_static;
        this.v_static = sec.v_static;
        this.q_front = sec.q_front;
        categories = new ArrayList<>();
        for(Category C : sec.categories) {
            SpeedCategoryAdapter SC = new SpeedCategoryAdapter(C);
            categories.add(SC);
        }
    }

    @Override
    public String toString() {
        return "SpeedSectionAdapter{" +
                "d_static=" + d_static +
                ", v_static=" + v_static +
                ", q_front=" + q_front +
                ", categories=" + categories +
                '}';
    }
}
