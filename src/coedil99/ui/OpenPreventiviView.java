package coedil99.ui;

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


import coedil99.persistentmodel.Preventivo;
import coedil99.ui.template.Etichetta;
import coedil99.application.controller.CtrlElaboraPreventivo;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;


public class OpenPreventiviView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<Preventivo> element;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private final String ICON_DOC = "/coedil99/ui/img/document_icon.png";
	
	public OpenPreventiviView() {
		super();
		this.init();
		this.initGui();
	}
	
	
	public void setElements(Preventivo[] listData){
		this.element.setListData(listData);
	}
	
	private void init(){
		this.element = new JList<Preventivo>();
		this.element.setCellRenderer(new ListCellRenderer());
	}
	
	private void initGui(){
		setAlwaysOnTop (true);
		setMinimumSize(new Dimension(600, 400));
		setPreferredSize(new Dimension(700, 400));
		setTitle("Apri...");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OpenPreventiviView.class.getResource(ICON_FRAME)));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel = new Etichetta("Seleziona l'elemento da aprire...");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		//this.element.setPreferredSize(new Dimension(500, 200));
		this.element.setMinimumSize(new Dimension(500, 200));
		
		
		this.element.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		this.element.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		this.element.setVisibleRowCount(-1);
		this.element.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                	CtrlElaboraPreventivo.getInstance().apriPreventivo(element.getSelectedValue());
                }
            }
        });
		panel_1.add(new JScrollPane(element));
	
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JButton btnNewButton = new JButton("Apri");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CtrlElaboraPreventivo.getInstance().apriPreventivo(element.getSelectedValue());
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
	
	private class ListCellRenderer extends DefaultListCellRenderer {
		/**
		 * 
		 */
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
	    	
	        label.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(OpenPreventiviView.class.getResource(ICON_DOC))));
	        label.setText("<html>"+((Preventivo) value).getID() +
	        		"<br><p style='color:gray'>Cliente:"+
	        		((Preventivo) value).getCliente().getCognome()+
	        		" "+
	        		((Preventivo) value).getCliente().getNome()+
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
