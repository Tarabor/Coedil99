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

public class BulloniDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final StringExpression id_item;
	public final IntegerExpression listinoIndex;
	public final FloatExpression diametro;
	
	public BulloniDetachedCriteria() {
		super(coedil99.PersistentModel.Bulloni.class, coedil99.PersistentModel.BulloniCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		id_item = new StringExpression("id_item", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		diametro = new FloatExpression("diametro", this.getDetachedCriteria());
	}
	
	public BulloniDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.BulloniCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		id_item = new StringExpression("id_item", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		diametro = new FloatExpression("diametro", this.getDetachedCriteria());
	}
	
	public ListinoDetachedCriteria createListinoCriteria() {
		return new ListinoDetachedCriteria(createCriteria("listino"));
	}
	
	public Bulloni uniqueBulloni(PersistentSession session) {
		return (Bulloni) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Bulloni[] listBulloni(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Bulloni[]) list.toArray(new Bulloni[list.size()]);
	}
}

