package coedil99.application.Controller;


import coedil99.Model.MPreventivo;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.Preventivo;
import coedil99.PersistentModel.PreventivoDAO;
import coedil99.ui.Coedil99View;
import coedil99.utility.Service;

import java.util.ArrayList;

public class ctrlElaboraPreventivo {
	
	private ArrayList<MPreventivo> preventivi;

	public ctrlElaboraPreventivo() {
		this.init();
	}

	private void init() {
		this.preventivi = new ArrayList<MPreventivo>();
	}

	public void creaPreventivo() {	
		Preventivo p = PreventivoDAO.createPreventivo();
		p.setData(Service.getDatadb());
		this.apriPreventivo(p);
		Coedil99View.getInstance().setStatusBar("Nuovo preventivo creato");
	}
	
	public void salvaPreventivo( String data, String destMateriale, String elemStrutt, String cartellino,boolean firmato, Object [][] distinta) {
		MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
		mp.setDistinta(distinta);
		Preventivo p = ((Preventivo)mp.getPersistentModel());
		p.setDestinazioneMateriale(destMateriale);
		p.setElementoStrutturale(elemStrutt);
		int i = Integer.parseInt(cartellino);
		p.setCartellino(i);
		p.setFirmato(firmato);
		p.setNome(p.getCliente().getCognome()+" "+p.getData().getTime());
		p.setData(Service.getDatadb(data));
		PreventivoDAO.save(p);
		Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().setStatusBar("Salvataggio effettuato");
	}
	
	public void nuovoClientePopUp() { 
		Coedil99View.getInstance().showNewClienti();
	}
	
	public void salvaNuovoCliente(String nome, String cognome, String indirizzo, String codiceFiscale, String partitaIva) {
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCognome(cognome);
		c.setIndirizzo(indirizzo);
		c.setCodiceFiscale(codiceFiscale);
		c.setPartitaIva(partitaIva);
		ClienteDAO.save(c);
		this.apriCliente(c);		
		Coedil99View.getInstance().hideClienti();
	}	

	public void listaPreventivi() { 
		Coedil99View.getInstance().showPreventivi(PreventivoDAO.listPreventivoByQuery(null, null));
	}
	
	public void listaClienti() {
		Coedil99View.getInstance().showClienti(ClienteDAO.listClienteByQuery(null, null));
	}

	public void eliminaPreventivo(int index){
		
		this.preventivi.remove(index);
		Coedil99View.getInstance().decreaseTabCount();
		Coedil99View.getInstance().eliminaScheda(index);
		if(Coedil99View.getInstance().getNumberofPreventivo() == 0){
			Coedil99View.getInstance().setSaveVisible(false);
		}
	}

	public void apriPreventivo(Preventivo p) {
		MPreventivo mp = new MPreventivo(p);
		this.preventivi.add( mp );	
		Coedil99View.getInstance().nuovaScheda();
		Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().hidePreventivi();
		if(Coedil99View.getInstance().getNumberofPreventivo() == 1){
			Coedil99View.getInstance().setSaveVisible(true);
		}
		this.totalePreventivo();
		Coedil99View.getInstance().setStatusBar("Preventivo disponibile");
	}
	
	public void apriCliente(Cliente cliente) {
		if(cliente != null){
			MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
			((Preventivo)mp.getPersistentModel()).setCliente(cliente);
			Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
			Coedil99View.getInstance().hideClienti();
		}
	}
	
	public void totalePreventivo() {
		Coedil99View.getInstance().setTotale(
				this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo())
				.calcolaPrezzo());
		
	}
}