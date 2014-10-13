package coedil99.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coedil99.ui.content.TabMagazzino;

import java.awt.Dimension;

public class MagazzinoView extends JFrame {

	private Container contentPane;
	private static MagazzinoView instance;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private TabMagazzino tb;

	/**
	 * Create the frame.
	 */
	private MagazzinoView() {
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MagazzinoView.class.getResource(ICON_FRAME)));
		
	}
	
	
	public static MagazzinoView getInstance(){
		if(instance == null)
			instance = new MagazzinoView();
		
		return instance;
	}

	
	public void nuovaSchedaMagazzino(ArrayList<Object[]> datiMagazzino){
		this.tb = new TabMagazzino(datiMagazzino);
		add(tb);
		//tb.setMagazzino(datiMagazzino);
	}
	public void setMagazzino(ArrayList<Object[]> datiMagazzino){
		tb.setMagazzino(datiMagazzino);
	}
	
}
