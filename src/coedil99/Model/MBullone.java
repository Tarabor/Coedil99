package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;

public class MBullone implements AModel {
	
	public APersistentModel model;

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