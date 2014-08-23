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

public class LastreCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final StringExpression id_item;
	public final IntegerExpression listinoIndex;
	public final FloatExpression materiale;
	
	public LastreCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		id_item = new StringExpression("id_item", this);
		listinoIndex = new IntegerExpression("listinoIndex", this);
		materiale = new FloatExpression("materiale", this);
	}
	
	public LastreCriteria(PersistentSession session) {
		this(session.createCriteria(Lastre.class));
	}
	
	public LastreCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession());
	}
	
	public ListinoCriteria createListinoCriteria() {
		return new ListinoCriteria(createCriteria("listino"));
	}
	
	public Lastre uniqueLastre() {
		return (Lastre) super.uniqueResult();
	}
	
	public Lastre[] listLastre() {
		java.util.List list = super.list();
		return (Lastre[]) list.toArray(new Lastre[list.size()]);
	}
}

