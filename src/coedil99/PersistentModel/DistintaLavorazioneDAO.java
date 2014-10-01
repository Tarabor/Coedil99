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

public class DistintaLavorazioneDAO {
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadDistintaLavorazioneByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(int attribute) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getDistintaLavorazioneByORMID(session, attribute);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadDistintaLavorazioneByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(int attribute, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getDistintaLavorazioneByORMID(session, attribute, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(PersistentSession session, int attribute) {
		try {
			return (DistintaLavorazione) session.load(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(PersistentSession session, int attribute) {
		try {
			return (DistintaLavorazione) session.get(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(attribute));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (DistintaLavorazione) session.load(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(PersistentSession session, int attribute, org.hibernate.LockMode lockMode) {
		try {
			return (DistintaLavorazione) session.get(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(attribute), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione[] listDistintaLavorazioneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listDistintaLavorazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione[] listDistintaLavorazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listDistintaLavorazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione[] listDistintaLavorazioneByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.DistintaLavorazione as DistintaLavorazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (DistintaLavorazione[]) list.toArray(new DistintaLavorazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione[] listDistintaLavorazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.DistintaLavorazione as DistintaLavorazione");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (DistintaLavorazione[]) list.toArray(new DistintaLavorazione[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadDistintaLavorazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadDistintaLavorazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByQuery(PersistentSession session, String condition, String orderBy) {
		DistintaLavorazione[] distintaLavoraziones = listDistintaLavorazioneByQuery(session, condition, orderBy);
		if (distintaLavoraziones != null && distintaLavoraziones.length > 0)
			return distintaLavoraziones[0];
		else
			return null;
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		DistintaLavorazione[] distintaLavoraziones = listDistintaLavorazioneByQuery(session, condition, orderBy, lockMode);
		if (distintaLavoraziones != null && distintaLavoraziones.length > 0)
			return distintaLavoraziones[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDistintaLavorazioneByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateDistintaLavorazioneByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateDistintaLavorazioneByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateDistintaLavorazioneByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateDistintaLavorazioneByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.DistintaLavorazione as DistintaLavorazione");
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
	
	public static java.util.Iterator iterateDistintaLavorazioneByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.DistintaLavorazione as DistintaLavorazione");
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
	
	public static DistintaLavorazione createDistintaLavorazione() {
		return new coedil99.PersistentModel.DistintaLavorazione();
	}
	
	public static boolean save(coedil99.PersistentModel.DistintaLavorazione distintaLavorazione) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(distintaLavorazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean delete(coedil99.PersistentModel.DistintaLavorazione distintaLavorazione) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(distintaLavorazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean refresh(coedil99.PersistentModel.DistintaLavorazione distintaLavorazione) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(distintaLavorazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean evict(coedil99.PersistentModel.DistintaLavorazione distintaLavorazione) {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(distintaLavorazione);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByCriteria(DistintaLavorazioneCriteria distintaLavorazioneCriteria) {
		DistintaLavorazione[] distintaLavoraziones = listDistintaLavorazioneByCriteria(distintaLavorazioneCriteria);
		if(distintaLavoraziones == null || distintaLavoraziones.length == 0) {
			return null;
		}
		return distintaLavoraziones[0];
	}
	
	public static DistintaLavorazione[] listDistintaLavorazioneByCriteria(DistintaLavorazioneCriteria distintaLavorazioneCriteria) {
		return distintaLavorazioneCriteria.listDistintaLavorazione();
	}
}
