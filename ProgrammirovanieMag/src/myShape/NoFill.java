package myShape;

import myShape.FillBehavior;
import myShape.MyShape;

import java.awt.*;

public class NoFill implements FillBehavior {
    @Override
    public void draw(Graphics2D g2, MyShape ms) {
        Paint p = g2.getPaint();
        g2.setPaint(ms.getCol());
        g2.setStroke(new BasicStroke(ms.getBorderSize()));
        //g2.fill(ms.getShape().getShape());
        g2.draw(ms.getShape().getShape());
        g2.setPaint(p);
    }
}
