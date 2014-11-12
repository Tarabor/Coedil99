package coedil99.application.controller;


import coedil99.model.MPreventivo;
import coedil99.persistentmodel.Cliente;
import coedil99.persistentmodel.ClienteDAO;
import coedil99.persistentmodel.Indirizzo;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.PreventivoDAO;
import coedil99.ui.Coedil99View;
import coedil99.utility.Service;

import java.util.ArrayList;

public class CtrlElaboraPreventivo {
	
	/*
	 * Istance of CtrlElaboraPreventivo
	 */
	private static CtrlElaboraPreventivo instance;
	/*
	 * Array contenente i preventivi aperti
	 */

	private ArrayList<MPreventivo> preventivi;

	public CtrlElaboraPreventivo() {
		this.init();
	}

	private void init() {
		this.preventivi = new ArrayList<MPreventivo>();
	}
	
	public static CtrlElaboraPreventivo getInstance(){

		return ((instance == null) ? instance = new CtrlElaboraPreventivo() : instance);	


	}

	public void creaPreventivo() {
		Preventivo p = PreventivoDAO.createPreventivo();
		p.setData(Service.getDatadb());
		this.apriPreventivo(p);
		Coedil99View.getInstance().setStatusBar("Nuovo preventivo creato");
	}
	
	public void salvaPreventivo( String data, String elemStrutt, String cartellino,boolean firmato, Object [][] distinta) {
		MPreventivo mp = this.getPreventivoCorrente();
		mp.addObserver(CtrlGestisciMagazzino.getInstance().getMagazzino());
		Preventivo  p  = ((Preventivo)mp.getPersistentModel());	
		p.setDestinazioneMateriale(p.getCliente().getIndirizzo());
		p.setElementoStrutturale(elemStrutt);
		p.setCartellino(Integer.parseInt(cartellino));
		p.setFirmato(firmato);
		p.setNome(p.getCliente().getCognome()+" "+p.getData());
		mp.setDistinta(distinta);
		PreventivoDAO.save(p);
		Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().alertPreventivoSaved();
		Coedil99View.getInstance().setStatusBar("Salvataggio effettuato");
	}
	

	public void listaPreventivi() { 
		Coedil99View.getInstance().showPreventivi(PreventivoDAO.listPreventivoByQuery(null, null));
	}
	

	public void chiudiPreventivo(int index){
		this.preventivi.get(index).deleteObservers();
		this.preventivi.remove(index);
		Coedil99View.getInstance().decreaseTabCount();
		Coedil99View.getInstance().eliminaScheda(index);
		if(Coedil99View.getInstance().getNumberofPreventivo() == 0){
			Coedil99View.getInstance().setSaveVisible(false);
			Coedil99View.getInstance().setItemsNotVisible();
		}
	}

	public void apriPreventivo(Preventivo p) {
		MPreventivo mp = new MPreventivo(p);
		this.preventivi.add( mp );	
		Coedil99View.getInstance().nuovaScheda();
		this.setElementiItem();
		Coedil99View.getInstance().setItemsVisible();
		Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().hidePreventivi();
		if(Coedil99View.getInstance().getNumberofPreventivo() == 1){
			Coedil99View.getInstance().setSaveVisible(true);
		}	
		mp.addObserver(Coedil99View.getInstance().getObserver(this.preventivi.indexOf(mp)));
		Coedil99View.getInstance().setStatusBar("Preventivo disponibile");
	}

	public void setElementiItem() {
		if (!Coedil99View.getInstance().isItemsVisible()) {
			//Coedil99View.getInstance().setItemsVisible();
			Coedil99View.getInstance().setElements(ItemDAO.listItemByQuery(null, "discriminator"));
		}
	}
	
	public MPreventivo getPreventivoCorrente() {
		return this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
	}
	
	public int getIndexPreventivoCorrente() {
		MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
		return this.preventivi.indexOf(mp);
	}
	
	public void totalePreventivo(Object [][] distinta) {
		MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
		mp.setDistinta(distinta);
	}
	
	public void nuovoClientePopUp() { 
		Coedil99View.getInstance().showNewClienti();
	}
	
	public void salvaNuovoCliente(String nome, String cognome, String indirizzo, String numero, String comune, String codiceFiscale, String partitaIva) {
		Cliente c = new Cliente(nome,cognome,new Indirizzo(indirizzo,Integer.valueOf(numero),comune),codiceFiscale,partitaIva);
		ClienteDAO.save(c);
		this.apriCliente(c);		
		Coedil99View.getInstance().hideClienti();
	}	
	
	public void listaClienti() {
		Coedil99View.getInstance().showClienti(ClienteDAO.listClienteByQuery(null, null));
	}
	
	public void apriCliente(Cliente cliente) {
		if(cliente != null){
			MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
			((Preventivo)mp.getPersistentModel()).setCliente(cliente);
			Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
			Coedil99View.getInstance().hideClienti();
		}
	}

	public void addItemtoPreventivo(Item item) {
		if(this.preventivi.get(Coedil99View.getInstance().
				getCurrentPreventivo()).
				addItem(item)) {
			Coedil99View.getInstance().alertItemSelected();
		} else {
			Coedil99View.getInstance().
	    	getObserver(Coedil99View.getInstance().getCurrentPreventivo()).
	    	addRow(item.getORMID(),item.getClass().getName().split("\\.")[2]);
		}
	}

	public void removeElementoDistinta(int selectedRow) {
		this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo()).removeElementoDistinta(selectedRow);
		Coedil99View.getInstance().getObserver(Coedil99View.getInstance().getCurrentPreventivo()).removeRow(selectedRow);
		
	}	
}