package coedil99.Model;

import java.util.ArrayList;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.MagazzinoDAO;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.Item;
import coedil99.PersistentModel.Lastra;
import coedil99.PersistentModel.Magazzino;
import coedil99.PersistentModel.Preventivo;

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
		
		Magazzino magazzino = MagazzinoDAO.loadMagazzinoByQuery(null, null);
		int rows = magazzino.elementoMagazzino__List_.size();
		for (int r = 0; r < rows; r++) {
			Object [] objD = new Object[10];
			objD[0] = (Object) magazzino.elementoMagazzino__List_.get(r).getItem().getClass().getName().split("\\.")[2]; //prendo solo l'ultima parte del nome
			objD[1] = (Object) magazzino.elementoMagazzino__List_.get(r).getItem().getDescrizione();
			if (((Item) (magazzino.elementoMagazzino__List_.get(r)).getItem()).getClass().getName().equals("Lastra")) {
				objD[2] = (Object) ((Lastra) (magazzino.elementoMagazzino__List_.get(r)).getItem()).getMateriale();
			} else {
				objD[2] = "/";
			}
			objD[3] = (Object) magazzino.elementoMagazzino__List_.get(r).getItem().getPeso();
			if (((Item) (magazzino.elementoMagazzino__List_.get(r)).getItem()).getClass().getName().equals("Bullone")) {
				objD[4] = (Object) ((Bullone) (magazzino.elementoMagazzino__List_.get(r)).getItem()).getDiametro();
			} else {
				objD[4] = "/";
			}
			if (((Item) (magazzino.elementoMagazzino__List_.get(r)).getItem()).getClass().getName().equals("Trave")) {
				objD[5] = (Object) ((Trave) (magazzino.elementoMagazzino__List_.get(r)).getItem()).getLunghezza();
			} else {
				objD[5] = "/";
			}
			objD[6] = (Object) magazzino.elementoMagazzino__List_.get(r).getItem().getTipoSagoma();
			objD[7] = (Object) magazzino.elementoMagazzino__List_.get(r).getItem().getPrezzo();
			objD[8] = (Object) magazzino.elementoMagazzino__List_.get(r).getQuantita();
			objD[9] = (Object) magazzino.elementoMagazzino__List_.get(r).get_fornitore().getDitta();
			dati.add(objD);
		}
		return dati;
	}

}
