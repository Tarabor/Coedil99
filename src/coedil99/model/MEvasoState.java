package coedil99.model;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.EvasoStateDAO;


public class MEvasoState implements AModel {
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public void setEvaso(boolean evaso) {
		EvasoState s = (EvasoState) this.getPersistentModel();
		s.setEvaso(evaso);
	}
}