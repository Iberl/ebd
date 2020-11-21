package de.ibw.tms.ma.positioning;

import de.ibw.rtm.intf.IRTMAssociatedPositioningSystem;
import de.ibw.rtm.intf.IRTMIntrinsicCoordinate;
import de.ibw.rtm.intf.IRTMPositioningSystem;
import de.ibw.tms.ma.common.DefaultObject;
import de.ibw.tms.ma.common.NetworkResource;
import org.apache.commons.lang3.NotImplementedException;
import org.railMl.rtm4rail.RTMAssociatedPositioningSystem;
import org.railMl.rtm4rail.RTMIntrinsicCoordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AssociatedPositioningSystem extends NetworkResource implements IRTMAssociatedPositioningSystem {
    public static final String CLASS_IDENTIFIER = "Associated_Positioning_System";

    private IRTMPositioningSystem PositioningSystem = null;

    private List<IRTMIntrinsicCoordinate> coordinateList = new ArrayList<>();

    public AssociatedPositioningSystem(IRTMPositioningSystem System) {
        super(CLASS_IDENTIFIER);
        this.PositioningSystem = System;
    }


    public List<IRTMIntrinsicCoordinate> getCoordinates() {
        return this.coordinateList;
    }


    @Override
    public List<RTMIntrinsicCoordinate> getIntrinsicCoordinate() {
        throw new NotImplementedException("ConverterNeeded");
    }

    @Override
    public String getPositioningSystemRef() {
        return PositioningSystem.getId();
    }

    @Override
    public void setPositioningSystemRef(String value) {
        IRTMPositioningSystem System = (IRTMPositioningSystem)
                DefaultObject.topologyRepository.getModel(UUID.fromString(value));
        this.PositioningSystem = System;
    }
}
