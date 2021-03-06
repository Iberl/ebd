package de.ibw.tms;

import de.ibw.tms.trackplan.controller.MoveController;
import de.ibw.tms.trackplan.controller.ZoomController;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
/**
 * Verwaltet Mousclicks in einer Zeichenfl&auml;che.
 *
 * @author iberl@verkehr.tu-darmstadt.de
 *
 * @version 0.3
 * @since 2020-08-12
 */
public class GraphicMoveByMouse {
    private Point mousePt;
    private boolean pressed;

    /**
     * Registriert das Panel um Mouseclicks auf diesem zu verwalten.
     * @param jPanel {@link JPanel}
     */
    public GraphicMoveByMouse(JPanel jPanel) {
        jPanel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MouseListener mouseListener = new MouseListener(jPanel);
        jPanel.addMouseListener(mouseListener);
        jPanel.addMouseMotionListener(mouseListener);
        jPanel.addMouseWheelListener(mouseListener);
    }

    private class MouseListener extends MouseInputAdapter {
        JPanel jPanel;

        public MouseListener(JPanel jPanel) {
            this.jPanel = jPanel;
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if(e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
                ZoomController zoomController = ZoomController.getInstance();
                if(e.getUnitsToScroll() == 0) return;
                if(e.getUnitsToScroll() < 0) zoomController.zoomIn();
                else zoomController.zoomOut();
            }
            //System.out.println("scrolled" + e.getUnitsToScroll());
            jPanel.repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            switch(e.getModifiersEx()) {
                case InputEvent.BUTTON1_DOWN_MASK: {
                    pressed = true;
                    mousePt = e.getPoint();
                    jPanel.repaint();
                    break;
                }
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            switch(e.getModifiersEx()) {
                case InputEvent.BUTTON1_DOWN_MASK: {
                    updatePoint(e);
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            switch(e.getModifiersEx()) {
                case InputEvent.BUTTON1_DOWN_MASK: {
                    if (pressed) {
                        updatePoint(e);
                    }
                }
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            switch(e.getModifiersEx()) {
                case InputEvent.BUTTON1_DOWN_MASK: {
                    updatePoint(e);
                    pressed = false;
                }
            }
        }

        private void updatePoint(MouseEvent e) {
            switch(e.getModifiersEx()) {
                case InputEvent.BUTTON1_DOWN_MASK: {


                    int dx = e.getX() - mousePt.x;
                    int dy = e.getY() - mousePt.y;
                    MoveController.getInstance().setTranslation(dx, dy);
                    mousePt = e.getPoint();
                    jPanel.repaint();
                }
            }
        }

    }
}
