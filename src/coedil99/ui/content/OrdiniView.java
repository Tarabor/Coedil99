package coedil99.ui.content;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;


import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.Item;
import coedil99.ui.template.Etichetta;
import javax.swing.border.LineBorder;

public class OrdiniView extends JFrame {

	private JPanel contentPane;
	private static OrdiniView instance;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_LASTRA = "/coedil99/ui/img/lastra.png";
	private final String ICON_BULLONE = "/coedil99/ui/img/bullone.png";
	private final String ICON_TRAVE = "/coedil99/ui/img/trave.png";
	private JPanel panel;
	private JList<ElementoRDA> element;
	
	private final String TITLE_FRAME  = "Gestione Ordini";


	/**
	 * Create the frame.
	 */
	public OrdiniView() {
		super();
		this.init();
		this.initGui();
	}
	
	private void init(){
		this.element = new JList<ElementoRDA>();
		element.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		this.element.setCellRenderer(new ListCellRenderer());
	}
	
	
	private void initGui() {
		setTitle(TITLE_FRAME);
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RdaView.class.getResource(ICON_FRAME)));
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
		lblCoedilSrl.setIcon(new ImageIcon(TabContent.class.getResource("/coedil99/ui/content/img/logo-scheda.png")));
		nord.add(lblCoedilSrl);
		contentPane.add(nord, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setRightComponent(new OrdinePanel());
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		panel.setMinimumSize(new Dimension(400, 0));
		panel.setLayout(new BorderLayout(0, 0));
		Etichetta rda_label = new Etichetta("RICHIESTE DI ACQUISTO");
		rda_label.setMaximumSize(new Dimension(200,30));
		panel.add(rda_label , BorderLayout.NORTH);
		panel.add(element, BorderLayout.CENTER);
		splitPane.setLeftComponent(panel);
	
	}


	public static OrdiniView getInstance(){
		if(instance == null)
			instance = new OrdiniView();
		
		return instance;
	}
	
	public void setElements(ElementoRDA [] listData){
		this.element.setListData(listData);
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
	            JList<?> list,
	            Object value,
	            int index,
	            boolean selected,
	            boolean expanded) {
	    	String icon = "";
	    	String name = ((ElementoRDA) value).getItem().getClass().getName().split("\\.")[2];
	    	switch(name){
	    	case "Trave":
	    		icon = ICON_TRAVE;
	    		break;
	    	case "Bullone":
	    		icon = ICON_BULLONE;
	    		break;
	    	case "Lastra":
	    		icon = ICON_LASTRA;
	    		break;
	    	}
	        label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(OrdiniView.class.getResource(icon))));
	        label.setText("<html>"+name+
	        		"<br><p style='color:gray'>"+
	        		" "+
	        		((ElementoRDA) value).getQuantita()+
	        		"</p></html>");

	        if (selected) {
	            label.setBackground(backgroundSelectionColor);
	            label.setForeground(textSelectionColor);
	        } else {
	            label.setBackground(backgroundNonSelectionColor);
	            label.setForeground(textNonSelectionColor);
	        }
	        return label;
	    }
	}
}