package Model;

import fabrica.LineCreator;
import fabrica.MyShapeCreator;
import fabrica.RectCreator;
import myShape.FillBehavior;
import myShape.MyShape;
import myShape.decorator.MyShapeInterface;

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


    public MyShapeInterface getCurrShape() {
        return currShape;
    }

    MyShapeInterface currShape;
    MyShapeCreator myShapeCreator;
    List<MyShapeInterface> list;

//    public Model() {
    private Model() {
        list = new ArrayList<MyShapeInterface>();
        myShapeCreator = new MyShapeCreator();
    }

    public void setCurrShape(MyShapeInterface currShape) {
        this.currShape = currShape;
    }

    public void addShape(){
        currShape = currShape.clone();
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
            for (MyShapeInterface s: list) s.draw(graph);
        }
        setChanged();
        notifyObservers();
    }

    public Shape findShape(Point2D point)
    {
        for (MyShapeInterface s : list)
            if(s.getShape().getShape().contains(point)) {
                setCurrShape(s);
                return s.getShape().getShape();
            }
        return null;
    }

    public void setMyShapeCreator(MyShapeCreator myShapeCreator) {
        this.myShapeCreator = myShapeCreator;
    }
}
