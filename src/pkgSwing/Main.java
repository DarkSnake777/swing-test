/*
 * Copyright (c) 2010-2017 Chernikov Vitaly. All rights reserved.
 */

package pkgSwing;




import javax.swing.*;


class Main {
	
	
	public static void main(String[] args)
	{
		//entry point
		SwingUtilities.invokeLater(MainFrame::new);
		 System.out.println("This might well be displayed before the other message.");

	}
	

	


}
