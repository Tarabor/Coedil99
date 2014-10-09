package coedil99.model;

import coedil99.persistentmodel.APersistentModel;

/**
 * Oggetto transiente Cliente, utilizzato per modellare il Business
 */
public class MCliente implements AModel {
	
	public APersistentModel model;
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
}