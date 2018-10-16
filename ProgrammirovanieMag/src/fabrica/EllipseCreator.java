package fabrica;

import myShape.MyRectangle;
import myShape.ShapeForm;

import java.awt.geom.Ellipse2D;

public class EllipseCreator implements ShapeCreator {
    @Override
    public ShapeForm create() {
        return new MyRectangle(new Ellipse2D.Double() );
    }
}
