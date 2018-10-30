package menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchState extends AbstractAction {

    public SwitchState(String name, Icon icon, Command command) {
        super(name, icon);
        putValue("command", command);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command m = (Command)getValue("command");
        m.execute();
    }
}
