package de.ibw.tms.ma.occupation;

import de.ibw.tms.ma.MovementAuthority;
import de.ibw.tms.ma.mob.MovableObject;
import de.ibw.tms.ma.occupation.intf.IMoveable;

/**
 * Ein von einer MA belegter Abschnitt
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class MAOccupation extends Occupation implements IMoveable {
    public static final String CLASS_IDENTIFIER = "MA_Occupation";

    private MovementAuthority MA;

    public MAOccupation() {
        super(CLASS_IDENTIFIER);
    }

    public MovementAuthority getMA() {
        return MA;
    }

    public void setMA(MovementAuthority MA) {
        this.MA = MA;
    }

    @Override
    public MovableObject getTargetMoveableObject() {
       return MA.getMOB();
    }
}
