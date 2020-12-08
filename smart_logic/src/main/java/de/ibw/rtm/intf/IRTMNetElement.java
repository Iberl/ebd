package de.ibw.rtm.intf;

import org.railMl.rtm4rail.TElementWithIDref;
import java.util.List;
public interface IRTMNetElement extends IRTMNetworkResource {
    List<TElementWithIDref> getRelation();
}
