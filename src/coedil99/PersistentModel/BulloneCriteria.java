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

public class BulloneCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final IntegerExpression listinoIndex;
	public final DoubleExpression peso;
	public final DoubleExpression prezzo;
	public final IntegerExpression tipoSagoma;
	public final FloatExpression diametro;
	
	public BulloneCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		listinoIndex = new IntegerExpression("listinoIndex", this);
		peso = new DoubleExpression("peso", this);
		prezzo = new DoubleExpression("prezzo", this);
		tipoSagoma = new IntegerExpression("tipoSagoma", this);
		diametro = new FloatExpression("diametro", this);
	}
	
	public BulloneCriteria(PersistentSession session) {
		this(session.createCriteria(Bullone.class));
	}
	
	public BulloneCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public Bullone uniqueBullone() {
		return (Bullone) super.uniqueResult();
	}
	
	public Bullone[] listBullone() {
		java.util.List list = super.list();
		return (Bullone[]) list.toArray(new Bullone[list.size()]);
	}
}

