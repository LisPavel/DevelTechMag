package myShape;

import myShape.decorater.MyShapeInterface;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Observable;

/**
 * Created by Денис on 18.09.2018.
 */


public class MyShape extends Observable implements MyShapeInterface {
    private Color col;
    private ShapeForm sf;
    private FillBehavior fb;
    private int param;

    //    public ShapeForm getSf() {
//        return sf;
//    }

    @Override
    public void setSf(ShapeForm sf) {
        this.sf = sf;
        setChanged();
        notifyObservers();
    }
    
    @Override
    public void setFb(FillBehavior fill) {
        this.fb = fill;
        setChanged();
        notifyObservers();
    }

    public MyShape(){
        col = Color.red;
        sf = new MyRectangle(new Ellipse2D.Double());
        //sf = new MyLine(new Line2D.Double());
        fb = new NoFill(5);
    }

    @Override
    public void setSize(Point2D[] point) {
        sf.setSize(point);
        setChanged();
        notifyObservers();
    }

    @Override
    public void setParametr(int param) {
        this.param = param;
    }

    @Override
    public void setColor(Color col) {
        this.col = col;
    }

    @Override
    public Color getColor() {
        return col;
    }

    @Override
    public ShapeForm getShape() {
        return sf;
    }

    @Override
    public void draw(Graphics2D g2) {
        fb.draw(g2,this);
    }

    public void setShape(ShapeForm shapeForm) {
        this.sf = shapeForm;
    }

    public MyShape clone(){
        MyShape new_s = new MyShape();
        new_s.setColor(col);
        new_s.setFb(fb.clone());
        new_s.setParametr(param);
        new_s.setSf(sf.clone());
        return new_s;
//        return new MyShape((MyShape)this.clone());
    }
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

}
