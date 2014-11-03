package coedil99.ui.content;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import coedil99.application.controller.CtrlGestisciMagazzino;
import coedil99.persistentmodel.ElementoRDA;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;

public class OrdinePanel extends JPanel {

	private JList<ElementoRDA> elements;
	public OrdinePanel() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Aggiungi Fornitore");
		btnNewButton.setMinimumSize(new Dimension(100, 9));
		panel.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(OrdinePanel.class.getResource("/coedil99/ui/img/add_cliente.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CtrlGestisciMagazzino.getInstance().listaFornitori();
			}
		});
		
		this.elements = new JList<ElementoRDA>();
		elements.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		add(elements, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 0));
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Salva");
		panel_1.add(btnNewButton_1, BorderLayout.EAST);
		
	
	}

}
