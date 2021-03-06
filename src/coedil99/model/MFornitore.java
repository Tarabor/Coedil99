package coedil99.model;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.FornitoreDAO;

public class MFornitore implements AModel {
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	public void salvaNuovoFornitore(String codice, String telefono, String ditta) {	
		Fornitore f = new Fornitore();
		f.setCodice(codice);
		f.setTelefono(telefono);
		f.setDitta(ditta);
		this.model = f;
		FornitoreDAO.save(f);
	}
}