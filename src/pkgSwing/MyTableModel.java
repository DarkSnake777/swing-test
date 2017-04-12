package pkgSwing;
import java.util.HashMap;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * @author Vitaly
 *
 */
class MyTableModel   implements TableModel {

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	private final List<String> columns;
	private final HashMap<Integer,String[]> rows;
	MyTableModel(List<String> columns, HashMap<Integer, String[]> rows)
	{
		this.columns=columns;
		this.rows=rows;
		//this.setColumnIdentifiers(newIdentifiers);
		
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return columns.get(columnIndex);
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return String.class;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
	    String str;
	    str= rows.get(rowIndex)[columnIndex];
	    
	
		return str;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#addTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#removeTableModelListener(javax.swing.event.TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

}
