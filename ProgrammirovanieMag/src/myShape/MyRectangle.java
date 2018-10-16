package myShape;
import java.awt.geom.*;
import java.awt.*;

/**
 * Created by Денис on 18.09.2018.
 */
public class MyRectangle implements ShapeForm{

    RectangularShape shape;

    public MyRectangle(){
        shape = new Rectangle2D.Double();
    }

    public MyRectangle(RectangularShape s){
        shape = s;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public RectangularShape getShape() {
        return shape;
    }

    @Override
    public ShapeForm clone() {
        return new MyRectangle((RectangularShape) shape.clone());
    }

    @Override
    public void setSize(Point2D[] p) {
        shape.setFrameFromDiagonal(p[0],p[1]);

    }
}
