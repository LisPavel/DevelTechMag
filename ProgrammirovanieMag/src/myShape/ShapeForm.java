package myShape;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Created by Денис on 18.09.2018.
 */
public interface ShapeForm {
    void setSize(Point2D[] p);
    Shape getShape();
    ShapeForm clone();
}
