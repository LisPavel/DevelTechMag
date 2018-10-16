package Model;

import fabrica.LineCreator;
import fabrica.MyShapeCreator;
import fabrica.RectCreator;
import myShape.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    MyShape currShape;
    MyShapeCreator myShapeCreator;
    List<MyShape> list;

    public Model() {
        list = new ArrayList<MyShape>();
        myShapeCreator = new MyShapeCreator();
    }

    public void setCurrShape(MyShape currShape) {
        this.currShape = currShape;
    }

    public void addShape(){
        currShape = currShape.clone();
//        currShape = myShapeCreator.create();
        list.add(currShape);
    }

    public void setSize(Point2D[] size) {
        currShape.setSize(size);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D graph) {
        if (!list.isEmpty()) {
            for (MyShape s: list) s.draw(graph);
        }
    }

    public void setMyShapeCreator(MyShapeCreator myShapeCreator) {
        this.myShapeCreator = myShapeCreator;
    }
}
