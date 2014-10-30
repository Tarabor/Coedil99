package coedil99.application.controller;

import java.util.ArrayList;
import java.util.HashMap;

import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.ui.content.RdaView;
import coedil99.ui.content.OrdiniView;
import coedil99.utility.Service;


public class CtrlGestisciRDA {
	
	
	private HashMap< Item , Integer > rda;
	
	private static CtrlGestisciRDA instance;
	
	public static CtrlGestisciRDA getInstance(){
		if(instance == null)
			instance = new CtrlGestisciRDA();
		
		return instance;
	}
	
	/*
	 * Creazione RDA 
	 */
	public void creaRDA(){
		this.rda = new HashMap<Item , Integer >();
	}
	
	/*
	 * Metodo che restituisce Il contenuto di raccoglitore
	 */
	public ArrayList<Item> getListaRDA(){
		
		return null;
	}
	
	
	public Item[] loadItems() {
		return ItemDAO.listItemByQuery(null, "discriminator");
		
	}
	
	public void createLineRDA(String tipoElemento, Float diametro, String materiale, Float lunghezza, int quantita) {
		Object[] obj = {tipoElemento,diametro,materiale,lunghezza,quantita};
		RdaView.getInstance().aggiungiRiga(obj);
		RdaView.getInstance().hideMakeNewLineRda();
	}
	
	public void popupNewLineRda() {
		RdaView.getInstance().showMakeNewLineRda();
	}

	public void apriRDA() {
		RdaView.getInstance().nuovaSchedaRda(this.loadItems());
		RdaView.getInstance().setVisible(true);
	}

	
	/*
	 * SEZIONE ORDINI
	 */
	public void apriOrdini() {
		OrdiniView.getInstance().setVisible(true);
	}
}
