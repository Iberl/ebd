package de.ibw.tms.ma;

import de.ibw.rtm.intf.IRTMEntityLocation;
import de.ibw.rtm.intf.IRTMLocatedNetEntity;
import de.ibw.rtm.intf.IRTMPositioningNetElement;
import de.ibw.tms.ma.common.NetworkResource;
import de.ibw.tms.ma.physical.LocatedNetEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityLocation extends NetworkResource implements IRTMEntityLocation {
    private IRTMLocatedNetEntity locatedNetEntity;

    private List<IRTMPositioningNetElement> positioningNetElementList = new ArrayList<>();

    public EntityLocation(String sName) {
        super(sName);
    }

    public IRTMLocatedNetEntity getLocatedNetEntity() {
        return locatedNetEntity;
    }

    public void setLocatedNetEntity(IRTMLocatedNetEntity locatedNetEntity) {
        this.locatedNetEntity = locatedNetEntity;
    }

}
