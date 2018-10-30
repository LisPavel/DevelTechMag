package fabrica;

import myShape.MyShape;
import myShape.ShapeForm;

import java.awt.*;

public class MyShapeCreator {
    MyShape shape;
    Color col;

    ShapeCreator shapeCreator;
    FillCreator fillCreator;

    public void setShapeCreator(ShapeCreator shapeCreator) {
        this.shapeCreator = shapeCreator;
    }

    public void setColor(Color col) {
        this.col = col;
    }

    public MyShape create(){
        shape = new MyShape();
        shape.setSf(shapeCreator.create());
        shape.setFb(fillCreator.ceate());
        shape.setColor(col);
        return shape;
    }
}
