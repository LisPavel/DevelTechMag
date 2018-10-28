package controller;

import Model.Model;
import View.MyFrame;
import View.MyPanel;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

import fabrica.EllipseCreator;
import fabrica.MyShapeCreator;
import myShape.Fill;
import myShape.MyShape;
import myShape.NoFill;
import myShape.ShapeForm;
import myShape.decorator.MyShapeInterface;

public class Controller {
    MyShapeInterface myShape;
    MyShapeCreator myShapeCreator;
    MyShape shape;
    MyPanel myPanel;
    MyFrame myFrame;
    Model model;
    Point2D p[];
    Point2D prevPoint;
    Point2D shapeTopLeft;

    public Controller(){
        //myShape = new Cross( new Border( new MyShape() ));
        //myShape.setColor(Color.PINK);
        //myShape.setFb(new Fill(2));
        //myShape.setSf(new MyLine(new Line2D.Double()) );
        myPanel = new MyPanel();
        myFrame = new MyFrame(myPanel);
        //((Observable)myShape).addObserver(myPanel);
        myPanel.setController(this);
//        model = new Model();
        model = Model.getInstance();

        p = new Point2D[2];
        p[0] = new Point2D.Double(300, 300);
        p[1] = new Point2D.Double(500, 500);


        shape = new MyShape();
        shape.setColor(Color.PINK);
        shape.setFb(new Fill(5));

        //myShapeCreator = new MyShapeCreator();
        //myShapeCreator.setShapeCreator(new EllipseCreator());
        //model.setMyShapeCreator(myShapeCreator);
        model.setCurrShape(shape);
        model.setSize(p);
        //model.setFill(new Fill(5));
        model.addObserver(myPanel);
        model.addShape();

    }
    public void press(Point2D point){
        //p[0] = point;
        System.out.println(shape.getShape().getShape().contains(point));
        //if(shape.getShape().getShape().contains(point))
        prevPoint = point;
        shapeTopLeft = new Point2D.Double( model.getCurrShape().getShape().getShape().getBounds().x,
                model.getCurrShape().getShape().getShape().getBounds().y      );
    }

    public void drag(Point2D point){
        //p[1] = point;
        //model.setSize(p);
        Shape sh = model.getCurrShape().getShape().getShape();
        RectangularShape shape = (RectangularShape)sh;

        shape.setFrame( shapeTopLeft.getX() + (point.getX() - prevPoint.getX()),
                shapeTopLeft.getY() + (point.getY() - prevPoint.getY()),
                shape.getWidth(), shape.getHeight());
        //System.out.println(point.getX() - prevPoint.getX());
        //System.out.println(point.getY() - prevPoint.getY());
        System.out.println(shape.getX());
        System.out.println(shape.getY());
    }

    public void draw(Graphics2D graph){
        model.draw(graph);
    }
}
