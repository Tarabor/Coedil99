package coedil99.application.controller;

import java.util.ArrayList;
import coedil99.model.MOrdine;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.persistentmodel.Fornitore;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.OrdineDAO;
import coedil99.ui.content.RdaView;
import coedil99.ui.content.OrdiniView;


public class CtrlGestisciRDA implements Controller{
	

	private MOrdine newOrdine;
	
	private static CtrlGestisciRDA instance;
	
	public static CtrlGestisciRDA getInstance(){
		if(instance == null)
			instance = new CtrlGestisciRDA();
		
		return instance;
	}
	
	private CtrlGestisciRDA(){}
	
	
	public Item[] loadItems() {
		return ItemDAO.listItemByQuery(null, "discriminator");
		
	}
	
	public void createLineRDA(String id, String tipoElemento, String diametro, String materiale, String lunghezza, int quantita) {
		Object[] obj = {id, tipoElemento,diametro,materiale,lunghezza,quantita};
		RdaView.getInstance().aggiungiRiga(obj);
		RdaView.getInstance().hideMakeNewLineRda();
	}
	
	public void popupNewLineRda() {
		RdaView.getInstance().showMakeNewLineRda(this.loadItems());
	}


	public void apriNuovaRDADirettore() {
		RdaView.getInstance().nuovaSchedaRda();
		RdaView.getInstance().setVisible(true);
	}
	
	/*
	 * SEZIONE ORDINI
	 */
	public void apriOrdini() {
		OrdiniView.getInstance().setOrdini(OrdineDAO.listOrdineByQuery(null, null));
		OrdiniView.getInstance().setElements(MRaccoglitoreRDA.getInstance().getRDAArray());
		this.createOrdine();
		OrdiniView.getInstance().setVisible(true);
	}
	
	public void createOrdine(){
		this.newOrdine = new MOrdine();
	}
	
	public void apriFornitore(Fornitore f){
		this.newOrdine.setFornitore(f);
	}
	
	public void inviaRda(ArrayList<Object[]> tableData) {
		MRaccoglitoreRDA.getInstance().creaPrincipaleRDA(tableData);
	}

	public void salvataRda() {
		RdaView.getInstance().setButtonSalvaInvisible();
		RdaView.getInstance().dispose();
		RdaView.getInstance().revalidate();
		RdaView.getInstance().repaint();
	}

	public void salvaOrdine(String consegnaPrevista, Object[] elements) {
		this.newOrdine.salva(consegnaPrevista, elements);
		
	}
}