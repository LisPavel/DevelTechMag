package fabrica;

import myShape.MyShape;
import myShape.ShapeForm;

public class MyShapeCreator {
    MyShape shape;
    ShapeCreator shapeform;

    public MyShapeCreator() {
    }

    public void setShapeform(ShapeCreator shapeform) {
        this.shapeform = shapeform;
    }
    public MyShape create(){
        shape = new MyShape();
        shape.setShape(shapeform.create());
        return shape;
    }
}
