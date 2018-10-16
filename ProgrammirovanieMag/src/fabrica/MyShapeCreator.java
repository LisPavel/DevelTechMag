package fabrica;

import myShape.MyShape;
import myShape.ShapeForm;

public class MyShapeCreator {
    MyShape shape;

    ShapeCreator shapeCreator;

    public void setShapeForm(ShapeCreator shapeCreator) {
        this.shapeCreator = shapeCreator;
    }

    public MyShape create(){
        shape.setShape(shapeCreator.create());
        return shape;
    }
}
