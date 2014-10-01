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

public class ListaRintracciabilitaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final StringExpression note;
	public final DoubleExpression pesoTeorico;
	
	public ListaRintracciabilitaDetachedCriteria() {
		super(coedil99.PersistentModel.ListaRintracciabilita.class, coedil99.PersistentModel.ListaRintracciabilitaCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		note = new StringExpression("note", this.getDetachedCriteria());
		pesoTeorico = new DoubleExpression("pesoTeorico", this.getDetachedCriteria());
	}
	
	public ListaRintracciabilitaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.ListaRintracciabilitaCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		note = new StringExpression("note", this.getDetachedCriteria());
		pesoTeorico = new DoubleExpression("pesoTeorico", this.getDetachedCriteria());
	}
	
	public ListaRintracciabilita uniqueListaRintracciabilita(PersistentSession session) {
		return (ListaRintracciabilita) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public ListaRintracciabilita[] listListaRintracciabilita(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (ListaRintracciabilita[]) list.toArray(new ListaRintracciabilita[list.size()]);
	}
}

