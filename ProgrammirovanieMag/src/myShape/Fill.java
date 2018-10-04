package myShape;

import java.awt.*;

/**
 * Created by Денис on 18.09.2018.
 */
public class Fill implements FillBehavior{
    int penSize;
    public Fill(int penSize)
    {
        this.penSize = penSize;
    }
    @Override
    public void draw(Graphics2D g2, MyShape ms) {
        Paint p = g2.getPaint();
        g2.setPaint(ms.getColor());
        g2.setStroke(new BasicStroke(penSize));
        g2.fill(ms.getShape().getShape());
        g2.draw(ms.getShape().getShape());
        g2.setPaint(p);
    }
}
