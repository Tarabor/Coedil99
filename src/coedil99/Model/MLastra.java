package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;
import coedil99.PersistentModel.Lastra;
import coedil99.PersistentModel.LastraDAO;

public class MLastra implements AModel {
	
	public APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	public double getPrezzo() {
		Lastra t = (Lastra) this.getPersistentModel();
		return t.getPrezzo();
	}
	
	public void setPrezzo(double prezzo) {
		Lastra t = (Lastra) this.getPersistentModel();
		double newPrice = prezzo * 2;
		t.setPrezzo(newPrice);
		
	}
}