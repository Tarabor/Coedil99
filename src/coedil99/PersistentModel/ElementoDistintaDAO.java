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

public class ElementoDistintaDAO {
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
	
	public static ElementoDistinta createElementoDistinta() {
		return new coedil99.PersistentModel.ElementoDistinta();
	}
	
	public static boolean save(coedil99.PersistentModel.ElementoDistinta elementoDistinta) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(elementoDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.ElementoDistinta elementoDistinta) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(elementoDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.ElementoDistinta elementoDistinta) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(elementoDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.ElementoDistinta elementoDistinta) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(elementoDistinta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
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
}
