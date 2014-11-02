package coedil99.ui.template;


import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class RdaTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String [] tableHeader = new String[] {
			"ID ARTICOLO", "ARTICOLO", "MATERIALE", "DIAMETRO", "LUNGHEZZA", "N\u00B0 PEZZI"
		};
	
	private ArrayList<Object[]> data = new ArrayList<>();
	
	public RdaTableModel() {
		
	}
	
	public RdaTableModel(String[] header) {
        this.tableHeader = header;
    }
	
	public void addRow(Object[] insert) {
		this.data.add(insert);
	}
	
	public void deleteRow(int arg0) {
		this.data.remove(arg0);
	}

	@Override
	public int getColumnCount() {
        return tableHeader.length;
    }


	@Override
    public int getRowCount() {
        return data.size();
    }

	@Override
    public Object getValueAt(int row, int column) {
        return data.get(row)[column];
    }
	
	@Override
    public void setValueAt(Object value, int row, int column) {
        data.get(row)[column] = value;
        fireTableCellUpdated(row, column);
    }
	
	public String getColumnName(int col) {
        return tableHeader[col];
    }
	
	
    public boolean isCellEditable(int row, int col) { 
        return false;
    }
    
    public ArrayList<Object[]> getTableData() {
    	return this.data;
    }

}
