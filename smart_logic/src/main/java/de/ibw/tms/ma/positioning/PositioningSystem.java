package de.ibw.tms.ma.positioning;

import de.ibw.rtm.intf.IRTMPositioningSystem;
import de.ibw.tms.ma.common.DefaultObject;
import ebd.globalUtils.position.Position;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMValidity;

import java.util.List;

/**
 *
 * Allgemeine Positionierungssysteme
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-15
 */
public abstract class PositioningSystem extends DefaultObject implements IRTMPositioningSystem {

    public PositioningSystem(String sName) {
        super(sName);
    }

    @Override
    public List<RTMValidity> getIsValid() {
        return null;
    }

    @Override
    public String getId() {
        return getUuid().toString();
    }

    @Override
    public void setId(String value) {
        throw new NotImplementedException("UUID kann nicht gesetzt werden.");
    }
}
