package View;
import Model.Model;
import activity.Activity;
import activity.DrawActivity;
import activity.MoveActivity;
import controller.Controller;
import controller.State;
import menu.*;
import myShape.Fill;
import myShape.MyRectangle;
import myShape.MyShape;
import myShape.NoFill;
import myShape.decorator.Border;
import myShape.decorator.Cross;

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
    Controller controller;

    public MyFrame(MyPanel p, final State state, final Controller controller){
        this.state = state;
        this.controller = controller;

        panel = p;
        JMenuBar bar;
        JToolBar toolBar = new JToolBar();
        ArrayList<Action> list = new ArrayList<Action>();
        list.add(new SwitchState("Прямоугольник", new ImageIcon(getClass().getResource("photo-frame.png")),
                new SwitchShape(state, new MyRectangle( new Rectangle2D.Double() ))));
        list.add(new SwitchState("Эллипс", new ImageIcon(getClass().getResource("ellipse.png")),
                new SwitchShape(state, new MyRectangle( new Ellipse2D.Double()) )));
        list.add(new SwitchState("Выберете цвет", new ImageIcon(getClass().getResource("paint-board-and-brush.png")),
                new SwitchColor(state, Color.GREEN)));
        list.add(new SwitchState("Движение", new ImageIcon(getClass().getResource("move-option.png")),
                new SwitchActivity(state, new MoveActivity() )));
        list.add(new SwitchState("Рисование", new ImageIcon(getClass().getResource("draw.png")),
                new SwitchActivity(state, new DrawActivity() )));
        list.add(new SwitchState("Без декорации", new ImageIcon(getClass().getResource("no-stopping.png")),
                new SwitchDecoration(state, new MyShape())));
        list.add(new SwitchState("Граница", new ImageIcon(getClass().getResource("object.png")),
                new SwitchDecoration(state, new Border(new MyShape())) ));
        list.add(new SwitchState("Пересечение", new ImageIcon(getClass().getResource("screwdriver-and-wrench-crossed.png")),
                new SwitchDecoration(state, new Cross(new MyShape())) ));
        list.add(new SwitchState("Граница и Пересечение", new ImageIcon(getClass().getResource("cross-mark-with-circle-border.png")),
                new SwitchDecoration(state,  new Border(new Cross(new MyShape())) )));
        list.add(new SwitchState("Без заливки", new ImageIcon(getClass().getResource("photo-frame.png")),
                new SwitchFill(state, new NoFill(5))));
        list.add(new SwitchState("С заливкой", new ImageIcon(getClass().getResource("maps-and-flags.png")),
                new SwitchFill(state, new Fill(5))) );
        /////////////////////

        JMenu menu, menu1, menu2, menu3, menu4, menu5;
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
        //////
        menu = new JMenu("Действие");
        menu1= new JMenu("Фигура");
        menu2 = new JMenu("Цвет");
        menu3 = new JMenu("Активность");
        menu4 = new JMenu("Декорации");
        menu5 = new JMenu("Заливка");
        /////
        menu1.add(list.get(0));
        menu1.add(list.get(1));
        menu2.add(list.get(2));
        menu3.add(list.get(3));
        menu3.add(list.get(4));
        menu4.add(list.get(5));
        menu4.add(list.get(6));
        menu4.add(list.get(7));
        menu4.add(list.get(8));
        menu5.add(list.get(9));
        menu5.add(list.get(10));
        ////////

        bar.add(menu);
        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        bar.add(menu4);
        bar.add(menu5);
        /////

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
