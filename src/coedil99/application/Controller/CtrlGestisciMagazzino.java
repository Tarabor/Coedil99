package coedil99.application.Controller;

import java.util.ArrayList;

import coedil99.model.MMagazzino;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.BulloneDAO;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.ClienteDAO;
import coedil99.persistentmodel.ElementoMagazzino;
import coedil99.persistentmodel.ElementoMagazzinoDAO;
import coedil99.persistentmodel.Fornitore;
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
	private MMagazzino magazzino = new MMagazzino(MagazzinoDAO.loadMagazzinoByORMID(1));
	
	public static CtrlGestisciMagazzino getInstance(){
		if(instance == null)
			instance = new CtrlGestisciMagazzino();
		
		return instance;
	}
	
/*++++++++++++++++ Gestione Magazzino ++++++++++++++++*/
	
	public void apriMagazzino() {
		//Coedil99View.getInstance().nuovaSchedaMagazzino(this.estraiDatiForView());
		//Coedil99View.getInstance().setStatusBar("Elenco Elementi in Magazzino");
		MagazzinoView.getInstance().nuovaSchedaMagazzino(this.estraiDatiForView());
		MagazzinoView.getInstance().setVisible(true);
	}
	
	public ArrayList<Object[]> estraiDatiForView() {
		return magazzino.getElementiMagazzino();
	}
	
	
	public void createElementoMagazzino() {
		this.em = ElementoMagazzinoDAO.createElementoMagazzino();
		Coedil99View.getInstance().showNewItem();		
	}
	
	
	
	public void salvaNuovoItem(String tipoElemento, Integer tipoSagoma, String descrizione, String diametro, String materiale, String lunghezza, String peso, String prezzo, int quantita) {
		
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
				b.setPeso(Integer.valueOf(peso));
				b.setPrezzo(Integer.valueOf(prezzo));
				b.setDiametro(Integer.valueOf(diametro));
				BulloneDAO.save(b);
				em.setItem(b);
				em.setQuantita(quantita);
				((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
			}	
		}
		
		else if  ( tipoElemento.equals("Lastra") ) {
			Lastra b1 = LastraDAO.loadLastraByQuery("materiale = " + materiale, "ID");
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
				l.setPeso(Integer.valueOf(peso));
				l.setPrezzo(Integer.valueOf(prezzo));
				l.setTipoSagoma(tipoSagoma);
				l.setMateriale(materiale);
				LastraDAO.save(l);	
				em.setItem(l);
				em.setQuantita(quantita);
				((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
			}
		}
		else{
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
				t.setPeso(Integer.valueOf(peso));
				t.setPrezzo(Integer.valueOf(prezzo));
				t.setLunghezza(Integer.valueOf(lunghezza));
				t.setTipoSagoma(tipoSagoma);
				TraveDAO.save(t);	
				em.setItem(t);
				em.setQuantita(quantita);
				((Magazzino)this.magazzino.getPersistentModel()).elementoMagazzino__List_.add(em);
			}
		}
		Coedil99View.getInstance().hideNewItem();
		
		MagazzinoDAO.save((Magazzino)this.magazzino.getPersistentModel());
		MagazzinoView.getInstance().setMagazzino(this.estraiDatiForView());
	}	
	
	
	
	public void apriFornitore(Fornitore fornitore) {
		if(fornitore != null){
			this.em.set_fornitore(fornitore);
			Coedil99View.getInstance().updateFornitore(fornitore.getDitta());
			Coedil99View.getInstance().hideFornitori();
		}
	}
	
	
}
