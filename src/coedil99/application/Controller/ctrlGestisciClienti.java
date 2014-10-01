package coedil99.application.Controller;



import coedil99.Model.MPreventivo;
import coedil99.PersistentModel.Preventivo;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.Indirizzo;
import coedil99.ui.Coedil99View;
import coedil99.ui.content.TabContent;
import coedil99.utility.Service;

import java.util.ArrayList;

public class ctrlGestisciClienti {
	
	private static ctrlGestisciClienti instance;
	
	public static ctrlGestisciClienti getInstance(){
		if(instance == null)
			instance = new ctrlGestisciClienti();
		
		return instance;
	}

	public void nuovoClientePopUp() { 
		Coedil99View.getInstance().showNewClienti();
	}
	
	public void salvaNuovoCliente(String nome, String cognome, String indirizzo, String numero, String comune, String codiceFiscale, String partitaIva) {
		Indirizzo i = new Indirizzo(); //setto prima l'indirizzo
		i.setVia(indirizzo);
		i.setComune(comune);
		i.setNumero(Integer.valueOf(numero)); 
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setIndirizzo(i);
		c.setCodiceFiscale(codiceFiscale);
		c.setPartitaIva(partitaIva);
		ClienteDAO.save(c);
		this.apriCliente(c);		
		Coedil99View.getInstance().hideClienti();
	}	
	
	public void listaClienti() {
		Coedil99View.getInstance().showClienti(ClienteDAO.listClienteByQuery(null, null));
	}
	
	public void apriCliente(Cliente cliente) {
		if(cliente != null){
			MPreventivo mp = ctrlElaboraPreventivo.getInstance().getPreventivoCorrente();
			((Preventivo)mp.getPersistentModel()).setCliente(cliente);
			int indexPreventivo = ctrlElaboraPreventivo.getInstance().getIndexPreventivoCorrente();
			Coedil99View.getInstance().updatePreventivo(indexPreventivo, mp);
			Coedil99View.getInstance().hideClienti();
		}
	}

}