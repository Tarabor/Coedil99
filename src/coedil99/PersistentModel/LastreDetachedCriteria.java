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

public class LastreDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final StringExpression id_item;
	public final IntegerExpression listinoIndex;
	public final FloatExpression materiale;
	
	public LastreDetachedCriteria() {
		super(coedil99.PersistentModel.Lastre.class, coedil99.PersistentModel.LastreCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		id_item = new StringExpression("id_item", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		materiale = new FloatExpression("materiale", this.getDetachedCriteria());
	}
	
	public LastreDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.LastreCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		id_item = new StringExpression("id_item", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		materiale = new FloatExpression("materiale", this.getDetachedCriteria());
	}
	
	public ListinoDetachedCriteria createListinoCriteria() {
		return new ListinoDetachedCriteria(createCriteria("listino"));
	}
	
	public Lastre uniqueLastre(PersistentSession session) {
		return (Lastre) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Lastre[] listLastre(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Lastre[]) list.toArray(new Lastre[list.size()]);
	}
}

