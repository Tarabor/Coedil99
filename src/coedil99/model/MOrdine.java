package coedil99.model;

import java.util.Date;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.Ordine;
import coedil99.persistentmodel.OrdineDAO;
import coedil99.utility.Service;

public class MOrdine implements AModel {
	private APersistentModel model;
	
	public MOrdine(){
		this.model = OrdineDAO.createOrdine();
	}

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public void salva(String consegnaPrevista) {
		Ordine o = ((Ordine) this.model);
		o.setDataConsegnaPrevista(Service.getDatadb(consegnaPrevista));
		OrdineDAO.save(o);
	}

	public void setFornitore(Fornitore f) {
		((Ordine) this.model).setFornitore(f);
	}

	public void aggiungiElemento(ElementoRDA value) {
		((Ordine) this.model).elementoRDAs.add(value);
		
	}
}