package View;
import controller.State;
import menu.SwitchColor;
import menu.SwitchShape;
import menu.SwitchState;
import myShape.MyRectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by Денис on 18.09.2018.
 */


public class MyFrame extends JFrame{
    MyPanel panel;
    State state;

    public MyFrame(MyPanel p, final State state){
        this.state = state;

        panel = p;
        JMenuBar bar;
        JToolBar toolBar = new JToolBar();
        ArrayList<Action> list = new ArrayList<Action>();
        list.add(new SwitchState("Прямоугольник", new ImageIcon("rect.gif"),
                new SwitchShape(state, new MyRectangle( new Rectangle2D.Double() ))));
        list.add(new SwitchState("Эллипс", new ImageIcon("rect.gif"),
                new SwitchShape(state, new MyRectangle( new Ellipse2D.Double()) )));
        list.add(new SwitchState("Цвет", new ImageIcon("col.gif"),
                new SwitchColor(state, Color.GREEN)));
        JMenu menu, menu1, menu2;
 //       JMenuItem ellepseItem = new JMenuItem("Эллипс");
//        ellepseItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                state.setShape( );
//            }
//        });
//        JMenuItem rectangeItem = new JMenuItem("Прямоугольник");
//        rectangeItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                state.setShape( );
//            }
//        });
        panel = p;
        bar = new JMenuBar();
        menu = new JMenu("Действие");
        menu1= new JMenu("Фигура");
        menu2 = new JMenu("Цвет");
        menu1.add(list.get(0));
        menu1.add(list.get(1));
        menu2.add(list.get(2));
        bar.add(menu);
        bar.add(menu1);
        bar.add(menu2);
        this.setJMenuBar(bar);
        for (Action x : list)
            toolBar.add(x);
        this.add(toolBar, BorderLayout.NORTH);


        ////////////
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);
    }
}
