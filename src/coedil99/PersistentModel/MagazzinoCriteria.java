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

public class MagazzinoCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	
	public MagazzinoCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
	}
	
	public MagazzinoCriteria(PersistentSession session) {
		this(session.createCriteria(Magazzino.class));
	}
	
	public MagazzinoCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public ElementoMagazzinoCriteria createElementoMagazzino__list_Criteria() {
		return new ElementoMagazzinoCriteria(createCriteria("ORM_ElementoMagazzino__list_"));
	}
	
	public Magazzino uniqueMagazzino() {
		return (Magazzino) super.uniqueResult();
	}
	
	public Magazzino[] listMagazzino() {
		java.util.List list = super.list();
		return (Magazzino[]) list.toArray(new Magazzino[list.size()]);
	}
}

