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

/**
 * Oggetto persistente Cliente, utilizzato per gestire la persistenza sul DataBase
 */
public class Cliente extends coedil99.PersistentModel.APersistentModel {
	public Cliente() {
	}
	
	public static Cliente loadClienteByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadClienteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente getClienteByORMID(int ID) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getClienteByORMID(session, ID);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente loadClienteByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadClienteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente getClienteByORMID(int ID, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return getClienteByORMID(session, ID, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente loadClienteByORMID(PersistentSession session, int ID) {
		try {
			return (Cliente) session.load(coedil99.PersistentModel.Cliente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente getClienteByORMID(PersistentSession session, int ID) {
		try {
			return (Cliente) session.get(coedil99.PersistentModel.Cliente.class, new Integer(ID));
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente loadClienteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Cliente) session.load(coedil99.PersistentModel.Cliente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente getClienteByORMID(PersistentSession session, int ID, org.hibernate.LockMode lockMode) {
		try {
			return (Cliente) session.get(coedil99.PersistentModel.Cliente.class, new Integer(ID), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente[] listClienteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listClienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente[] listClienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return listClienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente[] listClienteByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Cliente as Cliente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			List list = query.list();
			return (Cliente[]) list.toArray(new Cliente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente[] listClienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Cliente as Cliente");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("this", lockMode);
			List list = query.list();
			return (Cliente[]) list.toArray(new Cliente[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente loadClienteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadClienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente loadClienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return loadClienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Cliente loadClienteByQuery(PersistentSession session, String condition, String orderBy) {
		Cliente[] clientes = listClienteByQuery(session, condition, orderBy);
		if (clientes != null && clientes.length > 0)
			return clientes[0];
		else
			return null;
	}
	
	public static Cliente loadClienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		Cliente[] clientes = listClienteByQuery(session, condition, orderBy, lockMode);
		if (clientes != null && clientes.length > 0)
			return clientes[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateClienteByQuery(String condition, String orderBy) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateClienteByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateClienteByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) {
		try {
			PersistentSession session = coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession();
			return iterateClienteByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static java.util.Iterator iterateClienteByQuery(PersistentSession session, String condition, String orderBy) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Cliente as Cliente");
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
	
	public static java.util.Iterator iterateClienteByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) {
		StringBuffer sb = new StringBuffer("From coedil99.PersistentModel.Cliente as Cliente");
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
	
	public static Cliente loadClienteByCriteria(ClienteCriteria clienteCriteria) {
		Cliente[] clientes = listClienteByCriteria(clienteCriteria);
		if(clientes == null || clientes.length == 0) {
			return null;
		}
		return clientes[0];
	}
	
	public static Cliente[] listClienteByCriteria(ClienteCriteria clienteCriteria) {
		return clienteCriteria.listCliente();
	}
	
	public static Cliente createCliente() {
		return new coedil99.PersistentModel.Cliente();
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
	
	private coedil99.PersistentModel.Indirizzo indirizzo;
	
	private String nome;
	
	private String cognome;
	
	private String codiceFiscale;
	
	private String PartitaIva;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setCognome(String value) {
		this.cognome = value;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public void setPartitaIva(String value) {
		this.PartitaIva = value;
	}
	
	public String getPartitaIva() {
		return PartitaIva;
	}
	
	public void setIndirizzo(coedil99.PersistentModel.Indirizzo value) {
		this.indirizzo = value;
	}
	
	public coedil99.PersistentModel.Indirizzo getIndirizzo() {
		return indirizzo;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
