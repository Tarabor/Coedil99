package coedil99.model;

import java.util.ArrayList;
import java.util.HashMap;

import coedil99.application.controller.CtrlGestisciRDA;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.ElementoRDADAO;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.RaccoglitoreRDA;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.RaccoglitoreRDADAO;

public class MRaccoglitoreRDA implements AModel {
	
	/** Rendiamo RaccoglitoreRDA Singleton */
	private static MRaccoglitoreRDA instance;
	
	public static MRaccoglitoreRDA getInstance(){
		if(instance == null)
			instance = new MRaccoglitoreRDA();
		
		return instance;
	}
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public void insertRDA( HashMap<Item, Integer> rda) {
		//((RaccoglitoreRDA)(this.getPersistentModel())).items__Map_.putAll(rda);
		RaccoglitoreRDADAO.save(((RaccoglitoreRDA)(this.getPersistentModel())));
	}

	public void creaPrincipaleRDA(ArrayList<Object[]> tableData) {
		//se decidiamo che esisterà un unico raccoglitore, questo dovrà essere creato una sola volta all'inizio
		RaccoglitoreRDA raccoglitore = RaccoglitoreRDADAO.loadRaccoglitoreRDAByORMID(1);
		this.setPersistentModel(raccoglitore);
		Item item;
		int quantita = 0;
		for (int i = 0; i < tableData.size(); i++) {
			ElementoRDA elemento = ElementoRDADAO.createElementoRDA(); //ogni volta deve essere creato un nuovo elemento, sennò salva solo il primo
			item = ItemDAO.loadItemByORMID(Integer.valueOf((String)tableData.get(i)[0]));
			quantita = (Integer) tableData.get(i)[5];
			elemento.setItem(item);
			elemento.setQuantita(quantita);
			((RaccoglitoreRDA) this.getPersistentModel()).elementoRDAs.add(elemento);
			RaccoglitoreRDADAO.save(((RaccoglitoreRDA)(this.getPersistentModel())));
		}
		CtrlGestisciRDA.getInstance().salvataRda();
	}
}