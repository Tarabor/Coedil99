package coedil99.ui.content;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListCellRenderer;
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

import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Trave;
import coedil99.ui.template.Etichetta;
import coedil99.application.controller.CtrlGestisciRDA;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;


public class PopupNewLineRDA extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Item> element;
	JSpinner spinner;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_LASTRA = "/coedil99/ui/img/lastra.png";
	private final String ICON_BULLONE = "/coedil99/ui/img/bullone.png";
	private final String ICON_TRAVE = "/coedil99/ui/img/trave.png";
	
	
	public PopupNewLineRDA() {
		super();
		this.init();
		this.initGui();
	}
	
	
	public void setElements(Item[] listData){
		this.element.setListData(listData);
	}
	
	private void init(){
		this.element = new JList<Item>();
		this.element.setCellRenderer(new ListCellRenderer());
	}
	
	private void initGui(){
		setMinimumSize(new Dimension(700, 400));
		setPreferredSize(new Dimension(800, 400));
		setTitle("Apri...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PopupNewLineRDA.class.getResource(ICON_FRAME)));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new Etichetta("<html>Seleziona l'elemento dalla lista</html>");
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
		panel.add(lblNewLabel);
		
		
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
		
		JLabel lblNewLabel_1 = new Etichetta("Elemento:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1.setText("Indica la quantit\u00E0 da inserire:");
		panel_3.add(lblNewLabel_1);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, null, 999, 1));
		spinner.setToolTipText("Inserisci la quantit\u00E0 da ordinare per l'elemento che hai selezionato");
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinner.setPreferredSize(new Dimension(50, 30));
		panel_3.add(spinner);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		this.element.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        if (evt.getClickCount() == 2) {
		        	aggiungiItem();
		        }
		    }
		});
		
		JButton btnNewButton = new JButton("Aggiungi");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aggiungiItem();
			}
		});
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Annulla");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel_4.add(btnNewButton_1);
	}
	
	
	public void aggiungiItem() {
		String id = String.valueOf(element.getSelectedValue().getID());
		String tipoElemento = (String)element.getSelectedValue().getClass().getName().split("\\.")[2];
		String lunghezza = "-";
		String materiale = "-";
		String diametro = "-";
		if(tipoElemento.equalsIgnoreCase("Trave")){
			lunghezza = String.valueOf( ((Trave) element.getSelectedValue()).getLunghezza() );
		} 
		if(tipoElemento.equalsIgnoreCase("Lastra")){
			materiale = ((Lastra) element.getSelectedValue()).getMateriale();
		} 
		if(tipoElemento.equalsIgnoreCase("Bullone")){
			diametro = String.valueOf( ((Bullone) element.getSelectedValue()).getDiametro() );
		} 
		int value = (Integer) spinner.getValue();
		CtrlGestisciRDA.getInstance().createLineRDA(id,tipoElemento, diametro, materiale, lunghezza, value);
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
	        label.setBorder(new EmptyBorder(3,6,3,50));
	    }
	    @Override
	    public Component getListCellRendererComponent(
	            JList<?> list,
	            Object value,
	            int index,
	            boolean selected,
	            boolean expanded) {
	    	
	    	if(((Item) value).getClass().getName().split("\\.")[2].equalsIgnoreCase("Trave")){
	    		label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(PopupNewLineRDA.class.getResource(ICON_TRAVE))));
	    		label.setText("<html>"+((Trave) value).getDescrizione()+
	    				"<br><p style='color:black'>"+"Lunghezza:"+
		        		"<span  style='color:gray'>"+" "+((Trave) value).getLunghezza()+
		        		"</p></p></html>");
			} 
	    	if(((Item) value).getClass().getName().split("\\.")[2].equalsIgnoreCase("Lastra")){
	    		label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(PopupNewLineRDA.class.getResource(ICON_LASTRA))));
	    		label.setText("<html>"+((Lastra) value).getDescrizione()+
	    				"<br>"+"Materiale:"+
		        		"<span  style='color:gray'>"+
		        		" "+
		        		((Lastra) value).getMateriale()+
		        		"</p></html>");
			} 
	    	if(((Item) value).getClass().getName().split("\\.")[2].equalsIgnoreCase("Bullone")){
	    		label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(PopupNewLineRDA.class.getResource(ICON_BULLONE))));
	    		label.setText("<html>"+((Bullone) value).getDescrizione()+
		        		"<br>"+"Diametro:"+
		        		"<span  style='color:gray'>"+
		        		" "+
		        		((Bullone) value).getDiametro()+
		        		"</p></html>");
			} 
	    	
	        

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