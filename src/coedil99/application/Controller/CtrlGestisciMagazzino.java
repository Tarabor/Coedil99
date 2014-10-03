package coedil99.application.Controller;

import java.util.ArrayList;

import coedil99.Model.MMagazzino;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.ElementoMagazzino;
import coedil99.PersistentModel.ElementoMagazzinoDAO;
import coedil99.PersistentModel.Indirizzo;
import coedil99.PersistentModel.Item;
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
	
	
	
	public void salvaNuovoItem(String tipoElemento, Integer tipoSagoma, String descrizione, String diametro, String materiale, String lunghezza, String peso, String prezzo) {
		Bullone b = new Bullone(); //setto prima l'indirizzo
		b.setDescrizione(descrizione);
		b.setPeso(Integer.valueOf(peso));
		b.setPrezzo(Integer.valueOf(prezzo));
		b.setDiametro(Integer.valueOf(diametro));
		BulloneDAO.save(b);		
		Coedil99View.getInstance().hideNewItem();
	}	
	
	
	
}
