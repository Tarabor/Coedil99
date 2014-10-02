package coedil99;

import coedil99.PersistentModel.ElementoMagazzinoDAO;
import coedil99.PersistentModel.Fornitore;
import coedil99.PersistentModel.FornitoreDAO;
import coedil99.PersistentModel.Item;
import coedil99.PersistentModel.Bullone;
import coedil99.PersistentModel.BulloneDAO;
import coedil99.PersistentModel.Trave;
import coedil99.PersistentModel.TraveDAO;
import coedil99.PersistentModel.Magazzino;
import coedil99.PersistentModel.ElementoMagazzino;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import coedil99.PersistentModel.MagazzinoDAO;
import coedil99.ui.Coedil99View;
import coedil99.ui.SplashScreen;

public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		/*
		 * CODICE INIZIALE PER POPOLARE IL DB
		 * 
		 *
		Bullone  b = new Bullone();
		b.setDescrizione("abab");
		b.setDiametro(5);
		b.setPeso(3);
		b.setPrezzo(15);
		b.setTipoSagoma(0);
		BulloneDAO.save(b);
		
		Fornitore f = new Fornitore();
		f.setCodice("CCC");
		f.setDitta("Telf snc");
		f.setTelefono("0856748");
		FornitoreDAO.save(f);
		
		Trave  t = new Trave();
		t.setDescrizione("abab");
		t.setLunghezza(45);
		t.setPeso(3);
		t.setPrezzo(15);
		t.setTipoSagoma(0);
		TraveDAO.save(t);
		
		ElementoMagazzino em = new ElementoMagazzino();
		em.set_fornitore(f);
		em.setItem(t);
		em.setQuantita(15);
		//ElementoMagazzinoDAO.save(em);
		
		ElementoMagazzino em2 = new ElementoMagazzino();
		em2.set_fornitore(f);
		em2.setItem(b);
		em2.setQuantita(13);
		//ElementoMagazzinoDAO.save(em2);
		
		Magazzino m = new Magazzino();
		m.elementoMagazzino__List_.add(em);
		m.elementoMagazzino__List_.add(em2);
		MagazzinoDAO.save(m);
		*/
	
		
		
	
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				
				Coedil99View.getInstance().setVisible(true);
				splash.setVisible(false);
			}
		});
		/*try {
				SwingUtilities.invokeAndWait(RunGui);
				
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	*/
	}
}
