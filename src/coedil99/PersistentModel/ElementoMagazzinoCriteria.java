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

public class ElementoMagazzinoCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final IntegerExpression quantita;
	
	public ElementoMagazzinoCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		quantita = new IntegerExpression("quantita", this);
	}
	
	public ElementoMagazzinoCriteria(PersistentSession session) {
		this(session.createCriteria(ElementoMagazzino.class));
	}
	
	public ElementoMagazzinoCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public FornitoreCriteria create_fornitoreCriteria() {
		return new FornitoreCriteria(createCriteria("_fornitore"));
	}
	
	public ItemCriteria createItemCriteria() {
		return new ItemCriteria(createCriteria("item"));
	}
	
	public ElementoMagazzino uniqueElementoMagazzino() {
		return (ElementoMagazzino) super.uniqueResult();
	}
	
	public ElementoMagazzino[] listElementoMagazzino() {
		java.util.List list = super.list();
		return (ElementoMagazzino[]) list.toArray(new ElementoMagazzino[list.size()]);
	}
}

