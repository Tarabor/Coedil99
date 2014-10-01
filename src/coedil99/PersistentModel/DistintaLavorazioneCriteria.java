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

public class DistintaLavorazioneCriteria extends AbstractORMCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final DoubleExpression totale;
	
	public DistintaLavorazioneCriteria(Criteria criteria) {
		super(criteria);
		attribute = new IntegerExpression("attribute", this);
		ID = new IntegerExpression("ID", this);
		totale = new DoubleExpression("totale", this);
	}
	
	public DistintaLavorazioneCriteria(PersistentSession session) {
		this(session.createCriteria(DistintaLavorazione.class));
	}
	
	public DistintaLavorazioneCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public ElementoDistintaCriteria createElemento__List_Criteria() {
		return new ElementoDistintaCriteria(createCriteria("ORM_Elemento__List_"));
	}
	
	public DistintaLavorazione uniqueDistintaLavorazione() {
		return (DistintaLavorazione) super.uniqueResult();
	}
	
	public DistintaLavorazione[] listDistintaLavorazione() {
		java.util.List list = super.list();
		return (DistintaLavorazione[]) list.toArray(new DistintaLavorazione[list.size()]);
	}
}

