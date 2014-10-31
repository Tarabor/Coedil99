package coedil99.model;

import java.util.HashMap;

import coedil99.persistentmodel.APersistentModel;
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
}