package coedil99.application.Controller;


import coedil99.Model.MPreventivo;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.Fornitore;
import coedil99.PersistentModel.FornitoreDAO;
import coedil99.PersistentModel.Preventivo;
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
	}	
	
	public void listaClienti() { //lista fornitori
		//Coedil99View.getInstance().showFornitori(FornitoreDAO.listFornitoreByQuery(null, null)); 
	}
	
	public void nuovoFornitorePopUp() { 
		//Coedil99View.getInstance().showNewFornitori(); TO IMPLEMENT
	}
	
	public void apriFornitore(Fornitore fornitore) {
		if(fornitore != null){
			/* TO IMPLEMENT probabilmente l'implementazione sarà un po diversa
			 * MPreventivo mp = CtrlElaboraPreventivo.getInstance().getPreventivoCorrente();
			 *
			((Preventivo)mp.getPersistentModel()).setCliente(cliente);
			int indexPreventivo = CtrlElaboraPreventivo.getInstance().getIndexPreventivoCorrente();
			Coedil99View.getInstance().updatePreventivo(indexPreventivo, mp);
			Coedil99View.getInstance().hideClienti();*/
		}
	}

}