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

public class TraviDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final StringExpression id_item;
	public final IntegerExpression listinoIndex;
	public final FloatExpression lunghezza;
	
	public TraviDetachedCriteria() {
		super(coedil99.PersistentModel.Travi.class, coedil99.PersistentModel.TraviCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		id_item = new StringExpression("id_item", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		lunghezza = new FloatExpression("lunghezza", this.getDetachedCriteria());
	}
	
	public TraviDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.TraviCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		id_item = new StringExpression("id_item", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		lunghezza = new FloatExpression("lunghezza", this.getDetachedCriteria());
	}
	
	public ListinoDetachedCriteria createListinoCriteria() {
		return new ListinoDetachedCriteria(createCriteria("listino"));
	}
	
	public Travi uniqueTravi(PersistentSession session) {
		return (Travi) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Travi[] listTravi(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Travi[]) list.toArray(new Travi[list.size()]);
	}
}

