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

public abstract class Item extends coedil99.PersistentModel.APersistentModel {
	public Item() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == coedil99.PersistentModel.ORMConstants.KEY_ITEM_LISTINO) {
			this.listino = (coedil99.PersistentModel.Listino) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int ID;
	
	private coedil99.PersistentModel.Listino listino;
	
	private String descrizione;
	
	private String id_item;
	
	private Integer listinoIndex;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setId_item(String value) {
		this.id_item = value;
	}
	
	public String getId_item() {
		return id_item;
	}
	
	public void setListinoIndex(int value) {
		setListinoIndex(new Integer(value));
	}
	
	public void setListinoIndex(Integer value) {
		this.listinoIndex = value;
	}
	
	public Integer getListinoIndex() {
		return listinoIndex;
	}
	
	public void setListino(coedil99.PersistentModel.Listino value) {
		if (listino != null) {
			listino.item.remove(this);
		}
		if (value != null) {
			value.item.add(this);
		}
	}
	
	public coedil99.PersistentModel.Listino getListino() {
		return listino;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Listino(coedil99.PersistentModel.Listino value) {
		this.listino = value;
	}
	
	private coedil99.PersistentModel.Listino getORM_Listino() {
		return listino;
	}
	
	public String getIdItem() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void setIdItem(String codice) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
