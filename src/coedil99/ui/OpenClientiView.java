package coedil99.ui;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.Preventivo;
import coedil99.ui.content.TabContent;
import coedil99.ui.template.CampoTesto;
import coedil99.ui.template.Etichetta;
import coedil99.application.controller.CtrlElaboraPreventivo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;


public class OpenClientiView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Cliente> element;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_USER = "/coedil99/ui/img/user_icon.png";
	private final String ICON_ADD = "/coedil99/ui/img/add_cliente.png";
	
	
	public OpenClientiView() {
		super();
		this.init();
		this.initGui();
	}
	
	
	public void setElements(Cliente[] listData){
		this.element.setListData(listData);
	}
	
	private void init(){
		this.element = new JList<Cliente>();
		this.element.setCellRenderer(new ListCellRenderer());
	}
	
	private void initGui(){
		setMinimumSize(new Dimension(600, 400));
		setPreferredSize(new Dimension(700, 400));
		setTitle("Apri...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OpenClientiView.class.getResource(ICON_FRAME)));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new Etichetta("<html>Seleziona il cliente dalla lista<br> oppure <b>aggiungine</b> uno nuovo</html>");
		panel.add(lblNewLabel);
		
		JButton addCliente = new JButton("");
		addCliente.setIcon(new ImageIcon(OpenClientiView.class.getResource(ICON_ADD)));
		panel.add(addCliente);
		addCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CtrlElaboraPreventivo.getInstance().nuovoClientePopUp();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		
	
		
		this.element.setMinimumSize(new Dimension(500, 200));
		
		
		this.element.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.element.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.element.setVisibleRowCount(-1);
		panel_1.add(new JScrollPane(this.element));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		this.element.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	apriCliente();
		        }
		    }
		});
		
		JButton btnNewButton = new JButton("Apri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apriCliente();
			}
		});
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel_4.add(btnNewButton_1);
	}
	
	private void apriCliente(){
		CtrlElaboraPreventivo.getInstance().apriCliente(element.getSelectedValue());
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
	    	
	        label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(OpenClientiView.class.getResource(ICON_USER))));
	        label.setText("<html>"+((Cliente) value).getCognome()+
	        		" "+
	        		((Cliente) value).getNome()+
	        		"<br><p style='color:gray'>"+
	        		" "+
	        		((Cliente) value).getCodiceFiscale()+
	        		" "+
	        		((Cliente) value).getIndirizzo()+
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