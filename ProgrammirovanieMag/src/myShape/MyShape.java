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
    private int borderSize;
    private FillBehavior fb;
    private int param;


    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public Color getCol() {
        return col;
    }

    public void setCol(Color col) {
        this.col = col;
    }

//    public ShapeForm getSf() {
//        return sf;
//    }

    public void setSf(ShapeForm sf) {
        this.sf = sf;
    }
    public MyShape(){
        col = Color.red;
        sf = new MyRectangle(new Ellipse2D.Double());
//        sf = new MyLine(new Line2D.Double());
        fb = new Fill();
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
    public ShapeForm getShape() {
        return sf;
    }

    @Override
    public void draw(Graphics2D g2) {
        fb.draw(g2,this);
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//
//
//
//        return super.clone();
//    }

    public void setFb(Fill fill) {
        fb = fill;
    }
}
