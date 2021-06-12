package de.ibw.tms.ma.mob.position;

import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.util.intf.IToLogIntf;

/**
 * Position einer Mobilen
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1
 * @since 2021-06-11
 *
 */
public class MOBPosition implements IToLogIntf {

    // wird beim Zuweisen gesetzt // Referenz wechselseitig
    private MovableObject movableObject;


    private MOBPositionClasses positionArea;



    public MOBPosition(MOBPositionClasses positionArea) {
        this.positionArea = positionArea;
        positionArea.setLinkToMobileObject(this);
    }

    public MovableObject getMovableObject() {
        return movableObject;
    }

    public void setMovableObject(MovableObject movableObject) {
        this.movableObject = movableObject;
    }

    public MOBPositionClasses getPositionArea() {
        return positionArea;
    }

    public void setPositionArea(MOBPositionClasses positionArea) {
        this.positionArea = positionArea;
    }

    @Override
    public String toString() {
        return "MOBPosition{" +
                "positionArea=" + positionArea +
                '}';
    }

    @Override
    public String log() {
        return toString();
    }
}
