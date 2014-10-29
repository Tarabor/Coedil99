package coedil99.model;

import java.util.HashMap;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Item;

public class MRaccoglitoreRDA implements AModel {
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public void insertRDA( HashMap<Item, Integer> rda) {
		
	}
}