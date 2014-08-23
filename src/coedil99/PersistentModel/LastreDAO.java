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

public class LastreDAO {
	public static Lastre loadLastreByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadLastreByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre getLastreByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return getLastreByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre loadLastreByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadLastreByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre getLastreByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return getLastreByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre loadLastreByORMID(PersistentSession session, int ID) {
		try {
			return (Lastre) session.load(coedil99.PersistentModel.Lastre.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre getLastreByORMID(PersistentSession session, int ID) {
		try {
			return (Lastre) session.get(coedil99.PersistentModel.Lastre.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre loadLastreByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Lastre) session.load(coedil99.PersistentModel.Lastre.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre getLastreByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Lastre) session.get(coedil99.PersistentModel.Lastre.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre[] listLastreByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return listLastreByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre[] listLastreByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return listLastreByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre[] listLastreByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastre as Lastre");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Lastre[]) list.toArray(new Lastre[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre[] listLastreByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastre as Lastre");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Lastre[]) list.toArray(new Lastre[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre loadLastreByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadLastreByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre loadLastreByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadLastreByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Lastre loadLastreByQuery(PersistentSession session, String condition, String orderBy) {
		Lastre[] lastres = listLastreByQuery(session, condition, orderBy);
		if (lastres != null && lastres.length > 0)
			return lastres[0];
		else
			return null;
	}
	
	public static Lastre loadLastreByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Lastre[] lastres = listLastreByQuery(session, condition, orderBy, lockMode);
		if (lastres != null && lastres.length > 0)
			return lastres[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateLastreByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return iterateLastreByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateLastreByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return iterateLastreByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateLastreByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastre as Lastre");
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
	
	public static java.util.Iterator iterateLastreByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Lastre as Lastre");
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
	
	public static Lastre createLastre() {
		return new coedil99.PersistentModel.Lastre();
	}
	
	public static boolean save(coedil99.PersistentModel.Lastre lastre) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().saveObject(lastre);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Lastre lastre) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().deleteObject(lastre);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(coedil99.PersistentModel.Lastre lastre) {
		try {
			if(lastre.getListino() != null) {
				lastre.getListino().item.remove(lastre);
			}
			
			return delete(lastre);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(coedil99.PersistentModel.Lastre lastre, org.orm.PersistentSession session) {
		try {
			if(lastre.getListino() != null) {
				lastre.getListino().item.remove(lastre);
			}
			
			try {
				session.delete(lastre);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Lastre lastre) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession().refresh(lastre);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Lastre lastre) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession().evict(lastre);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Lastre loadLastreByCriteria(LastreCriteria lastreCriteria) {
		Lastre[] lastres = listLastreByCriteria(lastreCriteria);
		if(lastres == null || lastres.length == 0) {
			return null;
		}
		return lastres[0];
	}
	
	public static Lastre[] listLastreByCriteria(LastreCriteria lastreCriteria) {
		return lastreCriteria.listLastre();
	}
}
