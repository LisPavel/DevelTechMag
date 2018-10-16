package Model;

import fabrica.EllipseCreator;
import fabrica.MyShapeCreator;
import fabrica.RectangleCreator;
import myShape.MyRectangle;
import myShape.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    MyShape currentshape;
    MyShapeCreator creator;
    List<MyShape> list;

    public Model() {
        list = new ArrayList<MyShape>();
       // creator = new MyShapeCreator();
    }

    public void setCurrentshape(MyShape currentshape) {
        this.currentshape = currentshape;
    }

    public void setCreator(MyShapeCreator creator) {
        this.creator = creator;
    }

    public void addShape(){
        currentshape = creator.create();
        //currentshape = currentshape.clone();
        list.add(currentshape);
    }

    public void setSize(Point2D[] p) {
        currentshape.setSize(p);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D graph) {
        if(!list.isEmpty())
            for (MyShape s: list)
                s.draw(graph);
    }
}
