package myShape.decorator;
import java.util.Observable;

public abstract class ShapeDecorator extends Observable implements MyShapeInterface{

    MyShapeInterface msi;

    @Override
    public MyShapeInterface clone() {
        return null;
    }

    public ShapeDecorator(MyShapeInterface msi) {
        this.msi = msi;
    }
}
