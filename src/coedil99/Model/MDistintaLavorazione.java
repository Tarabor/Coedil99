package coedil99.model;


import java.util.Observable;

import coedil99.factory.PricingStrategyFactory;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.ElementoDistintaDAO;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;

public class MDistintaLavorazione extends Observable implements AModel {
	
	private int ITEM_ID 	 		 = 0;
	private int ITEM	 	 		 = 1;
	private int INDICAZIONE_INDEX 	 = 2;
	private int N_PEZZI_INDEX 	     = 3;
	private int MISURADITAGLIO_INDEX = 4;
	
	private APersistentModel model;
	
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
		Double totale = 0.0;
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

	public void createElementoDistinta(Object [][] data) {
		ElementoDistinta e;
		
		for(int r = 0; r < data.length; r++){

			if(r >= ((DistintaLavorazione) this.getPersistentModel()).elemento__List_.size()) {
				e = ElementoDistintaDAO.createElementoDistinta();
				((DistintaLavorazione) this.getPersistentModel()).elemento__List_.add(e);
			}
			else
				e = ((DistintaLavorazione) this.getPersistentModel()).elemento__List_.get(r);
			Item i = ItemDAO.loadItemByORMID((int)data[r][ITEM_ID]);
			e.setIndicazione((String)data[r][INDICAZIONE_INDEX]);
			e.setNPezzi(Integer.parseInt(String.valueOf(data[r][N_PEZZI_INDEX])));
			e.setMisuraDiTaglio(Double.parseDouble(String.valueOf(data[r][MISURADITAGLIO_INDEX])));
			e.setItem(i);
		}
	}
}