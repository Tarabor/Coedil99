package coedil99.application.Controller;


import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.Fornitore;
import coedil99.PersistentModel.FornitoreDAO;
import coedil99.PersistentModel.Preventivo;
import coedil99.model.MPreventivo;
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
		Coedil99View.getInstance().updateFornitore(f.getDitta());
	}	
	
	public void listaFornitori() {
		Coedil99View.getInstance().showFornitori(FornitoreDAO.listFornitoreByQuery(null, null)); 
	}
	
	public void nuovoFornitorePopUp() { 
		Coedil99View.getInstance().showNewFornitori();
	}
	
	

}