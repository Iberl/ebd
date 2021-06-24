package de.ibw.tms.ui.route.model;

import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;

import javax.swing.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Eine Geographische Karte in dem Trackpanel des TMS
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.10
 * @since 2021-06-23
 *
 */
public class GeoEdgeReference extends Line2D.Double implements Iinteractable, IConnectable {

    @Override
    public String getViewName() {
        return null;
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        return null;
    }
}
