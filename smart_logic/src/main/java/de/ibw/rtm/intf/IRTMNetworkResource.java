package de.ibw.rtm.intf;

import org.railMl.rtm4rail.RTMValidity;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

public interface IRTMNetworkResource extends IRTMBaseObject {
    List<RTMValidity> getIsValid() throws DatatypeConfigurationException;
}
