package coedil99.factory;

import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.EvasoStateDAO;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.persistentmodel.NonEvasoStateDAO;

public class EvasioneStateFactory {
	
	private static EvasioneStateFactory instance;
	private int _EVASOID  = 1;
	private int _NONEVASOID  = 2;
	private EvasoState evaso;
	private NonEvasoState nonevaso;
	
	private EvasioneStateFactory(){
		//this.evaso = EvasoStateDAO.loadEvasoStateByORMID(_EVASOID);
		this.evaso = EvasoStateDAO.loadEvasoStateByQuery("ID =" + _EVASOID, "ID");
		if(this.evaso == null){
			this.evaso = new EvasoState();
			EvasoStateDAO.save(this.evaso);
		}
		//this.nonevaso = NonEvasoStateDAO.loadNonEvasoStateByORMID(_NONEVASOID);
		this.nonevaso = NonEvasoStateDAO.loadNonEvasoStateByQuery("ID =" + _NONEVASOID, "ID");
		if(this.nonevaso == null){
			this.nonevaso = new NonEvasoState();
			NonEvasoStateDAO.save(this.nonevaso);
		}
	}
	
	
	public static EvasioneStateFactory getInstance(){
		if(instance == null)
			instance = new EvasioneStateFactory();
		
		return instance;
	}
	
	public EvasoState getEvasoState(){
		return evaso;
	}
	 
	public NonEvasoState getNonEvasoState(){
		return nonevaso;
	}
	
}
