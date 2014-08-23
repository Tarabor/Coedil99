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

public class TraviDAO {
	public static Travi loadTraviByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadTraviByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi getTraviByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return getTraviByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi loadTraviByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadTraviByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi getTraviByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return getTraviByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi loadTraviByORMID(PersistentSession session, int ID) {
		try {
			return (Travi) session.load(coedil99.PersistentModel.Travi.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi getTraviByORMID(PersistentSession session, int ID) {
		try {
			return (Travi) session.get(coedil99.PersistentModel.Travi.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi loadTraviByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Travi) session.load(coedil99.PersistentModel.Travi.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi getTraviByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Travi) session.get(coedil99.PersistentModel.Travi.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi[] listTraviByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return listTraviByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi[] listTraviByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return listTraviByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi[] listTraviByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Travi as Travi");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Travi[]) list.toArray(new Travi[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi[] listTraviByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Travi as Travi");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Travi[]) list.toArray(new Travi[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi loadTraviByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadTraviByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi loadTraviByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return loadTraviByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Travi loadTraviByQuery(PersistentSession session, String condition, String orderBy) {
		Travi[] travis = listTraviByQuery(session, condition, orderBy);
		if (travis != null && travis.length > 0)
			return travis[0];
		else
			return null;
	}
	
	public static Travi loadTraviByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Travi[] travis = listTraviByQuery(session, condition, orderBy, lockMode);
		if (travis != null && travis.length > 0)
			return travis[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTraviByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return iterateTraviByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateTraviByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession();
			return iterateTraviByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateTraviByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Travi as Travi");
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
	
	public static java.util.Iterator iterateTraviByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Travi as Travi");
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
	
	public static Travi createTravi() {
		return new coedil99.PersistentModel.Travi();
	}
	
	public static boolean save(coedil99.PersistentModel.Travi travi) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().saveObject(travi);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Travi travi) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().deleteObject(travi);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(coedil99.PersistentModel.Travi travi) {
		try {
			if(travi.getListino() != null) {
				travi.getListino().item.remove(travi);
			}
			
			return delete(travi);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean deleteAndDissociate(coedil99.PersistentModel.Travi travi, org.orm.PersistentSession session) {
		try {
			if(travi.getListino() != null) {
				travi.getListino().item.remove(travi);
			}
			
			try {
				session.delete(travi);
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
	
	public static boolean refresh(coedil99.PersistentModel.Travi travi) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession().refresh(travi);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Travi travi) {
		try {
			coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession().evict(travi);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Travi loadTraviByCriteria(TraviCriteria traviCriteria) {
		Travi[] travis = listTraviByCriteria(traviCriteria);
		if(travis == null || travis.length == 0) {
			return null;
		}
		return travis[0];
	}
	
	public static Travi[] listTraviByCriteria(TraviCriteria traviCriteria) {
		return traviCriteria.listTravi();
	}
}
