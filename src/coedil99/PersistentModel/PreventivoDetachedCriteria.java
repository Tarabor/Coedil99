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

public class PreventivoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression attribute;
	public final IntegerExpression ID;
	public final DateExpression data;
	public final BooleanExpression firmato;
	public final StringExpression elementoStrutturale;
	public final IntegerExpression cartellino;
	public final StringExpression nome;
	
	public PreventivoDetachedCriteria() {
		super(coedil99.PersistentModel.Preventivo.class, coedil99.PersistentModel.PreventivoCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		firmato = new BooleanExpression("firmato", this.getDetachedCriteria());
		elementoStrutturale = new StringExpression("elementoStrutturale", this.getDetachedCriteria());
		cartellino = new IntegerExpression("cartellino", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public PreventivoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, coedil99.PersistentModel.PreventivoCriteria.class);
		attribute = new IntegerExpression("attribute", this.getDetachedCriteria());
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		firmato = new BooleanExpression("firmato", this.getDetachedCriteria());
		elementoStrutturale = new StringExpression("elementoStrutturale", this.getDetachedCriteria());
		cartellino = new IntegerExpression("cartellino", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria createDestinazioneMaterialeCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("destinazioneMateriale"));
	}
	
	public ListaRintracciabilitaDetachedCriteria createListaRintracciabilitaCriteria() {
		return new ListaRintracciabilitaDetachedCriteria(createCriteria("listaRintracciabilita"));
	}
	
	public DistintaLavorazioneDetachedCriteria createDistintaCriteria() {
		return new DistintaLavorazioneDetachedCriteria(createCriteria("distinta"));
	}
	
	public ClienteDetachedCriteria createClienteCriteria() {
		return new ClienteDetachedCriteria(createCriteria("cliente"));
	}
	
	public Preventivo uniquePreventivo(PersistentSession session) {
		return (Preventivo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Preventivo[] listPreventivo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
	}
}

