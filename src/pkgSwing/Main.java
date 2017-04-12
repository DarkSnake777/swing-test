package pkgSwing;




import javax.swing.*;


/**
 * @author Vitaly
 *
 */
class Main {
	
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(MainFrame::new);
		 System.out.println("This might well be displayed before the other message.");

	}
	

	


}
