/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: DuKe TeAm
 * License Type: Purchased
 */
package coedil99.PersistentModel;

public class ElementoMagazzino {
	public ElementoMagazzino() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == coedil99.PersistentModel.ORMConstants.KEY_ELEMENTOMAGAZZINO_ITEM) {
			this.item = (coedil99.PersistentModel.Item) owner;
		}
		
		else if (key == coedil99.PersistentModel.ORMConstants.KEY_ELEMENTOMAGAZZINO__FORNITORE) {
			this._fornitore = (coedil99.PersistentModel.Fornitore) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int attribute;
	
	private coedil99.PersistentModel.Fornitore _fornitore;
	
	private coedil99.PersistentModel.Item item;
	
	private int ID;
	
	private int quantita;
	
	private void setAttribute(int value) {
		this.attribute = value;
	}
	
	public int getAttribute() {
		return attribute;
	}
	
	public int getORMID() {
		return getAttribute();
	}
	
	public void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setQuantita(int value) {
		this.quantita = value;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setItem(coedil99.PersistentModel.Item value) {
		this.item = value;
	}
	
	public coedil99.PersistentModel.Item getItem() {
		return item;
	}
	
	public void set_fornitore(coedil99.PersistentModel.Fornitore value) {
		this._fornitore = value;
	}
	
	public coedil99.PersistentModel.Fornitore get_fornitore() {
		return _fornitore;
	}
	
	public coedil99.PersistentModel.Fornitore getFornitore() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setFornitore(coedil99.PersistentModel.Fornitore fornitore) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
