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

public class ItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final DoubleExpression peso;
	public final DoubleExpression prezzo;
	
	public ItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		descrizione = new StringExpression("descrizione", this);
		peso = new DoubleExpression("peso", this);
		prezzo = new DoubleExpression("prezzo", this);
	}
	
	public ItemCriteria(PersistentSession session) {
		this(session.createCriteria(Item.class));
	}
	
	public ItemCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public Item uniqueItem() {
		return (Item) super.uniqueResult();
	}
	
	public Item[] listItem() {
		java.util.List list = super.list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

