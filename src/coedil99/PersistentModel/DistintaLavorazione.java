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

public class DistintaLavorazione extends coedil99.PersistentModel.APersistentModel {
	public DistintaLavorazione() {
	}
	
	private java.util.List this_getList (int key) {
		if (key == coedil99.PersistentModel.ORMConstants.KEY_DISTINTALAVORAZIONE_ELEMENTO__LIST_) {
			return ORM_elemento__List_;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int attribute;
	
	private int ID;
	
	private double totale;
	
	private java.util.List ORM_elemento__List_ = new java.util.ArrayList();
	
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
	
	public void setTotale(double value) {
		this.totale = value;
	}
	
	public double getTotale() {
		return totale;
	}
	
	private void setORM_Elemento__List_(java.util.List value) {
		this.ORM_elemento__List_ = value;
	}
	
	private java.util.List getORM_Elemento__List_() {
		return ORM_elemento__List_;
	}
	
	public final coedil99.PersistentModel.ElementoDistintaListCollection elemento__List_ = new coedil99.PersistentModel.ElementoDistintaListCollection(this, _ormAdapter, coedil99.PersistentModel.ORMConstants.KEY_DISTINTALAVORAZIONE_ELEMENTO__LIST_, coedil99.PersistentModel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
