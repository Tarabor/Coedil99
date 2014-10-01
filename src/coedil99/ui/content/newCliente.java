package coedil99.ui.content;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

import coedil99.PersistentModel.Indirizzo;
import coedil99.application.Controller.ctrlElaboraPreventivo;
import coedil99.application.Controller.ctrlGestisciClienti;
import coedil99.ui.Coedil99View;
import coedil99.ui.template.Etichetta;
import coedil99.ui.template.CampoTesto;

import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DropMode;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.mchange.v2.codegen.bean.IndirectingSerializableExtension;

import javax.swing.SpringLayout;

import java.awt.FlowLayout;
import java.awt.Toolkit;


public class newCliente extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CampoTesto campoTesto;
	private CampoTesto campoTesto_1;
	private CampoTesto campoTesto_2;
	private CampoTesto campoTesto_3;
	private CampoTesto campoTesto_4;
	private CampoTesto campoTesto_5;
	private CampoTesto campoTesto_6;
	

	/**
	 * Create the panel.
	 */
	public newCliente() {
		super();
		setIconImage(Toolkit.getDefaultToolkit().getImage(newCliente.class.getResource("/coedil99/ui/img/frame-icon.png")));
		setTitle("Aggiungi un nuovo cliente");
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
		
		Etichetta etichetta = new Etichetta("NOME");
		etichetta.setText("  NOME");
		etichetta.setHorizontalTextPosition(SwingConstants.LEFT);
		etichetta.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(etichetta, "2, 6, left, default");
		
		campoTesto = new CampoTesto();
		campoTesto.setColumns(10);
		campoTesto.setAlignmentX(0.0f);
		getContentPane().add(campoTesto, "6, 6, fill, default");
		
		Etichetta etichetta_1 = new Etichetta("COGNOME");
		etichetta_1.setText("  COGNOME");
		etichetta_1.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(etichetta_1, "2, 8");
		
		campoTesto_1 = new CampoTesto();
		campoTesto_1.setColumns(10);
		campoTesto_1.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_1, "6, 8, fill, default");
		
		Etichetta etichetta_2 = new Etichetta("INDIRIZZO");
		etichetta_2.setText("  INDIRIZZO");
		getContentPane().add(etichetta_2, "2, 10");
		
		campoTesto_2 = new CampoTesto();
		campoTesto_2.setColumns(10);
		campoTesto_2.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_2, "6, 10, fill, default");
		
		Etichetta etichetta_6 = new Etichetta("NUMERO");
		etichetta_6.setText("  NUMERO");
		getContentPane().add(etichetta_6, "2, 12");
		
		campoTesto_6 = new CampoTesto();
		campoTesto_6.setColumns(10);
		campoTesto_6.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_6, "6, 12, left, default");
		
		Etichetta etichetta_5 = new Etichetta("COMUNE");
		etichetta_5.setText("  COMUNE");
		etichetta_5.setHorizontalTextPosition(SwingConstants.LEFT);
		etichetta_5.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(etichetta_5, "2, 14");
		
		campoTesto_5 = new CampoTesto();
		campoTesto_5.setColumns(10);
		campoTesto_5.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_5, "6, 14, fill, default");
		
		Etichetta etichetta_3 = new Etichetta("CODICE FISCALE");
		etichetta_3.setText("  CODICE FISCALE");
		etichetta_3.setHorizontalTextPosition(SwingConstants.LEFT);
		etichetta_3.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(etichetta_3, "2, 16");
		
		campoTesto_3 = new CampoTesto();
		campoTesto_3.setColumns(10);
		campoTesto_3.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_3, "6, 16, fill, default");
		
		Etichetta etichetta_4 = new Etichetta("PARTITA IVA");
		etichetta_4.setText("  PARTITA IVA");
		etichetta_4.setHorizontalTextPosition(SwingConstants.LEFT);
		etichetta_4.setHorizontalAlignment(SwingConstants.LEFT);
		getContentPane().add(etichetta_4, "2, 18");
		
		campoTesto_4 = new CampoTesto();
		campoTesto_4.setColumns(10);
		campoTesto_4.setAlignmentX(0.0f);
		getContentPane().add(campoTesto_4, "6, 18, fill, default");
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.setMaximumSize(new Dimension(50, 23));
		btnSalva.setMinimumSize(new Dimension(50, 23));
		btnSalva.setPreferredSize(new Dimension(150, 50));
		getContentPane().add(btnSalva, "6, 22, center, default");
		setAlwaysOnTop (true);
		//setBorder(new LineBorder(SystemColor.desktop));
		setMinimumSize(new Dimension(700, 350));
		setPreferredSize(new Dimension(800, 600));
		setBackground(Color.WHITE);
		
		btnSalva.addActionListener(new ActionListener() {
			 
	            public void actionPerformed(ActionEvent e)
	            {
	                //Execute when button is pressed
	            	salvaCliente();
	            }
	    });     
		
	}
	public void salvaCliente() {
		String nome = this.campoTesto.getText();
		String cognome = this.campoTesto_1.getText();
		String indirizzo = this.campoTesto_2.getText();
		String numero = this.campoTesto_6.getText();
		String comune = this.campoTesto_5.getText();
		String codiceFiscale = this.campoTesto_3.getText();
		String partitaIva = this.campoTesto_4.getText();
		
		
		ctrlGestisciClienti.getInstance().salvaNuovoCliente(nome, cognome, indirizzo, numero, comune, codiceFiscale, partitaIva);
	}
}