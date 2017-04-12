package pkgSwing;
//new comment

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.*;

import java.io.File;
import java.lang.reflect.Field;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import javax.swing.tree.TreeModel;



/**
 * @author Vitaly
 *
 */
class MainFrame extends JFrame {
	
	
	private final JLabel label;
	private int x,y;
	private JPanel pnlCenter;
	private boolean clicked=false;
	private Color curColor=Color.YELLOW;
	private final JColorChooser ch;
	private final JList<ColoredPanel> list ;
	private final ColoredPanel[] panels;
	private int old_index=0;
	private final JComboBox<ColoredPanel> cmb;
	private  JPopupMenu popup;
	private final MyAction action;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MainFrame()
	{
		int sh = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight();
		int sw = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth();

		ImageIcon icon = new ImageIcon("1.png");
		ImageIcon rolloverIcon = new ImageIcon("2.png");
		int wheight = 750;
		int wwidth = 600;
		setSize(wwidth, wheight);
		setVisible(true);
		setLocation(sw /2- wwidth /2, sh /2- wheight /2);
		setTitle("Это Swing");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		 action  = new MyAction("Action",icon,KeyEvent.VK_A,KeyEvent.VK_B,"test");


	   JPanel mainPanel = new JPanel();
	   mainPanel.setLayout(new BorderLayout());
	   
	 
	   
	   
	   
	    label = new JLabel("test", icon,SwingConstants.LEFT);
	    label.setForeground(Color.blue);
	    label.setHorizontalAlignment(SwingConstants.CENTER);
	    label.setText("Это SWING!!!!!");
	  
	    JTextField tf = new JTextField(15);
	    JToggleButton toggle = new JToggleButton("Test");
	    toggle.addItemListener((n)->{
	    
	    	JToggleButton tb = (JToggleButton)n.getItem();
	    	if (tb.isSelected())
	    	{
	    		tb.setText("Selected");
	    	}
	    	else
	    	{
	    		tb.setText("Test");	
	    	} 
	    });
	   
	    // ActionListener
	    JRadioButton rbt1 = new JRadioButton("A");
	    JRadioButton rbt2 = new JRadioButton("B");
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(rbt1);
	    bg.add(rbt2); 
	    
	    JPanel pn = new JPanel();
	    pn.setLayout(new FlowLayout());
	    pn.add(label);
	    pn.add(tf);
	    pn.add(toggle);
	    pn.add(rbt1);
	    pn.add(rbt2);
	    
	    
	     cmb = new JComboBox<>();
	     cmb.addItemListener(e -> {
             ColoredPanel value=	(ColoredPanel)cmb.getSelectedItem() ;

              curColor= value.getColor();
              pnlCenter.repaint();

         });
	     
	     cmb.setRenderer(new ListCellRenderer<ColoredPanel>()
	    		 {
	    	       final DefaultListCellRenderer defaultRenderer =new DefaultListCellRenderer();
					@Override
					public Component getListCellRendererComponent(JList<? extends ColoredPanel> list,
							ColoredPanel value, int index, boolean isSelected, boolean cellHasFocus) {
						
						JLabel renderer = (JLabel)defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);	
					
						if (value!=null){
						renderer.setBackground(value.getColor());
						
						}
						return renderer;
					}
	    	 
	    		 });
	    pn.add(cmb);
	    mainPanel.add(pn,BorderLayout.NORTH);


		JPanel p = new JPanel();
	     p.setLayout(new BorderLayout());
	     
	     
	    JPanel pNorth = new JPanel();
	    FlowLayout fl = new FlowLayout();
	    pNorth.setLayout(fl);
	    p.add(pNorth, BorderLayout.NORTH);
	 //   mainPanel.add(p, BorderLayout.SOUTH);



        for(int i=0;i<4;i++)
        {

			JButton bt= new JButton("Button "+i, icon);
        	bt.setName("Button" +i);
        	bt.setActionCommand("bt"+i);
        	bt.setRolloverIcon(rolloverIcon);
        	bt.setPressedIcon(rolloverIcon);
        	bt.addActionListener((n)->{
        		label.setText(((JButton)n.getSource()).getName()+" pressed");
        		((JButton)n.getSource()).setBackground(curColor);
        	   //... some code
        		});
        	pNorth.add(bt);
        	
        }
           
   
        
