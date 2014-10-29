package coedil99.ui;

import java.awt.Font;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
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
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.Preventivo;
import coedil99.ui.content.OpenFornitoriView;
import coedil99.ui.content.TabContent;
import coedil99.ui.content.TabMagazzino;
import coedil99.ui.content.newCliente;
import coedil99.ui.content.newFornitore;
import coedil99.ui.template.Scheda;
import coedil99.ui.template.btnToolBar;
import coedil99.ui.template.ElencoItemsAlbero;


import coedil99.application.controller.CtrlElaboraPreventivo;
import coedil99.application.controller.CtrlGestisciMagazzino;


public class Coedil99View extends JFrame {

	private static final long serialVersionUID = 1L;
	

	private static Coedil99View instance;
	private OpenPreventiviView op;
	private OpenClientiView oc;
	private newCliente nc;
	private newFornitore nf;
	private ResourceBundle bundle;
	
	private JLabel lblStatusBar;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private int tab_count = 0;
	
	private JPopupMenu popNuovo;
	private JMenuItem mntmSalva;
	private JButton btnSave;
	
	private final int MINIMUM_WIDTH = 500;
	private final int MINIMUM_HEIGHT = 500;
	
	private final int MINIMUM_WIDTH_NAVIGATOR = 150;
	private final int MINIMUM_HEIGHT_NAVIGATOR = 150;

	private final String BUNDLE     = "coedil99.ui.languages.it";
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_NEW   = "/coedil99/ui/img/nuovo_icon.png";
	
	
	public Coedil99View(){		
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
	
	public void nuovaSchedaMagazzino(ArrayList<Object[]> datiMagazzino){     //togliere
		this.tabbedPane.addTab(bundle.getString("gui.tabcontent.magazzino"), new TabMagazzino(datiMagazzino));
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
	}
	
	public void setStatusBar(String stato) {
		lblStatusBar.setText(stato);
		System.out.println(stato);
	}
	
	public void setTotale(double totale) {
		((TabContent)this.tabbedPane.getSelectedComponent()).setTotale(totale);
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
		
		
		ElencoItemsAlbero navigator = new ElencoItemsAlbero("Navigator");
		
		navigator.setMinimumSize(new Dimension(MINIMUM_WIDTH_NAVIGATOR, MINIMUM_HEIGHT_NAVIGATOR));
		splitPane.setLeftComponent(navigator);
		navigator.setVisible(true);
	}
}