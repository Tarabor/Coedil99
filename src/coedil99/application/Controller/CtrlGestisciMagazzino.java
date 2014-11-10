package coedil99.application.controller;

import java.util.ArrayList;

import coedil99.model.MFornitore;
import coedil99.model.MMagazzino;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.FornitoreDAO;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.MagazzinoDAO;
import coedil99.ui.Coedil99View;
import coedil99.ui.MagazzinoView;

public class CtrlGestisciMagazzino implements CtrlFornitore{

	private static CtrlGestisciMagazzino instance;

	private MMagazzino magazzino;
	private int MAGAZZINO_N  = 0;
	
	public static CtrlGestisciMagazzino getInstance(){
		if(instance == null)
			instance = new CtrlGestisciMagazzino();
		
		return instance;
	}
	
	private CtrlGestisciMagazzino(){
		Magazzino m = MagazzinoDAO.loadMagazzinoByQuery("id <> " + MAGAZZINO_N, "ID");
		if(m == null) 
		{
			m = new Magazzino();
			MagazzinoDAO.save(m);
		}
		this.magazzino = new MMagazzino(m);
	}
	
	public MMagazzino getMagazzino(){
		return this.magazzino;
	}
	
/*++++++++++++++++ Gestione Magazzino ++++++++++++++++*/
	
	public void apriMagazzino() {
		MagazzinoView.getInstance().setMagazzino(this.estraiDatiForView());
		MagazzinoView.getInstance().setVisible(true);
	}
	
	public ArrayList<Object[]> estraiDatiForView() {
		return magazzino.getElementiMagazzino();
	}
	
	public void createElementoMagazzino() {
		this.magazzino.createElementoMagazzino();
		MagazzinoView.getInstance().showNewItem();		
	}
	
	
	public void salvaNuovoItem(String tipoElemento, Integer tipoSagoma, String descrizione, Float diametro, String materiale, Float lunghezza, Double peso, Double prezzo, int quantita) {
		this.magazzino.salvaElementoMagazzino(tipoElemento, tipoSagoma, descrizione, diametro, materiale, lunghezza, peso, prezzo, quantita);
	}	
	
	public void aggiornaMagazzino(){ //Aggiorna il magazzino dopo una aggiunta (richiamato da MMagazzino in salvaElementoMagazzino)
		MagazzinoView.getInstance().hideNewItem();
		MagazzinoView.getInstance().setMagazzino(this.estraiDatiForView());
		CtrlElaboraPreventivo.getInstance().setElementiItem();
	}
	
	
	public void apriFornitore(Fornitore fornitore) {
		this.magazzino.setFornitoreElemento(fornitore);
		MagazzinoView.getInstance().updateFornitore(fornitore.getDitta());
		MagazzinoView.getInstance().hideFornitori();
	}
	
	
	
	/*++++++++++++++++ Gestione Fornitori ++++++++++++++++*/
	
	public void nuovoFornitore(String codice, String telefono, String ditta) {	
		MFornitore f = new MFornitore();
		f.salvaNuovoFornitore(codice, telefono, ditta);	
		Coedil99View.getInstance().hideNewFornitori();
		this.apriFornitore((Fornitore)f.getPersistentModel());	
	}
	
	public void listaFornitori() {
		MagazzinoView.getInstance().showFornitori(FornitoreDAO.listFornitoreByQuery(null, null)); 
	}
	
	public void nuovoFornitorePopUp() { 
		Coedil99View.getInstance().showNewFornitori();
	}
	
}
