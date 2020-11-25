package de.ibw.smart.logic.intf;

import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.Route;
import ebd.rbc_tms.util.MA;

import java.util.UUID;

public interface SmartServerFromTmsIntf {
    public void checkMovementAuthority(int iTrainId, Route R, MA Ma, UUID uuid, String tms_id, String rbc_id,
                                       Long lPriority);

}
