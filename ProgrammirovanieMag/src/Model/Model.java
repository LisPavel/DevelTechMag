package Model;

import fabrica.LineCreator;
import fabrica.MyShapeCreator;
import fabrica.RectCreator;
import myShape.FillBehavior;
import myShape.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Model extends Observable {
    private static Model ourInstance = new Model();

    public static Model getInstance() {
        return ourInstance;
    }


    public MyShape getCurrShape() {
        return currShape;
    }

    MyShape currShape;
    MyShapeCreator myShapeCreator;
    List<MyShape> list;

//    public Model() {
    private Model() {
        list = new ArrayList<MyShape>();
        myShapeCreator = new MyShapeCreator();
    }

    public void setCurrShape(MyShape currShape) {
        this.currShape = currShape;
    }

    public void addShape(){
        //currShape = currShape.clone();
        //currShape = myShapeCreator.create();
        list.add(currShape);
    }

    public void setSize(Point2D[] size) {
        currShape.setSize(size);
        setChanged();
        notifyObservers();
    }

    public void setFill(FillBehavior fill) {
        currShape.setFb(fill);
        setChanged();
        notifyObservers();
    }

    public void draw(Graphics2D graph) {
        if (!list.isEmpty()) {
            for (MyShape s: list) s.draw(graph);
        }
        setChanged();
        notifyObservers();
    }

    public void setMyShapeCreator(MyShapeCreator myShapeCreator) {
        this.myShapeCreator = myShapeCreator;
    }
}
