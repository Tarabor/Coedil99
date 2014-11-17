package coedil99.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;


import coedil99.application.controller.CtrlGestisciRDA;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Ordine;
import coedil99.persistentmodel.Trave;
import coedil99.ui.content.OpenFornitoriView;
import coedil99.ui.content.OrdinePanel;
import coedil99.ui.template.Etichetta;
import coedil99.ui.template.RdaTableModel;

import javax.swing.border.LineBorder;
import javax.swing.table.JTableHeader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class OrdiniView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static OrdiniView instance;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_LASTRA = "/coedil99/ui/img/lastra.png";
	private final String ICON_BULLONE = "/coedil99/ui/img/bullone.png";
	private final String ICON_TRAVE = "/coedil99/ui/img/trave.png";
	private final String ICON_ARROW = "/coedil99/ui/img/arrow_icon.png";
	private JPanel panel;
	private OrdinePanel newOrdine;
	private JList<ElementoRDA> element;
	
	private JTabbedPane tabbedPane;
	
	private final String TITLE_FRAME  = "Gestione Ordini";
	private JTable rda;
	private String [] tableHeader = new String[] {
			"ID", "CONSEGNA PREVISTA", "CONSEGNA EFFETTIVA", "RITARDO", "FORNITORE"};
	private static final Font FONT_TABLE_HEADER = new Font("Century Gothic", Font.BOLD, 14);
	private static final Font FONT_TABLE = new Font("Century Gothic", Font.PLAIN, 14);
	
	protected String[] columnToolTips = {
			"ID univoco dell'ordine",
			"Data di consegna prevista",
		    "Data di consegna effettiva",
		    "Ritardo"};
	


	/**
	 * Create the frame.
	 */
	public OrdiniView() {
		super();
		this.init();
		this.initGui();
	}
	
	private void init(){
		this.element = new JList<ElementoRDA>(new DefaultListModel<ElementoRDA>());
		this.element.setCellRenderer(new ListCellRenderer());
	}
	
	
	private void initGui() {
		setTitle(TITLE_FRAME);
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(OrdiniView.class.getResource(ICON_FRAME)));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 20, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel nord = new JPanel();
		nord.setBackground(Color.WHITE);
		JLabel lblCoedilSrl = new JLabel("COEDIL 99 srl associato GEA s.c.r.l.");
		lblCoedilSrl.setMaximumSize(new Dimension(172, 80));
		lblCoedilSrl.setIcon(new ImageIcon(OrdiniView.class.getResource("/coedil99/ui/content/img/logo-scheda.png")));
		nord.add(lblCoedilSrl);
		contentPane.add(nord, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setMinimumSize(new Dimension(400, 0));
		panel.setLayout(new BorderLayout(0, 0));
		Etichetta rda_label = new Etichetta("RICHIESTE DI ACQUISTO");
		rda_label.setMaximumSize(new Dimension(200,30));
		panel.add(rda_label , BorderLayout.NORTH);
		element.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(new JScrollPane(element), BorderLayout.CENTER);
		splitPane.setLeftComponent(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JButton addButton = new JButton();
		addButton.setIcon(new ImageIcon(OrdiniView.class.getResource(ICON_ARROW)));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					int index = element.getSelectedIndex();
					if( index >= 0){
						CtrlGestisciRDA.getInstance().addElementoRDAtoOrdine(index);
						CtrlGestisciRDA.getInstance().removeElementoRDA(index);
					}
			}
		});
		panel_2.add(addButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(20, 20, 20, 20));
		splitPane.setRightComponent(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		Etichetta ordini_label = new Etichetta("ORDINI");
		ordini_label.setMaximumSize(new Dimension(200,30));
		panel_3.add(ordini_label , BorderLayout.NORTH);
		
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//this.tabbedPane.add(new OrdinePanel());
		panel_3.add(tabbedPane);
		
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
		rda.setRowSelectionAllowed(true);
		rda.setRowHeight(30);
		rda.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JSplitPane sp = new JSplitPane();
		sp.setOrientation(JSplitPane.VERTICAL_SPLIT);
		JScrollPane scrollPane = new JScrollPane(rda);
		scrollPane.setMinimumSize(new Dimension(23, 200));
		sp.setLeftComponent(scrollPane);
		this.newOrdine = new OrdinePanel();
		sp.setRightComponent(this.newOrdine);
		
		JLabel lblNuo = new Etichetta("Nuovo Ordine");
		newOrdine.add(lblNuo, BorderLayout.NORTH);
		tabbedPane.addTab("Storico Ordini", null, sp, null);
	}


	public static OrdiniView getInstance(){
		if(instance == null)
			instance = new OrdiniView();
		
		return instance;
	}
	
	public OrdinePanel getNewOrdine(){
		return this.newOrdine;
	}
	
	public void setElements(ElementoRDA [] listData){
		DefaultListModel<ElementoRDA> m = ((DefaultListModel<ElementoRDA>) this.element.getModel());
		m.clear();
		for( int i = 0 ; i < listData.length ; i++)
		((DefaultListModel<ElementoRDA>) this.element.getModel()).addElement(listData[i]);
	}
	
	public void removeElementRDA(int i){
		((DefaultListModel<ElementoRDA>) this.element.getModel()).remove(i);
	}
	
	public void setOrdini(Ordine [] listData){
		RdaTableModel m = ((RdaTableModel) this.rda.getModel());
		for (int i = m.getRowCount() - 1; i > -1; i--) m.deleteRow(i);
		for(Ordine o : listData){
			m.addRow(new Object[]{o.getID(),
					             o.getDataConsegnaPrevista(),
					             o.getDataConsegnaEffettiva(),
					             o.getRitardo(),
					            (o.getFornitore() == null) ? "" :  o.getFornitore().getDitta()});
		}
	}
	
	public void updateOrdini(Ordine o){
		((RdaTableModel) this.rda.getModel()).
		 addRow(new Object[]{o.getID(),
				             o.getDataConsegnaPrevista(),
				             o.getDataConsegnaEffettiva(),
				             o.getRitardo(),
				             (o.getFornitore() == null) ? "" :  o.getFornitore().getDitta()});
		((RdaTableModel) this.rda.getModel()).fireTableDataChanged();
	}
	
	private class ListCellRenderer extends DefaultListCellRenderer {

		private static final long serialVersionUID = 1L;
		private JLabel label;
	    private Color textSelectionColor = Color.BLACK;
	    private Color backgroundSelectionColor = new Color(220, 242, 248);
	    private Color textNonSelectionColor = Color.BLACK;
	    private Color backgroundNonSelectionColor = Color.WHITE;

	    ListCellRenderer() {
	        label = new Etichetta();
	        label.setOpaque(true);
	        label.setBorder(new EmptyBorder(3,6,3,3));
	    }
	    @Override
	    public Component getListCellRendererComponent(
	            JList<?> list, Object value,
	            int index,
	            boolean selected, boolean expanded) {
	    	
	    	String icon = "";
	    	String name = ((ElementoRDA) value).getItem().getClass().getName().split("\\.")[2];
	    	String discriminatorLabel = "";
	    	String discriminator = "";
	    	switch(name){
	    	case "Trave":
	    		icon = ICON_TRAVE;
	    		discriminatorLabel = "Lunghezza";
	    		discriminator += ((Trave)((ElementoRDA) value).getItem()).getLunghezza();
	    		break;
	    	case "Bullone":
	    		icon = ICON_BULLONE;
	    		discriminatorLabel = "Diametro";
	    		discriminator +=((Bullone)((ElementoRDA) value).getItem()).getDiametro();
	    		break;
	    	case "Lastra":
	    		icon = ICON_LASTRA;
	    		discriminatorLabel = "Materiale";
	    		discriminator =((Lastra)((ElementoRDA) value).getItem()).getMateriale();
	    		break;
	    	}
	        label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(OrdiniView.class.getResource(icon))));
	        label.setText("<html><span style='font-weight: bold;'>"+name+"</span>"+
	        		"<br><span style='color:gray'>"+
	        			  discriminatorLabel+
	        			  ": </span>"+
	        			  "<span style='color:black'>"+
	        			  discriminator+
	        			  "</span></html>");

	        if (selected) {
	            label.setBackground(backgroundSelectionColor);
	            label.setForeground(textSelectionColor);
	        } else {
	            label.setBackground(backgroundNonSelectionColor);
	            label.setForeground(textNonSelectionColor);
	        }
	        JPanel p = new JPanel(new BorderLayout(0, 0));
	        p.add(label, BorderLayout.CENTER);
	        JButton b = new JButton(((ElementoRDA) value).getQuantita()+"");
	        b.setMinimumSize(new Dimension(10,50));
	        b.setFont(new Font("sansserif",Font.BOLD,14));
	        p.add(b, BorderLayout.EAST);
	        return p;
	    }
	}

	public void showFornitori(Fornitore[] listFornitoreByQuery) {
		OpenFornitoriView of = OpenFornitoriView.getInstance();
		of.setElements(listFornitoreByQuery);
		of.setController(CtrlGestisciRDA.getInstance());
		of.setVisible(true);	
	}

	public void hideFornitori() {
		OpenFornitoriView.getInstance().setVisible(false);
	}

	public void reset() {
		this.newOrdine.reset();
	}
}