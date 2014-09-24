package coedil99.Model;

import java.awt.EventQueue;
import java.util.List;
import java.util.Observable;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.ElementoDistinta;
import coedil99.ui.content.TabContent;

public class MDistintaLavorazione extends Observable implements AModel, Runnable {
	
	public APersistentModel model;

	public void setDistintaLavorazione(List<String> listElementi) {
		throw new UnsupportedOperationException();
	}
	
	public void calcolaPrezzo() {
		Double totale;
		DistintaLavorazione d = (DistintaLavorazione) this.getPersistentModel();
		totale = new Double(d.getTotale());
		for (int i = 0; i < d.elemento__List_.size(); i++) {
			ElementoDistinta el = d.elemento__List_.get(i);
			totale += (el.getNPezzi() * el.getItem().getPrezzo());
		}
		this.run();
	}
	
	@Override
    public void run() {
        // Do work
        System.out.println("Thread in run: " + Thread.currentThread());
        this.setChanged();

        // Notify the observers on the EDT.
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread in invokeLater: " + Thread.currentThread());
                notifyObservers("Update!");
            }
        });
    }
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}
}