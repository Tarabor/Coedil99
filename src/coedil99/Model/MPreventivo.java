package coedil99.Model;

import java.util.List;
import coedil99.PersistentModel.DistintaLavorazione;
import coedil99.PersistentModel.DistintaLavorazioneDAO;
import coedil99.PersistentModel.ElementoDistinta;
import coedil99.PersistentModel.ElementoDistintaDAO;
import coedil99.PersistentModel.Preventivo;

public class MPreventivo extends AModel {
	
	private int INDICAZIONE_INDEX 	 = 0;
	private int N_PEZZI_INDEX 	     = 1;
	private int DIAMETRO_INDEX 		 = 2;
	private int MISURADITAGLIO_INDEX = 3;
	private int TIPOSAGOMA_INDEX 	 = 4;

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
			e.setIndicazione((String)data[r][INDICAZIONE_INDEX]);
			e.setNPezzi(Integer.parseInt(String.valueOf(data[r][N_PEZZI_INDEX])));
			e.setDiametro(Double.parseDouble(String.valueOf(data[r][DIAMETRO_INDEX])));
			e.setMisuraDiTaglio(Double.parseDouble(String.valueOf(data[r][MISURADITAGLIO_INDEX])));
			e.setTipoSagoma((int)data[r][TIPOSAGOMA_INDEX]);
			
		}
	}
	public Object [][] getDistinta(){
		DistintaLavorazione d = ((Preventivo)this.getPersistentModel()).getDistinta();
		int rows = d.elemento__List_.size();
		Object [][] objD = new Object[rows][5];
		for(int r = 0; r < rows; r++){
			objD[r][0] = (Object)(d.elemento__List_.get(r).getIndicazione());
			objD[r][1] = (Object)(d.elemento__List_.get(r).getNPezzi());
			objD[r][2] = (Object)(d.elemento__List_.get(r).getDiametro());
			objD[r][3] = (Object)(d.elemento__List_.get(r).getMisuraDiTaglio());
			objD[r][4] = (Object)(d.elemento__List_.get(r).getTipoSagoma());
		}
		return objD;
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
			Object [][] objD = this.getDistinta();
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