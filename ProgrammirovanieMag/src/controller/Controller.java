package controller;

import Model.Model;
import View.MyFrame;
import View.MyPanel;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import fabrica.EllipseCreator;
import fabrica.MyShapeCreator;
import myShape.Fill;
import myShape.MyLine;
import myShape.MyShape;
import myShape.decorater.Border;
import myShape.decorater.Cross;
import myShape.decorater.MyShapeInterface;

import java.util.Observable;

public class Controller {
    MyShapeInterface myShape;
    MyShapeCreator creator;
    MyShape shape;
    MyPanel myPanel;
    MyFrame myFrame;
    Model model;
    Point2D p[];

    public Controller(){
        myShape = new Cross( new Border( new MyShape() ));
        myShape.setColor(Color.PINK);
        myShape.setFb(new Fill(2));
        myShape.setSf(new MyLine(new Line2D.Double()) );
        myPanel = new MyPanel();

        //myShape.setParametr(11);
        ((Observable)myShape).addObserver(myPanel);
        myPanel.setController(this);
        model = new Model();
        p = new Point2D[2];

        creator = new MyShapeCreator();
        creator.setShapeform(new EllipseCreator());
        model.setCreator(creator);

        shape = new MyShape();
        model.setCurrentshape(shape);
        model.addObserver(myPanel);
        myFrame = new MyFrame(myPanel);
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
