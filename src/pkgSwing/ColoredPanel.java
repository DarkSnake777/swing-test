package pkgSwing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Vitaly
 *
 */
class ColoredPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static Dimension preferredSize = new Dimension(0, 20);
	private final Color color;
	private final String name;
	Color getColor()
	{
		return color;
	}
	 ColoredPanel(String name,Color color)
	{
    	this.name=name;
	  this.color=color;
	  this.setBackground(color);	
	  this.setSize(preferredSize);

	}
	
	@Override
	public String toString()
	{
	  return  name;
	}
	

}
