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

public class ElementoMagazzinoDAO {
	public static ElementoMagazzino loadElementoMagazzinoByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoMagazzinoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino getElementoMagazzinoByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getElementoMagazzinoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoMagazzinoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino getElementoMagazzinoByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getElementoMagazzinoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByORMID(PersistentSession session, int attribute) {
		try {
			return (ElementoMagazzino) session.load(coedil99.PersistentModel.ElementoMagazzino.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino getElementoMagazzinoByORMID(PersistentSession session, int attribute) {
		try {
			return (ElementoMagazzino) session.get(coedil99.PersistentModel.ElementoMagazzino.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (ElementoMagazzino) session.load(coedil99.PersistentModel.ElementoMagazzino.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino getElementoMagazzinoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (ElementoMagazzino) session.get(coedil99.PersistentModel.ElementoMagazzino.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino[] listElementoMagazzinoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listElementoMagazzinoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino[] listElementoMagazzinoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listElementoMagazzinoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino[] listElementoMagazzinoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoMagazzino as ElementoMagazzino");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (ElementoMagazzino[]) list.toArray(new ElementoMagazzino[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino[] listElementoMagazzinoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoMagazzino as ElementoMagazzino");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (ElementoMagazzino[]) list.toArray(new ElementoMagazzino[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoMagazzinoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadElementoMagazzinoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByQuery(PersistentSession session, String condition, String orderBy) {
		ElementoMagazzino[] elementoMagazzinos = listElementoMagazzinoByQuery(session, condition, orderBy);
		if (elementoMagazzinos != null && elementoMagazzinos.length > 0)
			return elementoMagazzinos[0];
		else
			return null;
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ElementoMagazzino[] elementoMagazzinos = listElementoMagazzinoByQuery(session, condition, orderBy, lockMode);
		if (elementoMagazzinos != null && elementoMagazzinos.length > 0)
			return elementoMagazzinos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateElementoMagazzinoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateElementoMagazzinoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateElementoMagazzinoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateElementoMagazzinoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateElementoMagazzinoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoMagazzino as ElementoMagazzino");
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
	
	public static java.util.Iterator iterateElementoMagazzinoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ElementoMagazzino as ElementoMagazzino");
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
	
	public static ElementoMagazzino createElementoMagazzino() {
		return new coedil99.PersistentModel.ElementoMagazzino();
	}
	
	public static boolean save(coedil99.PersistentModel.ElementoMagazzino elementoMagazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(elementoMagazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.ElementoMagazzino elementoMagazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(elementoMagazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.ElementoMagazzino elementoMagazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(elementoMagazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.ElementoMagazzino elementoMagazzino) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(elementoMagazzino);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static ElementoMagazzino loadElementoMagazzinoByCriteria(ElementoMagazzinoCriteria elementoMagazzinoCriteria) {
		ElementoMagazzino[] elementoMagazzinos = listElementoMagazzinoByCriteria(elementoMagazzinoCriteria);
		if(elementoMagazzinos == null || elementoMagazzinos.length == 0) {
			return null;
		}
		return elementoMagazzinos[0];
	}
	
	public static ElementoMagazzino[] listElementoMagazzinoByCriteria(ElementoMagazzinoCriteria elementoMagazzinoCriteria) {
		return elementoMagazzinoCriteria.listElementoMagazzino();
	}
}
