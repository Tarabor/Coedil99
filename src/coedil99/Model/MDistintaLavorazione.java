package coedil99.Model;

import java.util.List;
import java.util.Observable;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.ElementoDistinta;
import coedil99.ui.content.TabContent;

public class MDistintaLavorazione extends Observable implements AModel {
	
	public APersistentModel model;

	public void setDistintaLavorazione(List<String> listElementi) {
		throw new UnsupportedOperationException();
	}
	
	public void calcolaPrezzo() {
		Double totale = 0.0;
		DistintaLavorazione d = (DistintaLavorazione) this.getPersistentModel();
		for (int i = 0; i < d.elemento__List_.size(); i++) {
			ElementoDistinta el = d.elemento__List_.get(i);
			totale += (el.getNPezzi() * el.getItem().getPrezzo());
		}
		this.setChanged();
		this.notifyObservers(totale);
	}
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
}