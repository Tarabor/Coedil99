package coedil99.ui.content;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.ListSelectionModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import coedil99.Model.MDistintaLavorazione;
import coedil99.ui.Coedil99View;
import coedil99.ui.template.Etichetta;
import coedil99.ui.template.CampoTesto;
import coedil99.ui.template.ImageSelector;
import coedil99.ui.template.MyTableModel;
import coedil99.ui.template.SelectItem;
import coedil99.utility.Service;

import javax.swing.JToggleButton;

public class TabContent extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	private static TabContent instance;
	
	private JTable distinta;
	private JTextField destinazioneMateriale;
	private JTextField elementoStrutturale;
	private JTextField cartellino;
	private JTextField rev;
	private JTextField data_1;
	private CampoTesto campoTesto_1;
	private CampoTesto data;
	private CampoTesto cliente;
	private CampoTesto pagina;
	private Box verticalBox_2;
	private JPanel panel_3;
	private JPopupMenu popMenu;
	private JToggleButton btnFirma;
	private SelectItem selectStatica;
	private ResourceBundle bundle = Coedil99View.getInstance().getBundle();
	
	private  final ImageIcon RED_ICON = new ImageIcon(TabContent.class.getResource(bundle.getString("gui.tabcontent.icon.redbullet")));
	private  final ImageIcon GREEN_ICON = new ImageIcon(TabContent.class.getResource(bundle.getString("gui.tabcontent.icon.greenbullet")));
	private static final Font FONT_TABLE_HEADER = new Font("Century Gothic", Font.BOLD, 14);
	private static final Font FONT_TABLE = new Font("Century Gothic", Font.PLAIN, 14);

	private String [] tableHeader = new String[] {
			"ARTICOLO", "INDICAZIONE", "N\u00B0 PEZZI", "DIAM", "MISURA DI TAGLIO", "TIPO SAGOMA"
		};
	
	protected String[] columnToolTips = {
			"Il tipo di elemento che si desidera inserire in distinta",
		    null, // "First Name" assumed obvious
		    null, // "Last Name" assumed obvious
		    "Il diametro del bullone",
		    "La misura di taglio dell'elemento",
		    "Il tipo di sagoma della lastra o della trave"};
	

	/**
	 * Create the panel.
	 */
	public TabContent() {		
		setBorder(new EmptyBorder(50, 0, 0, 0));
		setMinimumSize(new Dimension(0, 0));
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{678, 0};
		gridBagLayout.rowHeights = new int[] {86, 70, 70, 70, 136};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		setLayout(gridBagLayout);
		
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 100, 1, 100));
		panel.setMaximumSize(new Dimension(32767, 50));
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
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		panel_1.add(horizontalBox_2, BorderLayout.EAST);
		
		JLabel lblData = new JLabel("Data:");
		horizontalBox_2.add(lblData);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		
		data_1 = new CampoTesto();
		horizontalBox_2.add(data_1);
		data_1.setColumns(10);
		
		JLabel lblDistintaLavorazione = new Etichetta("DISTINTA DI LAVORAZIONE");
		lblDistintaLavorazione.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDistintaLavorazione, BorderLayout.NORTH);
		lblDistintaLavorazione.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel lblNewLabel = new JLabel("MO7.51-03");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.WEST);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 10));
		
		Box horizontalBox = Box.createHorizontalBox();
		panel_1.add(horizontalBox, BorderLayout.CENTER);
		
		JLabel lblRev = new JLabel("Rev.:");
		horizontalBox.add(lblRev);
		lblRev.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRev.setPreferredSize(new Dimension(30, 14));
		
		rev = new CampoTesto();
		rev.setMaximumSize(new Dimension(60, 30));
		rev.setText("1");
		horizontalBox.add(rev);
		rev.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_3.setBackground(Color.WHITE);
		panel_3.setMaximumSize(new Dimension(32767, 50));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		panel_3.setLayout(new GridLayout(1, 3, 15, 0));
		
		Box verticalBox_1 = Box.createVerticalBox();
		verticalBox_1.setPreferredSize(new Dimension(0, 50));
		panel_3.add(verticalBox_1);
		
		Etichetta tchtData = new Etichetta("DATA");
		tchtData.setText("  DATA");
		verticalBox_1.add(tchtData);
		tchtData.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtData.setHorizontalAlignment(SwingConstants.LEFT);
		
		data = new CampoTesto();
		verticalBox_1.add(data);
		data.setAlignmentX(Component.LEFT_ALIGNMENT);
		data.setColumns(10);
		
		verticalBox_2 = Box.createVerticalBox();
		verticalBox_2.setPreferredSize(new Dimension(0, 50));
		panel_3.add(verticalBox_2);
		
		Etichetta tchtClienteimpresa = new Etichetta("CLIENTE/IMPRESA");
		tchtClienteimpresa.setText("  CLIENTE/IMPRESA");
		verticalBox_2.add(tchtClienteimpresa);
		tchtClienteimpresa.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		cliente = new CampoTesto();
		cliente.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		cliente.setEditable(false);
		cliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Coedil99View.getInstance().getController().listaClienti();
			}
		});
		cliente.setBackground(Color.WHITE);
		verticalBox_2.add(cliente);
		cliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		cliente.setColumns(30);
		
		Box verticalBox_3 = Box.createVerticalBox();
		verticalBox_3.setPreferredSize(new Dimension(0, 50));
		panel_3.add(verticalBox_3);
		
		Etichetta tchtPag = new Etichetta("PAG.");
		tchtPag.setText("  PAG.");
		verticalBox_3.add(tchtPag);
		
		pagina = new CampoTesto();
		verticalBox_3.add(pagina);
		pagina.setAlignmentX(Component.LEFT_ALIGNMENT);
		pagina.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_2.setMaximumSize(new Dimension(32767, 50));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(new GridLayout(0, 3, 15, 0));
		
		Box verticalBox = Box.createVerticalBox();
		panel_2.add(verticalBox);
		
		JLabel lblDestinazioneMateriale = new Etichetta("DESTINAZIONE MATERIALE");
		lblDestinazioneMateriale.setText("  DESTINAZIONE MATERIALE");
		verticalBox.add(lblDestinazioneMateriale);
		
		destinazioneMateriale = new CampoTesto();
		verticalBox.add(destinazioneMateriale);
		destinazioneMateriale.setColumns(10);
		
		Box verticalBox_4 = Box.createVerticalBox();
		panel_2.add(verticalBox_4);
		
		JLabel lblElementoSttrutturale = new Etichetta("ELEMENTO STRUTTURALE");
		lblElementoSttrutturale.setText("  ELEMENTO STRUTTURALE");
		verticalBox_4.add(lblElementoSttrutturale);
		
		elementoStrutturale = new CampoTesto();
		verticalBox_4.add(elementoStrutturale);
		elementoStrutturale.setColumns(10);
		
		Box verticalBox_5 = Box.createVerticalBox();
		panel_2.add(verticalBox_5);
		
		JLabel lblCartellino = new Etichetta("CARTELLINO");
		verticalBox_5.add(lblCartellino);
		
		cartellino = new CampoTesto();
		verticalBox_5.add(cartellino);
		cartellino.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setMaximumSize(new Dimension(32767, 50));
		panel_5.setBorder(new EmptyBorder(0, 100, 0, 100));
		panel_5.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 3;
		add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 3, 15, 0));
		
		Box verticalBox_6 = Box.createVerticalBox();
		panel_5.add(verticalBox_6);
		
		Etichetta etichetta_Firmato = new Etichetta("FIRMATO");
		verticalBox_6.add(etichetta_Firmato);
		
		btnFirma = new JToggleButton();
		btnFirma.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.setFirma(false);
		btnFirma.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
			      if(ev.getStateChange()==ItemEvent.SELECTED){
			    	  setFirma(true);
			      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
			    	  setFirma(false);
			      }
			   }
			});
		verticalBox_6.add(btnFirma);
		
		Box verticalBox_7 = Box.createVerticalBox();
		panel_5.add(verticalBox_7);
		
		Etichetta etichetta_1 = new Etichetta("TOTALE");
		etichetta_1.setText("  TOTALE");
		verticalBox_7.add(etichetta_1);
		
		campoTesto_1 = new CampoTesto();
		campoTesto_1.setToolTipText("Totale del preventivo");
		campoTesto_1.setBackground(Color.WHITE);
		campoTesto_1.setEditable(false);
		campoTesto_1.setColumns(10);
		campoTesto_1.setText("0 $");
		verticalBox_7.add(campoTesto_1);
		
		Box verticalBox_8 = Box.createVerticalBox();
		panel_5.add(verticalBox_8);
				
				Etichetta etichetta = new Etichetta("SALVA");
				etichetta.setText("  SALVA");
				verticalBox_8.add(etichetta);
				
						JButton btnSalvaPreventivo = new JButton("Salva Preventivo");
						btnSalvaPreventivo.setAlignmentY(Component.BOTTOM_ALIGNMENT);
						verticalBox_8.add(btnSalvaPreventivo);
				btnSalvaPreventivo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salva();
					}
				});
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 4;
		add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		distinta = new JTable(new MyTableModel()) { //Alla creazione della tabella inseriamo i tooltips
		  
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
		distinta.setFont(FONT_TABLE);
		distinta.setSelectionForeground(new Color(0, 0, 0));
		distinta.setSelectionBackground(new Color(173, 216, 230));
		distinta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);	
		distinta.getTableHeader().setReorderingAllowed(false);
		distinta.getTableHeader().setFont(FONT_TABLE_HEADER);
		distinta.setRowSelectionAllowed(true);
		distinta.setRowHeight(30);
		distinta.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		selectStatica = new SelectItem();
		selectStatica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { //da l'aspetto di un campo disabilitato
				SelectItem cb = (SelectItem) e.getSource();
		        String itemName = (String) cb.getSelectedItem();
				if (itemName.equals("Bullone")) {
					final int selectedRow = distinta.getSelectedRow();
					distinta.getColumnModel().getColumn(5).setCellRenderer(new DefaultTableCellRenderer() {
						public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				                boolean hasFocus, int row, int column) {
				            Component component =
				                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				            component.setEnabled(selectedRow!=row);
				            return component;
				   }   
					});
				} else if (itemName.equals("Trave") || itemName.equals("Lastra")) {
					final int selectedRow = distinta.getSelectedRow();
					distinta.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
						public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				                boolean hasFocus, int row, int column) {
				            Component component =
				                    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				            component.setEnabled(selectedRow!=row);
				            return component;
				   }   
					});
				}
			}
		});
		this.setUpTipoColumn(distinta, distinta.getColumnModel().getColumn(0));
		distinta.getColumnModel().getColumn(0).setPreferredWidth(100);
		distinta.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new ImageSelector()));
		distinta.getColumnModel().getColumn(5).setPreferredWidth(226);
		distinta.addKeyListener(new RowListener());
		distinta.addMouseListener( new TableMouseListener());
		JScrollPane scrollPane = new JScrollPane(distinta);
		panel_4.add(scrollPane);
		
		this.popMenu = new JPopupMenu();
		JMenuItem cancItem = new JMenuItem("Cancella riga");
		cancItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteRow();
			}
		});
		popMenu.add(cancItem);
	}
	
	public static TabContent getInstance(){
		if(instance == null)
			instance = new TabContent();
		
		return instance;
	}
	
	
	public void setDistinta(ArrayList<Object[]> dati) {
		this.distinta.setModel(new MyTableModel(dati, this.tableHeader));
		this.setUpTipoColumn(distinta, distinta.getColumnModel().getColumn(0));
		this.distinta.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new ImageSelector()));
		this.distinta.getColumnModel().getColumn(5).setPreferredWidth(226);
	}
	
	private void deleteRow(){
		((MyTableModel)this.distinta.getModel()).removeRow( this.distinta.getSelectedRow());
		if(this.distinta.getRowCount() == 0)
			((MyTableModel) distinta.getModel()).addRow(new Object[] {"", "", 0, 0, 0, "/"});
			
	}
	
	public void setData(String data){
		this.data.setText(data);
		this.data_1.setText(data);
	}
	
	public void setFirma(boolean b){
		if(b){
			btnFirma.setIcon(GREEN_ICON);
			btnFirma.setText(bundle.getString("gui.tabcontent.text.firmato"));
		}
		else{
			btnFirma.setIcon(RED_ICON);
			btnFirma.setText(bundle.getString("gui.tabcontent.text.firma"));
		}
	}
	
	public void setDestinazioneMateriale(String dm){
		this.destinazioneMateriale.setText(dm);
	}
	
	public void setElementoStrutturale(String es){
		this.elementoStrutturale.setText(es);
	}
	public void setCartellino(String c){
		this.cartellino.setText(c);
	}
	
	public void setCliente(String cliente){
		this.cliente.setText(cliente);
	}
	
	public void setPagina(String pagina){
		this.pagina.setText(pagina);
	}
	
	public void setUpTipoColumn(JTable table, TableColumn tipColumn) {
		tipColumn.setCellEditor(new DefaultCellEditor(selectStatica));

		//Set up tool tips for the sport cells.
		DefaultTableCellRenderer renderer =
				new DefaultTableCellRenderer();
		renderer.setToolTipText("Click per la selezione");
		tipColumn.setCellRenderer(renderer);
	}
	
	public void salva() {
		this.distinta.changeSelection(0, 0, false, false);
		Coedil99View.getInstance().getController().
		salvaPreventivo(this.data.getText(),
					    this.elementoStrutturale.getText(),
					    this.cartellino.getText(),
					    this.btnFirma.isSelected(),
					    Service.getTableData((MyTableModel)this.distinta.getModel()));
	}
	
	private class RowListener implements KeyListener {
		 public void keyPressed(KeyEvent e) {
			 if(e.getKeyCode() == KeyEvent.VK_ENTER){
				 Coedil99View.getInstance().getController().totalePreventivo(Service.getTableData((MyTableModel)distinta.getModel()));
				 ((MyTableModel) distinta.getModel()).addRow(new Object[] {"", "", 0, 0, 0, "/"});
             }
		    }
		public void keyReleased(KeyEvent arg0){}
		public void keyTyped(KeyEvent arg0){}
    }
	
	private class TableMouseListener implements MouseListener{
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {
		    if(SwingUtilities.isRightMouseButton(e)){
		    	popMenu.show(e.getComponent(), e.getX(), e.getY());
		    }
		}
	}

	public void setTotale(double totale) {
		campoTesto_1.setText(String.valueOf(totale)+" $");
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Thread in update: " + Thread.currentThread());
		campoTesto_1.setText(String.valueOf(arg)+" $");
		campoTesto_1.repaint();
	}
	
	
}