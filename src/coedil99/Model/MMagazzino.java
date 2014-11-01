package coedil99.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import coedil99.application.controller.CtrlGestisciRDA;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.ElementoMagazzino;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.ElementoRDADAO;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.RaccoglitoreRDA;
import coedil99.persistentmodel.Trave;

public class MMagazzino implements AModel,Observer {
	
	public APersistentModel model;

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
		ArrayList<Object[]> dati = new ArrayList<>();
		
		Magazzino magazzino = (Magazzino)this.getPersistentModel();
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
			for (int i = 0; i < ((MPreventivo)arg1).getDistinta().size(); i++) {
				for (int j = 0; j < magazzino.size(); j++) {
					if (distinta.get(i).getItem().getID() == magazzino.get(j).getItem().getID()){    // Cerca l'item dell'ElementoDistinta tra item degli ElemetoMagazzino (aggiungere controllo: se l'item nella distinta non si trova nel magazzino?)
						if (distinta.get(i).getNPezzi() <= magazzino.get(j).getQuantita()){          // Sei il numero di pezzi richiesto nel preventivo lo riesco a coprire con quello che già ho, allora decremento la quantità in magazzino
							int quantita = magazzino.get(j).getQuantita() - distinta.get(i).getNPezzi();
							magazzino.get(j).setQuantita(quantita);
						}	
						else{ //Se la quantità richiesta è superiore alla giacenza in magazzino, aggiungi alla lista della RDA
							ElementoRDA elemento = new ElementoRDA();
							elemento.setItem(distinta.get(i).getItem());
							elemento.setQuantita(distinta.get(i).getNPezzi());
							rda.add(elemento);
						}
					}
				}	
			}	
			MRaccoglitoreRDA.getInstance().insertRDA(rda);
		} 	
	}

	
}
