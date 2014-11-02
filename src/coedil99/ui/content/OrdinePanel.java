package coedil99.ui.content;

import javax.swing.JPanel;

import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

import coedil99.ui.template.Etichetta;

import java.awt.BorderLayout;

public class OrdinePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public OrdinePanel() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		Etichetta rda_label = new Etichetta("ORDINI");
		rda_label.setMaximumSize(new Dimension(200,30));
		add(rda_label , BorderLayout.NORTH);
		
	
	}

}
