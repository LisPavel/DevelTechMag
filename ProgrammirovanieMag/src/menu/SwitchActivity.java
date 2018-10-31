package menu;

import activity.Activity;
import controller.Controller;
import controller.State;

public class SwitchActivity implements Command {
    State state;
    Activity activity;

    public SwitchActivity(State state, Activity activity) {
        this.state = state;
        this.activity = activity;
    }

    @Override
    public void execute() {   state.setActivity(activity);   }
}
