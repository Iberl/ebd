package de.ibw.tms.trackplan.ui;

import de.ibw.tms.ma.physical.LocatedNetEntity;

/**
 * Bahnhof
 * Unused
 */
public class StopPosition extends LocatedNetEntity {
    private int effectiveClearance;
    private boolean water;
    private boolean sand;
    private boolean air;
    private boolean electricity;
    private boolean diesel;

    public StopPosition(String sName) {
        super(sName);
    }
}
