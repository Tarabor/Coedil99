package coedil99.application.controller;

import coedil99.persistentmodel.Fornitore;

public interface Controller {
	public void apriFornitore(Fornitore f);
	public void nuovoFornitore(String codice, String telefono, String ditta);

}
