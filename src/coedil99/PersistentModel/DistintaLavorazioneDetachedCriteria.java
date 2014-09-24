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

public class DistintaLavorazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final DoubleExpression totale;
	
	public DistintaLavorazioneDetachedCriteria() {
		super(coedil99.PersistentModel.DistintaLavorazione.class, coedil99.PersistentModel.DistintaLavorazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		totale = new DoubleExpression("totale", this.getDetachedCriteria());
	}
	
	public DistintaLavorazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.DistintaLavorazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		totale = new DoubleExpression("totale", this.getDetachedCriteria());
	}
	
	public ElementoDistintaDetachedCriteria createElemento__List_Criteria() {
		return new ElementoDistintaDetachedCriteria(createCriteria("ORM_Elemento__List_"));
	}
	
	public DistintaLavorazione uniqueDistintaLavorazione(PersistentSession session) {
		return (DistintaLavorazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public DistintaLavorazione[] listDistintaLavorazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (DistintaLavorazione[]) list.toArray(new DistintaLavorazione[list.size()]);
	}
}

