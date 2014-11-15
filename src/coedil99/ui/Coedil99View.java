package coedil99.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JSplitPane;

import coedil99.model.MPreventivo;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.Trave;
import coedil99.ui.content.TabContent;
import coedil99.ui.content.newCliente;
import coedil99.ui.content.newFornitore;
import coedil99.ui.template.Etichetta;
import coedil99.ui.template.Scheda;
import coedil99.ui.template.btnToolBar;
import coedil99.ui.template.ElencoItemsAlbero;


import coedil99.application.controller.CtrlElaboraPreventivo;
import coedil99.application.controller.CtrlGestisciMagazzino;
import coedil99.application.controller.CtrlGestisciRDA;


public class Coedil99View extends JFrame {

	private static final long serialVersionUID = 1L;
	

	private static Coedil99View instance;
	private OpenPreventiviView op;
	private OpenClientiView oc;
	private newCliente nc;
	private newFornitore nf;
	private ResourceBundle bundle;
	private ElencoItemsAlbero navigator;
	
	private JLabel lblStatusBar;
	private JPanel contentPane;
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private int tab_count = 0;
	
	private JPopupMenu popNuovo;
	private JMenuItem mntmSalva;
	private JButton btnSave;
	private JButton addButton;
	
	private JList<Item> element;
	
	private final int MINIMUM_WIDTH = 500;
	private final int MINIMUM_HEIGHT = 500;
	
	//private final int MINIMUM_WIDTH_NAVIGATOR = 150;
	//private final int MINIMUM_HEIGHT_NAVIGATOR = 150;

	private final String BUNDLE     = "coedil99.ui.languages.it";
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_NEW   = "/coedil99/ui/img/nuovo_icon.png";
	private final String ICON_LASTRA = "/coedil99/ui/img/lastra.png";
	private final String ICON_BULLONE = "/coedil99/ui/img/bullone.png";
	private final String ICON_TRAVE = "/coedil99/ui/img/trave.png";
	private final String ICON_ARROW = "/coedil99/ui/img/arrow_icon.png";
	
	public Coedil99View(){		
		this.init();
		this.initComponents();
	}
	
	
	public static Coedil99View getInstance(){
		if(instance == null)
			instance = new Coedil99View();
		
		return instance;
	}
	
	public ResourceBundle getBundle(){
		return bundle;
	}
	
	
	public int getCurrentPreventivo(){
		return this.tabbedPane.getSelectedIndex();
	}
	
	public TabContent getObserver(int index){
		
		return ((TabContent)this.tabbedPane.getComponentAt(index));
	}
	
	public int getNumberofPreventivo(){
		return this.tab_count;
	}
	
	public void setSaveVisible(boolean b){
		this.mntmSalva.setEnabled(b);
		this.btnSave.setEnabled(b);
	}
	
	public void decreaseTabCount(){
		this.tab_count --;
	}
	
	public void nuovaScheda(){
		this.tabbedPane.addTab(bundle.getString("gui.tabcontent.defaulttitle"), new TabContent());
		this.tabbedPane.setTabComponentAt(this.tab_count , new Scheda(this.tabbedPane));
		this.tabbedPane.setSelectedIndex(this.tab_count);
		this.tab_count++;
	}
	
	public void eliminaScheda(int index){
		this.tabbedPane.remove(index);      
	}
	
	public void showPreventivi(Preventivo [] preventivi){
		this.op.setElements(preventivi);
		this.op.setVisible(true);
	}
	
	public void hidePreventivi(){
		this.op.setVisible(false);
	}
	
	public void showClienti(Cliente [] clienti){
		this.oc.setElements(clienti);
		this.oc.setVisible(true);
	}
	
	public void hideClienti(){
		this.oc.setVisible(false);
		this.nc.setVisible(false);
	}
	
	
	public void showNewFornitori() {
		this.nf.setVisible(true);
	}
	
	public void hideNewFornitori(){
		this.nf.setVisible(false);
	}
	
	
	public void showNewClienti(){
		this.nc.setVisible(true);
	}
	
	public void hideNewClienti(){
		this.nc.setVisible(false);
	}
	
	public void updateUI(){
		this.validate();
		this.repaint();
	}
	
	public void updateCliente(String cliente){
		((TabContent)this.tabbedPane.getSelectedComponent()).setCliente(cliente);
	}
	
