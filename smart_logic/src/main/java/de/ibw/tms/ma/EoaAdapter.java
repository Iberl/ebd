package de.ibw.tms.ma;

import com.google.gson.annotations.Expose;
import ebd.internal.util.EOA;

import java.util.ArrayList;
import java.util.List;

public class EoaAdapter extends EOA {
    @Expose
    public Integer q_dir;
    @Expose
    public Integer q_scale;
    @Expose
    public int v_loa;
    @Expose
    public int t_loa;
    @Expose
    public List<EoaSectionAdapter> sections;
    @Expose
    public EndTimerAdapter endTimer;
    @Expose
    public DangerPointAdapter dangerPoint;
    @Expose
    public OverlapApdapter overlap;



    public EoaAdapter(EOA eoa) {
        super(eoa.q_dir, eoa.q_scale, eoa.v_loa, eoa.t_loa, eoa.sections, eoa.endTimer, eoa.dangerPoint, eoa.overlap);
        this.q_dir = eoa.q_dir;
        this.q_scale = eoa.q_scale;
        this.v_loa = eoa.v_loa;
        this.t_loa = eoa.t_loa;
        this.sections = new ArrayList();
        for(Section s : eoa.sections){
            EoaSectionAdapter  eoaSection = new EoaSectionAdapter(s);
            this.sections.add(eoaSection);
        }
        this.endTimer = new EndTimerAdapter(eoa.endTimer);

        if(eoa.dangerPoint == null) {
            this.dangerPoint = null;
        } else this.dangerPoint = new DangerPointAdapter(eoa.dangerPoint);

        if(eoa.overlap == null) {
            this.overlap = null;
        } else this.overlap = new OverlapApdapter(eoa.overlap);
    }

    @Override
    public String toString() {
        return "EoaAdapter{" +
                "q_dir=" + q_dir +
                ", q_scale=" + q_scale +
                ", v_loa=" + v_loa +
                ", t_loa=" + t_loa +
                ", sections=" + sections +
                ", endTimer=" + endTimer +
                ", dangerPoint=" + dangerPoint +
                ", overlap=" + overlap +
                '}';
    }

    public EOA convert() {
        ArrayList<Section> sections = new ArrayList<>();

        EndTimer ETimer = null;
        DangerPoint DPoint = null;
        Overlap OLap = null;
        for(EoaSectionAdapter SectionAdapter: this.sections) {
            Section S = SectionAdapter.convert();
            sections.add(S);
        }


        if(this.endTimer != null) {
            ETimer = this.endTimer.convert();
        }
        if(this.dangerPoint != null) {
            DPoint = this.dangerPoint.convert();
        }
        if(this.overlap != null) {
            OLap = this.overlap.convert();
        }
        EOA EoaResult = new EOA(this.q_dir, this.q_scale, this.v_loa,this.t_loa, sections,ETimer, DPoint,OLap);

        return EoaResult;

    }
}
