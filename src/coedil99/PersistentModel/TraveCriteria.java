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

public class TraveCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final IntegerExpression listinoIndex;
	public final DoubleExpression peso;
	public final DoubleExpression prezzo;
	public final IntegerExpression tipoSagoma;
	public final FloatExpression lunghezza;
	
	public TraveCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		listinoIndex = new IntegerExpression("listinoIndex", this);
		peso = new DoubleExpression("peso", this);
		prezzo = new DoubleExpression("prezzo", this);
		tipoSagoma = new IntegerExpression("tipoSagoma", this);
		lunghezza = new FloatExpression("lunghezza", this);
	}
	
	public TraveCriteria(PersistentSession session) {
		this(session.createCriteria(Trave.class));
	}
	
	public TraveCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public Trave uniqueTrave() {
		return (Trave) super.uniqueResult();
	}
	
	public Trave[] listTrave() {
		java.util.List list = super.list();
		return (Trave[]) list.toArray(new Trave[list.size()]);
	}
}

