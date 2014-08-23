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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ListinoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	
	public ListinoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
	}
	
	public ListinoCriteria(PersistentSession session) {
		this(session.createCriteria(Listino.class));
	}
	
	public ListinoCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession());
	}
	
	public ItemCriteria createItemCriteria() {
		return new ItemCriteria(createCriteria("ORM_Item"));
	}
	
	public Listino uniqueListino() {
		return (Listino) super.uniqueResult();
	}
	
	public Listino[] listListino() {
		java.util.List list = super.list();
		return (Listino[]) list.toArray(new Listino[list.size()]);
	}
}

