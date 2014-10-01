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

/**
 * Oggetto persistente Cliente, utilizzato per gestire la persistenza sul DataBase
 */
public class Cliente extends coedil99.PersistentModel.APersistentModel {
	public Cliente() {
	}
	
	private int ID;
	
	private coedil99.PersistentModel.Indirizzo indirizzo;
	
	private String nome;
	
	private String cognome;
	
	private String codiceFiscale;
	
	private String PartitaIva;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setPartitaIva(String value) {
		this.PartitaIva = value;
	}
	
	public String getPartitaIva() {
		return PartitaIva;
	}
	
	public void setIndirizzo(coedil99.PersistentModel.Indirizzo value) {
		this.indirizzo = value;
	}
	
	public coedil99.PersistentModel.Indirizzo getIndirizzo() {
		return indirizzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
