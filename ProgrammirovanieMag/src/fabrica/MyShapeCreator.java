package fabrica;

import myShape.MyShape;
import myShape.ShapeForm;

public class MyShapeCreator {
    MyShape shape;

    ShapeCreator shapeCreator;

    public void setShapeCreator(ShapeCreator shapeCreator) {
        this.shapeCreator = shapeCreator;
    }

    public MyShape create(){
        shape = new MyShape();
        shape.setSf(shapeCreator.create());
        return shape;
    }
}
