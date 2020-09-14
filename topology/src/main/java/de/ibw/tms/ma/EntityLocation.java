package de.ibw.tms.ma;

import de.ibw.tms.ma.physical.LocatedNetEntity;

import java.util.ArrayList;
import java.util.List;

public class EntityLocation {
    private LocatedNetEntity locatedNetEntity;
    private PositioningNetElement MainNetElement;
    private List<PositioningNetElement> positioningNetElementList = new ArrayList<>();

    public LocatedNetEntity getLocatedNetEntity() {
        return locatedNetEntity;
    }

    public void setLocatedNetEntity(LocatedNetEntity locatedNetEntity) {
        this.locatedNetEntity = locatedNetEntity;
    }

    public PositioningNetElement getMainNetElement() {
        return MainNetElement;
    }

    public void setMainNetElement(PositioningNetElement mainNetElement) {
        MainNetElement = mainNetElement;
        if(!positioningNetElementList.contains(MainNetElement)) {
            positioningNetElementList.add(MainNetElement);
        }
    }
}
