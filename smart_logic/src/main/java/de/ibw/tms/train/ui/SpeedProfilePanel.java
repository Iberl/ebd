package de.ibw.tms.train.ui;

import de.ibw.tms.train.controller.SpeedProfileController;
import de.ibw.tms.train.model.TrainModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

public class SpeedProfilePanel extends JPanel {

    private static int height = 700;

    private TrainModel Model;
    private SpeedProfileController SpeedController;

    public SpeedProfilePanel(TrainModel Model, SingleTrainSubPanel TrainSubPanel) {
        super();
        this.setBounds(this.getX(),this.getY(), 700, height);
        this.Model = Model;

        this.SpeedController = new SpeedProfileController(Model, this);


        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                SpeedProfilePanel.this.SpeedController.handleMousePress(e.getPoint());

            }
        });












    }
    private void drawCenteredString(Graphics2D g2d, String string,
                                    int x0, int y0, float angle) {
        FontRenderContext frc = g2d.getFontRenderContext();
        Rectangle2D bounds = g2d.getFont().getStringBounds(string, frc);
        LineMetrics metrics = g2d.getFont().getLineMetrics(string, frc);
        if (angle == 0) {
            g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                    y0 + metrics.getHeight() / 2);
        } else {
            g2d.rotate(angle, x0, y0);
            g2d.drawString(string, x0 - (float) bounds.getWidth() / 2,
                    y0 + metrics.getHeight() / 2);
            g2d.rotate(-angle, x0, y0);
        }
    }
    private void paintAxes(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.blue);



        YAxis Y = new YAxis(50, 50, height, Model.iSpeedMax);
        XAxis X = new XAxis(50, 140, 50,height, 140 );
        g2d.draw(Y);
        double dSpeedDescription = Model.iSpeedMax * 0.75d;
        String speedDesc = String.valueOf((dSpeedDescription));
        g2d.draw(X);






        drawCenteredString(g2d, speedDesc, 50, (int) Math.ceil(height * 0.75d), 0);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);

        g2d.setFont(new Font("Century Schoolbook", Font.PLAIN, 12));

        paintAxes(g);

               /* Data.refreshData();
                Float xLower = d.getXLower();
                Float xUpper = d.getXUpper();
                Float xInterval = d.getXInterval();
                Float yLower = d.getYLower();
                Float yUpper = d.getYUpper();
                Float yInterval = d.getYInterval();
                Float dx = xUpper - xLower;
                Float dy = yUpper - yLower;

                drawCenteredString(g2d, d.getTitle(), 250, 25, (float) 0.);
                drawCenteredString(g2d, d.getXTitle(), 250, 475, (float) 0.);
                drawCenteredString(g2d, d.getYTitle(), 25, 250,
                        (float) -Math.PI / 2);
                drawCenteredString(g2d, xLower.toString(), 50, 475, (float) 0);
                drawCenteredString(g2d, xUpper.toString(), 450, 475, (float) 0);
                drawCenteredString(g2d, yLower.toString(), 25, 450, (float) 0);
                drawCenteredString(g2d, yUpper.toString(), 25, 50, (float) 0);*/

        //g2d.setPaint(Color.gray);


                /*for (Float x = 50f; x <= 450; x += 400 * xInterval / dx)
                    g2d.draw(new Line2D.Float(x, 450, x, 50));
                for (Float y = 50f; y <= 450; y += 400 * yInterval / dy)
                    g2d.draw(new Line2D.Float(45, y, 450, y));

                g2d.setPaint(Color.red);
                Float diam = 8f;
                int num_points = d.getNumberOfPoints();
                for (int i = 0; i < num_points; i++) {
                    Float ex = 400 * (d.getPoint(i).x - xLower) / dx + 50;
                    ex -= diam / 2;
                    Float ey = -400 * (d.getPoint(i).y - yLower) / dy + 450;
                    ey -= diam / 2;
                    g2d.fill(new Ellipse2D.Float(ex, ey, diam, diam));
                  */

    }


}
