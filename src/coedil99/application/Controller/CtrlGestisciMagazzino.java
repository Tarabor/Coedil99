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
	
	
	
	public void salvaNuovoItem(String tipoElemento, Integer tipoSagoma, String descrizione, String diametro, String materiale, String lunghezza, String peso, String prezzo) {
		
		if  ( tipoElemento.equals("Bullone") ) {
			Bullone b = new Bullone(); 
			b.setDescrizione(descrizione);
			b.setPeso(Integer.valueOf(peso));
			b.setPrezzo(Integer.valueOf(prezzo));
			b.setDiametro(Integer.valueOf(diametro));
			BulloneDAO.save(b);	
			em.setItem(b);
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
		//em.set_fornitore(f);
		em.setQuantita(666);
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
