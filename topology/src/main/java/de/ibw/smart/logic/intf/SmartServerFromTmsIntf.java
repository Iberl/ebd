package de.ibw.smart.logic.intf;

import de.ibw.tms.ma.MaRequestWrapper;
import ebd.rbc_tms.util.MA;

import java.util.UUID;

public interface SmartServerFromTmsIntf {
    public void checkMovementAuthority(MaRequestWrapper MaRequest, MA Ma, UUID uuid, String tms_id, String rbc_id,
                                       Long lPriority);

}
