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

public class MagazzinoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	
	public MagazzinoDetachedCriteria() {
		super(coedil99.PersistentModel.Magazzino.class, coedil99.PersistentModel.MagazzinoCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public MagazzinoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.MagazzinoCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ElementoMagazzinoDetachedCriteria createElementoMagazzino__list_Criteria() {
		return new ElementoMagazzinoDetachedCriteria(createCriteria("ORM_ElementoMagazzino__list_"));
	}
	
	public Magazzino uniqueMagazzino(PersistentSession session) {
		return (Magazzino) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Magazzino[] listMagazzino(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Magazzino[]) list.toArray(new Magazzino[list.size()]);
	}
}

