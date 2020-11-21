package de.ibw.tms.ma.net.elements;

import de.ibw.rtm.intf.IRTMNetElement;
import de.ibw.tms.ma.common.NetworkResource;
import org.railMl.rtm4rail.TElementWithIDref;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Ein allgemeines Strukturelles Netzelement
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-14
 */
public abstract class NetElement extends NetworkResource implements IRTMNetElement {

    public NetElement(String sName) {
        super(sName);
    }

    @Override
    public List<TElementWithIDref> getRelation() {
        return new ArrayList<>();
    }
}
