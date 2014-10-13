package coedil99.ui.content;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import coedil99.application.Controller.CtrlGestisciFornitori;
import coedil99.ui.template.CampoTesto;
import coedil99.ui.template.Etichetta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class newFornitore extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	
	private CampoTesto textField_1;
	private CampoTesto textField_2;
	private CampoTesto textField;
	public newFornitore() {
		setMinimumSize(new Dimension(500, 250));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		setTitle("Inserisci i dati relativi al Fornitore");
		gridBagLayout.columnWidths = new int[]{222, 231, 84, 86, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 20, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		Etichetta lblCodiceFornitore = new Etichetta("CODICE FORNITORE:");
		GridBagConstraints gbc_lblCodiceFornitore = new GridBagConstraints();
		gbc_lblCodiceFornitore.anchor = GridBagConstraints.EAST;
		gbc_lblCodiceFornitore.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodiceFornitore.gridx = 0;
		gbc_lblCodiceFornitore.gridy = 2;
		getContentPane().add(lblCodiceFornitore, gbc_lblCodiceFornitore);
		
		textField_1 = new CampoTesto();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		Etichetta lblNomeDitta = new Etichetta("NOME DITTA:");
		GridBagConstraints gbc_lblNomeDitta = new GridBagConstraints();
		gbc_lblNomeDitta.anchor = GridBagConstraints.EAST;
		gbc_lblNomeDitta.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDitta.gridx = 0;
		gbc_lblNomeDitta.gridy = 3;
		getContentPane().add(lblNomeDitta, gbc_lblNomeDitta);
		
		textField_2 = new CampoTesto();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		Etichetta lblNumeroDiTelefono = new Etichetta("NUMERO DI TELEFONO:");
		GridBagConstraints gbc_lblNumeroDiTelefono = new GridBagConstraints();
		gbc_lblNumeroDiTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblNumeroDiTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumeroDiTelefono.gridx = 0;
		gbc_lblNumeroDiTelefono.gridy = 4;
		getContentPane().add(lblNumeroDiTelefono, gbc_lblNumeroDiTelefono);
		
		textField = new CampoTesto();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 4;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnSalva = new JButton("Salva");
		btnSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Execute when button is pressed
            	salvaFornitore();
			}
		});
		GridBagConstraints gbc_btnSalva = new GridBagConstraints();
		gbc_btnSalva.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalva.gridx = 1;
		gbc_btnSalva.gridy = 6;
		getContentPane().add(btnSalva, gbc_btnSalva);
		
	}
	
	public void salvaFornitore() {
		String codiceF = this.textField_1.getText();
		String dittaF= this.textField_2.getText();
		String tel = this.textField.getText();
		
		CtrlGestisciFornitori.getInstance().salvaNuovoFornitore(codiceF, tel, dittaF);
		
	}

}
