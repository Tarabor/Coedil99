package coedil99.model.strategy;

import coedil99.model.MDistintaLavorazione;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.ElementoDistinta;

public class BullonePercentDiscountStrategy implements ITotaleStrategy {
	private int percentuale = 10;

	public int getPercentuale() {
		return this.percentuale;
	}

	public void setPercentuale(int percentuale) {
		this.percentuale = percentuale;
	}

	public void calcolaPrezzo(MDistintaLavorazione distinta) {
		DistintaLavorazione d = (DistintaLavorazione) distinta.getPersistentModel();
		Double totale = d.getTotale();
		for (int i = 0; i < d.elemento__List_.size(); i++) {
			ElementoDistinta el = d.elemento__List_.get(i);
			int numPezzi = el.getNPezzi();
			if (numPezzi >= 10) {
			totale = totale - ( (totale /100) * percentuale);
			}
		}
		d.setTotale(totale);
	}
}