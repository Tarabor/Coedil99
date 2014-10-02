package coedil99.ui.content;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JList;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import coedil99.PersistentModel.Item;
import coedil99.PersistentModel.Preventivo;
import coedil99.application.Controller.CtrlElaboraPreventivo;


public class TabMagazzino extends JPanel {
	
	
	private JList<Item> element;

	/**
	 * Create the panel.
	 */
	public TabMagazzino() {
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setMinimumSize(new Dimension(0, 0));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{678, 0};
		gridBagLayout.rowHeights = new int[] {86, 70, 70, 70, 136};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(new EmptyBorder(0, 100, 1, 100));
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 2, 5, 1));
		
		JLabel lblCoedilSrl = new JLabel("COEDIL 99 srl associato GEA s.c.r.l.");
		lblCoedilSrl.setMaximumSize(new Dimension(172, 80));
		panel.add(lblCoedilSrl);
		lblCoedilSrl.setIcon(new ImageIcon(TabContent.class.getResource("/coedil99/ui/content/img/logo-scheda.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setMaximumSize(new Dimension(350, 400));
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(25, 0));
		
		JButton btnNewItem = new JButton("Lista Items prova");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlElaboraPreventivo.getInstance().listaItems();
			}
		});
		panel_1.add(btnNewItem, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 3;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		

		this.element = new JList<Item>();
		this.element.setBounds(new Rectangle(5, 5, 5, 5));
		this.element.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.element.setMinimumSize(new Dimension(500, 500));
		this.element.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.element.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.element.setVisibleRowCount(-1);
		panel_2.add(this.element);

	}
	
	public void setElements(Item[] listData){
		this.element.setListData(listData);
	}

}
