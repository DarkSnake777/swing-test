package pkgSwing;

import java.io.File;
import java.util.Arrays;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @author Vitaly
 *
 */
class FileTreeModel implements TreeModel {
	
	private final File root;
	
	FileTreeModel(File root)
	{
		this.root=root;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#getRoot()
	 */
	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		 return root;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#getChild(java.lang.Object, int)
	 */
	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		   File f = (File) parent;
	        System.out.println("got child: " + f);
	        File[] files =  f.listFiles();
	        if (files==null) return null;
	        return files[index];
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#getChildCount(java.lang.Object)
	 */
	@Override
	public int getChildCount(Object parent) {

		 File f = (File) parent;
	        System.out.println("get children counf for: " + f);
	        if (!f.isDirectory()) {
	            return 0;
	        } else {
	        	String[] s = f.list();
	        	if (s==null) return 0;
	        	 else
	              return s.length;
	        }
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#isLeaf(java.lang.Object)
	 */
	@Override
	public boolean isLeaf(Object node) {
		   File f = (File) node;
	        return !f.isDirectory();
	}



	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#getIndexOfChild(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		File par = (File) parent;
        File ch = (File) child;
        File[] f =par.listFiles();
        if (f==null) return -1;
        return Arrays.asList(f).indexOf(ch);
		
	}
	
	
	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#valueForPathChanged(javax.swing.tree.TreePath, java.lang.Object)
	 */
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#addTreeModelListener(javax.swing.event.TreeModelListener)
	 */
	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#removeTreeModelListener(javax.swing.event.TreeModelListener)
	 */
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
