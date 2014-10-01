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

public class ElementoDistinta extends coedil99.PersistentModel.APersistentModel {
	public ElementoDistinta() {
	}
	
	private int attribute;
	
	private int ID;
	
	private String indicazione;
	
	private int NPezzi;
	
	private double misuraDiTaglio;
	
	private coedil99.PersistentModel.Item item;
	
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
	
	public void setIndicazione(String value) {
		this.indicazione = value;
	}
	
	public String getIndicazione() {
		return indicazione;
	}
	
	public void setNPezzi(int value) {
		this.NPezzi = value;
	}
	
	public int getNPezzi() {
		return NPezzi;
	}
	
	public void setMisuraDiTaglio(double value) {
		this.misuraDiTaglio = value;
	}
	
	public double getMisuraDiTaglio() {
		return misuraDiTaglio;
	}
	
	public void setItem(coedil99.PersistentModel.Item value) {
		this.item = value;
	}
	
	public coedil99.PersistentModel.Item getItem() {
		return item;
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
