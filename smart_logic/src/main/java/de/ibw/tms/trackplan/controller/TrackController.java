package de.ibw.tms.trackplan.controller;

import de.ibw.tms.MainTmsSim;
import de.ibw.tms.ma.MaRequestWrapper;
import de.ibw.tms.ma.repo.MaRepository;
import de.ibw.tms.plan.elements.Rail;
import de.ibw.tms.plan.elements.interfaces.Iinteractable;
import de.ibw.tms.plan.elements.model.PlanData;
import de.ibw.tms.trackplan.MaCreatingFrame;
import de.ibw.tms.trackplan.TrackplanGraphicPanel;
import de.ibw.tms.trackplan.controller.Intf.IController;
import de.ibw.tms.trackplan.ui.RouteViewPort;
import de.ibw.tms.trackplan.ui.TrackPanel;
import de.ibw.tms.trackplan.ui.TrackWindow;
import de.ibw.tms.trackplan.viewmodel.TranslationModel;
import de.ibw.tms.trackplan.viewmodel.ZoomModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
/**
 * Verwaltet Mas. Mas dieses Controllers werden in einem Track-Dialog-Angelegt.
 * Dieser hat wie das Hauptfenster eine Karte.
 *
 *
 * @author iberl@verkehr.tu-darmstadt.de
 * @version 0.3
 * @since 2020-08-11
 */
public class TrackController extends SubmissionPublisher<String> implements IController<String> {

    /**
     * Holt den Kontroller der zum angegebenen Fenster geh&ouml;rt.
     * @param TrackPanel - Das Fenster zu dem der Controller angefragt wird
     * @return TrackController - Verwaltung von Mas
     */
    public static TrackController getInstance(TrackplanGraphicPanel TrackPanel) {

            return new TrackController(TrackPanel);


    }

    /**
     * Speichert letzeten Punkt, den der Nutzer angeclickt hat
     */
    public static Point ClickPoint = null;



    private PlanData DataModel;

    private RouteViewPort RoutePort;

    private JPopupMenu EditMaMenu;
    private JPopupMenu DeleteMaMenu;

    /**
     * Beantragt, dass Nutzer eine neue Ma definieren will. Das Fenster wird aufgemacht.
     */
    public void requestMaAction() {
        new MaCreatingFrame(new MaRequestWrapper(null), MainTmsSim.MainFrame);
    }

