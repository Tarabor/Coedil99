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

public class ListaRintracciabilita extends coedil99.PersistentModel.APersistentModel {
	public ListaRintracciabilita() {
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadListaRintracciabilitaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita getListaRintracciabilitaByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getListaRintracciabilitaByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadListaRintracciabilitaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita getListaRintracciabilitaByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getListaRintracciabilitaByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByORMID(PersistentSession session, int ID) {
		try {
			return (ListaRintracciabilita) session.load(coedil99.PersistentModel.ListaRintracciabilita.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita getListaRintracciabilitaByORMID(PersistentSession session, int ID) {
		try {
			return (ListaRintracciabilita) session.get(coedil99.PersistentModel.ListaRintracciabilita.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ListaRintracciabilita) session.load(coedil99.PersistentModel.ListaRintracciabilita.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita getListaRintracciabilitaByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (ListaRintracciabilita) session.get(coedil99.PersistentModel.ListaRintracciabilita.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita[] listListaRintracciabilitaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listListaRintracciabilitaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita[] listListaRintracciabilitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listListaRintracciabilitaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita[] listListaRintracciabilitaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ListaRintracciabilita as ListaRintracciabilita");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (ListaRintracciabilita[]) list.toArray(new ListaRintracciabilita[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita[] listListaRintracciabilitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ListaRintracciabilita as ListaRintracciabilita");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (ListaRintracciabilita[]) list.toArray(new ListaRintracciabilita[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadListaRintracciabilitaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadListaRintracciabilitaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByQuery(PersistentSession session, String condition, String orderBy) {
		ListaRintracciabilita[] listaRintracciabilitas = listListaRintracciabilitaByQuery(session, condition, orderBy);
		if (listaRintracciabilitas != null && listaRintracciabilitas.length > 0)
			return listaRintracciabilitas[0];
		else
			return null;
	}
	
	public static ListaRintracciabilita loadListaRintracciabilitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		ListaRintracciabilita[] listaRintracciabilitas = listListaRintracciabilitaByQuery(session, condition, orderBy, lockMode);
		if (listaRintracciabilitas != null && listaRintracciabilitas.length > 0)
			return listaRintracciabilitas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateListaRintracciabilitaByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateListaRintracciabilitaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateListaRintracciabilitaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateListaRintracciabilitaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateListaRintracciabilitaByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ListaRintracciabilita as ListaRintracciabilita");
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
	
	public static java.util.Iterator iterateListaRintracciabilitaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.ListaRintracciabilita as ListaRintracciabilita");
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
	
	public static ListaRintracciabilita loadListaRintracciabilitaByCriteria(ListaRintracciabilitaCriteria listaRintracciabilitaCriteria) {
		ListaRintracciabilita[] listaRintracciabilitas = listListaRintracciabilitaByCriteria(listaRintracciabilitaCriteria);
		if(listaRintracciabilitas == null || listaRintracciabilitas.length == 0) {
			return null;
		}
		return listaRintracciabilitas[0];
	}
	
	public static ListaRintracciabilita[] listListaRintracciabilitaByCriteria(ListaRintracciabilitaCriteria listaRintracciabilitaCriteria) {
		return listaRintracciabilitaCriteria.listListaRintracciabilita();
	}
	
	public static ListaRintracciabilita createListaRintracciabilita() {
		return new coedil99.PersistentModel.ListaRintracciabilita();
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
	
	private int ID;
	
	private String note;
	
	private double pesoTeorico;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNote(String value) {
		this.note = value;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setPesoTeorico(double value) {
		this.pesoTeorico = value;
	}
	
	public double getPesoTeorico() {
		return pesoTeorico;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
