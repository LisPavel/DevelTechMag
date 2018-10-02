package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

import controller.Controller;
import myShape.*;

import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Денис on 18.09.2018.
 */
public class MyPanel extends JPanel implements Observer {
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        controller.draw(g2);

    }

    public MyPanel(){

        this.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                controller.press(e.getPoint());

            }

        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                controller.drag(e.getPoint());
            }

        });

    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
    }
}
