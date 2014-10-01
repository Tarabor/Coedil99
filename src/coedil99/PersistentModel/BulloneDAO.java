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

public class BulloneDAO {
	public static Bullone loadBulloneByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadBulloneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone getBulloneByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getBulloneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone loadBulloneByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadBulloneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone getBulloneByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getBulloneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone loadBulloneByORMID(PersistentSession session, int ID) {
		try {
			return (Bullone) session.load(coedil99.PersistentModel.Bullone.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone getBulloneByORMID(PersistentSession session, int ID) {
		try {
			return (Bullone) session.get(coedil99.PersistentModel.Bullone.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone loadBulloneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Bullone) session.load(coedil99.PersistentModel.Bullone.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone getBulloneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Bullone) session.get(coedil99.PersistentModel.Bullone.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone[] listBulloneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listBulloneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone[] listBulloneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listBulloneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone[] listBulloneByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bullone as Bullone");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Bullone[]) list.toArray(new Bullone[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone[] listBulloneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bullone as Bullone");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Bullone[]) list.toArray(new Bullone[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone loadBulloneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadBulloneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone loadBulloneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadBulloneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bullone loadBulloneByQuery(PersistentSession session, String condition, String orderBy) {
		Bullone[] bullones = listBulloneByQuery(session, condition, orderBy);
		if (bullones != null && bullones.length > 0)
			return bullones[0];
		else
			return null;
	}
	
	public static Bullone loadBulloneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Bullone[] bullones = listBulloneByQuery(session, condition, orderBy, lockMode);
		if (bullones != null && bullones.length > 0)
			return bullones[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBulloneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateBulloneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateBulloneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateBulloneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateBulloneByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bullone as Bullone");
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
	
	public static java.util.Iterator iterateBulloneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bullone as Bullone");
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
	
	public static Bullone createBullone() {
		return new coedil99.PersistentModel.Bullone();
	}
	
	public static boolean save(coedil99.PersistentModel.Bullone bullone) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(bullone);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Bullone bullone) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(bullone);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Bullone bullone) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(bullone);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Bullone bullone) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(bullone);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Bullone loadBulloneByCriteria(BulloneCriteria bulloneCriteria) {
		Bullone[] bullones = listBulloneByCriteria(bulloneCriteria);
		if(bullones == null || bullones.length == 0) {
			return null;
		}
		return bullones[0];
	}
	
	public static Bullone[] listBulloneByCriteria(BulloneCriteria bulloneCriteria) {
		return bulloneCriteria.listBullone();
	}
}