	    ch = new JColorChooser();

		ChangeListener changeListener = e -> {
            curColor = ch.getColor();
            cmb.addItem(new ColoredPanel(curColor.toString(), curColor));
            pnlCenter.repaint();

        };
		ch.getSelectionModel().addChangeListener(changeListener);
	    

	   // JScrollPane jsp = new JScrollPane(p);
	    p.add(ch,BorderLayout.CENTER);
	    
	    //
	     panels =  new ColoredPanel[]{
	    		new ColoredPanel("Синий",Color.BLUE),
	    		new ColoredPanel("Красный",Color.red),
	    		new ColoredPanel("Зеленый",Color.GREEN)
	    };
	    
	    list = new JList<>();
	    list.setListData(panels); 
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
        list.addListSelectionListener(e -> {
            // TODO Auto-generated method stub
            int index= list.getSelectedIndex();
            if (e.getValueIsAdjusting())
             {
              if (index!=-1)
              {


                  ColoredPanel cpanel_old = panels[old_index];
                  ColoredPanel cpanel_new = panels[index];
                  old_index=index;
                  cpanel_old.setBorder(BorderFactory.createLineBorder(Color.black, 0));
                  cpanel_new.setBorder(BorderFactory.createLineBorder(Color.black, 5));
              }
           }



        });
	    
	    
	    
	 

	    JPanel pSouth = new JPanel();
	    pSouth.setLayout(new GridLayout()); 
	    pSouth.add(list);
	   
	    for(ColoredPanel cp:panels)
	    {
	      pSouth.add(cp);
	    }
	    p.add(pSouth,BorderLayout.SOUTH);
	    
        
         pnlCenter= new JPanel()
        		 {

					/**
					 * 
					 */
					private static final long serialVersionUID = 1L;
					
					@Override
					public void paintComponent(Graphics g)
					{
					super.paintComponent(g);
					 g.setColor(curColor);
					 g.drawString("***", x-5, y+5);
					 g.drawString("*", x, y); 
					 g.drawString("*", x, y+10); 
					 
					 if (clicked)
					 {
						 clicked=false;
						 g.drawOval(x-50, y-50, 100, 100);
					 }
						
					}
        	 
        	 
        		 };
        pnlCenter.setBorder(BorderFactory.createEtchedBorder(Color.blue, Color.CYAN));
        	//	 pnlCenter.setBorder(BorderFactory.createLineBorder(Color.blue, 10));
		MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				x = e.getX();
				y = e.getY();
				label.setText(x + " " + y);
				pnlCenter.repaint();
			}

		};
		pnlCenter.addMouseMotionListener(mouseMotionAdapter);
		MouseAdapter mouseAdapter = new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				label.setText("Clicked mouse!");
				clicked = true;
				pnlCenter.repaint();
			}
