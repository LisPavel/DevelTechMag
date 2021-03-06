package myShape.decorator;

import myShape.FillBehavior;
import myShape.MyShape;
import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class Border extends ShapeDecorator {
    private int width = 10;
    public Border(MyShapeInterface msi) {
        super(msi);
    }

    @Override
    public void draw(Graphics2D g2) {
        msi.draw(g2);
        g2.setPaint(getColor());

        Point2D left = null, right = null;

        Shape helpShape = msi.getShape().getShape();

        if (helpShape instanceof RectangularShape){

            if (!helpShape.getBounds2D().isEmpty()){
                left = new Point2D.Double(
                        helpShape.getBounds2D().getMinX() - width ,
                        helpShape.getBounds2D().getMinY() - width
                );

                right = new Point2D.Double(
                        helpShape.getBounds2D().getMaxX() + width ,
                        helpShape.getBounds2D().getMaxY() + width
                );
            }

            if (left!=null && right!=null){
                RectangularShape helpShapeRect = (RectangularShape)((RectangularShape) helpShape).clone();
                helpShapeRect.setFrameFromDiagonal(left,right);
                g2.draw(helpShapeRect);
            }
        }
    }

    @Override
    public void setSf(ShapeForm sf) {
        msi.setSf(sf);
    }

    @Override
    public void setFb(FillBehavior fill) {
        msi.setFb(fill);
    }

    @Override
    public FillBehavior getFB() {
        return msi.getFB();
    }

    @Override
    public void setSize(Point2D[] size) {
        msi.setSize(size);
        setChanged();
        notifyObservers();
    }

    @Override
    public void setShape(ShapeForm shapeForm) {
        msi.setShape(shapeForm);
    }

    @Override
    public void setColor(Color col) {
        msi.setColor(col);
    }

    @Override
    public Color getColor() {
        return msi.getColor();
    }

    @Override
    public ShapeForm getShape() {
        return msi.getShape();
    }

    @Override
    public MyShapeInterface clone() {
        MyShapeInterface myShapeInterface;
        if(msi instanceof Cross)
            myShapeInterface = new Border(new Cross(new MyShape()) );
        else
            myShapeInterface = new Border(new MyShape() );
        myShapeInterface.setColor(getColor());
        myShapeInterface.setShape(getShape().clone());
        myShapeInterface.setFb(getFB().clone());
        return myShapeInterface;
    }
}
