package de.ibw.tms.ma.positioned.elements;

import de.ibw.rtm.intf.IRTMNetEntity;
import de.ibw.tms.ma.common.NetworkResource;

/**
 * Ein Netzelement mit Position
 *
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-12
 */
public abstract class NetEntity extends NetworkResource implements IRTMNetEntity {
    public NetEntity(String sName) {
        super(sName);
    }

}
