package coedil99.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


import javax.swing.table.DefaultTableModel;

public class Service {
	
		public static Object[][] getTableData (DefaultTableModel dtm) {
		   
		    int nRow = dtm.getRowCount() , nCol = dtm.getColumnCount();
		    Object[][] tableData = new Object[nRow][nCol];
		    for (int i = 0 ; i < nRow ; i++)
		        for (int j = 0 ; j < nCol ; j++)
		            tableData[i][j] = dtm.getValueAt(i,j);
		    return tableData;
		}
		
		public static DefaultTableModel setTableData (Object[][] tableData) {
			   
			 int nRow = tableData.length , nCol = tableData[0].length;
		    DefaultTableModel dtm = new DefaultTableModel(nRow,nCol);
		    for (int i = 0 ; i <  nRow; i++)
		        for (int j = 0 ; j <  nCol; j++)
		             dtm.setValueAt( tableData[i][j],i,j);            		 
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
}
