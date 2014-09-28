package coedil99.application.Controller;


import coedil99.Model.MBullone;
import coedil99.Model.MDistintaLavorazione;
import coedil99.Model.MLastra;
import coedil99.Model.MPreventivo;
import coedil99.Model.MTrave;
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
import coedil99.PersistentModel.Listino;
import coedil99.PersistentModel.ListinoDAO;
import coedil99.PersistentModel.Preventivo;
import coedil99.PersistentModel.PreventivoDAO;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.TraveDAO;
import coedil99.ui.Coedil99View;
import coedil99.ui.content.TabContent;
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
		
		/*  ci vuole un metodo di avviamento che carica il listino e setta tutti i prezzi degli item
		 *  con una map per tenere traccia del prezzo?
		Bullone b = BulloneDAO.createBullone();
		Trave t = TraveDAO.createTrave();
		Lastra l = LastraDAO.createLastra();
		
		MBullone bullone = new MBullone();
		MLastra lastra = new MLastra();
		MTrave trave = new MTrave();
		bullone.setPersistentModel(b);
		lastra.setPersistentModel(l);
		trave.setPersistentModel(t);
		
		bullone.setPrezzo(5); //perch� il setPrezzo del persistent model non pu� contenere logica e per come � fatta  
		lastra.setPrezzo(5);  //l'implementazione in MPreventivo non possiamo chiamare il setPrezzo del Model
		trave.setPrezzo(5);
		
		Listino listino = ListinoDAO.createListino();
		listino.item__List_.add(b);
		listino.item__List_.add(t);
		listino.item__List_.add(l);
		ListinoDAO.save(listino); */
		
		Preventivo p = PreventivoDAO.createPreventivo();
		p.setData(Service.getDatadb());
		this.apriPreventivo(p);
		Coedil99View.getInstance().setStatusBar("Nuovo preventivo creato");
	}
	
	public void salvaPreventivo( String data, String elemStrutt, String cartellino,boolean firmato, Object [][] distinta) {
		MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
		mp.setDistinta(distinta);
		Preventivo p = ((Preventivo)mp.getPersistentModel());
		Indirizzo address = p.getCliente().getIndirizzo();
		p.setDestinazioneMateriale(address);
		p.setElementoStrutturale(elemStrutt);
		int i = Integer.parseInt(cartellino);
		p.setCartellino(i);
		p.setFirmato(firmato);
		p.setNome(p.getCliente().getCognome()+" "+p.getData().getTime());
		p.setData(Service.getDatadb(data));
		ArrayList<ElementoDistinta> elementi = mp.getDistinta();
		//Listino listino = ListinoDAO.loadListinoByORMID(1);
		for (ElementoDistinta ed : elementi) {
			ItemDAO.save(ed.getItem());
		}
		DistintaLavorazione dl = ((Preventivo) mp.getPersistentModel()).getDistinta();
		MDistintaLavorazione dist = new MDistintaLavorazione();
		dist.setPersistentModel(dl);
		dist.calcolaPrezzo();
		//DistintaLavorazioneDAO.save(dl);
		PreventivoDAO.save(p);
		Coedil99View.getInstance().updatePreventivo(this.preventivi.indexOf(mp), mp);
		Coedil99View.getInstance().setStatusBar("Salvataggio effettuato");
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
	
	public void totalePreventivo(Object [][] distinta) {
		MPreventivo mp = this.preventivi.get(Coedil99View.getInstance().getCurrentPreventivo());
		mp.setDistinta(distinta);
		

		DistintaLavorazione dl = ((Preventivo) mp.getPersistentModel()).getDistinta();
		
		MDistintaLavorazione dist = new MDistintaLavorazione();
		dist.addObserver(TabContent.getInstance());
		dist.setPersistentModel(dl);
		dist.calcolaPrezzo();
		
	}
}