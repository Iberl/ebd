package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.ModeProfile;

import java.util.ArrayList;
import java.util.List;

public class ModeAdapter extends ModeProfile {

    @Expose
    public Integer q_dir;
    @Expose
    public Integer q_scale;
    @Expose
    public List<SingleModeAdapter> modes;

    public ModeAdapter(ModeProfile modeProfile) {
        super(modeProfile.q_dir, modeProfile.q_scale, modeProfile.modes);
        this.q_dir = modeProfile.q_dir;
        this.q_scale = modeProfile.q_scale;
        this.modes = new ArrayList();
        ArrayList<ModeProfile.Mode> mList = (ArrayList<Mode>) modeProfile.modes;
        for(Mode M : mList) {
            SingleModeAdapter sma = new SingleModeAdapter(M);
            this.modes.add(sma);
        }


    }

    @Override
    public String toString() {
        return "ModeAdapter{" +
                "q_dir=" + q_dir +
                ", q_scale=" + q_scale +
                ", modes=" + modes +
                '}';
    }

    public ModeProfile convert() {
        ArrayList<Mode> modeList = new ArrayList<>();
        for(SingleModeAdapter ModeAdapter: modes) {
            modeList.add(ModeAdapter.convert());
        }
        return new ModeProfile(this.q_dir, this.q_scale, modeList);
    }
}
