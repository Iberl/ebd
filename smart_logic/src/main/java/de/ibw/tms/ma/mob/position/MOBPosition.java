package de.ibw.tms.ma.mob.position;

import de.ibw.tms.ma.mob.MovableObject;
/**
 * Position einer Mobilen
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2021-03-31
 *
 */
public class MOBPosition {

    // wird beim Zuweisen gesetzt
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
}
