package coedil99.model;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Trave;

public class MTrave implements AModel {
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	public double getPrezzo() {
		Trave t = (Trave) this.getPersistentModel();
		return t.getPrezzo();
	}
	
	public void setPrezzo(double prezzo) {
		Trave t = (Trave) this.getPersistentModel();
		double newPrice = prezzo * 3;
		t.setPrezzo(newPrice);
		
	}
}