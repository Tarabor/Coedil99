package coedil99.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import coedil99.persistentmodel.APersistentModel;
import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.BulloneDAO;
import coedil99.persistentmodel.DistintaLavorazione;
import coedil99.persistentmodel.DistintaLavorazioneDAO;
import coedil99.persistentmodel.ElementoDistinta;
import coedil99.persistentmodel.ElementoDistintaDAO;
import coedil99.persistentmodel.Item;
import coedil99.persistentmodel.Preventivo;
import coedil99.persistentmodel.Trave;
import coedil99.persistentmodel.TraveDAO;

public class MPreventivo extends Observable implements AModel {
	
	private int ITEM_INDEX 	 		 = 0;
	private int INDICAZIONE_INDEX 	 = 1;
	private int N_PEZZI_INDEX 	     = 2;
	private int MISURADITAGLIO_INDEX = 3;
	
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
			Class valueClass = null;
			try {
				valueClass = Class.forName((String) "coedil99.persistentmodel." + data[r][ITEM_INDEX]);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Item i = null;

			try {
				i = (Item) valueClass.newInstance();
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.setIndicazione((String)data[r][INDICAZIONE_INDEX]);
			e.setNPezzi(Integer.parseInt(String.valueOf(data[r][N_PEZZI_INDEX])));
			e.setMisuraDiTaglio(Double.parseDouble(String.valueOf(data[r][MISURADITAGLIO_INDEX])));
			
			//imposto il prezzo
			switch(i.getClass().getName()) {
		    case "coedil99.persistentmodel.Bullone":
		    	MBullone bullone = new MBullone();
		    	bullone.setPersistentModel(i);
		    	bullone.setPrezzo(5);
		    	break;
		    case "coedil99.persistentmodel.Trave":
		    	MTrave trave = new MTrave();
		    	trave.setPersistentModel(i);
		    	trave.setPrezzo(5);
		    	break;
		    case "coedil99.persistentmodel.Lastra":
		    	MLastra lastra = new MLastra();
		    	lastra.setPersistentModel(i);
		    	lastra.setPrezzo(5);
		    	break;
			}
			
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

	public double totalePesiDistinte() {
		throw new UnsupportedOperationException();
	}

	public double totaleCostiDistinteBarre() {
		throw new UnsupportedOperationException();
	}

	public double totaleCostiDistinteLaminato() {
		throw new UnsupportedOperationException();
	}

	public void importaCVS() {
		throw new UnsupportedOperationException();
	}

	public void setElementoPreventivo(List<String> listElementi) {
		throw new UnsupportedOperationException();
	}
}