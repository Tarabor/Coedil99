package coedil99.ui.template;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;

public class CampoTesto extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 30;
	private static final int WIDTH = Integer.MAX_VALUE;
	private static final Font FONT_DEFAULT = new Font("Century Gothic", Font.PLAIN, 14);
	
	public CampoTesto(){
		super();
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setFont(FONT_DEFAULT);
	}
	

}
