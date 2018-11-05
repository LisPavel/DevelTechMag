package menu;

import controller.State;

import javax.swing.*;
import java.awt.*;

public class SwitchColor implements Command {
    State state;
    Color col;

    public SwitchColor(State state, Color col) {
        this.state = state;
        this.col = col;
    }

    @Override
    public void execute() {
        col = JColorChooser.showDialog(null, "Выберете цвет", Color.BLACK);
        state.setCol(col);
    }
}
