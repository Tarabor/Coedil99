package coedil99.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.ui.template.MyTableModel;

public class Service {
	
		public static Object[][] getTableData (MyTableModel dtm) {
		   
		    int nRow = dtm.getRowCount() , nCol = dtm.getColumnCount();
		    Object[][] tableData = new Object[nRow][nCol];
		    for (int i = 0 ; i < nRow ; i++)
		        for (int j = 0 ; j < nCol ; j++)
		            tableData[i][j] = dtm.getValueAt(i,j);
		    return tableData;
		}
		
		public static MyTableModel setTableData (ArrayList<Object[]> tableData) {
			int nRow = tableData.size();
			int nCol = tableData.get(0).length;
			
			MyTableModel dtm = new MyTableModel();
		    for (int i = 0 ; i <  nRow; i++)
		        for (int j = 0 ; j <  nCol; j++)
		             dtm.setValueAt( tableData.get(i)[j],i,j);            		 
		    return dtm;
		}
		
		public static Date getDatadb(String data){
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date data_db = null;
			try {
				data_db = new Date(sdf.parse(data).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return data_db;
		}
		
		public static Date getDatadb(){
			GregorianCalendar gc = new GregorianCalendar();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String data = sdf.format(gc.getTime());
			Date data_db = null;
			try {
				data_db = new Date(sdf.parse(data).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return data_db;
		}
		
		public static Item[] loadDataItemsFromDB() {
			return ItemDAO.listItemByQuery(null, "discriminator");
			
		}
}
