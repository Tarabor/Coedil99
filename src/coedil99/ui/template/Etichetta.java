package coedil99.ui.template;

import java.awt.Font;
import javax.swing.JLabel;

public class Etichetta extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Font FONT_DEFAULT = new Font("Century Gothic", Font.BOLD, 14);
	
	public Etichetta(){
		super();
		impostaFont();
	}
	
	public Etichetta(String text){
		super(text);
		impostaFont();
	}
	
	private void impostaFont(){
		
		setFont(FONT_DEFAULT);
	}

}
