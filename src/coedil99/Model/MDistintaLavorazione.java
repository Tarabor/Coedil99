package coedil99.model;

import java.awt.EventQueue;
import java.util.List;
import java.util.Observable;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.ElementoDistinta;
import coedil99.factory.PricingStrategyFactory;
import coedil99.model.strategy.ITotaleStrategy;

public class MDistintaLavorazione extends Observable implements AModel {
	
	public APersistentModel model;

	public void totale() {
		DistintaLavorazione d = (DistintaLavorazione) this.getPersistentModel();
				Double totale = d.getTotale();
				for (int i = 0; i < d.elemento__List_.size(); i++) {
					ElementoDistinta el = d.elemento__List_.get(i);
					MElementoDistinta elem = new MElementoDistinta();
					elem.setPersistentModel(el);
					totale += elem.getSubTotale();
				}
				
				d.setTotale(totale);
	}

	public void calcolaPrezzo() {
		PricingStrategyFactory.getInstance().getBullonePercentDiscountStrategy().calcolaPrezzo(this);
		this.setChanged();
		DistintaLavorazione d = (DistintaLavorazione) this.getPersistentModel();
		notifyObservers(d.getTotale());
	}
	
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
}