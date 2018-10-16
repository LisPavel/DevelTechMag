package fabrica;

import myShape.MyLine;
import myShape.ShapeForm;

public class LineCreator implements ShapeCreator {
    @Override
    public ShapeForm create() {
        return new MyLine();
    }
}
