package myShape.decorator;

import myShape.FillBehavior;
import myShape.MyShape;
import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.Point2D;

public interface MyShapeInterface {
    void draw(Graphics2D g2);

    void setSf(ShapeForm sf);
    void setFb(FillBehavior fill);
    FillBehavior getFB();

    void setSize(Point2D[] size);
    void setShape(ShapeForm shapeForm);
    //void setParametr(int param);
    void setColor(Color col);
    Color getColor();
    ShapeForm getShape();
    MyShapeInterface clone();
}
