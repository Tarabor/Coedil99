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

public class PreventivoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final DateExpression data;
	public final BooleanExpression firmato;
	public final StringExpression elementoStrutturale;
	public final IntegerExpression cartellino;
	public final StringExpression nome;
	
	public PreventivoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		data = new DateExpression("data", this);
		firmato = new BooleanExpression("firmato", this);
		elementoStrutturale = new StringExpression("elementoStrutturale", this);
		cartellino = new IntegerExpression("cartellino", this);
		nome = new StringExpression("nome", this);
	}
	
	public PreventivoCriteria(PersistentSession session) {
		this(session.createCriteria(Preventivo.class));
	}
	
	public PreventivoCriteria() throws PersistentException {
		this(coedil99.PersistentModel.Coedil99rev1modPersistentManager.instance().getSession());
	}
	
	public IndirizzoCriteria createDestinazioneMaterialeCriteria() {
		return new IndirizzoCriteria(createCriteria("destinazioneMateriale"));
	}
	
	public ListaRintracciabilitaCriteria createListaRintracciabilitaCriteria() {
		return new ListaRintracciabilitaCriteria(createCriteria("listaRintracciabilita"));
	}
	
	public DistintaLavorazioneCriteria createDistintaCriteria() {
		return new DistintaLavorazioneCriteria(createCriteria("distinta"));
	}
	
	public ClienteCriteria createClienteCriteria() {
		return new ClienteCriteria(createCriteria("cliente"));
	}
	
	public Preventivo uniquePreventivo() {
		return (Preventivo) super.uniqueResult();
	}
	
	public Preventivo[] listPreventivo() {
		java.util.List list = super.list();
		return (Preventivo[]) list.toArray(new Preventivo[list.size()]);
	}
}

