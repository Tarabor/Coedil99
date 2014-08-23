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

public class BulloniDAO {
	public static Bulloni loadBulloniByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadBulloniByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni getBulloniByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return getBulloniByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni loadBulloniByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadBulloniByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni getBulloniByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return getBulloniByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni loadBulloniByORMID(PersistentSession session, int ID) {
		try {
			return (Bulloni) session.load(coedil99.PersistentModel.Bulloni.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni getBulloniByORMID(PersistentSession session, int ID) {
		try {
			return (Bulloni) session.get(coedil99.PersistentModel.Bulloni.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni loadBulloniByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Bulloni) session.load(coedil99.PersistentModel.Bulloni.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni getBulloniByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Bulloni) session.get(coedil99.PersistentModel.Bulloni.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni[] listBulloniByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return listBulloniByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni[] listBulloniByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return listBulloniByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni[] listBulloniByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bulloni as Bulloni");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Bulloni[]) list.toArray(new Bulloni[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni[] listBulloniByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bulloni as Bulloni");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Bulloni[]) list.toArray(new Bulloni[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni loadBulloniByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadBulloniByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni loadBulloniByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadBulloniByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Bulloni loadBulloniByQuery(PersistentSession session, String condition, String orderBy) {
		Bulloni[] bullonis = listBulloniByQuery(session, condition, orderBy);
		if (bullonis != null && bullonis.length > 0)
			return bullonis[0];
		else
			return null;
	}
	
	public static Bulloni loadBulloniByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Bulloni[] bullonis = listBulloniByQuery(session, condition, orderBy, lockMode);
		if (bullonis != null && bullonis.length > 0)
			return bullonis[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateBulloniByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return iterateBulloniByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateBulloniByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return iterateBulloniByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateBulloniByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bulloni as Bulloni");
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
	
	public static java.util.Iterator iterateBulloniByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Bulloni as Bulloni");
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
	
	public static Bulloni createBulloni() {
		return new coedil99.PersistentModel.Bulloni();
	}
	
	public static boolean save(coedil99.PersistentModel.Bulloni bulloni) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().saveObject(bulloni);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Bulloni bulloni) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().deleteObject(bulloni);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(coedil99.PersistentModel.Bulloni bulloni) {
		try {
			if(bulloni.getListino() != null) {
				bulloni.getListino().item.remove(bulloni);
			}
			
			return delete(bulloni);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(coedil99.PersistentModel.Bulloni bulloni, org.orm.PersistentSession session) {
		try {
			if(bulloni.getListino() != null) {
				bulloni.getListino().item.remove(bulloni);
			}
			
			try {
				session.delete(bulloni);
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
	
	public static boolean refresh(coedil99.PersistentModel.Bulloni bulloni) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession().refresh(bulloni);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Bulloni bulloni) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession().evict(bulloni);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Bulloni loadBulloniByCriteria(BulloniCriteria bulloniCriteria) {
		Bulloni[] bullonis = listBulloniByCriteria(bulloniCriteria);
		if(bullonis == null || bullonis.length == 0) {
			return null;
		}
		return bullonis[0];
	}
	
	public static Bulloni[] listBulloniByCriteria(BulloniCriteria bulloniCriteria) {
		return bulloniCriteria.listBulloni();
	}
}
