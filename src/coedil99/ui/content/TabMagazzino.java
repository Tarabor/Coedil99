package coedil99.ui.content;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Dimension;
import java.awt.Font;
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
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;

import coedil99.application.Controller.CtrlElaboraPreventivo;
import coedil99.application.Controller.CtrlGestisciMagazzino;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Preventivo;
import coedil99.ui.template.MagazzinoTableModel;

public class TabMagazzino extends JPanel {
	
	private JTable magazzino;
	
	private String [] tableHeader = new String[] {
			"ARTICOLO", "DESCRIZIONE", "MATERIALE", "PESO", "DIAMETRO", "LUNGHEZZA", "TIPO SAGOMA", "PREZZO", "N\u00B0 PEZZI", "FORNITORE"
		};
	
	private static final Font FONT_TABLE_HEADER = new Font("Century Gothic", Font.BOLD, 14);
	private static final Font FONT_TABLE = new Font("Century Gothic", Font.PLAIN, 14);
	
	
	
	protected String[] columnToolTips = {
			"Il tipo di elemento",
		    null, // "First Name" assumed obvious
		    null,
		    null,
		    "Il diametro del bullone",
		    "La lunghezza dell'elemento",
		    "Il tipo di sagoma della lastra o della trave",
		    null,
		    "Numero di pezzi disponibili in magazzino",
		    "Fornitore dell'articolo"};

	/**
	 * Create the panel.
	 */
	public TabMagazzino(ArrayList<Object[]> data) {
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setMinimumSize(new Dimension(0, 0));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{805, 0};
		gridBagLayout.rowHeights = new int[] {70, 307};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(32767, 50));
		panel.setBorder(new EmptyBorder(0, 100, 1, 100));
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
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
		
		JButton btnNewItem = new JButton("Aggiungi Elementi al Magazzino");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlGestisciMagazzino.getInstance().createElementoMagazzino(); 
			}
		});
		panel_1.add(btnNewItem, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		magazzino = new JTable(new MagazzinoTableModel(data,tableHeader)) { //Alla creazione della tabella inseriamo i tooltips
		  
		    //Implement table header tool tips.
		    protected JTableHeader createDefaultTableHeader() {
		        return new JTableHeader(columnModel) {
		            public String getToolTipText(MouseEvent e) {
		                String tip = null;
		                java.awt.Point p = e.getPoint();
		                int index = columnModel.getColumnIndexAtX(p.x);
		                int realIndex = 
		                        columnModel.getColumn(index).getModelIndex();
		                return columnToolTips[realIndex];
		            }
		        };
		    }
		};
		magazzino.setFont(FONT_TABLE);
		magazzino.setSelectionForeground(new Color(0, 0, 0));
		magazzino.setSelectionBackground(new Color(173, 216, 230));
		magazzino.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	
		magazzino.getTableHeader().setReorderingAllowed(false);
		magazzino.getTableHeader().setFont(FONT_TABLE_HEADER);
		magazzino.setRowSelectionAllowed(true);
		magazzino.setRowHeight(30);
		magazzino.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		JScrollPane scrollPane = new JScrollPane(magazzino);
		panel_2.add(scrollPane);

	}
	
	
	public void setMagazzino(ArrayList<Object[]> dati) {
		this.magazzino.setModel(new MagazzinoTableModel(dati, this.tableHeader));
	}
	

}
