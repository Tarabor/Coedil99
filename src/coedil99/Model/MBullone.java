package coedil99.model;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;

public class MBullone implements AModel {
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	public double getPrezzo() {
		Bullone t = (Bullone) this.getPersistentModel();
		return t.getPrezzo();
	}
	
	public void setPrezzo(double prezzo) {
		Bullone b = (Bullone) this.getPersistentModel();
		double newPrice = prezzo * 0.5;
		b.setPrezzo(newPrice);
		
	}
}