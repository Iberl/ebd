package de.ibw.tms.ui.route.model;

import de.ibw.tms.intf.cmd.CheckDbdCommand;
import de.ibw.tms.plan.elements.interfaces.IConnectable;
import de.ibw.tms.plan.elements.interfaces.ISwitchHandler;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan_pro.adapter.topology.TopologyGraph;
import de.ibw.tms.ui.route.controller.RouteController;
import de.ibw.util.DefaultRepo;
import plan_pro.modell.geodaten._1_9_0.CGEOKante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Eine Kante innerhalb einer DKW
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 1.1.11
 * @since 2021-07-02
 *
 */
public class DbdCommandEdgeReference extends Line2D.Double implements Iinteractable, IConnectable {

    public static DefaultRepo<CGEOKante, DbdCommandEdgeReference> ReferenceRepo = new DefaultRepo();
    public double dTolerance = 1;

    private TopologyGraph.Edge E = null;
    private CGEOKante GeoE = null;
    private CheckDbdCommand DbdCommand = null;



    @Override
    public String getViewName() {
        String sPostfixName = "";
        if(DbdCommand != null) {
            String aId = E.A.name;
            String bId = E.B.name;
            if(aId.equals(DbdCommand.sId)) {
                int iBegin = bId.length() - 2;
                sPostfixName = aId + "-" + bId.substring(iBegin);
            } else {
                int iBegin = aId.length() -2;
                sPostfixName = bId + "-" + aId.substring(iBegin);
            }
            return "DKW | EKW " + sPostfixName;
        }
        return "DKW | EKW";
    }

    @Override
    public ArrayList<JComponent> getViewElements() {
        if(DbdCommand != null) {
            ArrayList<JComponent> uiList = new ArrayList<JComponent>();
            uiList.add(new JLabel("<HTML><b><u>".concat(this.getViewName())
                    .concat("</u></b></HTML>")));
            uiList.add(new JSeparator(SwingConstants.HORIZONTAL));
            uiList.add(generateSwitchButton());
            return uiList;
        }
        return new ArrayList<>();




    }

    private JButton generateSwitchButton() {
        JButton result = new JButton("Switch DKW | EKW to " + DbdCommand.printStatus() );
        result.addActionListener(handleSwitchEvent());
        return result;
    }

    private ActionListener handleSwitchEvent() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RouteController.sendTESC_Request(DbdCommandEdgeReference.this.DbdCommand);
            }
        };
    }


    public void setTopEdge(TopologyGraph.Edge e) {
        this.E = e;
    }

    public void setGeoEdge(CGEOKante geoEdge) {
        this.GeoE = geoEdge;
        ReferenceRepo.update(GeoE, this);
    }

    public TopologyGraph.Edge getE() {
        return E;
    }

    public void setDbdCommand(CheckDbdCommand dbdCommand) {
        DbdCommand = dbdCommand;
    }
}
