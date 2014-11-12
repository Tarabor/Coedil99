package coedil99.model;

import java.util.ArrayList;
import java.util.Observable;

import coedil99.factory.EvasioneStateFactory;
import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.DistintaLavorazioneDAO;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.PreventivoDAO;

public class MPreventivo extends Observable implements AModel {

	
	private APersistentModel model;
	
	public APersistentModel getPersistentModel() {
		return this.model;
	}

	public void setPersistentModel(APersistentModel model) {
		this.model = model;
	}

	public MPreventivo(){}
	
	public MPreventivo( Preventivo p ){
		this.setPersistentModel(p);
	}


	public void setDistinta(Object [][] data){
		Preventivo p = (Preventivo)this.getPersistentModel();
		DistintaLavorazione d = (p.getDistinta());
		if(d  == null){
			 d = DistintaLavorazioneDAO.createDistintaLavorazione();
			 p.setDistinta(d);
		}
		
		MDistintaLavorazione dist = new MDistintaLavorazione();
		dist.setPersistentModel(d);
		dist.createElementoDistinta(data);
		dist.totale();
		dist.calcolaPrezzo();
		this.setChanged();
		this.notifyObservers(this);
	}
	
	public Object [][] getDistintaObj(){
		DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
		int rows = d.elemento__List_.size();
		Object [][] objD = new Object[rows][6];
		for(int r = 0; r < rows; r++){
			objD[r][0] = (Object)(d.elemento__List_.get(r).getItem().getORMID());
			objD[r][1] = (Object)(d.elemento__List_.get(r).getItem().getClass().getName().split("\\.")[2]); //prendo solo l'ultima parte del nome
			objD[r][2] = (Object)(d.elemento__List_.get(r).getIndicazione());
			objD[r][3] = (Object)(d.elemento__List_.get(r).getNPezzi());
			objD[r][4] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
		}
		return objD;
	}
	
	public ArrayList<Object[]> getDistintaArrayList(){
		DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
		int rows = d.elemento__List_.size();
		ArrayList<Object[]> data = new ArrayList<>();
		for(int r = 0; r < rows; r++){
			Object [] objD = new Object[6];
			objD[0] = (Object)(d.elemento__List_.get(r).getItem().getORMID());
			objD[1] = (Object)(d.elemento__List_.get(r).getItem().getClass().getName().split("\\.")[2]); //prendo solo l'ultima parte del nome
			objD[2] = (Object)(d.elemento__List_.get(r).getIndicazione());
			objD[3] = (Object)(d.elemento__List_.get(r).getNPezzi());
			objD[4] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			data.add(objD);
		}
		return data;
	}
	
	public ArrayList<ElementoDistinta> getDistinta(){
		DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
		ArrayList<ElementoDistinta> dlList = new ArrayList<>();
		if(d!=null) {
			int rows = d.elemento__List_.size();
			Object [][] objD = new Object[rows][6];

			for(int r = 0; r < rows; r++){

				dlList.add(d.elemento__List_.get(r));
				objD[r][0] = (Object)(d.elemento__List_.get(r).getItem().getORMID());
				objD[r][1] = (Object)(d.elemento__List_.get(r).getItem().getClass().getName());
				objD[r][2] = (Object)(d.elemento__List_.get(r).getIndicazione());
				objD[r][3] = (Object)(d.elemento__List_.get(r).getNPezzi());
				objD[r][4] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			}
			return dlList;
		} else {
			return dlList;
		}
	}
	
	
	
	
	
	public Boolean addItem(Item item) {
		return new MDistintaLavorazione(((Preventivo)this.getPersistentModel()).getDistinta()).addItem(item);
	}
	
	
	
	
	public static MPreventivo[] getPreventiviNonEvasi(){
		Preventivo[] preventivi = PreventivoDAO.listPreventivoByQuery("preventivostateid = 2", "ID");
		MPreventivo[] mp = null;
		if (preventivi.length > 0){
			mp = new MPreventivo[preventivi.length];
			for( int i = 0; i < preventivi.length; i++)
				mp[i] = new MPreventivo(preventivi[i]);
		}
		return mp;
	}
	
	
	//Settare stato del preventivo per quanto riguard l'evasione
	public void  statoEvasione(boolean stato){
		Preventivo p = (Preventivo)(this.getPersistentModel());
		if (stato){
			p.setPreventivoState(EvasioneStateFactory.getInstance().getEvasoState());
			PreventivoDAO.save(p);
		}
		else{
			p.setPreventivoState(EvasioneStateFactory.getInstance().getNonEvasoState());
			PreventivoDAO.save(p);
		}
	}

	public void removeElementoDistinta(int selectedRow) {
		MDistintaLavorazione dist = 
		new MDistintaLavorazione(((Preventivo)this.getPersistentModel()).getDistinta());
		dist.removeElementoDistinta(selectedRow);
		dist.totale();
		dist.calcolaPrezzo();
		this.setChanged();
		this.notifyObservers(this);
	}

}