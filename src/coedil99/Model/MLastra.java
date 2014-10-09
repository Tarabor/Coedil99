package coedil99.model;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.BulloneDAO;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.LastraDAO;

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