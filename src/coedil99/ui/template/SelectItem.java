package coedil99.ui.template;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class SelectItem extends JComboBox{

	static String[] elementi = {"Trave", "Bullone", "Lastra"};

	public SelectItem() {
		super(elementi);


		
	}

}