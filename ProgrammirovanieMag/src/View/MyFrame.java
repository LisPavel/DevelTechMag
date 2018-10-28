package View;
import javax.swing.*;
/**
 * Created by Денис on 18.09.2018.
 */


public class MyFrame extends JFrame{
    MyPanel panel;
    public MyFrame(MyPanel p){
        panel = p;
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
}
