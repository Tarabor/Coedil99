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
	
	private int ID;
	
	private coedil99.PersistentModel.Item item;
	
	private String indicazione;
	
	private double diametro;
	
	private double misuraDiTaglio;
	
	private int NPezzi;
	
	private int tipoSagoma;
	
	private double peso;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setIndicazione(String value) {
		this.indicazione = value;
	}
	
	public String getIndicazione() {
		return indicazione;
	}
	
	public void setDiametro(double value) {
		this.diametro = value;
	}
	
	public double getDiametro() {
		return diametro;
	}
	
	public void setMisuraDiTaglio(double value) {
		this.misuraDiTaglio = value;
	}
	
	public double getMisuraDiTaglio() {
		return misuraDiTaglio;
	}
	
	public void setNPezzi(int value) {
		this.NPezzi = value;
	}
	
	public int getNPezzi() {
		return NPezzi;
	}
	
	public void setTipoSagoma(int value) {
		this.tipoSagoma = value;
	}
	
	public int getTipoSagoma() {
		return tipoSagoma;
	}
	
	public void setPeso(double value) {
		this.peso = value;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setItem(coedil99.PersistentModel.Item value) {
		this.item = value;
	}
	
	public coedil99.PersistentModel.Item getItem() {
		return item;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
