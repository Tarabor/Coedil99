package coedil99.model;

import java.awt.EventQueue;
import java.util.List;
import java.util.Observable;

import coedil99.factory.PricingStrategyFactory;
import coedil99.model.strategy.ITotaleStrategy;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.ElementoDistinta;

public class MDistintaLavorazione extends Observable implements AModel {
	
	public APersistentModel model;
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
	
	/*
	 * Calcolo Totale
	 */

	public void totale() {
		DistintaLavorazione d = (DistintaLavorazione) this.getPersistentModel();
		Double totale = d.getTotale();
		MElementoDistinta elem; 
				for (int i = 0; i < d.elemento__List_.size(); i++) {
					ElementoDistinta el = d.elemento__List_.get(i);
					elem = new MElementoDistinta();
					elem.setPersistentModel(el);
					totale += elem.getSubTotale();
				}			
		d.setTotale(totale);
	}

	
	public void calcolaPrezzo() {
		PricingStrategyFactory.getInstance().getBullonePercentDiscountStrategy().calcolaPrezzo(this);
	}
}