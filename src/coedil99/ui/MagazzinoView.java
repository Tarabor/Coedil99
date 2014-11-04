package coedil99.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import coedil99.persistentmodel.Fornitore;
import coedil99.ui.content.OpenFornitoriView;
import coedil99.ui.content.TabMagazzino;
import coedil99.ui.content.newItem;

import java.awt.Dimension;

public class MagazzinoView extends JFrame {

	private Container contentPane;
	private static MagazzinoView instance;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private TabMagazzino tb;
	private newItem ni;
	

	/**
	 * Create the frame.
	 */
	private MagazzinoView() {
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MagazzinoView.class.getResource(ICON_FRAME)));
		this.ni = new newItem();
		
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
	public void showNewItem(){
		this.ni.setVisible(true);
	}
	
	public void hideNewItem(){
		this.ni.setVisible(false);
		this.ni.clearForm();
	}
	
	public void showFornitori(Fornitore [] fornitori){
		OpenFornitoriView.getInstance().setElements(fornitori);
		OpenFornitoriView.getInstance().setVisible(true);
	}
	
	public void hideFornitori(){
		OpenFornitoriView.getInstance().setVisible(false);
	}
	
	public void updateFornitore(String ditta) {
		this.ni.updateFornitore(ditta);
	}
	
}
