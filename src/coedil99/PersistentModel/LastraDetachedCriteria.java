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

public class LastraDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final DoubleExpression peso;
	public final DoubleExpression prezzo;
	public final IntegerExpression tipoSagoma;
	public final StringExpression materiale;
	
	public LastraDetachedCriteria() {
		super(coedil99.PersistentModel.Lastra.class, coedil99.PersistentModel.LastraCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		peso = new DoubleExpression("peso", this.getDetachedCriteria());
		prezzo = new DoubleExpression("prezzo", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
		materiale = new StringExpression("materiale", this.getDetachedCriteria());
	}
	
	public LastraDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.LastraCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		peso = new DoubleExpression("peso", this.getDetachedCriteria());
		prezzo = new DoubleExpression("prezzo", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
		materiale = new StringExpression("materiale", this.getDetachedCriteria());
	}
	
	public Lastra uniqueLastra(PersistentSession session) {
		return (Lastra) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Lastra[] listLastra(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Lastra[]) list.toArray(new Lastra[list.size()]);
	}
}

