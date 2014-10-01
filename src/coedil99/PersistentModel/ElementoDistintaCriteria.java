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

public class ElementoDistintaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression indicazione;
	public final IntegerExpression NPezzi;
	public final DoubleExpression misuraDiTaglio;
	
	public ElementoDistintaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		indicazione = new StringExpression("indicazione", this);
		NPezzi = new IntegerExpression("NPezzi", this);
		misuraDiTaglio = new DoubleExpression("misuraDiTaglio", this);
	}
	
	public ElementoDistintaCriteria(PersistentSession session) {
		this(session.createCriteria(ElementoDistinta.class));
	}
	
	public ElementoDistintaCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public ItemCriteria createItemCriteria() {
		return new ItemCriteria(createCriteria("item"));
	}
	
	public ElementoDistinta uniqueElementoDistinta() {
		return (ElementoDistinta) super.uniqueResult();
	}
	
	public ElementoDistinta[] listElementoDistinta() {
		java.util.List list = super.list();
		return (ElementoDistinta[]) list.toArray(new ElementoDistinta[list.size()]);
	}
}

