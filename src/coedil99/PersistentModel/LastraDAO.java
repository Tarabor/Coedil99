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

public class LastraDAO {
	public static Lastra loadLastraByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadLastraByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra getLastraByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getLastraByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra loadLastraByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadLastraByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra getLastraByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getLastraByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra loadLastraByORMID(PersistentSession session, int attribute) {
		try {
			return (Lastra) session.load(coedil99.PersistentModel.Lastra.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra getLastraByORMID(PersistentSession session, int attribute) {
		try {
			return (Lastra) session.get(coedil99.PersistentModel.Lastra.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra loadLastraByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (Lastra) session.load(coedil99.PersistentModel.Lastra.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra getLastraByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (Lastra) session.get(coedil99.PersistentModel.Lastra.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra[] listLastraByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listLastraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra[] listLastraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listLastraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra[] listLastraByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastra as Lastra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Lastra[]) list.toArray(new Lastra[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra[] listLastraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastra as Lastra");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Lastra[]) list.toArray(new Lastra[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra loadLastraByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadLastraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra loadLastraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadLastraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastra loadLastraByQuery(PersistentSession session, String condition, String orderBy) {
		Lastra[] lastras = listLastraByQuery(session, condition, orderBy);
		if (lastras != null && lastras.length > 0)
			return lastras[0];
		else
			return null;
	}
	
	public static Lastra loadLastraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Lastra[] lastras = listLastraByQuery(session, condition, orderBy, lockMode);
		if (lastras != null && lastras.length > 0)
			return lastras[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLastraByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateLastraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateLastraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateLastraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateLastraByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastra as Lastra");
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
	
	public static java.util.Iterator iterateLastraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastra as Lastra");
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
	
	public static Lastra createLastra() {
		return new coedil99.PersistentModel.Lastra();
	}
	
	public static boolean save(coedil99.PersistentModel.Lastra lastra) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(lastra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Lastra lastra) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(lastra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Lastra lastra) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(lastra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Lastra lastra) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(lastra);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Lastra loadLastraByCriteria(LastraCriteria lastraCriteria) {
		Lastra[] lastras = listLastraByCriteria(lastraCriteria);
		if(lastras == null || lastras.length == 0) {
			return null;
		}
		return lastras[0];
	}
	
	public static Lastra[] listLastraByCriteria(LastraCriteria lastraCriteria) {
		return lastraCriteria.listLastra();
	}
}
