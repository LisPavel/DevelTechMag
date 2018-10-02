package myShape.decorater;

import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Observable;

public abstract class ShapeDecorator extends Observable implements MyShapeInterface{

    MyShapeInterface msi;

    public ShapeDecorator(MyShapeInterface msi) {
        this.msi = msi;
    }
}
