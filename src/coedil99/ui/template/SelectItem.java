package coedil99.ui.template;

import javax.swing.JComboBox;


public class SelectItem extends JComboBox{

	static String[] elementi = {"Trave", "Bullone", "Lastra"};

	public SelectItem() {
		super(elementi);
	}

}