package de.ibw.tms.ma.flanking;

import de.ibw.tms.ma.flanking.intf.IFlankProtectionDevice;
import de.ibw.tms.ma.positioned.elements.DangerArea;

import java.util.List;

/**
 * Ein Flankenschutz &Uuml;berwachungsliste
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.4
 * @since 2020-10-30
 */
public class FlankProtectionWatchlist {
    private List<DangerArea> dangerAreaList;
    private List<IFlankProtectionDevice> flankDevices;

}
