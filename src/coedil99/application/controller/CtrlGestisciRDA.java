package coedil99.application.controller;

import java.util.ArrayList;
import java.util.HashMap;
import coedil99.persistentmodel.Item;


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
}
