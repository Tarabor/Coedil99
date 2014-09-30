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

public class DistintaLavorazione extends coedil99.PersistentModel.APersistentModel {
	public DistintaLavorazione() {
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadDistintaLavorazioneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getDistintaLavorazioneByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadDistintaLavorazioneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getDistintaLavorazioneByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(PersistentSession session, int ID) {
		try {
			return (DistintaLavorazione) session.load(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(PersistentSession session, int ID) {
		try {
			return (DistintaLavorazione) session.get(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione loadDistintaLavorazioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (DistintaLavorazione) session.load(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static DistintaLavorazione getDistintaLavorazioneByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (DistintaLavorazione) session.get(coedil99.PersistentModel.DistintaLavorazione.class, new Integer(ID), lockMode);
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
	
	public static DistintaLavorazione createDistintaLavorazione() {
		return new coedil99.PersistentModel.DistintaLavorazione();
	}
	
	public boolean save() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().saveObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().deleteObject(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean refresh() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().refresh(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean evict() {
		try {
			coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession().evict(this);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private java.util.List this_getList (int key) {
		if (key == coedil99.PersistentModel.ORMConstants.KEY_DISTINTALAVORAZIONE_ELEMENTO__LIST_) {
			return ORM_elemento__List_;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
	private int ID;
	
	private double totale;
	
	private java.util.List ORM_elemento__List_ = new java.util.ArrayList();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTotale(double value) {
		this.totale = value;
	}
	
	public double getTotale() {
		return totale;
	}
	
	private void setORM_Elemento__List_(java.util.List value) {
		this.ORM_elemento__List_ = value;
	}
	
	private java.util.List getORM_Elemento__List_() {
		return ORM_elemento__List_;
	}
	
	public final coedil99.PersistentModel.ElementoDistintaListCollection elemento__List_ = new coedil99.PersistentModel.ElementoDistintaListCollection(this, _ormAdapter, coedil99.PersistentModel.ORMConstants.KEY_DISTINTALAVORAZIONE_ELEMENTO__LIST_, coedil99.PersistentModel.ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