    /**
     * Vorhandene MA soll bearbeitet werden.
     */
    public void editMaAction() {
        JLabel emptyLabel = new JLabel("keine MA beantragt");
        EditMaMenu = new JPopupMenu();
        JButton CloseButton = new JButton("schließen");
        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TrackController.this.EditMaMenu.setVisible(false);
            }
        });
        emptyLabel.addMouseListener(new MouseListener() {
                                        @Override
                                        public void mouseClicked(MouseEvent mouseEvent) {
                                            TrackController.this.EditMaMenu.setVisible(false);
                                        }

                                        @Override
                                        public void mousePressed(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseReleased(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseEntered(MouseEvent mouseEvent) {

                                        }

                                        @Override
                                        public void mouseExited(MouseEvent mouseEvent) {

                                        }
                                    });
        EditMaMenu = new JPopupMenu();
        Collection<MaRequestWrapper> maRequest = MaRepository.getMaList();
        EditMaMenu.setLocation(300, 100);
        if(maRequest.size() == 0) {
            EditMaMenu.add(emptyLabel);
        } else {
            for(MaRequestWrapper Request: maRequest) {
                String sTrainId = Request.getTm().label;
                String sMenuText = "Für Zug Id ".concat(sTrainId).concat(" MA bearbeiten");
                JMenuItem RequestItem = new JMenuItem(sMenuText);
                RequestItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        new MaCreatingFrame(Request, MainTmsSim.MainFrame);
                    }
                });
                EditMaMenu.add(RequestItem);
            }
        }
        EditMaMenu.add(CloseButton);
        EditMaMenu.setVisible(true);
    }



    private TrackController(TrackplanGraphicPanel TrackPanel) {

        this.DataModel = PlanData.getInstance();
        if(TrackPanel != null) {
            this.RoutePort = TrackPanel.getRoutePort();
        }
    }

    /**
     * Verwaltet Clicks auf der Zeichenebene.
     * @param point {@link Point} Stelle an die geclickt wurde
     * @param isMainWindow - wurde auf dem Hauptfenster geclickt.
     */
    public void handleMousePress(Point point, boolean isMainWindow) {
        TranslationModel MapTranslation = TranslationModel.getInstance();
        ZoomModel Zoom = TranslationModel.TrackplanEnvironment.CurrentEnvironment.Zoom;
        Point TranslatedPoint = new Point();

        TranslatedPoint.x = (int) (point.x / Zoom.getdZoomX()  - MapTranslation.getdMoveX());
        TranslatedPoint.y = (int) (point.y / Zoom.getdZoomY() - MapTranslation.getdMoveY()) * -1;
        ClickPoint = TranslatedPoint;
        ArrayList panels = new ArrayList();
        Iterator shapes= DataModel.getInteractable().iterator();
        for (int i= 1; shapes.hasNext(); i++) {
            Shape S = (Shape) shapes.next();
            if(S.contains(TranslatedPoint)) {
                if(S instanceof Iinteractable) {
                    de.ibw.tms.trackplan.ui.TrackPanel TrackUtilPanel = new TrackPanel((Iinteractable)
                            S, point, this.RoutePort, isMainWindow);
                    panels.add(TrackUtilPanel);
                }
            }
            if(S instanceof Line2D) {
                Line2D LineRail = (Line2D) S;
                if(LineRail.ptSegDist(TranslatedPoint) < Rail.dRailTolerance) {
                    de.ibw.tms.trackplan.ui.TrackPanel TrackUtilPanel = new TrackPanel((Iinteractable) S, point, this.RoutePort, isMainWindow);
                    panels.add(TrackUtilPanel);
                }
            }




        }
        if(panels.size() > 0) new TrackWindow(panels, point, isMainWindow);
    }


    /**
     * Ma ver&auml;nderung wird weitergegeben
     */

    @Override
    public void publish() {
        this.standardSubscription();
        this.submit("Ma changed");

        //this.close();
        //this.subs
    }

    /**
     * Liste aller zu benachrichtigten Komponenten.
     * Bisher nur das Hauptfenster.
     * @return List - Benachrichtigte Komponenten.
     */
    @Override
    public List<Flow.Subscriber> getSubscriberList() {
        List<Flow.Subscriber> returnList = new ArrayList<Flow.Subscriber>();
        returnList.add(MainTmsSim.MainSubscriber);
        return returnList;
    }

    /**
     * Setzt die Vermittlung zu Routen
     * @param routePort {@link RouteViewPort} - Vermittlung zu Routen
     */
    public void setRouteViewPort(RouteViewPort routePort) {
        this.RoutePort = routePort;
    }

    /**
     * Entfernt eine entworfene nicht gesendete MA.
     */
    public void deleteMaAction() {
        JLabel emptyLabel = new JLabel("keine MA beantragt");
        DeleteMaMenu = new JPopupMenu();
        JButton CloseButton = new JButton("schließen");
        CloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TrackController.this.DeleteMaMenu.setVisible(false);
            }
        });
        emptyLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                TrackController.this.DeleteMaMenu.setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        DeleteMaMenu = new JPopupMenu();
        Collection<MaRequestWrapper> maRequest = MaRepository.getMaList();
        DeleteMaMenu.setLocation(300, 100);
        if(maRequest.size() == 0) {
            DeleteMaMenu.add(emptyLabel);
        } else {
            for(MaRequestWrapper Request: maRequest) {
                String sTrainId = Request.getTm().label;
                String sMenuText = "Für Zug Id ".concat(sTrainId).concat(" MA löschen");
                JMenuItem RequestItem = new JMenuItem(sMenuText);
                RequestItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        Request.delete();
                        TrackController.this.publish();
                    }
                });
                DeleteMaMenu.add(RequestItem);
            }
        }
        DeleteMaMenu.add(CloseButton);
        DeleteMaMenu.setVisible(true);
    }
}
