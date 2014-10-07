package coedil99.Model.strategy;

import coedil99.Model.MDistintaLavorazione;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.ElementoDistinta;

public class SogliaDiscountStrategy implements ITotaleStrategy {
	private int soglia;

	public int getSoglia() {
		return this.soglia;
	}

	public void setSoglia(int soglia) {
		this.soglia = soglia;
	}

	public void calcolaPrezzo(MDistintaLavorazione distinta) {
		DistintaLavorazione d = (DistintaLavorazione) distinta.getPersistentModel();
		Double totale = d.getTotale();
		int numPezzi = 0;
		for (int i = 0; i < d.elemento__List_.size(); i++) {
			ElementoDistinta el = d.elemento__List_.get(i);
			numPezzi += numPezzi + el.getNPezzi();
					
			}
			if (numPezzi >= soglia) {
				totale = totale - ( (totale /100) * 30);
			}
		d.setTotale(totale);
	}
}