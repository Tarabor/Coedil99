package coedil99.application.Controller;


import coedil99.model.MPreventivo;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.ClienteDAO;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.FornitoreDAO;
import coedil99.persistentmodel.Preventivo;
import coedil99.ui.Coedil99View;

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
		Coedil99View.getInstance().hideNewFornitori();
		Coedil99View.getInstance().hideFornitori();
		CtrlGestisciMagazzino.getInstance().apriFornitore(f);
		
	}	
	
	public void listaFornitori() {
		Coedil99View.getInstance().showFornitori(FornitoreDAO.listFornitoreByQuery(null, null)); 
	}
	
	public void nuovoFornitorePopUp() { 
		Coedil99View.getInstance().showNewFornitori();
	}
	
	

}