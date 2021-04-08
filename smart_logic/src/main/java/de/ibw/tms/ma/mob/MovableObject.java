package de.ibw.tms.ma.mob;

import de.ibw.tms.ma.MovementAuthority;
import de.ibw.tms.ma.mob.common.NID_ENGINE;
import de.ibw.tms.ma.mob.position.MOBPosition;
import de.ibw.util.ThreadedRepo;

import java.util.Objects;

/**
 * Mobiles Element (Zug etc)
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2021-03-31
 *
 */
public class MovableObject {

    public static ThreadedRepo<NID_ENGINE, MovableObject> ObjectRepo = new ThreadedRepo<>();

    private NID_ENGINE nid_Engine;

    private MOBPosition position;

    private MovementAuthority MA;


    public MovableObject(NID_ENGINE nid_Engine, MOBPosition position) {
        this.nid_Engine = nid_Engine;
        this.position = position;

        position.setMovableObject(this);
        ObjectRepo.update(nid_Engine, this);
    }

    public NID_ENGINE getNid_Engine() {
        return nid_Engine;
    }

    public void setNid_Engine(NID_ENGINE nid_Engine) {
        this.nid_Engine = nid_Engine;
    }

    public MOBPosition getPosition() {
        return position;
    }

    public void setPosition(MOBPosition position) {
        this.position = position;
        position.setMovableObject(this);
    }

    public MovementAuthority getMA() {
        return MA;
    }

    public void setMA(MovementAuthority MA) {
        this.MA = MA;
        MA.setMOB(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovableObject that = (MovableObject) o;
        return Objects.equals(nid_Engine, that.nid_Engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nid_Engine);
    }
}
