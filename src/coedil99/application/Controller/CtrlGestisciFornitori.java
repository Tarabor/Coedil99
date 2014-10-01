package coedil99.application.Controller;


import coedil99.PersistentModel.Fornitore;
import coedil99.PersistentModel.FornitoreDAO;

import java.util.ArrayList;

public class CtrlGestisciFornitori {
	
private static CtrlGestisciFornitori instance;
	
	public static CtrlGestisciFornitori getInstance(){
		if(instance == null)
			instance = new CtrlGestisciFornitori();
		
		return instance;
	}
	
	public void salvaNuovoFornitore(String codice, String telefono, String ditta) {
		
		Fornitore f = new Fornitore();
		f.setCodice(codice);
		f.setTelefono(telefono);
		f.setDitta(ditta);
		FornitoreDAO.save(f);
	}	

}