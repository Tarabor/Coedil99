package coedil99.model;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.NonEvasoState;

public class MNonEvasoState implements AModel {
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public void setEvaso(boolean evaso) {
		NonEvasoState s = (NonEvasoState) this.getPersistentModel();
		s.setEvaso(evaso);
	}
}