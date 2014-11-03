package coedil99.application.controller;

import java.util.ArrayList;
import java.util.HashMap;

import coedil99.model.MOrdine;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.ui.content.RdaView;
import coedil99.ui.content.OrdiniView;


public class CtrlGestisciRDA {
	
	
	private HashMap< Item , Integer > rda;
	private ArrayList<MOrdine> ordini = new ArrayList<MOrdine>();
	
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
	
	public void createLineRDA(String id, String tipoElemento, String diametro, String materiale, String lunghezza, int quantita) {
		Object[] obj = {id, tipoElemento,diametro,materiale,lunghezza,quantita};
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

	public void apriNuovaRDADirettore() {
		RdaView.getInstance().nuovaSchedaRda(this.loadItems());
		RdaView.getInstance().setVisible(true);
	}
	
	/*
	 * SEZIONE ORDINI
	 */
	public void apriOrdini() {

		OrdiniView.getInstance().setElements(MRaccoglitoreRDA.getInstance().getRDAArray());
		OrdiniView.getInstance().setVisible(true);
	}
	
	public void createOrdine(){
		this.ordini.add(new MOrdine());
	}
	
	public void closeOrdine(int index){
		this.ordini.remove(index);
	}
	
	public void inviaRda(ArrayList<Object[]> tableData) {
		MRaccoglitoreRDA.getInstance().creaPrincipaleRDA(tableData);
	}

	public void salvataRda() {
		RdaView.getInstance().setButtonSalvaInvisible();
		
	}
}