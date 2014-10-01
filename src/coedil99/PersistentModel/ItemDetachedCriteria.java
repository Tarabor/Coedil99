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

public class ItemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final StringExpression descrizione;
	public final IntegerExpression listinoIndex;
	public final DoubleExpression peso;
	public final DoubleExpression prezzo;
	public final IntegerExpression tipoSagoma;
	
	public ItemDetachedCriteria() {
		super(coedil99.PersistentModel.Item.class, coedil99.PersistentModel.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		peso = new DoubleExpression("peso", this.getDetachedCriteria());
		prezzo = new DoubleExpression("prezzo", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.ItemCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		descrizione = new StringExpression("descrizione", this.getDetachedCriteria());
		listinoIndex = new IntegerExpression("listinoIndex", this.getDetachedCriteria());
		peso = new DoubleExpression("peso", this.getDetachedCriteria());
		prezzo = new DoubleExpression("prezzo", this.getDetachedCriteria());
		tipoSagoma = new IntegerExpression("tipoSagoma", this.getDetachedCriteria());
	}
	
	public Item uniqueItem(PersistentSession session) {
		return (Item) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Item[] listItem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Item[]) list.toArray(new Item[list.size()]);
	}
}

