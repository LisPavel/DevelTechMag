package menu;

import controller.State;
import myShape.FillBehavior;

public class SwitchFill implements Command {
    State state;
    FillBehavior fillBehavior;

    public SwitchFill(State state, FillBehavior fillBehavior) {
        this.state = state;
        this.fillBehavior = fillBehavior;
    }

    @Override
    public void execute() {
        state.setFillBehavior(fillBehavior);
    }
}
