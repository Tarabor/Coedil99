package coedil99.application.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import coedil99.Model.MMagazzino;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.ElementoMagazzino;
import coedil99.PersistentModel.ElementoMagazzinoDAO;
import coedil99.PersistentModel.Fornitore;
import coedil99.PersistentModel.FornitoreDAO;
import coedil99.PersistentModel.Indirizzo;
import coedil99.PersistentModel.Item;
import coedil99.PersistentModel.ItemDAO;
import coedil99.PersistentModel.Lastra;
import coedil99.PersistentModel.LastraDAO;
import coedil99.PersistentModel.Magazzino;
import coedil99.PersistentModel.MagazzinoDAO;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.TraveDAO;
import coedil99.ui.Coedil99View;
import coedil99.ui.content.newItem;

public class CtrlGestisciMagazzino {

	private static CtrlGestisciMagazzino instance;
	private ElementoMagazzino em;
	
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

	public void createElementoMagazzino() {
		this.em = ElementoMagazzinoDAO.createElementoMagazzino();
		Coedil99View.getInstance().showNewItem();		
	}
	
	
	
	public void salvaNuovoItem(String tipoElemento, Integer tipoSagoma, String descrizione, String diametro, String materiale, String lunghezza, String peso, String prezzo, String fornitore) {
		//aggiungere variabile quantità per la funzione 
		if  ( tipoElemento.equals("Bullone") ) {
			Bullone b = new Bullone();
			b.setDescrizione(descrizione);
			b.setPeso(Integer.valueOf(peso));
			b.setPrezzo(Integer.valueOf(prezzo));
			b.setDiametro(Integer.valueOf(diametro));
			Bullone b1 = new Bullone();
			b1 = BulloneDAO.loadBulloneByQuery("diametro = " + diametro, "ID");
			if(b1 != null){
				if(ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID") == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(6);
				}
				else{                                                                                         //se esiste l'item e l'elemento magazzino aggiorna la quantità
					//incremento quantità em già esistente
					em = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
					em.setQuantita(66);
					//ElementoMagazzinoDAO.save(e);
					//Iterator i = ElementoMagazzinoDAO.iterateElementoMagazzinoByQuery("item = " + b1, "ID"); //Iteratore agli elementi del magazzino
					//((ElementoMagazzino)i.next()).getItem().equals(b1); // elemento corrente
					
				}
			}
			else{
				BulloneDAO.save(b);
				em.setItem(b);
				em.setQuantita(7);
			}	
		}
		else if  ( tipoElemento.equals("Lastra") ) {
			Lastra l = new Lastra();
			l.setDescrizione(descrizione);
			l.setPeso(Integer.valueOf(peso));
			l.setPrezzo(Integer.valueOf(prezzo));
			l.setMateriale(materiale);
			l.setTipoSagoma(tipoSagoma);
			LastraDAO.save(l);	
			em.setItem(l);
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
		}
		//em.setQuantita(666);
		Coedil99View.getInstance().hideNewItem();
		
		Magazzino m = MagazzinoDAO.loadMagazzinoByORMID(1);
		m.elementoMagazzino__List_.add(em);
		MagazzinoDAO.save(m);
	}	
	
	
	
	public void apriFornitore(Fornitore fornitore) {
		if(fornitore != null){
			/* TO IMPLEMENT probabilmente l'implementazione sarà un po diversa
			 * MPreventivo mp = CtrlElaboraPreventivo.getInstance().getPreventivoCorrente();
			 *
			((Preventivo)mp.getPersistentModel()).setCliente(cliente);
			int indexPreventivo = CtrlElaboraPreventivo.getInstance().getIndexPreventivoCorrente();
			Coedil99View.getInstance().updatePreventivo(indexPreventivo, mp);
			*/
			this.em.set_fornitore(fornitore);
			Coedil99View.getInstance().updateFornitore(fornitore.getDitta());
			Coedil99View.getInstance().hideFornitori();
		}
	}
	
	
}
