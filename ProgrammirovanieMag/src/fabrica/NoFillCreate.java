package fabrica;

import myShape.FillBehavior;

public class NoFillCreate implements FillCreator{

    @Override
    public FillBehavior create() {
        return null;
    }
}
