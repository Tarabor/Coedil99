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
	
	private int ID;
	
	private String descrizione;
	
	private double peso;
	
	private double prezzo;
	
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
	
	public void setPeso(double value) {
		this.peso = value;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPrezzo(double value) {
		this.prezzo = value;
	}
	
	public double getPrezzo() {
		return prezzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
