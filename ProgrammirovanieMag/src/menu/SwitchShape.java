package menu;

import controller.State;
import myShape.ShapeForm;

public class SwitchShape implements  Command{
    State state;
    ShapeForm shapeForm;

    public SwitchShape(State state, ShapeForm shapeForm) {
        this.state = state;
        this.shapeForm = shapeForm;
    }


    @Override
    public void execute() {
        state.setShape(shapeForm);
    }
}
