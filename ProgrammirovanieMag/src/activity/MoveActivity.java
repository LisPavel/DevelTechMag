package activity;

import Model.Model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class MoveActivity implements Activity{

    Model model;
    Point2D p[];
    Point2D prevPoint;
    Point2D shapeTopLeft;
    RectangularShape shape;
    //boolean isShapePressed;

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    public MoveActivity() {
        p = new Point2D[2];
    }

    @Override
    public void press(Point2D point) {
        shape = (RectangularShape) model.findShape(point);
        if(shape != null)
            shapeTopLeft = new Point2D.Double(shape.getBounds().getX(),
                    shape.getBounds().getY());
        prevPoint = point;
    }

    @Override
    public void drag(Point2D point) {
        if(!shapeTopLeft.equals(null) )
            shape.setFrame( shapeTopLeft.getX() + (point.getX() - prevPoint.getX()),
                  shapeTopLeft.getY() + (point.getY() - prevPoint.getY()),
                 shape.getWidth(), shape.getHeight());

    }
}
