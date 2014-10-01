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

public class FornitoreDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final StringExpression codice;
	public final StringExpression telefono;
	public final StringExpression ditta;
	
	public FornitoreDetachedCriteria() {
		super(coedil99.PersistentModel.Fornitore.class, coedil99.PersistentModel.FornitoreCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		codice = new StringExpression("codice", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		ditta = new StringExpression("ditta", this.getDetachedCriteria());
	}
	
	public FornitoreDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.FornitoreCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		codice = new StringExpression("codice", this.getDetachedCriteria());
		telefono = new StringExpression("telefono", this.getDetachedCriteria());
		ditta = new StringExpression("ditta", this.getDetachedCriteria());
	}
	
	public Fornitore uniqueFornitore(PersistentSession session) {
		return (Fornitore) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Fornitore[] listFornitore(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Fornitore[]) list.toArray(new Fornitore[list.size()]);
	}
}

