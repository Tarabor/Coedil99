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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ListaRintracciabilitaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression note;
	public final DoubleExpression pesoTeorico;
	
	public ListaRintracciabilitaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		note = new StringExpression("note", this);
		pesoTeorico = new DoubleExpression("pesoTeorico", this);
	}
	
	public ListaRintracciabilitaCriteria(PersistentSession session) {
		this(session.createCriteria(ListaRintracciabilita.class));
	}
	
	public ListaRintracciabilitaCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99PersistentManager.instance().getSession());
	}
	
	public ListaRintracciabilita uniqueListaRintracciabilita() {
		return (ListaRintracciabilita) super.uniqueResult();
	}
	
	public ListaRintracciabilita[] listListaRintracciabilita() {
		java.util.List list = super.list();
		return (ListaRintracciabilita[]) list.toArray(new ListaRintracciabilita[list.size()]);
	}
}