	public void updatePreventivo(int index, MPreventivo mp){
		
		TabContent tb = ((TabContent)this.tabbedPane.getComponentAt(index));
		Preventivo p = (Preventivo)mp.getPersistentModel();
		if (p.getNome() != null)
			tabbedPane.setTitleAt(index, p.getNome());
		if( p.getCliente() != null) {
			tb.setCliente(p.getCliente().getCognome()+" "+p.getCliente().getNome());
			String indirizzo = p.getCliente().getIndirizzo().getVia() + " " + p.getCliente().getIndirizzo().getNumero() + ", " + p.getCliente().getIndirizzo().getComune();
			tb.setDestinazioneMateriale(indirizzo);
		}
		tb.setElementoStrutturale(p.getElementoStrutturale());
		tb.setPagina("1");
		tb.setCartellino(Integer.toString(p.getCartellino()));
		tb.setData(p.getData().toString());
		tb.setFirma(p.getFirmato());
		if( p.getDistinta()!= null){
			tb.setDistinta( mp.getDistintaArrayList());
			tb.setTotale(p.getDistinta().getTotale());
		}
		if(p.getFirmato()==true){
			this.addButton.setEnabled(false);
			tb.disableIfFirmato();
		} else {
			this.addButton.setEnabled(true);
		}
	}
	
	public void setItemsTreeVisible() {
		this.navigator.setVisible(true);
	}
	
	public void setItemsTreeNotVisible() {
		this.navigator.setVisible(false);
	}
	
	public void setItemsNotVisible() {
		this.element.setVisible(false);
	}
	
	public void setItemsVisible() {
		this.element.setVisible(true);
	}
	
	public Boolean isItemsVisible() {
		return this.element.isVisible();
	}
	
	public void setStatusBar(String stato) {
		lblStatusBar.setText(stato);
		System.out.println(stato);
	}
	
	public void setTotale(double totale) {
		((TabContent)this.tabbedPane.getSelectedComponent()).setTotale(totale);
	}
	
	public void setElements(Item [] listData){
		((DefaultListModel<Item>) this.element.getModel()).clear();
		for( int i = 0 ; i < listData.length ; i++)
		((DefaultListModel<Item>) this.element.getModel()).addElement(listData[i]);
	}
	
	
	public void alertItemSelected() {
		JOptionPane.showMessageDialog(this, "Hai gi� selezionato questo elemento, se desideri aumentare la quantit� aggiorna il numero dei pezzi", "Warning Selezione Item", JOptionPane.WARNING_MESSAGE);
	}
	
	public void alertPreventivoSaved() {
		JOptionPane.showMessageDialog(this, "Preventivo salvato correttamente.");
	}
	
	private void init(){
		this.element = new JList<Item>(new DefaultListModel<Item>());
		this.element.setCellRenderer(new ListCellRenderer());
	}

	/**
	 * Inizializzazione interfaccia.
	 */
	private void initComponents() {
		
		this.bundle = ResourceBundle.getBundle(BUNDLE);
		try {
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}catch (Exception e) {
				JOptionPane.showMessageDialog(instance,
						bundle.getString("gui.dialog.errorlook.text"),
						bundle.getString("gui.dialog.errorlook.frameTitle"),
			    JOptionPane.ERROR_MESSAGE);
		}
	    this.op = new OpenPreventiviView();
		this.oc = new OpenClientiView();
		this.nc = new newCliente();
		this.nf = new newFornitore();

		setIconImage(Toolkit.getDefaultToolkit().getImage(Coedil99View.class.getResource(ICON_FRAME)));
		setMinimumSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
		setTitle(bundle.getString("gui.frameTitle"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu(bundle.getString("gui.menu.file"));
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenu mnNuovo = new JMenu(bundle.getString("gui.menu.file.new"));
		mnFile.add(mnNuovo);
		
		/*
		 * *************************************************************************************
		 * MENU NUOVO
		 * *************************************************************************************
		 */
		JMenuItem mntmPreventivo1 = new JMenuItem(bundle.getString("gui.menu.file.new.preventivo"));
		mntmPreventivo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CtrlElaboraPreventivo.getInstance().creaPreventivo();
			}
		});
		mnNuovo.add(mntmPreventivo1);
		
