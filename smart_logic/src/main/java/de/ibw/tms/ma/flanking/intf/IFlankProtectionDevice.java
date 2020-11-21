package de.ibw.tms.ma.flanking.intf;

import de.ibw.tms.ma.flanking.FlankProtectionWatchlist;

import java.util.List;

public interface IFlankProtectionDevice {
    List<FlankProtectionWatchlist> getFlankWatches();

}
