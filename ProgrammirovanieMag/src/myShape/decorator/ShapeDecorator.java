package myShape.decorator;
import java.util.Observable;

public abstract class ShapeDecorator extends Observable implements MyShapeInterface{

    MyShapeInterface msi;

    public ShapeDecorator(MyShapeInterface msi) {
        this.msi = msi;
    }
}
