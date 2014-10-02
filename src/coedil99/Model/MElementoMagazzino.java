package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;

public class MElementoMagazzino implements AModel {
	
	public APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

}
