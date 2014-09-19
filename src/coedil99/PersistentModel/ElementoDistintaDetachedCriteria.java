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

public class ElementoDistintaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression indicazione;
	public final IntegerExpression NPezzi;
	public final DoubleExpression misuraDiTaglio;
	public final IntegerExpression tipoSagoma;
	
	public ElementoDistintaDetachedCriteria() {
		super(coedil99.PersistentModel.ElementoDistinta.class, coedil99.PersistentModel.ElementoDistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
		NPezzi = new IntegerExpression("NPezzi", this.getDetachedCriteria());
		misuraDiTaglio = new DoubleExpression("misuraDiTaglio", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
	}
	
	public ElementoDistintaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.ElementoDistintaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indicazione = new StringExpression("indicazione", this.getDetachedCriteria());
		NPezzi = new IntegerExpression("NPezzi", this.getDetachedCriteria());
		misuraDiTaglio = new DoubleExpression("misuraDiTaglio", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria createItemCriteria() {
		return new ItemDetachedCriteria(createCriteria("item"));
	}
	
	public ElementoDistinta uniqueElementoDistinta(PersistentSession session) {
		return (ElementoDistinta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ElementoDistinta[] listElementoDistinta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ElementoDistinta[]) list.toArray(new ElementoDistinta[list.size()]);
	}
}

