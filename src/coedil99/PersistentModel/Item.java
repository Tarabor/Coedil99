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
	
	private int attribute;
	
	protected int ID;
	
	protected String descrizione;
	
	protected double peso;
	
	protected double prezzo;
	
	protected int tipoSagoma;
	
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
	
	public void setTipoSagoma(int value) {
		this.tipoSagoma = value;
	}
	
	public int getTipoSagoma() {
		return tipoSagoma;
	}
	
	public String toString() {
		return String.valueOf(getAttribute());
	}
	
}