/*
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				if (e.isPopupTrigger())
				{
				  popup.show(e.getComponent(),e.getX(),e.getY());
				}
			}
*/
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if(e.isPopupTrigger())
				{
					popup.show(e.getComponent(),e.getX(),e.getY());
				}
			}


		};
		pnlCenter.addMouseListener(mouseAdapter);
         pnlCenter.setBackground(new Color(128,128,128));
        
         mainPanel.add(pnlCenter, BorderLayout.CENTER);

         mainPanel.add(addToolBar(),BorderLayout.WEST);
    
     
      
         
		
      
        
         JPanel p2 = addJTree();
         JPanel p3 = addJTable();

         
         
       JTabbedPane tp = new JTabbedPane();
  	   tp.add("Main",mainPanel);
  	   tp.addTab("Some else", p);
  	   tp.addTab("JTree",p2);
  	  tp.addTab("JTable",p3); 
  	   
  	   this.add(tp);
	    
        setupMainMenu();
		setupPopup();


	    setVisible(true);
	}


	private JToolBar addToolBar()
	{
		JToolBar tb = new JToolBar("Test",JToolBar.VERTICAL);
        JButton btn = new JButton(new ImageIcon("1.png"));
        btn.addActionListener(e->label.setText("Tool clicked"));
        tb.add(btn);
        btn = new JButton( new MyAction("",new ImageIcon("2.png"),KeyEvent.VK_Y,KeyEvent.VK_Y,"ttt")  );
		tb.add(btn);
		return tb;
	}

	private void setupPopup()
	{
	  popup = new JPopupMenu();
	  JMenuItem mi =new JMenuItem("Mark");
	  mi.addActionListener(el-> label.setText("Marked!"));
	  popup.add(mi);
	  popup.add(new JMenuItem(action));

	}

    private void setupMainMenu() {

        final JMenuBar mb = new JMenuBar();
        final JMenu menu = new JMenu("File");
        menu.setIcon( new ImageIcon("1.png"));
        final int count =5;
        for (int i = 0; i < count; i++)
        {
            JMenuItem mi = new JMenuItem("Item "+i);
          //  mi.setDisabledIcon(new ImageIcon("2.png"));
            mi.setIcon(new ImageIcon("2.png"));
            mi.setToolTipText("Item "+i);
            if(i%2==0)
            {
             mi.setEnabled(false);
            }

            //hot keys
            Field f=null;
            try {
                f = KeyEvent.class.getField("VK_"+i);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            if (f != null) {
                try {
                    mi.setAccelerator(KeyStroke.getKeyStroke(f.getInt(null), KeyEvent.CTRL_DOWN_MASK));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

           //
            mi.addActionListener(e->System.out.println("Clicked item "+e.toString()));

           menu.add(mi);
        }
        menu.add(new JMenuItem(action));
        mb.add(menu);

        //check boxes
        final JMenu optionsMenu = new JMenu("Options");
        for(int i=0;i<count;i++)
		{
		 final JCheckBoxMenuItem mi = new JCheckBoxMenuItem("Item "+i);
		 if(i%2==0)
			{
				mi.setState(true);
			}
		 mi.addActionListener(System.out::println);

		 optionsMenu.add(mi);
		}
        mb.add(optionsMenu);

       //radio
		final JMenu radioMenu = new JMenu("Radio");
		final ButtonGroup bg = new ButtonGroup();
		for (int i=0;i<count;i++)
		{

			JRadioButtonMenuItem mi = new JRadioButtonMenuItem("Item " +i);
			if(i==0) mi.setSelected(true);
			bg.add(mi);
			radioMenu.add(mi);
		}



		mb.add(radioMenu);



        this.setJMenuBar(mb);
    }


    private JPanel addJTable()
	{
	 JPanel p = new JPanel();
	 p.setLayout(new BorderLayout());
	 
	 List<String> cols = new ArrayList<>();
	 cols.add("Name");
	 cols.add("Fam");
	 cols.add("Info");
	 
	 HashMap<Integer,String[]> rows = new HashMap<>();
	 
	 rows.put(0, new String[]{"ssws","wsws","edede","xsxs"});//!!!
	 rows.put(1, new String[]{"hhhh","gggg","ffff"}); 
	 rows.put(2, new String[]{"ddd","sss","aaaa"});

	 MyTableModel tm = new MyTableModel(cols,rows);
	 JTable tbl = new JTable(tm);
	
	 
	 
	 p.add( new JScrollPane(tbl),BorderLayout.CENTER);
	 return p;
	}

	private JPanel addJTree() {
		JPanel p2 = new JPanel();
         JTree tree;
         // DefaultMutableTreeNode top = new DefaultMutableTreeNode("�����"); 
         TreeModel model = new FileTreeModel(new File(System.getProperty("user.dir")));
      //   TreeModel model = new PathTreeModel(Paths.get(""));
		
         tree = new JTree(model);
		
         tree.addTreeSelectionListener(e -> System.out.println( e.getPath()+"!!!!!"));
         JScrollPane sp = new JScrollPane(tree);
         p2.setLayout(new BorderLayout());
         p2.add(sp,BorderLayout.CENTER);
		return p2;
	}

	class MyAction extends AbstractAction
	{
		 MyAction(String name,Icon icon,int mnem, int accel,String tTip)
		 {
		 	super(name,icon);
		 	putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(accel,InputEvent.CTRL_DOWN_MASK));
		 	putValue(MNEMONIC_KEY,mnem);
		 	putValue(SHORT_DESCRIPTION,tTip);
		 }

		@Override
		public void actionPerformed(ActionEvent e) {
         label.setText(e.getActionCommand());
		}
	}


}
