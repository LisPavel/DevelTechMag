package myShape.decorater;

import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.Point2D;

public interface MyShapeInterface {
    void draw(Graphics2D g2);
    void setSize(Point2D[] size);
    void setParametr(int param);
    ShapeForm getShape();
}