		this.popNuovo = new JPopupMenu();
		JMenuItem mntmPreventivo2 = new JMenuItem(bundle.getString("gui.menu.file.new.preventivo"));
		mntmPreventivo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CtrlElaboraPreventivo.getInstance().creaPreventivo();
			}
		});
		this.popNuovo.add(mntmPreventivo2);
		/*
		 * *************************************************************************************
		 * 
		 * *************************************************************************************
		 */
		
		
		
		JMenuItem mntmApri = new JMenuItem(bundle.getString("gui.menu.file.open"));
		mntmApri.setIcon(new ImageIcon(Coedil99View.class.getResource("/coedil99/ui/img/explorer-icon.png")));
		mntmApri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CtrlElaboraPreventivo.getInstance().listaPreventivi();
			}
		});
		mnFile.add(mntmApri);
		
		JSeparator separator_2 = new JSeparator();
		mnFile.add(separator_2);
		
		JMenuItem mntmChiudi = new JMenuItem(bundle.getString("gui.menu.file.close"));
		mntmChiudi.setEnabled(false);
		mnFile.add(mntmChiudi);
		
		this.mntmSalva = new JMenuItem(bundle.getString("gui.menu.file.save"));
		this.mntmSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				((TabContent)tabbedPane.getSelectedComponent()).salva();
			}
		});
		this.mntmSalva.setEnabled(false);
		mnFile.add(this.mntmSalva);
		
		JMenuItem mntmSalvaConNome = new JMenuItem(bundle.getString("gui.menu.file.saveName"));
		mntmSalvaConNome.setEnabled(false);
		mnFile.add(mntmSalvaConNome);
		
		JSeparator separator_3 = new JSeparator();
		mnFile.add(separator_3);
		
		/*++++++Gestione Magazzino++++++*/
		JMenuItem mntmGestioneMagazzino = new JMenuItem(bundle.getString("gui.menu.file.magazzino"));
		mntmGestioneMagazzino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CtrlGestisciMagazzino.getInstance().apriMagazzino();
			}
		});
		mnFile.add(mntmGestioneMagazzino);
		
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		
		
		
		/*++++++Gestione RDA++++++*/
		JMenuItem mntmGestioneRDA = new JMenuItem(bundle.getString("gui.menu.file.newRDA"));
		mntmGestioneRDA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CtrlGestisciRDA.getInstance().apriNuovaRDADirettore();
			}
		});
		//mnFile.add(mntmGestioneRDA);
		
		/*++++++Gestione ORDINI++++++*/
		JMenuItem mntmGestioneOrdini = new JMenuItem(bundle.getString("gui.menu.file.ordini"));
		mntmGestioneOrdini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CtrlGestisciRDA.getInstance().apriOrdini();
			}
		});
		//mnFile.add(mntmGestioneOrdini);
		
		JMenu gestOrdini = new JMenu(bundle.getString("gui.menu.file.rda"));
		gestOrdini.setIcon(new ImageIcon(Coedil99View.class.getResource("/coedil99/ui/img/magazzino_icon.png")));
		gestOrdini.add(mntmGestioneRDA);
		gestOrdini.add(mntmGestioneOrdini);
		mnFile.add(gestOrdini);
		
		JSeparator separatore = new JSeparator();
		mnFile.add(separatore);
		
		JMenuItem mntmEsci = new JMenuItem(bundle.getString("gui.menu.file.exit"));
		mnFile.add(mntmEsci);
		
		JMenu mnEdit = new JMenu(bundle.getString("gui.menu.modify"));
		mnEdit.setMnemonic(KeyEvent.VK_E);
		menuBar.add(mnEdit);
		
		JMenuItem mntmCut = new JMenuItem(bundle.getString("gui.textcomponent.context.cut"));
		mntmCut.setMnemonic(KeyEvent.VK_CUT);
		mntmCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
		mnEdit.add(mntmCut);
		
		JMenuItem mntmCopy = new JMenuItem(bundle.getString("gui.textcomponent.context.copy"));
		mntmCopy.setMnemonic(KeyEvent.VK_COPY);
		mntmCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		mnEdit.add(mntmCopy);
		
		JMenuItem mntmPaste = new JMenuItem(bundle.getString("gui.textcomponent.context.paste"));
		mntmPaste.setMnemonic(KeyEvent.VK_PASTE);
		mntmPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmDelete = new JMenuItem(bundle.getString("gui.textcomponent.context.delete"));
		mntmDelete.setMnemonic(KeyEvent.VK_DELETE);
		mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		mnEdit.add(mntmDelete);
		
		JMenu menu = new JMenu(bundle.getString("gui.menu.about"));
		menuBar.add(menu);
		
		JMenuItem mntmInformazioniSuCoedil = new JMenuItem(bundle.getString("gui.menu.about.information"));
		mntmInformazioniSuCoedil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JOptionPane.showMessageDialog(instance,
								bundle.getString("gui.dialog.information.text"),
								bundle.getString("gui.dialog.information.frameTitle"),
					    JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu.add(mntmInformazioniSuCoedil);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*
		 * *************************************************************************************
		 * BARRA DEGLI STRUMENTI
		 * *************************************************************************************
		 */
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
				
		btnToolBar btnNew = new btnToolBar("", new ImageIcon(Coedil99View.class.getResource(ICON_NEW)));
        btnNew.setPopupMenu(popNuovo);
        btnNew.setToolTipText(bundle.getString("gui.menu.file.new"));
        toolBar.add(btnNew);
		
		btnSave = new JButton("");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setToolTipText(bundle.getString("gui.menu.file.save"));
		btnSave.setIcon(new ImageIcon(Coedil99View.class.getResource("/coedil99/ui/img/save-icon.png")));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				((TabContent)tabbedPane.getSelectedComponent()).salva();
			}
		});
		this.btnSave.setEnabled(false);
		toolBar.add(btnSave);
		
		JButton btnPrint = new JButton("");
		btnPrint.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPrint.setEnabled(false);
		btnPrint.setIcon(new ImageIcon(Coedil99View.class.getResource("/coedil99/ui/img/print-icon.png")));
		btnPrint.setToolTipText(bundle.getString("gui.menu.file.print"));
		toolBar.add(btnPrint);
		
		/*
		 * *************************************************************************************
		 * BARRA DI STATO
		 * *************************************************************************************
		 */
		
		JPanel statusBar = new JPanel();
		contentPane.add(statusBar, BorderLayout.SOUTH);
		statusBar.setLayout(new BorderLayout(0, 0));
		
		lblStatusBar = new JLabel("Bar");
		lblStatusBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblStatusBar.setHorizontalTextPosition(SwingConstants.LEFT);
		lblStatusBar.setHorizontalAlignment(SwingConstants.LEFT);
		statusBar.add(lblStatusBar);
		
		JSeparator separator_1 = new JSeparator();
		statusBar.add(separator_1, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setAutoscrolls(true);
		splitPane.setContinuousLayout(true);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.setBorder(new EmptyBorder(10, 10, 10, 10) );

		splitPane.setRightComponent(tabbedPane);	
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setPreferredSize(new Dimension(300, 0));
		panel.setMinimumSize(new Dimension(250, 0));
		panel.setLayout(new BorderLayout(0, 0));
		Etichetta label = new Etichetta("ELENCO ITEMS");
		label.setMaximumSize(new Dimension(200,30));
		panel.add(label , BorderLayout.NORTH);
		element.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.add(new JScrollPane(element), BorderLayout.CENTER);
		this.element.setVisible(false);
		splitPane.setLeftComponent(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel.setEnabled(false);
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		addButton = new JButton();
		addButton.setIcon(new ImageIcon(Coedil99View.class.getResource(ICON_ARROW)));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					int index = element.getSelectedIndex();
					if( index >= 0){
						CtrlElaboraPreventivo.getInstance().addItemtoPreventivo(element.getSelectedValue());
					}
			}
		});
		panel_2.add(addButton);
		
		/*
		 * CODICE PER IL NAVIGATOR AD ALBERO
		 * 
		navigator = new ElencoItemsAlbero("Elenco Items");
		panel.add(navigator);
		
		navigator.setMinimumSize(new Dimension(MINIMUM_WIDTH_NAVIGATOR, MINIMUM_HEIGHT_NAVIGATOR));
		navigator.setVisible(true);*/
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
	    	String name = ((Item) value).getClass().getName().split("\\.")[2];
	    	String discriminatorLabel = "";
	    	String discriminator = "";
	    	switch(name){
	    	case "Trave":
	    		icon = ICON_TRAVE;
	    		discriminatorLabel = "Lunghezza";
	    		discriminator += ((Trave) (value)).getLunghezza();
	    		break;
	    	case "Bullone":
	    		icon = ICON_BULLONE;
	    		discriminatorLabel = "Diametro";
	    		discriminator +=((Bullone) (value)).getDiametro();
	    		break;
	    	case "Lastra":
	    		icon = ICON_LASTRA;
	    		discriminatorLabel = "Materiale";
	    		discriminator =((Lastra) (value)).getMateriale();
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
	        return p;
	    }
	}
}