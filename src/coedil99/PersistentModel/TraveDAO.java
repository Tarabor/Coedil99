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

public class TraveDAO {
	public static Trave loadTraveByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadTraveByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave getTraveByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getTraveByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave loadTraveByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadTraveByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave getTraveByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getTraveByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave loadTraveByORMID(PersistentSession session, int ID) {
		try {
			return (Trave) session.load(coedil99.PersistentModel.Trave.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave getTraveByORMID(PersistentSession session, int ID) {
		try {
			return (Trave) session.get(coedil99.PersistentModel.Trave.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave loadTraveByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Trave) session.load(coedil99.PersistentModel.Trave.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave getTraveByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Trave) session.get(coedil99.PersistentModel.Trave.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave[] listTraveByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listTraveByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave[] listTraveByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listTraveByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave[] listTraveByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Trave as Trave");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Trave[]) list.toArray(new Trave[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave[] listTraveByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Trave as Trave");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Trave[]) list.toArray(new Trave[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave loadTraveByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadTraveByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave loadTraveByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadTraveByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Trave loadTraveByQuery(PersistentSession session, String condition, String orderBy) {
		Trave[] traves = listTraveByQuery(session, condition, orderBy);
		if (traves != null && traves.length > 0)
			return traves[0];
		else
			return null;
	}
	
	public static Trave loadTraveByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Trave[] traves = listTraveByQuery(session, condition, orderBy, lockMode);
		if (traves != null && traves.length > 0)
			return traves[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTraveByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateTraveByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateTraveByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateTraveByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateTraveByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Trave as Trave");
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
	
	public static java.util.Iterator iterateTraveByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Trave as Trave");
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
	
	public static Trave createTrave() {
		return new coedil99.PersistentModel.Trave();
	}
	
	public static boolean save(coedil99.PersistentModel.Trave trave) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(trave);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Trave trave) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(trave);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Trave trave) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(trave);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Trave trave) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(trave);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Trave loadTraveByCriteria(TraveCriteria traveCriteria) {
		Trave[] traves = listTraveByCriteria(traveCriteria);
		if(traves == null || traves.length == 0) {
			return null;
		}
		return traves[0];
	}
	
	public static Trave[] listTraveByCriteria(TraveCriteria traveCriteria) {
		return traveCriteria.listTrave();
	}
}
