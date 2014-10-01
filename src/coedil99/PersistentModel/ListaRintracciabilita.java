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

public class ListaRintracciabilita extends coedil99.PersistentModel.APersistentModel {
	public ListaRintracciabilita() {
	}
	
	private int attribute;
	
	private int ID;
	
	private String note;
	
	private double pesoTeorico;
	
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
	
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setPesoTeorico(double value) {
		this.pesoTeorico = value;
	}
	
	public double getPesoTeorico() {
		return pesoTeorico;
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
