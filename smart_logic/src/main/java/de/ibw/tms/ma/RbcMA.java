package de.ibw.tms.ma;

import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.mob.common.NID_ENGINE;

import java.io.Serializable;


public class RbcMA extends MovementAuthority implements Serializable {
    public static final long serialVersionUID = 773L;

    // für Christopher.... bitte zeitnah schicken...
    public RbcMA(String sTrainId) {
        this.sTrainId = sTrainId;
        try {
            int iTrainId = Integer.parseInt(sTrainId);
            NID_ENGINE nid_engine = new NID_ENGINE(iTrainId);
            MovableObject MOB = MovableObject.ObjectRepo.getModel(nid_engine);
            if(MOB == null) return;
            MOB.setMA(this);
        } catch(NumberFormatException NFE) {
            NFE.printStackTrace();
        }


    }

    public String sTrainId;





}
