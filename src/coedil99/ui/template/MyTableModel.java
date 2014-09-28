package coedil99.ui.template;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	private String [] tableHeader = new String[] {
			"ARTICOLO", "INDICAZIONE", "N\u00B0 PEZZI", "DIAM", "MISURA DI TAGLIO", "TIPO SAGOMA"
		};
	
	private ArrayList<Object[]> data = new ArrayList<>();
	
	public MyTableModel() {
        this.data.add( new Object[] {"", "", 0, 0, 0, "/"} );
        }
	
	public MyTableModel(ArrayList<Object[]> data, String[] header) {
        this.tableHeader = header;
        this.data = data;
    }
	
	public void addRow(Object[] insert) {
		this.data.add(insert);
	}
	
	public void removeRow(int index) {
		this.data.remove(index);
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
	
	/*
     * Don't need to implement this method unless your table's
     * editable. Serve a disabilitare l'editing della cella
     */
    public boolean isCellEditable(int row, int col) { 
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
    	String testo = (String) getValueAt(row,0).toString();
        if ( ((testo.equals("Lastra") || testo.equals("Trave")) && col == 3 )  ) {
        	return false;
        } 
        if ((testo.equals("Bullone") && col == 5)) {
        	setValueAt("/",row,5);
        	return false;
        }else {
            return true;
        }
    }


}
