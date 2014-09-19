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

public class ListinoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	
	public ListinoDetachedCriteria() {
		super(coedil99.PersistentModel.Listino.class, coedil99.PersistentModel.ListinoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ListinoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.ListinoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
	}
	
	public ItemDetachedCriteria createItem__List_Criteria() {
		return new ItemDetachedCriteria(createCriteria("ORM_Item__List_"));
	}
	
	public Listino uniqueListino(PersistentSession session) {
		return (Listino) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Listino[] listListino(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Listino[]) list.toArray(new Listino[list.size()]);
	}
}

