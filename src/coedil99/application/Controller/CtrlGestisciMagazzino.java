package coedil99.application.controller;

import java.util.ArrayList;

import coedil99.model.MMagazzino;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.BulloneDAO;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.ClienteDAO;
import coedil99.persistentmodel.ElementoMagazzino;
import coedil99.persistentmodel.ElementoMagazzinoDAO;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.FornitoreDAO;
import coedil99.persistentmodel.Indirizzo;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.LastraDAO;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.MagazzinoDAO;
import coedil99.persistentmodel.Trave;
import coedil99.persistentmodel.TraveDAO;
import coedil99.ui.Coedil99View;
import coedil99.ui.MagazzinoView;
import coedil99.ui.content.newItem;

public class CtrlGestisciMagazzino {

	private static CtrlGestisciMagazzino instance;
	private ElementoMagazzino em;
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
		MagazzinoView.getInstance().nuovaSchedaMagazzino(this.estraiDatiForView());
		MagazzinoView.getInstance().setVisible(true);
	}
	
	public ArrayList<Object[]> estraiDatiForView() {
		return magazzino.getElementiMagazzino();
	}
	
	public void createElementoMagazzino() {
		this.em = ElementoMagazzinoDAO.createElementoMagazzino();
		MagazzinoView.getInstance().showNewItem();		
	}
	
	
	
	public void salvaNuovoItem(String tipoElemento, Integer tipoSagoma, String descrizione, Float diametro, String materiale, Float lunghezza, Double peso, Double prezzo, int quantita) {
		
		if  ( tipoElemento.equals("Bullone") ) {
			Bullone b1 = BulloneDAO.loadBulloneByQuery("diametro = " + diametro, "ID");
			if(b1 != null){
				ElementoMagazzino em1 = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
				if(em1 == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(quantita);
					((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					em1.setQuantita(em1.getQuantita() + quantita);	
				}
			}
			else{
				Bullone b = new Bullone(); 
				b.setDescrizione(descrizione);
				b.setPeso(peso);
				b.setPrezzo(prezzo);
				b.setDiametro(diametro);
				BulloneDAO.save(b);
				em.setItem(b);
				em.setQuantita(quantita);
				((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
			}	
		}
		
		else if  ( tipoElemento.equals("Lastra") ) {
			Lastra b1 = LastraDAO.loadLastraByQuery("materiale = '" + materiale+"'", "ID");
			if(b1 != null){
				ElementoMagazzino em1 = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
				if(em1 == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(quantita);
					((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					em1.setQuantita(em1.getQuantita() + quantita);	
				}
			}
			else{	
				Lastra l = new Lastra();
				l.setDescrizione(descrizione);
				l.setPeso(peso);
				l.setPrezzo(prezzo);
				l.setTipoSagoma(tipoSagoma);
				l.setMateriale(materiale);
				LastraDAO.save(l);	
				em.setItem(l);
				em.setQuantita(quantita);
				((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
			}
		}
		else if  ( tipoElemento.equals("Trave") ){
			Trave b1 = TraveDAO.loadTraveByQuery("lunghezza = " + lunghezza, "ID");
			if(b1 != null){
				ElementoMagazzino em1 = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
				if(em1 == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(quantita);
					((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					em1.setQuantita(em1.getQuantita() + quantita);	
				}
			}
			else{	
				Trave t = new Trave();
				t.setDescrizione(descrizione);
				t.setPeso(peso);
				t.setPrezzo(prezzo);
				t.setLunghezza(lunghezza);
				t.setTipoSagoma(tipoSagoma);
				TraveDAO.save(t);	
				em.setItem(t);
				em.setQuantita(quantita);
				((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
			}
		}
		MagazzinoView.getInstance().hideNewItem();
		
		MagazzinoDAO.save((Magazzino)this.magazzino.getPersistentModel());
		MagazzinoView.getInstance().setMagazzino(this.estraiDatiForView());
	}	
	
	
	
	public void apriFornitore(Fornitore fornitore) {
		if(fornitore != null){
			this.em.set_fornitore(fornitore);
			MagazzinoView.getInstance().updateFornitore(fornitore.getDitta());
			MagazzinoView.getInstance().hideFornitori();
		}
	}
	
	
	
	/*++++++++++++++++ Gestione Fornitori ++++++++++++++++*/
	
	public void salvaNuovoFornitore(String codice, String telefono, String ditta) {	
		Fornitore f = new Fornitore();
		f.setCodice(codice);
		f.setTelefono(telefono);
		f.setDitta(ditta);
		FornitoreDAO.save(f);
		Coedil99View.getInstance().hideNewFornitori();
		MagazzinoView.getInstance().hideFornitori();
		CtrlGestisciMagazzino.getInstance().apriFornitore(f);	
	}
	
	public void listaFornitori() {
		MagazzinoView.getInstance().showFornitori(FornitoreDAO.listFornitoreByQuery(null, null)); 
	}
	
	public void nuovoFornitorePopUp() { 
		Coedil99View.getInstance().showNewFornitori();
	}
	
}
