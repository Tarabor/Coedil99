package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.ElementoDistinta;

public class MElementoDistinta implements AModel {
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public double getSubTotale() {
		double totale = ( (ElementoDistinta) this.getPersistentModel()).getNPezzi() * ( (ElementoDistinta) this.getPersistentModel()).getItem().getPrezzo();
		return totale;
	}
}