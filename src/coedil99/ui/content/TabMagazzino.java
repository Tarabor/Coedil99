package coedil99.ui.content;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class TabMagazzino extends JPanel {

	/**
	 * Create the panel.
	 */
	public TabMagazzino() {
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(new EmptyBorder(0, 100, 1, 100));
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 5, 1));
		
		JLabel label = new JLabel("COEDIL 99 srl associato GEA s.c.r.l.");
		label.setMaximumSize(new Dimension(172, 80));
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(350, 400));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(25, 0));

	}

}
