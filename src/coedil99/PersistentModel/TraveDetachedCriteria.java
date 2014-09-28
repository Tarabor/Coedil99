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

public class TraveDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final DoubleExpression peso;
	public final DoubleExpression prezzo;
	public final IntegerExpression tipoSagoma;
	public final FloatExpression lunghezza;
	
	public TraveDetachedCriteria() {
		super(coedil99.PersistentModel.Trave.class, coedil99.PersistentModel.TraveCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		peso = new DoubleExpression("peso", this.getDetachedCriteria());
		prezzo = new DoubleExpression("prezzo", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
		lunghezza = new FloatExpression("lunghezza", this.getDetachedCriteria());
	}
	
	public TraveDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.TraveCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		peso = new DoubleExpression("peso", this.getDetachedCriteria());
		prezzo = new DoubleExpression("prezzo", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
		lunghezza = new FloatExpression("lunghezza", this.getDetachedCriteria());
	}
	
	public Trave uniqueTrave(PersistentSession session) {
		return (Trave) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Trave[] listTrave(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Trave[]) list.toArray(new Trave[list.size()]);
	}
}

