package coedil99.application.Controller;


import coedil99.model.MBullone;
import coedil99.model.MDistintaLavorazione;
import coedil99.model.MLastra;
import coedil99.model.MPreventivo;
import coedil99.model.MTrave;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;
import coedil99.PersistentModel.Cliente;
import coedil99.PersistentModel.ClienteDAO;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.DistintaLavorazioneDAO;
import coedil99.PersistentModel.ElementoDistinta;
import coedil99.PersistentModel.Indirizzo;
import coedil99.PersistentModel.ItemDAO;
import coedil99.PersistentModel.Lastra;
import coedil99.PersistentModel.LastraDAO;
import coedil99.PersistentModel.Preventivo;
import coedil99.PersistentModel.PreventivoDAO;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.TraveDAO;





import coedil99.ui.Coedil99View;
import coedil99.ui.content.TabContent;
import coedil99.utility.Service;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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
		Preventivo  p  = ((Preventivo)mp.getPersistentModel());
		mp.setDistinta(distinta);

		p.setDestinazioneMateriale(p.getCliente().getIndirizzo());

		p.setElementoStrutturale(elemStrutt);
		p.setCartellino(Integer.parseInt(cartellino));

		p.setFirmato(firmato);
		p.setNome(p.getCliente().getCognome()+" "+p.getData());
		//p.setData(Service.getDatadb(data));
		ArrayList<ElementoDistinta> elementi = mp.getDistinta();
		for (ElementoDistinta ed : elementi) {
			ItemDAO.save(ed.getItem());
		}
		DistintaLavorazione dl = ((Preventivo) mp.getPersistentModel()).getDistinta();
		MDistintaLavorazione dist = new MDistintaLavorazione();
		dist.setPersistentModel(dl);
		dist.calcolaPrezzo();
		PreventivoDAO.save(p);
		Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().setStatusBar("Salvataggio effettuato");
	}
	

	public void listaPreventivi() { 
		Coedil99View.getInstance().showPreventivi(PreventivoDAO.listPreventivoByQuery(null, null));
	}
	

	public void chiudiPreventivo(int index){
		
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
		//Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().hidePreventivi();
		if(Coedil99View.getInstance().getNumberofPreventivo() == 1){
			Coedil99View.getInstance().setSaveVisible(true);
		}	
		mp.addObserver(Coedil99View.getInstance().getObserver(this.preventivi.indexOf(mp)));
		mp.notifyObservers(mp);

		Coedil99View.getInstance().setStatusBar("Preventivo disponibile");
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
		

		DistintaLavorazione dl = ((Preventivo) mp.getPersistentModel()).getDistinta();
		
		MDistintaLavorazione dist = new MDistintaLavorazione();
		dist.addObserver(Coedil99View.getInstance().getObserver(this.preventivi.indexOf(mp)));

		dist.setPersistentModel(dl);
		dist.calcolaPrezzo();
		
	}
	
	public void nuovoClientePopUp() { 
		Coedil99View.getInstance().showNewClienti();
	}
	
	public void salvaNuovoCliente(String nome, String cognome, String indirizzo, String numero, String comune, String codiceFiscale, String partitaIva) {
		Indirizzo i = new Indirizzo(indirizzo,Integer.valueOf(numero),comune);
		Cliente c = new Cliente(nome,cognome,i,codiceFiscale,partitaIva);










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







}