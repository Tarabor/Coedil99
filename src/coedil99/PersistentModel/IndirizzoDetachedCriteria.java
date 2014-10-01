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

public class IndirizzoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression via;
	public final StringExpression comune;
	public final IntegerExpression numero;
	
	public IndirizzoDetachedCriteria() {
		super(coedil99.PersistentModel.Indirizzo.class, coedil99.PersistentModel.IndirizzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		via = new StringExpression("via", this.getDetachedCriteria());
		comune = new StringExpression("comune", this.getDetachedCriteria());
		numero = new IntegerExpression("numero", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.IndirizzoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		via = new StringExpression("via", this.getDetachedCriteria());
		comune = new StringExpression("comune", this.getDetachedCriteria());
		numero = new IntegerExpression("numero", this.getDetachedCriteria());
	}
	
	public Indirizzo uniqueIndirizzo(PersistentSession session) {
		return (Indirizzo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Indirizzo[] listIndirizzo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Indirizzo[]) list.toArray(new Indirizzo[list.size()]);
	}
}

