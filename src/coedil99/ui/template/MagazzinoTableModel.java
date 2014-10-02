package coedil99.ui.template;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MagazzinoTableModel extends AbstractTableModel {
	
	private String [] tableHeader = new String[] {
			"ARTICOLO", "DESCRIZIONE", "MATERIALE", "PESO", "DIAMETRO", "LUNGHEZZA", "TIPO SAGOMA", "PREZZO", "N\u00B0 PEZZI", "FORNITORE"
		};
	
	private ArrayList<Object[]> data = new ArrayList<>();
	
	public MagazzinoTableModel() {
		
	}
	
	public MagazzinoTableModel(ArrayList<Object[]> data, String[] header) {
        this.tableHeader = header;
        this.data = data;
    }
	
	public void addRow(Object[] insert) {
		this.data.add(insert);
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

}
