package coedil99;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import coedil99.ui.Coedil99View;
import coedil99.ui.SplashScreen;

public class Main {
	
	public static void main(String[] args) {

		final SplashScreen  splash = new SplashScreen();
		splash.setVisible(true); 
		
		Runnable RunGui = new Runnable() {
			
			@Override
			public void run() {
				
				Coedil99View.getInstance().setVisible(true);
				splash.setVisible(false);
			}
		};
		SwingUtilities.invokeLater(RunGui);
		try {
				SwingUtilities.invokeAndWait(RunGui);
				
			} catch (InvocationTargetException e) {
				
				e.printStackTrace();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}	
	}
}
