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

import org.orm.*;
import org.hibernate.Query;
import java.util.List;

public class Preventivo extends coedil99.PersistentModel.APersistentModel {
	public Preventivo() {
	}
	
	public static Preventivo loadPreventivoByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getPreventivoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getPreventivoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByORMID(PersistentSession session, int ID) {
		try {
			return (Preventivo) session.load(coedil99.PersistentModel.Preventivo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(PersistentSession session, int ID) {
		try {
			return (Preventivo) session.get(coedil99.PersistentModel.Preventivo.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Preventivo) session.load(coedil99.PersistentModel.Preventivo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Preventivo) session.get(coedil99.PersistentModel.Preventivo.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listPreventivoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listPreventivoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByQuery(PersistentSession session, String condition, String orderBy) {
		Preventivo[] preventivos = listPreventivoByQuery(session, condition, orderBy);
		if (preventivos != null && preventivos.length > 0)
			return preventivos[0];
		else
			return null;
	}
	
	public static Preventivo loadPreventivoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Preventivo[] preventivos = listPreventivoByQuery(session, condition, orderBy, lockMode);
		if (preventivos != null && preventivos.length > 0)
			return preventivos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iteratePreventivoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iteratePreventivoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByCriteria(PreventivoCriteria preventivoCriteria) {
		Preventivo[] preventivos = listPreventivoByCriteria(preventivoCriteria);
		if(preventivos == null || preventivos.length == 0) {
			return null;
		}
		return preventivos[0];
	}
	
	public static Preventivo[] listPreventivoByCriteria(PreventivoCriteria preventivoCriteria) {
		return preventivoCriteria.listPreventivo();
	}
	
	public static Preventivo createPreventivo() {
		return new coedil99.PersistentModel.Preventivo();
	}
	
	public boolean save() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean refresh() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean evict() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private int ID;
	
	private coedil99.PersistentModel.Indirizzo destinazioneMateriale;
	
	private coedil99.PersistentModel.ListaRintracciabilita listaRintracciabilita;
	
	private coedil99.PersistentModel.DistintaLavorazione distinta;
	
	private String elementoStrutturale;
	
	private int cartellino;
	
	private String nome;
	
	private coedil99.PersistentModel.Cliente cliente;
	
	private boolean firmato;
	
	private java.util.Date data;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
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
	
	public void setDestinazioneMateriale(coedil99.PersistentModel.Indirizzo value) {
		this.destinazioneMateriale = value;
	}
	
	public coedil99.PersistentModel.Indirizzo getDestinazioneMateriale() {
		return destinazioneMateriale;
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
