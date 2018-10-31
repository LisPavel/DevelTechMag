package activity;

import Model.Model;

import java.awt.geom.Point2D;

public interface Activity {
    void drag(Point2D point);
    void press(Point2D point);
    void setModel(Model model);
}
