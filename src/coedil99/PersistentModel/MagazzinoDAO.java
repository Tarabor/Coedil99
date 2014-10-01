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

public class MagazzinoDAO {
	public static Magazzino loadMagazzinoByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadMagazzinoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino getMagazzinoByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getMagazzinoByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino loadMagazzinoByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadMagazzinoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino getMagazzinoByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getMagazzinoByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino loadMagazzinoByORMID(PersistentSession session, int ID) {
		try {
			return (Magazzino) session.load(coedil99.PersistentModel.Magazzino.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino getMagazzinoByORMID(PersistentSession session, int ID) {
		try {
			return (Magazzino) session.get(coedil99.PersistentModel.Magazzino.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino loadMagazzinoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Magazzino) session.load(coedil99.PersistentModel.Magazzino.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino getMagazzinoByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Magazzino) session.get(coedil99.PersistentModel.Magazzino.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino[] listMagazzinoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listMagazzinoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino[] listMagazzinoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listMagazzinoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino[] listMagazzinoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Magazzino as Magazzino");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Magazzino[]) list.toArray(new Magazzino[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino[] listMagazzinoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Magazzino as Magazzino");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Magazzino[]) list.toArray(new Magazzino[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino loadMagazzinoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadMagazzinoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino loadMagazzinoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadMagazzinoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Magazzino loadMagazzinoByQuery(PersistentSession session, String condition, String orderBy) {
		Magazzino[] magazzinos = listMagazzinoByQuery(session, condition, orderBy);
		if (magazzinos != null && magazzinos.length > 0)
			return magazzinos[0];
		else
			return null;
	}
	
	public static Magazzino loadMagazzinoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Magazzino[] magazzinos = listMagazzinoByQuery(session, condition, orderBy, lockMode);
		if (magazzinos != null && magazzinos.length > 0)
			return magazzinos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateMagazzinoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateMagazzinoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateMagazzinoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateMagazzinoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateMagazzinoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Magazzino as Magazzino");
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
	
	public static java.util.Iterator iterateMagazzinoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Magazzino as Magazzino");
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
	
	public static Magazzino createMagazzino() {
		return new coedil99.PersistentModel.Magazzino();
	}
	
	public static boolean save(coedil99.PersistentModel.Magazzino magazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(magazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Magazzino magazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(magazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Magazzino magazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(magazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Magazzino magazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(magazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Magazzino loadMagazzinoByCriteria(MagazzinoCriteria magazzinoCriteria) {
		Magazzino[] magazzinos = listMagazzinoByCriteria(magazzinoCriteria);
		if(magazzinos == null || magazzinos.length == 0) {
			return null;
		}
		return magazzinos[0];
	}
	
	public static Magazzino[] listMagazzinoByCriteria(MagazzinoCriteria magazzinoCriteria) {
		return magazzinoCriteria.listMagazzino();
	}
}
