package de.ibw.smart.logic.intf;

import de.ibw.history.data.ComposedRoute;
import ebd.messageLibrary.packet.trackpackets.Packet_5;

public interface ILinkingIntf {
    Packet_5 generateLinkingByRoute(ComposedRoute compRoute, int nid_lrbg);
}
