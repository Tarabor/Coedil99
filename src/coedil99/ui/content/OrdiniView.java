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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;


import coedil99.persistentmodel.Item;
import coedil99.ui.template.CampoTesto;
import coedil99.ui.template.Etichetta;

public class OrdiniView extends JFrame {

	private JPanel contentPane;
	private static OrdiniView instance;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_USER = "/coedil99/ui/img/user_icon.png";
	
	private JList<Item> element;


	/**
	 * Create the frame.
	 */
	public OrdiniView() {
		super();
		this.init();
		this.initGui();
	}
	
	private void init(){
		this.element = new JList<Item>();
		this.element.setCellRenderer(new ListCellRenderer());
	}
	
	
	private void initGui() {
		setTitle("Gestione Ordini");
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RdaView.class.getResource(ICON_FRAME)));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		splitPane.setLeftComponent(this.element);
	}


	public static OrdiniView getInstance(){
		if(instance == null)
			instance = new OrdiniView();
		
		return instance;
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
	    	
	        label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(OrdiniView.class.getResource(ICON_USER))));
	        label.setText("<html>"+((Item) value).getDescrizione()+
	        		"<br><p style='color:gray'>"+
	        		" "+
	        		((Item) value).getPeso()+
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