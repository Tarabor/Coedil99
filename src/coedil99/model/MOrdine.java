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

	public void salva(String consegnaPrevista, Object[] elements) {
		Ordine o = ((Ordine) this.model);
		for(int i=0; i<elements.length; i++)
			o.elementoRDAs.add(i, (ElementoRDA)elements[i]);
		o.setDataConsegnaPrevista(Service.getDatadb(consegnaPrevista));
		OrdineDAO.save(o);
	}

	public void setFornitore(Fornitore f) {
		((Ordine) this.model).setFornitore(f);
	}
}