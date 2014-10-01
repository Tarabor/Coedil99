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

public class Indirizzo {
	public Indirizzo() {
	}
	
	private int ID;
	
	private String via;
	
	private String comune;
	
	private int numero;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setVia(String value) {
		this.via = value;
	}
	
	public String getVia() {
		return via;
	}
	
	public void setComune(String value) {
		this.comune = value;
	}
	
	public String getComune() {
		return comune;
	}
	
	public void setNumero(int value) {
		this.numero = value;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
