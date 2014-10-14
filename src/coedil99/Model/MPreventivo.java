package coedil99.model;

import java.util.ArrayList;
import java.util.Observable;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.DistintaLavorazioneDAO;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.ElementoDistintaDAO;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.ItemDAO;
import coedil99.persistentmodel.Preventivo;

public class MPreventivo extends Observable implements AModel {
	private int ITEM_ID 	 		 = 0;
	private int ITEM	 	 		 = 1;
	private int INDICAZIONE_INDEX 	 = 2;
	private int N_PEZZI_INDEX 	     = 3;
	private int MISURADITAGLIO_INDEX = 4;
	
	public APersistentModel model;
	
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
		ElementoDistinta e;
		for(int r = 0; r < data.length; r++){

			if(r >= d.elemento__List_.size()){
				e = ElementoDistintaDAO.createElementoDistinta();
				d.elemento__List_.add(e);
			}
			else
				e = d.elemento__List_.get(r);
			Item i = ItemDAO.loadItemByORMID((int)data[r][ITEM_ID]);
			e.setIndicazione((String)data[r][INDICAZIONE_INDEX]);
			e.setNPezzi(Integer.parseInt(String.valueOf(data[r][N_PEZZI_INDEX])));
			e.setMisuraDiTaglio(Double.parseDouble(String.valueOf(data[r][MISURADITAGLIO_INDEX])));
			e.setItem(i);
		}
		MDistintaLavorazione dist = new MDistintaLavorazione();
		dist.setPersistentModel(d);
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
			objD[r][0] = (Object)(d.elemento__List_.get(r).getItem().getClass().getName().split("\\.")[2]); //prendo solo l'ultima parte del nome
			objD[r][1] = (Object)(d.elemento__List_.get(r).getIndicazione());
			objD[r][2] = (Object)(d.elemento__List_.get(r).getNPezzi());
			objD[r][3] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
		}
		return objD;
	}
	
	public ArrayList<Object[]> getDistintaArrayList(){
		DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
		int rows = d.elemento__List_.size();
		ArrayList<Object[]> data = new ArrayList<>();
		for(int r = 0; r < rows; r++){
			Object [] objD = new Object[6];
			objD[0] = (Object)(d.elemento__List_.get(r).getItem().getClass().getName().split("\\.")[2]); //prendo solo l'ultima parte del nome
			objD[1] = (Object)(d.elemento__List_.get(r).getIndicazione());
			objD[2] = (Object)(d.elemento__List_.get(r).getNPezzi());
			objD[3] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			data.add(objD);
		}
		return data;
	}
	
	public ArrayList<ElementoDistinta> getDistinta(){
		DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
		int rows = d.elemento__List_.size();
		Object [][] objD = new Object[rows][6];
		ArrayList<ElementoDistinta> dlList = new ArrayList<>();
		for(int r = 0; r < rows; r++){
			
			dlList.add(d.elemento__List_.get(r));
			objD[r][0] = (Object)(d.elemento__List_.get(r).getItem().getClass().getName());
			objD[r][1] = (Object)(d.elemento__List_.get(r).getIndicazione());
			objD[r][2] = (Object)(d.elemento__List_.get(r).getNPezzi());
			objD[r][3] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
		}
		return dlList;
	}

}