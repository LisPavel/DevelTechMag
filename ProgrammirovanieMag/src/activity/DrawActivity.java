package activity;

import Model.Model;

import java.awt.geom.Point2D;

public class DrawActivity implements Activity {
    Point2D p[];
    Model model;


    public DrawActivity() {
        p = new Point2D[2];
        //p[0] = new Point2D.Double(300, 300);
        //p[1] = new Point2D.Double(500, 500);
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void press(Point2D point) {
        p[0] = point;
        model.addShape();
    }

    @Override
    public void drag(Point2D point) {
        p[1] = point;
        model.setSize(p);
    }


}
