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

public class Magazzino {
	public Magazzino() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == coedil99.PersistentModel.ORMConstants.KEY_MAGAZZINO_ELEMENTOMAGAZZINO__LIST_) {
			return ORM_elementoMagazzino__List_;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int ID;
	
	private java.util.Set ORM_elementoMagazzino__List_ = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	private void setORM_ElementoMagazzino__List_(java.util.Set value) {
		this.ORM_elementoMagazzino__List_ = value;
	}
	
	private java.util.Set getORM_ElementoMagazzino__List_() {
		return ORM_elementoMagazzino__List_;
	}
	
	public final coedil99.PersistentModel.ElementoMagazzinoSetCollection elementoMagazzino__List_ = new coedil99.PersistentModel.ElementoMagazzinoSetCollection(this, _ormAdapter, coedil99.PersistentModel.ORMConstants.KEY_MAGAZZINO_ELEMENTOMAGAZZINO__LIST_, coedil99.PersistentModel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void aggiungiElementoMagazzino(coedil99.PersistentModel.ElementoMagazzino elem) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
