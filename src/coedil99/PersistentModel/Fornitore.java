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

public class Fornitore {
	public Fornitore() {
	}
	
	private int ID;
	
	private String codice;
	
	private String telefono;
	
	private String ditta;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setCodice(String value) {
		this.codice = value;
	}
	
	public String getCodice() {
		return codice;
	}
	
	public void setTelefono(String value) {
		this.telefono = value;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setDitta(String value) {
		this.ditta = value;
	}
	
	public String getDitta() {
		return ditta;
	}
	
	public void setTelefono(int telefono) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
