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

public class PreventivoDAO {
	public static Preventivo loadPreventivoByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getPreventivoByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getPreventivoByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByORMID(PersistentSession session, int attribute) {
		try {
			return (Preventivo) session.load(coedil99.PersistentModel.Preventivo.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(PersistentSession session, int attribute) {
		try {
			return (Preventivo) session.get(coedil99.PersistentModel.Preventivo.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (Preventivo) session.load(coedil99.PersistentModel.Preventivo.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo getPreventivoByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (Preventivo) session.get(coedil99.PersistentModel.Preventivo.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listPreventivoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listPreventivoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo[] listPreventivoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadPreventivoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Preventivo loadPreventivoByQuery(PersistentSession session, String condition, String orderBy) {
		Preventivo[] preventivos = listPreventivoByQuery(session, condition, orderBy);
		if (preventivos != null && preventivos.length > 0)
			return preventivos[0];
		else
			return null;
	}
	
	public static Preventivo loadPreventivoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Preventivo[] preventivos = listPreventivoByQuery(session, condition, orderBy, lockMode);
		if (preventivos != null && preventivos.length > 0)
			return preventivos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iteratePreventivoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iteratePreventivoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iteratePreventivoByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
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
	
	public static java.util.Iterator iteratePreventivoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Preventivo as Preventivo");
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
	
	public static Preventivo createPreventivo() {
		return new coedil99.PersistentModel.Preventivo();
	}
	
	public static boolean save(coedil99.PersistentModel.Preventivo preventivo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(preventivo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.Preventivo preventivo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(preventivo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.Preventivo preventivo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(preventivo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.Preventivo preventivo) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(preventivo);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Preventivo loadPreventivoByCriteria(PreventivoCriteria preventivoCriteria) {
		Preventivo[] preventivos = listPreventivoByCriteria(preventivoCriteria);
		if(preventivos == null || preventivos.length == 0) {
			return null;
		}
		return preventivos[0];
	}
	
	public static Preventivo[] listPreventivoByCriteria(PreventivoCriteria preventivoCriteria) {
		return preventivoCriteria.listPreventivo();
	}
}
