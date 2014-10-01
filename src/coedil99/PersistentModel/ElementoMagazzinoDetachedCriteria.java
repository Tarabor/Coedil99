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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ElementoMagazzinoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final IntegerExpression quantita;
	
	public ElementoMagazzinoDetachedCriteria() {
		super(coedil99.PersistentModel.ElementoMagazzino.class, coedil99.PersistentModel.ElementoMagazzinoCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
	}
	
	public ElementoMagazzinoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.ElementoMagazzinoCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		quantita = new IntegerExpression("quantita", this.getDetachedCriteria());
	}
	
	public FornitoreDetachedCriteria create_fornitoreCriteria() {
		return new FornitoreDetachedCriteria(createCriteria("_fornitore"));
	}
	
	public ItemDetachedCriteria createItemCriteria() {
		return new ItemDetachedCriteria(createCriteria("item"));
	}
	
	public ElementoMagazzino uniqueElementoMagazzino(PersistentSession session) {
		return (ElementoMagazzino) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ElementoMagazzino[] listElementoMagazzino(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ElementoMagazzino[]) list.toArray(new ElementoMagazzino[list.size()]);
	}
}

