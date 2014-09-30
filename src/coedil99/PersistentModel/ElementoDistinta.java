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

public class ElementoDistinta extends coedil99.PersistentModel.APersistentModel {
	public ElementoDistinta() {
	}
	
	public static ElementoDistinta loadElementoDistintaByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta getElementoDistintaByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getElementoDistintaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta loadElementoDistintaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta getElementoDistintaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getElementoDistintaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta loadElementoDistintaByORMID(PersistentSession session, int ID) {
		try {
			return (ElementoDistinta) session.load(coedil99.PersistentModel.ElementoDistinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta getElementoDistintaByORMID(PersistentSession session, int ID) {
		try {
			return (ElementoDistinta) session.get(coedil99.PersistentModel.ElementoDistinta.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta loadElementoDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ElementoDistinta) session.load(coedil99.PersistentModel.ElementoDistinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta getElementoDistintaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ElementoDistinta) session.get(coedil99.PersistentModel.ElementoDistinta.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta[] listElementoDistintaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listElementoDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta[] listElementoDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listElementoDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta[] listElementoDistintaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoDistinta as ElementoDistinta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (ElementoDistinta[]) list.toArray(new ElementoDistinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta[] listElementoDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoDistinta as ElementoDistinta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (ElementoDistinta[]) list.toArray(new ElementoDistinta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta loadElementoDistintaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta loadElementoDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoDistinta loadElementoDistintaByQuery(PersistentSession session, String condition, String orderBy) {
		ElementoDistinta[] elementoDistintas = listElementoDistintaByQuery(session, condition, orderBy);
		if (elementoDistintas != null && elementoDistintas.length > 0)
			return elementoDistintas[0];
		else
			return null;
	}
	
	public static ElementoDistinta loadElementoDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ElementoDistinta[] elementoDistintas = listElementoDistintaByQuery(session, condition, orderBy, lockMode);
		if (elementoDistintas != null && elementoDistintas.length > 0)
			return elementoDistintas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateElementoDistintaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateElementoDistintaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateElementoDistintaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateElementoDistintaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateElementoDistintaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoDistinta as ElementoDistinta");
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
	
	public static java.util.Iterator iterateElementoDistintaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoDistinta as ElementoDistinta");
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
	
	public static ElementoDistinta loadElementoDistintaByCriteria(ElementoDistintaCriteria elementoDistintaCriteria) {
		ElementoDistinta[] elementoDistintas = listElementoDistintaByCriteria(elementoDistintaCriteria);
		if(elementoDistintas == null || elementoDistintas.length == 0) {
			return null;
		}
		return elementoDistintas[0];
	}
	
	public static ElementoDistinta[] listElementoDistintaByCriteria(ElementoDistintaCriteria elementoDistintaCriteria) {
		return elementoDistintaCriteria.listElementoDistinta();
	}
	
	public static ElementoDistinta createElementoDistinta() {
		return new coedil99.PersistentModel.ElementoDistinta();
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
	
	private coedil99.PersistentModel.Item item;
	
	private String indicazione;
	
	private int NPezzi;
	
	private double misuraDiTaglio;
	
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
		return String.valueOf(getID());
	}
	
}
