package coedil99.ui.content;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import coedil99.application.controller.CtrlGestisciRDA;
import coedil99.ui.template.RdaTableModel;

public class TabRda extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTable rda;
	private JButton btnInviaRda;
	private JButton btnNewItem;
	
	private String [] tableHeader = new String[] {
			"ID ARTICOLO", "ARTICOLO", "MATERIALE", "DIAMETRO", "LUNGHEZZA", "N\u00B0 PEZZI"
		};
	
	private static final Font FONT_TABLE_HEADER = new Font("Century Gothic", Font.BOLD, 14);
	private static final Font FONT_TABLE = new Font("Century Gothic", Font.PLAIN, 14);
	
	
	
	protected String[] columnToolTips = {
			"ID univoco dell'elemento",
			"Il tipo di elemento",
		    "Il materiale della lastra",
		    "Il diametro del bullone",
		    "La lunghezza dell'elemento",
		    "Numero di pezzi da ordinare"};

	/**
	 * Create the panel.
	 */
	public TabRda() {
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setMinimumSize(new Dimension(0, 0));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {363, 201, 0};
		gridBagLayout.rowHeights = new int[] {70, 133, 46};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0};
		setLayout(gridBagLayout);
		
		JLabel lblCoedilSrl = new JLabel("COEDIL 99 srl associato GEA s.c.r.l.");
		GridBagConstraints gbc_lblCoedilSrl = new GridBagConstraints();
		gbc_lblCoedilSrl.anchor = GridBagConstraints.WEST;
		gbc_lblCoedilSrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblCoedilSrl.gridx = 0;
		gbc_lblCoedilSrl.gridy = 0;
		add(lblCoedilSrl, gbc_lblCoedilSrl);
		lblCoedilSrl.setMaximumSize(new Dimension(172, 80));
		lblCoedilSrl.setIcon(new ImageIcon(TabContent.class.getResource("/coedil99/ui/content/img/logo-scheda.png")));
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		
		
		rda = new JTable(new RdaTableModel(tableHeader)) { //Alla creazione della tabella inseriamo i tooltips
		  
		    //Implement table header tool tips.
		    protected JTableHeader createDefaultTableHeader() {
		        return new JTableHeader(columnModel) {
		            public String getToolTipText(MouseEvent e) {
		                java.awt.Point p = e.getPoint();
		                int index = columnModel.getColumnIndexAtX(p.x);
		                int realIndex = 
		                        columnModel.getColumn(index).getModelIndex();
		                return columnToolTips[realIndex];
		            }
		        };
		    }
		};
		rda.setEnabled(false);
		rda.setFont(FONT_TABLE);
		rda.setSelectionForeground(new Color(0, 0, 0));
		rda.setSelectionBackground(new Color(173, 216, 230));
		rda.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	
		rda.getTableHeader().setReorderingAllowed(false);
		rda.getTableHeader().setFont(FONT_TABLE_HEADER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		rda.setRowSelectionAllowed(true);
		rda.setRowHeight(30);
		rda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		JScrollPane scrollPane = new JScrollPane(rda);
		panel_1.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		btnNewItem = new JButton("Aggiungi Elementi alla RDA");
		btnNewItem.setBounds(10, 11, 159, 23);
		panel.add(btnNewItem);
		btnNewItem.setPreferredSize(new Dimension(100, 20));
		
		btnInviaRda = new JButton("Invia RDA");
		btnInviaRda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//la view invia il contenuto della tabella al controller
				CtrlGestisciRDA.getInstance().inviaRda(((RdaTableModel) rda.getModel()).getTableData());
			}
		});
		btnInviaRda.setBounds(10, 97, 89, 23);
		panel.add(btnInviaRda);
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlGestisciRDA.getInstance().popupNewLineRda();
			}
		});

	}
	
	
	
	public void aggiungiRigaRda(Object[] insert) {
		((RdaTableModel) this.rda.getModel()).addRow(insert);
		((RdaTableModel) this.rda.getModel()).fireTableDataChanged(); //utile per visualizzare subito l'aggiunta della riga
	}



	public void setSalvaInvisible() {
		JOptionPane.showMessageDialog(this, "RDA Inviata!");
		btnInviaRda.setVisible(false);
		btnNewItem.setVisible(false);
	}


}
