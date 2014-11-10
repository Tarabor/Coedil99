package coedil99.model;

import coedil99.persistentmodel.APersistentModel;

public class MElementoMagazzino implements AModel {
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

}
