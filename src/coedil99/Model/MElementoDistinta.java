package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;

public class MElementoDistinta implements AModel {
	
	public APersistentModel model;
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public MElementoDistinta() {
		throw new UnsupportedOperationException();
	}

	public MElementoDistinta(int iD, String indicazione) {
		throw new UnsupportedOperationException();
	}
}