package coedil99.ui.content;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import coedil99.persistentmodel.Item;
import coedil99.ui.content.PopupNewLineRDA;
import coedil99.ui.template.CampoTesto;

public class RdaView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static RdaView instance;
	private final String ICON_FRAME = "/coedil99/ui/img/frame-icon.png";
	private TabRda tb;
	private PopupNewLineRDA nlRrda;
	

	/**
	 * Create the frame.
	 */
	private RdaView() {
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RdaView.class.getResource(ICON_FRAME)));
		
		CampoTesto lblCompilazioneRichestaDacquisto = new CampoTesto();
		lblCompilazioneRichestaDacquisto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompilazioneRichestaDacquisto.setText("Compilazione Richesta D'Acquisto");
		lblCompilazioneRichestaDacquisto.setEditable(false);
		getContentPane().add(lblCompilazioneRichestaDacquisto, BorderLayout.NORTH);
		
		this.addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent evt) {
				   remove(tb);
				   dispose();
				   }
				  });
		
	}
	
	
	public static RdaView getInstance(){
		if(instance == null)
			instance = new RdaView();
		
		return instance;
	}
	
	public void nuovaSchedaRda(){
		this.tb = new TabRda();
		add(tb);
	}
	
	public void showMakeNewLineRda(Item[] datiItems){
		this.nlRrda = new PopupNewLineRDA();
		this.nlRrda.setElements(datiItems);
		this.nlRrda.setVisible(true);
	}
	
	public void hideMakeNewLineRda(){
		this.nlRrda.setVisible(false);
		this.remove(nlRrda);
	}
	
	
	
	public void aggiungiRiga(Object[] insert) {
		this.tb.aggiungiRigaRda(insert);
	}


	public void setButtonSalvaInvisible() {
		this.tb.setSalvaInvisible();
		this.remove(tb);
		this.remove(nlRrda);
	}
	
}