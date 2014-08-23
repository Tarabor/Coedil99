package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;

public abstract class AModel {
	public APersistentModel model;
	

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
}