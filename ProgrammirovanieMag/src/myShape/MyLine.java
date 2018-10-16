package myShape;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.*;

/**
 * Created by Денис on 18.09.2018.
 */
public class MyLine implements ShapeForm {
    Line2D line;

    public MyLine(Line2D line) {
        this.line = line;
    }
    public MyLine(){
        this.line = new Line2D.Double();
    }
    public Line2D getLine() {
        return line;
    }

    public void setLine(Line2D line) {
        this.line = line;
    }

    @Override
    public void setSize(Point2D[] p) {
        line.setLine(p[0],p[1]);
    }

    @Override
    public Shape getShape() {
        return line;
    }

    @Override
    public ShapeForm clone() {
        return new MyLine((Line2D)line.clone());
    }
}
