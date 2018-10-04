package myShape.decorater;

import myShape.Fill;
import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.Point2D;

public interface MyShapeInterface {
    void draw(Graphics2D g2);

    void setSf(ShapeForm sf);
    void setFb(Fill fill);

    void setSize(Point2D[] size);
    void setParametr(int param);
    void setColor(Color col);
    Color getColor();
    ShapeForm getShape();
}
