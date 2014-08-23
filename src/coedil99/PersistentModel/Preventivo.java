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

public class Preventivo extends coedil99.PersistentModel.APersistentModel {
	public Preventivo() {
	}
	
	private int ID;
	
	private coedil99.PersistentModel.ListaRintracciabilita listaRintracciabilita;
	
	private coedil99.PersistentModel.DistintaLavorazione distinta;
	
	private String id_preventivo;
	
	private java.util.Date data;
	
	private boolean firmato;
	
	private String destinazioneMateriale;
	
	private String elementoStrutturale;
	
	private int cartellino;
	
	private String nome;
	
	private coedil99.PersistentModel.Cliente cliente;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setId_preventivo(String value) {
		this.id_preventivo = value;
	}
	
	public String getId_preventivo() {
		return id_preventivo;
	}
	
	public void setData(java.util.Date value) {
		this.data = value;
	}
	
	public java.util.Date getData() {
		return data;
	}
	
	public void setFirmato(boolean value) {
		this.firmato = value;
	}
	
	public boolean getFirmato() {
		return firmato;
	}
	
	public void setDestinazioneMateriale(String value) {
		this.destinazioneMateriale = value;
	}
	
	public String getDestinazioneMateriale() {
		return destinazioneMateriale;
	}
	
	public void setElementoStrutturale(String value) {
		this.elementoStrutturale = value;
	}
	
	public String getElementoStrutturale() {
		return elementoStrutturale;
	}
	
	public void setCartellino(int value) {
		this.cartellino = value;
	}
	
	public int getCartellino() {
		return cartellino;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCliente(coedil99.PersistentModel.Cliente value) {
		this.cliente = value;
	}
	
	public coedil99.PersistentModel.Cliente getCliente() {
		return cliente;
	}
	
	public void setDistinta(coedil99.PersistentModel.DistintaLavorazione value) {
		this.distinta = value;
	}
	
	public coedil99.PersistentModel.DistintaLavorazione getDistinta() {
		return distinta;
	}
	
	public void setListaRintracciabilita(coedil99.PersistentModel.ListaRintracciabilita value) {
		this.listaRintracciabilita = value;
	}
	
	public coedil99.PersistentModel.ListaRintracciabilita getListaRintracciabilita() {
		return listaRintracciabilita;
	}
	
	public double totalePesiDistinte() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public double totaleCostiDistinteBarre() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public double totaleCostiDistinteLaminato() {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
