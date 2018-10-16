package fabrica;

import myShape.MyRectangle;
import myShape.ShapeForm;

public class RectCreator implements ShapeCreator {
    @Override
    public ShapeForm create() {
        return new MyRectangle();
    }
}
