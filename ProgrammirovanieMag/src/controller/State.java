package controller;

import Model.Model;
import myShape.Fill;
import myShape.FillBehavior;
import myShape.MyShape;
import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.RectangularShape;

public class State {
    MyShape shape;
    FillBehavior fillBehavior;
    Color col;
    Model  model;

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
        model.setCurrShape(this.shape);
    }

    public void setFillBehavior(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
        shape.setFb(fillBehavior);
        model.setCurrShape(shape);
    }

    public void setModel(Model model) {
        this.model = model;
        this.model.setCurrShape(shape);
    }

    public State() {
        shape = new MyShape();
        col = Color.PINK;
        shape.setColor(col);
        fillBehavior= new Fill(5);

        shape.setFb(fillBehavior);
    }
}
