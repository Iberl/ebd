package de.ibw.tms.ma.mob.common;

import java.util.Objects;

/**
 * Id einer Mobilen
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2021-03-31
 *
 */
public class NID_ENGINE {
    private int id;

    public NID_ENGINE(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NID_ENGINE that = (NID_ENGINE) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
