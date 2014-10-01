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

public class IndirizzoDAO {
	public static Indirizzo loadIndirizzoByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadIndirizzoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo getIndirizzoByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getIndirizzoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo loadIndirizzoByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadIndirizzoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo getIndirizzoByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getIndirizzoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo loadIndirizzoByORMID(PersistentSession session, int attribute) {
		try {
			return (Indirizzo) session.load(coedil99.PersistentModel.Indirizzo.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo getIndirizzoByORMID(PersistentSession session, int attribute) {
		try {
			return (Indirizzo) session.get(coedil99.PersistentModel.Indirizzo.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo loadIndirizzoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (Indirizzo) session.load(coedil99.PersistentModel.Indirizzo.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo getIndirizzoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (Indirizzo) session.get(coedil99.PersistentModel.Indirizzo.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo[] listIndirizzoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listIndirizzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo[] listIndirizzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listIndirizzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo[] listIndirizzoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Indirizzo as Indirizzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Indirizzo[]) list.toArray(new Indirizzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo[] listIndirizzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Indirizzo as Indirizzo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Indirizzo[]) list.toArray(new Indirizzo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo loadIndirizzoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadIndirizzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo loadIndirizzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadIndirizzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Indirizzo loadIndirizzoByQuery(PersistentSession session, String condition, String orderBy) {
		Indirizzo[] indirizzos = listIndirizzoByQuery(session, condition, orderBy);
		if (indirizzos != null && indirizzos.length > 0)
			return indirizzos[0];
		else
			return null;
	}
	
	public static Indirizzo loadIndirizzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Indirizzo[] indirizzos = listIndirizzoByQuery(session, condition, orderBy, lockMode);
		if (indirizzos != null && indirizzos.length > 0)
			return indirizzos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateIndirizzoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateIndirizzoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateIndirizzoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateIndirizzoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateIndirizzoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Indirizzo as Indirizzo");
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
	
	public static java.util.Iterator iterateIndirizzoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Indirizzo as Indirizzo");
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
	
	public static Indirizzo createIndirizzo() {
		return new coedil99.PersistentModel.Indirizzo();
	}
	
	public static boolean save(coedil99.PersistentModel.Indirizzo indirizzo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(indirizzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Indirizzo indirizzo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(indirizzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Indirizzo indirizzo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(indirizzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Indirizzo indirizzo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(indirizzo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Indirizzo loadIndirizzoByCriteria(IndirizzoCriteria indirizzoCriteria) {
		Indirizzo[] indirizzos = listIndirizzoByCriteria(indirizzoCriteria);
		if(indirizzos == null || indirizzos.length == 0) {
			return null;
		}
		return indirizzos[0];
	}
	
	public static Indirizzo[] listIndirizzoByCriteria(IndirizzoCriteria indirizzoCriteria) {
		return indirizzoCriteria.listIndirizzo();
	}
}
