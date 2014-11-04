package coedil99.ui.content;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import coedil99.application.controller.CtrlGestisciRDA;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Trave;
import coedil99.ui.template.CampoTesto;
import coedil99.ui.template.Etichetta;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class OrdinePanel extends JPanel {

	private JList<ElementoRDA> elements;
	private final String ICON_LASTRA = "/coedil99/ui/img/lastra.png";
	private final String ICON_BULLONE = "/coedil99/ui/img/bullone.png";
	private final String ICON_TRAVE = "/coedil99/ui/img/trave.png";
	private JTextField consegnaPrevista;
	private JButton fornitoreButton;
	private JButton salvaButton;
	
	public OrdinePanel() {
		setLayout(new BorderLayout(0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel.add(verticalBox_1);
		
		this.fornitoreButton = new JButton("Aggiungi Fornitore");
		verticalBox_1.add(fornitoreButton);
		fornitoreButton.setMinimumSize(new Dimension(100, 9));
		fornitoreButton.setIcon(new ImageIcon(OrdinePanel.class.getResource("/coedil99/ui/img/add_cliente.png")));
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox_1.add(verticalBox);
		
		JLabel lblNewLabel = new Etichetta("CONSEGNA PREVISTA");
		verticalBox.add(lblNewLabel);
		
		consegnaPrevista = new CampoTesto();
		verticalBox.add(consegnaPrevista);
		consegnaPrevista.setColumns(10);
		fornitoreButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CtrlGestisciRDA.getInstance().listaFornitori();
			}
		});
		
		this.elements = new JList<ElementoRDA>(new DefaultListModel<ElementoRDA>());
		this.elements.setCellRenderer(new ListCellRenderer());
		elements.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		add(new JScrollPane(elements), BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 0));
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_1 = new JButton("Salva");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CtrlGestisciRDA.getInstance().salvaOrdine(getConsegnaPrevista());
			}
		});
		panel_1.add(btnNewButton_1, BorderLayout.EAST);
		
	
	}
	
	public void initFornitoreButton(){
		this.fornitoreButton.setText("Aggiungi Fornitore");
		this.fornitoreButton.setMinimumSize(new Dimension(100, 9));
		this.fornitoreButton.setEnabled(true);
		this.fornitoreButton.setIcon(new ImageIcon(OrdinePanel.class.getResource("/coedil99/ui/img/add_cliente.png")));
	}
	
	public void reset(){
		((DefaultListModel<ElementoRDA>)this.elements.getModel()).clear();
		this.consegnaPrevista.setText("");
		this.initFornitoreButton();
	}
	
	public void setElements(ElementoRDA [] listData){
		this.elements.setListData(listData);
	}
	
	public void addElement(ElementoRDA e){
		 ((DefaultListModel<ElementoRDA>)this.elements.getModel()).addElement(e);
	}
	
	public void setFornitore(Fornitore f){
		this.fornitoreButton.setText(f.getDitta());
		this.fornitoreButton.setIcon(new ImageIcon(OrdinePanel.class.getResource("/coedil99/ui/img/user_icon.png")));
		this.fornitoreButton.setEnabled(false);
	}
	
	public String getConsegnaPrevista(){
		return this.consegnaPrevista.getText();
	}
	
	
	public Object[] getElements(){
		return ((DefaultListModel<ElementoRDA>)this.elements.getModel()).toArray();
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
	        b.setFont(new Font("sansserif",Font.BOLD,14));
	        p.add(b, BorderLayout.EAST);
	        return p;
	    }
	}

}
