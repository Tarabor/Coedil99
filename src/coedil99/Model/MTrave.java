package coedil99.model;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.Lastra;
import coedil99.PersistentModel.LastraDAO;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.TraveDAO;

public class MTrave implements AModel {
	
	public APersistentModel model;

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