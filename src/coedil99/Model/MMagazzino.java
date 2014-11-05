package coedil99.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import coedil99.application.controller.CtrlGestisciMagazzino;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.BulloneDAO;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.ElementoMagazzino;
import coedil99.persistentmodel.ElementoMagazzinoDAO;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.LastraDAO;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.MagazzinoDAO;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.RaccoglitoreRDA;
import coedil99.persistentmodel.RaccoglitoreRDADAO;
import coedil99.persistentmodel.Trave;
import coedil99.persistentmodel.TraveDAO;

public class MMagazzino implements AModel,Observer {
	
	private static final int MAGAZZINO_N = 0;
	public APersistentModel model;
	private ElementoMagazzino em;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	public MMagazzino(){}
	
	public MMagazzino( Magazzino m ){
		this.setPersistentModel(m);
	}
	
	public ArrayList<Object[]> getElementiMagazzino() {
		ArrayList<Object[]> dati = new ArrayList<Object[]>();
		
		Magazzino magazzino = MagazzinoDAO.loadMagazzinoByQuery("id <> " + MAGAZZINO_N, "ID");
		this.model = magazzino;
		Iterator i = magazzino.elementoMagazzino__List_.getIterator();
		while(i.hasNext()){
			ElementoMagazzino e = (ElementoMagazzino)i.next();
			if(e!=null){
			Object [] objD = new Object[10];
			objD[0] = (Object) e.getItem().getClass().getName().split("\\.")[2]; //prendo solo l'ultima parte del nome
			objD[1] = (Object) e.getItem().getDescrizione();
			if (((Item) (e).getItem()).getClass().getName().split("\\.")[2].equals("Lastra")) {
				objD[2] = (Object) ((Lastra) (e).getItem()).getMateriale();
			} else {
				objD[2] = "/";
			}
			objD[3] = (Object) e.getItem().getPeso();
			if (((Item) (e).getItem()).getClass().getName().split("\\.")[2].equals("Bullone")) {
				objD[4] = (Object) ((Bullone) (e).getItem()).getDiametro();
			} else {
				objD[4] = "/";
			}
			if (((Item) (e).getItem()).getClass().getName().split("\\.")[2].equals("Trave")) {
				objD[5] = (Object) ((Trave) (e).getItem()).getLunghezza();
			} else {
				objD[5] = "/";
			}
			objD[6] = (Object) e.getItem().getTipoSagoma();
			objD[7] = (Object) e.getItem().getPrezzo();
			objD[8] = (Object) e.getQuantita();
			if((e.get_fornitore()) == null){
				objD[9] = "/";
				}
			else{
				objD[9] = (Object) e.get_fornitore().getDitta();
			}
			dati.add(objD);
			}
		}
		return dati;
	}

	
	@Override
	public void update(Observable arg0, Object arg1) {
		ArrayList<ElementoDistinta> distinta = ((MPreventivo)arg1).getDistinta();
		coedil99.persistentmodel.ElementoMagazzinoListCollection magazzino = ((Magazzino)this.getPersistentModel()).elementoMagazzino__List_;
		ArrayList<ElementoRDA> rda = new ArrayList<ElementoRDA>();
		
		if(((Preventivo)((MPreventivo)arg1).getPersistentModel()).getFirmato()){	
			RaccoglitoreRDA raccoglitore = RaccoglitoreRDADAO.loadRaccoglitoreRDAByORMID(1);
			for (int i = 0; i < ((MPreventivo)arg1).getDistinta().size(); i++) {
				for (int j = 0; j < magazzino.size(); j++) {
					if (distinta.get(i).getItem().getID() == magazzino.get(j).getItem().getID()){    // Cerca l'item dell'ElementoDistinta tra item degli ElemetoMagazzino (aggiungere controllo: se l'item nella distinta non si trova nel magazzino?)
						if (distinta.get(i).getNPezzi() <= magazzino.get(j).getQuantita()){          // Sei il numero di pezzi richiesto nel preventivo lo riesco a coprire con quello che già ho, allora decremento la quantità in magazzino
							
							if(MRaccoglitoreRDA.getInstance().checkElemento(raccoglitore, distinta.get(i).getItem())){//controlla se è già presente un'rda per lo stesso item (se si decremento x dal magazzino e aggiungo x alla quantità dell'elementoRDA)
								ElementoRDA elemento = new ElementoRDA();
								elemento.setItem(distinta.get(i).getItem());
								elemento.setQuantita(distinta.get(i).getNPezzi());
								rda.add(elemento);
							}
							int quantita = magazzino.get(j).getQuantita() - distinta.get(i).getNPezzi();
							magazzino.get(j).setQuantita(quantita);
						}	
						else{ //Se la quantità richiesta è superiore alla giacenza in magazzino, aggiungi alla lista della RDA
							ElementoRDA elemento = new ElementoRDA();
							elemento.setItem(distinta.get(i).getItem());
							elemento.setQuantita(distinta.get(i).getNPezzi() - magazzino.get(j).getQuantita());
							rda.add(elemento);
						}
					}
				}	
			}	
			MRaccoglitoreRDA.getInstance().insertRDA(rda);
		} 	
	}
	
	//salva o aggiorna un elemento del magazzino (e nel caso crea un nuovo item)
	public void salvaElementoMagazzino(String tipoElemento, Integer tipoSagoma, String descrizione, Float diametro, String materiale, Float lunghezza, Double peso, Double prezzo, int quantita){
		 //Prova, nel caso verrà fatto nel controller e passato come paramentro (se la creazione di em spetta al controller)
		if  ( tipoElemento.equals("Bullone") ) {
			Bullone b1 = BulloneDAO.loadBulloneByQuery("diametro = " + diametro, "ID");
			if(b1 != null){
				ElementoMagazzino em1 = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
				if(em1 == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(quantita);
					((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
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
				((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
			}	
		}
		
		else if  ( tipoElemento.equals("Lastra") ) {
			Lastra b1 = LastraDAO.loadLastraByQuery("materiale = '" + materiale+"'", "ID");
			if(b1 != null){
				ElementoMagazzino em1 = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
				if(em1 == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(quantita);
					((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
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
				((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
			}
		}
		else if  ( tipoElemento.equals("Trave") ){
			Trave b1 = TraveDAO.loadTraveByQuery("lunghezza = " + lunghezza, "ID");
			if(b1 != null){
				ElementoMagazzino em1 = ElementoMagazzinoDAO.loadElementoMagazzinoByQuery("item = " + b1, "ID");
				if(em1 == null){          //se esiste l'item ma non l'elemento magazzino, crea un nuovo elemento magazzino
					em.setItem(b1);
					em.setQuantita(quantita);
					((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
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
				((Magazzino)this.getPersistentModel()).elementoMagazzino__List_.add(em);
			}
		}
		
		MagazzinoDAO.save((Magazzino)this.getPersistentModel());
		CtrlGestisciMagazzino.getInstance().aggiornaMagazzino();
	}

	public void createElementoMagazzino() {
		this.em = ElementoMagazzinoDAO.createElementoMagazzino();
	}

	public void setFornitoreElemento(Fornitore fornitore) {
		if(fornitore != null){
			this.em.set_fornitore(fornitore);
		}
		
	}

}
