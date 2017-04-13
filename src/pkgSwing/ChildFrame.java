/*
 * Copyright (c) 2010-2017 Chernikov Vitaly. All rights reserved.
 */

package pkgSwing;

import javax.swing.*;
import java.awt.*;


class ChildFrame extends JFrame {
    ChildFrame()
    {
        final Dimension size = new Dimension(500,500);
        final int xcenter = (int)((GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth()-size.getWidth())/2);
        final int ycenter = (int)((GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight()-size.getHeight())/2);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(xcenter,ycenter);
        setSize(size);
        setTitle("Child Frame!");
        setAlwaysOnTop(true);
        setVisible(true);

        JLabel label = new JLabel("Change in testing");
        add(label,BorderLayout.NORTH);

        JLabel label2 = new JLabel("Hot change");
        add(label2,BorderLayout.SOUTH);

    }
}
