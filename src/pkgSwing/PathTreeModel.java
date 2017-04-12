package pkgSwing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @author Vitaly
 *
 */
@SuppressWarnings("unused")
class PathTreeModel implements TreeModel {

	
	private final Path root;

	public PathTreeModel(Path root)
	{
		this.root=root;
	}
// --Commented out by Inspection STOP (12.04.2017 10:16)
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
		
		Path p = (Path)parent;
		Object o=null;
		try {
			o = Files.list(p).toArray()[index];
		} catch (IOException e) {
			e.printStackTrace();
		}
		return o;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#getChildCount(java.lang.Object)
	 */
	@Override
	public int getChildCount(Object parent) {
		Path p = (Path)parent;
		if( Files.isDirectory(p))
		{
		try {
			return Files.list(p).toArray().length;
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#isLeaf(java.lang.Object)
	 */
	@Override
	public boolean isLeaf(Object node) {
		Path p = (Path)node;
		
		return !Files.isDirectory(p);
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#valueForPathChanged(javax.swing.tree.TreePath, java.lang.Object)
	 */
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.tree.TreeModel#getIndexOfChild(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		
		Path p = (Path)parent;
	//	Path pch = (Path)child;
		
		int index=0;
		try {
		index=	Arrays.asList(Files.list(p).toArray()).indexOf(child);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("get index: "+index);
		return index;
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
