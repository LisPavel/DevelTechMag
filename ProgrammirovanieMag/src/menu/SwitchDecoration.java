package menu;

import Model.Model;
import controller.State;
import myShape.decorator.MyShapeInterface;

public class SwitchDecoration implements Command {
    MyShapeInterface myShapeInterface;
    State state;

    public SwitchDecoration( State state, MyShapeInterface myShapeInterface) {
        this.myShapeInterface = myShapeInterface;
        this.state = state;
    }

    @Override
    public void execute() {
        state.setMyShape(myShapeInterface);
    }
}
