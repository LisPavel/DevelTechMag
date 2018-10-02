package myShape.decorater;

import myShape.ShapeForm;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class Cross extends ShapeDecorator {
    public Cross(MyShapeInterface msi) {
        super(msi);
    }
    @Override
    public void draw(Graphics2D g2) {
        msi.draw(g2);

        Point2D left = null, right = null;

        Shape helpShape = msi.getShape().getShape();

        if (helpShape instanceof RectangularShape){

            if (!helpShape.getBounds2D().isEmpty()){
                left = new Point2D.Double(
                        helpShape.getBounds2D().getMinX()  ,
                        helpShape.getBounds2D().getMinY()
                );

                right = new Point2D.Double(
                        helpShape.getBounds2D().getMaxX()  ,
                        helpShape.getBounds2D().getMaxY()
                );
            }

            if (left!=null && right!=null){
                Line2D cross = new Line2D.Double(left, right);
                g2.draw(cross);
            }
        }
    }

    @Override
    public void setSize(Point2D[] size) {
        msi.setSize(size);
        setChanged();
        notifyObservers();
    }

    @Override
    public void setParametr(int param) {
        return;
    }

    @Override
    public ShapeForm getShape() {
        return msi.getShape();
    }
}
