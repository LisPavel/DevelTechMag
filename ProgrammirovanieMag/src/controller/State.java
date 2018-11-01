package controller;

import Model.Model;
import activity.Activity;
import activity.DrawActivity;
import activity.MoveActivity;
import myShape.Fill;
import myShape.FillBehavior;
import myShape.MyShape;
import myShape.ShapeForm;
import myShape.decorator.Border;
import myShape.decorator.Cross;
import myShape.decorator.MyShapeInterface;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class State {
    MyShapeInterface shape;
    FillBehavior fillBehavior;
    Color col;
    Model  model;
    Activity activity;

    public void setCol(Color col) {
        this.col = col;
        shape.setColor(col);
        model.setCurrShape(shape);
    }


    public void setShape(ShapeForm shapeForm) {
        //this.shape = shape;
        this.shape.setShape(shapeForm);
        this.shape.setColor(col);
        this.shape.setFb(fillBehavior);
        model.setCurrShape(shape);
    }

    public void setFillBehavior(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
        shape.setFb(fillBehavior);
        model.setCurrShape(shape);
    }

    public void setModel(Model model) {
        this.model = model;
        this.activity.setModel(model);
        this.model.setCurrShape(shape);
    }

    public State() {
        shape = new Cross( new Border(new MyShape()));
        col = Color.PINK;
        shape.setColor(col);
        fillBehavior = new Fill(5);
        shape.setFb(fillBehavior);
        activity = new DrawActivity();
    }

    public void drag(Point2D p)
    {
        this.activity.drag(p);

    }
    public void press(Point2D p)
    {
        this.activity.press(p);

    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.activity.setModel(model);
        this.model.setCurrShape(shape);
    }
}
