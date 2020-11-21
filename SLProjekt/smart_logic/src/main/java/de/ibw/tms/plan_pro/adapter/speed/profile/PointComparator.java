package de.ibw.tms.plan_pro.adapter.speed.profile;

import plan_pro.modell.geodaten._1_9_0.CStreckePunkt;

import java.util.Comparator;

/**
 * Not used now belongs to SSP
 */
public class PointComparator implements Comparator<CStreckePunkt> {

    @Override
    public int compare(CStreckePunkt cStreckePunkt, CStreckePunkt t1) {
        return cStreckePunkt.getStreckeMeter().getWert().compareTo(t1.getStreckeMeter().getWert());
    }
}
