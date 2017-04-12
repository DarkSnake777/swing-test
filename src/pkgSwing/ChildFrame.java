package pkgSwing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DS on 12.04.2017.
 * demo of child window
 */
class ChildFrame extends JFrame {
    ChildFrame()
    {
        final Dimension size = new Dimension(500,500);
        final int xcenter = (int)((GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth()-size.getWidth())/2);
        final int ycenter = (int)((GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-size.getHeight())/2);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(xcenter,ycenter);
        setSize(size);
        setTitle("Child Frame");
        setVisible(true);

    }
}
