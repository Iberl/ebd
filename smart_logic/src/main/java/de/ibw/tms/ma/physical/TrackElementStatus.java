package de.ibw.tms.ma.physical;

import com.google.gson.annotations.Expose;
import de.ibw.tms.ma.physical.intf.IControlledElementStatus;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author iberl@verkehr.tu-darmstadt.de
 * @version MVP5
 * @since 2021-03-12
 */
public class TrackElementStatus implements Serializable, IControlledElementStatus {

    public enum Status {
        UNKNOWN, LEFT, RIGHT
    }
    @Expose
    public List<Status> statusList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrackElementStatus that = (TrackElementStatus) o;
        return Objects.equals(statusList, that.statusList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusList);
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("statusList", statusList)
                .toString();
    }
}
