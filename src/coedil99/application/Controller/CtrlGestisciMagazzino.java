package coedil99.application.Controller;

import java.util.ArrayList;

import coedil99.Model.MMagazzino;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.ElementoMagazzino;
import coedil99.PersistentModel.ElementoMagazzinoDAO;
import coedil99.PersistentModel.Indirizzo;
import coedil99.PersistentModel.ItemDAO;
import coedil99.ui.Coedil99View;

public class CtrlGestisciMagazzino {

	private static CtrlGestisciMagazzino instance;
	
	public static CtrlGestisciMagazzino getInstance(){
		if(instance == null)
			instance = new CtrlGestisciMagazzino();
		
		return instance;
	}
	
/*++++++++++++++++ Gestione Magazzino ++++++++++++++++*/
	
	public void apriMagazzino() {
		Coedil99View.getInstance().nuovaSchedaMagazzino(this.estraiDatiForView());
		Coedil99View.getInstance().setStatusBar("Elenco Elementi in Magazzino");
	}
	
	public ArrayList<Object[]> estraiDatiForView() {
		ArrayList<Object[]> dati = new ArrayList<>();
		MMagazzino magazzino = new MMagazzino();
		dati = magazzino.getElementiMagazzino();
		return dati;
	}
	
	public void listaMagazzino() { 
		ArrayList<Object[]> dati = this.estraiDatiForView();
		Coedil99View.getInstance().showElementiMagazzino(dati);
	}

	public void addItem() {
		Coedil99View.getInstance().showNewItem();
		
	}
	
	
	/*
	
	public void salvaNuovoItem(String nome, String cognome, String indirizzo, String numero, String comune, String codiceFiscale, String partitaIva) {
		Indirizzo i = new Indirizzo(); //setto prima l'indirizzo
		i.setVia(indirizzo);
		i.setComune(comune);
		i.setNumero(Integer.valueOf(numero)); 
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setIndirizzo(i);
		c.setCodiceFiscale(codiceFiscale);
		c.setPartitaIva(partitaIva);
		ClienteDAO.save(c);
		this.apriCliente(c);		
		Coedil99View.getInstance().hideClienti();
	}	
	*/
	
	
}
