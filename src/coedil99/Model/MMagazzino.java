package coedil99.model;

import java.util.ArrayList;
import java.util.Iterator;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.ElementoMagazzino;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Magazzino;
import coedil99.persistentmodel.MagazzinoDAO;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.Trave;

public class MMagazzino implements AModel {
	
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

}
