package coedil99.ui.content;


import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import coedil99.application.controller.CtrlGestisciMagazzino;
import coedil99.ui.template.Etichetta;
import coedil99.ui.template.CampoTesto;
import coedil99.ui.template.ImageSelector;
import coedil99.ui.template.SelectItem;
import coedil99.utility.DoubleVerifier;
import coedil99.utility.FloatVerifier;
import coedil99.utility.IntegerVerifier;
import coedil99.utility.StrictInputVerifier;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;



public class newItem extends JFrame {
	
	/**
	 * 
	 */
	private static newItem instance;
	private static final long serialVersionUID = 1L;
	private CampoTesto campoTesto_2;
	private CampoTesto campoTesto_3;
	private CampoTesto campoTesto_4;
	private CampoTesto campoTesto_5;
	private CampoTesto campoTesto_6;
	private CampoTesto campoTesto_1;
	private CampoTesto campoTesto_7;
	private CampoTesto campoTesto_8;
	private SelectItem  comboBox;
	private ImageSelector comboBox_1;
	private Etichetta  tchtDiamentro;
	private Etichetta tchtTipoSagoma;
	private Etichetta tchtTipoElemento;
	private Etichetta tchtDescrizione;
	private Etichetta tchtMateriale;
	private Etichetta tchtLunghezza;
	private Etichetta tchtPeso;
	private Etichetta tchtPrezzo;
	private Etichetta tchtQuantita;
	private Etichetta tchtFornitore;
	

