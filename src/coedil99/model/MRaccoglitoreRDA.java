package coedil99.model;

import java.util.ArrayList;

import coedil99.factory.CostantFactory;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.ElementoRDA;
import coedil99.persistentmodel.ElementoRDADAO;
import coedil99.persistentmodel.ElementoRDAListCollection;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.RaccoglitoreRDA;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.RaccoglitoreRDADAO;

public class MRaccoglitoreRDA implements AModel {
	
	private static MRaccoglitoreRDA instance;
	
	public static MRaccoglitoreRDA getInstance(){
		if(instance == null)
			instance = new MRaccoglitoreRDA();
		
		return instance;
	}
	
	private MRaccoglitoreRDA(){
		this.loadPersistentModel();
	}
	
	public void loadPersistentModel(){
		this.model = RaccoglitoreRDADAO.loadRaccoglitoreRDAByQuery("id = " + CostantFactory.RACCOGLITORE_1, "ID");
	}
	
	private APersistentModel model;

	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	/*
	 * Creazione delle RDA da parte del sistema
	 */
	public void insertRDA( ArrayList<ElementoRDA> rda) {
		if(rda.size() != 0){
			ElementoRDA elemento;
			for (int i = 0; i < rda.size(); i++) {
				elemento = rda.get(i);
				this.checkPresenzaElemento(elemento);
				RaccoglitoreRDADAO.save(((RaccoglitoreRDA)(this.getPersistentModel())));
			}
		}
	}
	
	/*
	 * Creazione delle RDA da parte del principale
	 */
	public void creaPrincipaleRDA(ArrayList<Object[]> tableData) {
		Item item;
		ElementoRDA elemento;
		int quantita = 0;
		for (int i = 0; i < tableData.size(); i++) {
			elemento = ElementoRDADAO.createElementoRDA(); 
			item = ItemDAO.loadItemByORMID(Integer.valueOf((String)tableData.get(i)[0]));
			quantita = (Integer) tableData.get(i)[5];
			elemento.setItem(item);
			elemento.setQuantita(quantita);
			this.checkPresenzaElemento(elemento);
			RaccoglitoreRDADAO.save(((RaccoglitoreRDA)(this.getPersistentModel())));
		}
	}

	public void checkPresenzaElemento(ElementoRDA elemento) {
		RaccoglitoreRDA raccoglitore = (RaccoglitoreRDA) this.getPersistentModel();
		if(raccoglitore.elementoRDAs.size() != 0) {
			Boolean trovato = false;
			for (int j = 0; j < raccoglitore.elementoRDAs.size(); j++) {
				ElementoRDA elemento2 = raccoglitore.elementoRDAs.get(j);
				if(elemento2.getItem().equals(elemento.getItem())) {
					elemento2.setQuantita(elemento2.getQuantita() + elemento.getQuantita());
					((RaccoglitoreRDA) this.getPersistentModel()).elementoRDAs.set(j,elemento2);
					trovato = true;
				} 
			}
			if(!trovato) {
				((RaccoglitoreRDA) this.getPersistentModel()).elementoRDAs.add(elemento);
			}
		}
		else {
			((RaccoglitoreRDA) this.getPersistentModel()).elementoRDAs.add(elemento);
		}
	}
	
	public boolean checkElemento(Item item) { //Lo uso nel magazzio. Dato un item controllo se esiste già un elementoRDA con associato questo item.
		RaccoglitoreRDA raccoglitore = (RaccoglitoreRDA) this.getPersistentModel();
		Boolean trovato = false;
		if(raccoglitore.elementoRDAs.size() != 0) {
			for (int j = 0; j < raccoglitore.elementoRDAs.size(); j++) {
				ElementoRDA elemento2 = raccoglitore.elementoRDAs.get(j);
				if(elemento2.getItem().equals(item)) {
					trovato = true;
				} 
			}
		}
		return trovato;
	}
	
	public ElementoRDA[] getRDAArray(){
		RaccoglitoreRDADAO.refresh(((RaccoglitoreRDA)this.model));
		return ((RaccoglitoreRDA)this.model).elementoRDAs.toArray();
	}
	
	public ElementoRDA getElementAt(int index){
		return ((RaccoglitoreRDA)this.getPersistentModel()).elementoRDAs.get(index);
	}
	
	public void removeElementoRDA(int index){
		 ((RaccoglitoreRDA)this.getPersistentModel()).elementoRDAs.remove(index);
	}

	public void salva() {
		RaccoglitoreRDADAO.save(((RaccoglitoreRDA)this.getPersistentModel()));
	}

	
}