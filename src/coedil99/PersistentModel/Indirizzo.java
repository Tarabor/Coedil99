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
	
	private int attribute;
	
	private int ID;
	
	private String via;
	
	private String comune;
	
	private int numero;
	
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
		return String.valueOf(getAttribute());
	}
	
}