	/**
	 * Create the panel.
	 */
	public newItem() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(newItem.class.getResource("/coedil99/ui/img/frame-icon.png")));
		setTitle("Aggiungi un nuovo elemento");
		getContentPane().setPreferredSize(new Dimension(0, 20));
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("60px"),
				ColumnSpec.decode("left:127px"),
				ColumnSpec.decode("35px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("392px:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("86px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("46px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("172px"),},
			new RowSpec[] {
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		tchtTipoElemento = new Etichetta("TIPO ELEMENTO");
		tchtTipoElemento.setText("TIPO ELEMENTO");
		tchtTipoElemento.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtTipoElemento.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtTipoElemento, "2, 4, left, default");
		
		comboBox = new SelectItem();
		getContentPane().add(comboBox, "6, 4, fill, default");
		
		tchtTipoSagoma = new Etichetta("TIPO SAGOMA");
		tchtTipoSagoma.setText("TIPO SAGOMA");
		tchtTipoSagoma.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtTipoSagoma.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtTipoSagoma, "2, 6, left, default");
		
		comboBox_1 = new ImageSelector();
		getContentPane().add(comboBox_1, "6, 6, fill, default");
		
		
		tchtDescrizione = new Etichetta("DESCRIZIONE");
		tchtDescrizione.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtDescrizione.setText("DESCRIZIONE");
		tchtDescrizione.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtDescrizione, "2, 8, left, default");
		
		campoTesto_1 = new CampoTesto();
		campoTesto_1.setColumns(10);
		campoTesto_1.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_1, "6, 8, fill, default");
		campoTesto_1.setText("0");
		
		tchtDiamentro = new Etichetta("DIAMETRO");
		tchtDiamentro.setText("DIAMETRO");
		getContentPane().add(tchtDiamentro, "2, 10");
		tchtDiamentro.setVisible(false);
		
	 	 
		campoTesto_2 = new CampoTesto();
		campoTesto_2.setColumns(10);
		campoTesto_2.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_2, "6, 10, fill, default");
		campoTesto_2.setVisible(false);
		campoTesto_2.setText("0");
		campoTesto_2.setInputVerifier(new FloatVerifier("")); //Controllo sull'inserimento
		
		tchtMateriale = new Etichetta("MATERIALE");
		tchtMateriale.setText("MATERIALE");
		getContentPane().add(tchtMateriale, "2, 12");
		tchtMateriale.setVisible(false);  
		
		campoTesto_6 = new CampoTesto();
		campoTesto_6.setColumns(10);
		campoTesto_6.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_6, "6, 12, left, default");
		campoTesto_6.setVisible(false);
		campoTesto_6.setText("0");
		
		tchtLunghezza = new Etichetta("LUNGHEZZA");
		tchtLunghezza.setText("LUNGHEZZA");
		tchtLunghezza.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtLunghezza.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtLunghezza, "2, 14");
		
		campoTesto_5 = new CampoTesto();
		campoTesto_5.setColumns(10);
		campoTesto_5.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_5, "6, 14, fill, default");
		campoTesto_5.setText("0");
		campoTesto_5.setInputVerifier(new FloatVerifier("")); //Controllo sull'inserimento

		
		tchtPeso = new Etichetta("PESO");
		tchtPeso.setText("PESO");
		tchtPeso.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtPeso.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtPeso, "2, 16");
		
		campoTesto_3 = new CampoTesto();
		campoTesto_3.setColumns(10);
		campoTesto_3.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_3, "6, 16, fill, default");
		campoTesto_3.setText("0");
		campoTesto_3.setInputVerifier(new DoubleVerifier("")); //Controllo sull'inserimento
		
		tchtPrezzo = new Etichetta("PREZZO");
		tchtPrezzo.setText("PREZZO");
		tchtPrezzo.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtPrezzo.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtPrezzo, "2, 18");
		
		campoTesto_4 = new CampoTesto();
		campoTesto_4.setColumns(10);
		campoTesto_4.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_4, "6, 18, fill, default");
		campoTesto_4.setText("0");
		campoTesto_4.setInputVerifier(new DoubleVerifier("")); //Controllo sull'inserimento
		
		tchtQuantita = new Etichetta("QUANTITA'");
		tchtQuantita.setText("QUANTITA'");
		tchtQuantita.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtQuantita.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtQuantita, "2, 20");
		
		campoTesto_8 = new CampoTesto();
		campoTesto_8.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		campoTesto_8.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_8, "6, 20, fill, default");
		campoTesto_8.setColumns(10);
		campoTesto_8.setText("0");
		campoTesto_8.setInputVerifier(new IntegerVerifier("")); //Controllo sull'inserimento

		
		tchtFornitore = new Etichetta("FORNITORE");
		tchtFornitore.setText("FORNITORE");
		tchtFornitore.setHorizontalTextPosition(SwingConstants.LEFT);
		tchtFornitore.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(tchtFornitore, "2, 22");
		
		campoTesto_7 = new CampoTesto();
		campoTesto_7.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		campoTesto_7.setEditable(false);
		campoTesto_7.setText("0");
		campoTesto_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CtrlGestisciMagazzino.getInstance().listaFornitori();
			}
		});
		campoTesto_7.setColumns(10);
		campoTesto_7.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_7, "6, 22, fill, default");
		
		
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	 Object selected = comboBox.getSelectedItem();
		    	 if(selected.toString().equals("Trave")){
		    		 tchtDiamentro.setVisible(false);
		    	 	 campoTesto_2.setVisible(false);
		    	 	 campoTesto_2.setText("0");
		    	     tchtMateriale.setVisible(false);
		    	     campoTesto_6.setVisible(false);
		    	     campoTesto_6.setText("0");
		    	     tchtLunghezza.setVisible(true);
		    	     campoTesto_5.setVisible(true);
		    	     tchtTipoSagoma.setVisible(true);
		    	     comboBox_1.setVisible(true);
		    	     }
		    	 else if(selected.toString().equals("Bullone")){
		    		 tchtMateriale.setVisible(false);
		    	     campoTesto_6.setVisible(false);
		    	     campoTesto_6.setText("0");
		    	     tchtLunghezza.setVisible(false);
		    	     campoTesto_5.setVisible(false);
		    	     campoTesto_5.setText("0");
		    	     tchtDiamentro.setVisible(true);
		    	 	 campoTesto_2.setVisible(true);
		    	 	 tchtTipoSagoma.setVisible(false);
		    	     comboBox_1.setVisible(false);
		    	 }
		    	 else if(selected.toString().equals("Lastra")){
		    		 tchtDiamentro.setVisible(false);
		    	 	 campoTesto_2.setVisible(false);
		    	 	 campoTesto_2.setText("0");
		    	 	 tchtLunghezza.setVisible(false);
		    	     campoTesto_5.setVisible(false);
		    	     campoTesto_5.setText("0");
		    	     tchtMateriale.setVisible(true);
		    	     campoTesto_6.setVisible(true);
		    	     tchtTipoSagoma.setVisible(true);
		    	     comboBox_1.setVisible(true);
		    	 }
		    }
		});
		
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.setMaximumSize(new Dimension(50, 23));
		btnSalva.setMinimumSize(new Dimension(50, 23));
		btnSalva.setPreferredSize(new Dimension(150, 50));
		getContentPane().add(btnSalva, "6, 24, center, default");
		
		btnSalva.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	            	salvaItem();
	            }
	    });     

		//setBorder(new LineBorder(SystemColor.desktop));
		setMinimumSize(new Dimension(700, 450));
		setPreferredSize(new Dimension(800, 700));
		setBackground(Color.WHITE);		
	}
	
	
	public static newItem getInstance(){
		if(instance == null)
			instance = new newItem();
		return instance;
	}
	
	public void salvaItem() {
		String tipoElemento = (String)this.comboBox.getSelectedItem();
		Integer tipoSagoma = (Integer)this.comboBox_1.getSelectedItem();
		String descrizione = this.campoTesto_1.getText();
		Float diametro = Float.parseFloat(this.campoTesto_2.getText());
		String materiale = this.campoTesto_6.getText();
		Float lunghezza = Float.parseFloat(this.campoTesto_5.getText());
		Double peso = Double.parseDouble(this.campoTesto_3.getText());
		Double prezzo = Double.parseDouble(this.campoTesto_4.getText());
		int quantita = (Integer.parseInt(this.campoTesto_8.getText()));
		int idFornitore = (Integer.parseInt(this.campoTesto_7.getText()));
		
		
		CtrlGestisciMagazzino.getInstance().salvaNuovoItem(tipoElemento, tipoSagoma, descrizione, diametro, materiale, lunghezza, peso, prezzo, quantita, idFornitore);
	}
	
	public void updateFornitore(String d){
		this.campoTesto_7.setText(d);
	}
	
	public void clearForm(){
		this.comboBox.setSelectedIndex(0);
		this.comboBox_1.setSelectedIndex(0);
		this.campoTesto_1.setText("0");
		this.campoTesto_2.setText("0");
		this.campoTesto_3.setText("0");	
		this.campoTesto_4.setText("0");
		this.campoTesto_5.setText("0");
		this.campoTesto_6.setText("0");
		this.campoTesto_7.setText("0");
		this.campoTesto_8.setText("0");
	}
	
	
}