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

public class Listino {
	public Listino() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == coedil99.PersistentModel.ORMConstants.KEY_LISTINO_ITEM) {
			return ORM_item;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Set ORM_item = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void setORM_Item(java.util.Set value) {
		this.ORM_item = value;
	}
	
	private java.util.Set getORM_Item() {
		return ORM_item;
	}
	
	public final coedil99.PersistentModel.ItemSetCollection item = new coedil99.PersistentModel.ItemSetCollection(this, _ormAdapter, coedil99.PersistentModel.ORMConstants.KEY_LISTINO_ITEM, coedil99.PersistentModel.ORMConstants.KEY_ITEM_LISTINO, coedil99.PersistentModel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
