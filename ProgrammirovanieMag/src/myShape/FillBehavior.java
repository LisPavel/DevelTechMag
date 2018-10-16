package myShape;

import java.awt.*;

/**
 * Created by Денис on 18.09.2018.
 */
public interface FillBehavior {

    public void draw(Graphics2D g2, MyShape ms);
    FillBehavior clone();
}
