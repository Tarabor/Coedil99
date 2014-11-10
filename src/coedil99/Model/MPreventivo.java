package coedil99.model;

import java.util.ArrayList;
import java.util.Observable;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.DistintaLavorazioneDAO;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.Preventivo;

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

}