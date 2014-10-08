package coedil99.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import coedil99.PersistentModel.APersistentModel;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.DistintaLavorazioneDAO;
import coedil99.PersistentModel.ElementoDistinta;
import coedil99.PersistentModel.ElementoDistintaDAO;
import coedil99.PersistentModel.Item;
import coedil99.PersistentModel.Preventivo;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.TraveDAO;

public class MPreventivo extends Observable implements AModel {
	
	private int ITEM_INDEX 	 		 = 0;
	private int INDICAZIONE_INDEX 	 = 1;
	private int N_PEZZI_INDEX 	     = 2;
	private int DIAMETRO_INDEX 		 = 3;
	private int MISURADITAGLIO_INDEX = 4;
	private int TIPOSAGOMA_INDEX 	 = 5;
	
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
				valueClass = Class.forName((String) "coedil99.PersistentModel." + data[r][ITEM_INDEX]);
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
			if (i.getClass().getName().equals("coedil99.PersistentModel.Bullone")) {
				((Bullone) i).setDiametro(Float.parseFloat(String.valueOf(data[r][DIAMETRO_INDEX])));
			} else {
				//e.getItem().setDiametro(0); item non ha ancora l'operazione setDiametro
			}
			
			e.setMisuraDiTaglio(Double.parseDouble(String.valueOf(data[r][MISURADITAGLIO_INDEX])));
			if ((data[r][TIPOSAGOMA_INDEX]).equals("/")) {
				i.setTipoSagoma(0);
			} else {
				i.setTipoSagoma(Integer.parseInt(String.valueOf(data[r][TIPOSAGOMA_INDEX]))+1);
			}
			
			//imposto il prezzo
			switch(i.getClass().getName()) {
		    case "coedil99.PersistentModel.Bullone":
		    	MBullone bullone = new MBullone();
		    	bullone.setPersistentModel(i);
		    	bullone.setPrezzo(5);
		    	break;
		    case "coedil99.PersistentModel.Trave":
		    	MTrave trave = new MTrave();
		    	trave.setPersistentModel(i);
		    	trave.setPrezzo(5);
		    	break;
		    case "coedil99.PersistentModel.Lastra":
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
		this.hasChanged();
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
			if (((Item) (d.elemento__List_.get(r)).getItem()).getClass().getName().equals("coedil99.PersistentModel.Bullone")) { //controllo se è un bullone e ha diametro
				objD[r][3] = (Object) ((Bullone) (d.elemento__List_.get(r)).getItem()).getDiametro(); 
			} else {
				objD[r][3] = 0; //altrimenti diametro è 0
			}
			objD[r][4] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			objD[r][5] = (Object) ((Item) (d.elemento__List_.get(r)).getItem()).getTipoSagoma();
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
			if (((Item) (d.elemento__List_.get(r)).getItem()).getClass().getName().equals("coedil99.PersistentModel.Bullone")) { //controllo se è un bullone e ha diametro
				objD[3] = (Object) ((Bullone) (d.elemento__List_.get(r)).getItem()).getDiametro(); 
			} else {
				objD[3] = 0; //altrimenti diametro è 0
			}
			objD[4] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			objD[5] = (Object) ((Item) (d.elemento__List_.get(r)).getItem()).getTipoSagoma();
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
			if (((Item) (d.elemento__List_.get(r)).getItem()).getClass().getName().equals("Bullone")) {
				objD[r][3] = (Object) ((Bullone) (d.elemento__List_.get(r)).getItem()).getDiametro(); 
			} else {
				objD[r][3] = 0;
			}
			objD[r][4] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			objD[r][5] = (Object) ((Item) (d.elemento__List_.get(r)).getItem()).getTipoSagoma();
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

	public double calcolaPrezzo() {
		double totale = 0;
		try{
			DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
			int rows = d.elemento__List_.size();
			Object [][] objD = this.getDistintaObj();
			for(int r = 0; r < rows; r++){
				int num = (int) objD[r][1];
				double diam = (double) objD[r][2];
				double mis = (double) objD[r][3];
				int sagoma = (int) objD[r][4];
				totale += ((diam*mis)*((sagoma+1)*10))*num;
			}
		}
		catch(NullPointerException e){}
		return totale;
	}

	public void importaCVS() {
		throw new UnsupportedOperationException();
	}

	public void setElementoPreventivo(List<String> listElementi) {
		throw new UnsupportedOperationException();
	}
}