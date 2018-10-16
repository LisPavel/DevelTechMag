package controller;

import Model.Model;
import View.MyFrame;
import View.MyPanel;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import fabrica.EllipseCreator;
import fabrica.MyShapeCreator;
import fabrica.RectCreator;
import myShape.Fill;
import myShape.MyLine;
import myShape.MyShape;
import myShape.decorater.Border;
import myShape.decorater.Cross;
import myShape.decorater.MyShapeInterface;

import java.util.Observable;

public class Controller {
    MyShapeInterface myShape;
    MyShapeCreator myShapeCreator;
    MyShape shape;
    MyPanel myPanel;
    MyFrame myFrame;
    Model model;
    Point2D p[];

    public Controller(){
        myShape = new Cross( new Border( new MyShape() ));
        myShape.setColor(Color.PINK);
        myShape.setFb(new Fill(2));
        //myShape.setSf(new MyLine(new Line2D.Double()) );
        myPanel = new MyPanel();
        myFrame = new MyFrame(myPanel);
        //myShape.setParametr(11);
        ((Observable)myShape).addObserver(myPanel);
        myPanel.setController(this);

//        model = new Model();
        model = Model.getInstance();

        p = new Point2D[2];
        shape = new MyShape();

        shape.setColor(Color.red);


        myShapeCreator = new MyShapeCreator();
        myShapeCreator.setShapeCreator(new EllipseCreator());
        model.setMyShapeCreator(myShapeCreator);

        model.setCurrShape(shape);
        ((Observable)model).addObserver(myPanel);
    }
    public void press(Point2D point){
        p[0] = point;
        model.addShape();
    }

    public void drag(Point2D point){
        p[1] = point;
        model.setSize(p);
    }

    public void draw(Graphics2D graph){
        model.draw(graph);
    }
}
