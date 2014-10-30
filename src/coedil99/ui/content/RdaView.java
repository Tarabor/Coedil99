package coedil99.ui.content;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
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
	private OpenFornitoriView of;
	

	/**
	 * Create the frame.
	 */
	private RdaView() {
		setMinimumSize(new Dimension(500, 500));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RdaView.class.getResource(ICON_FRAME)));
		
		CampoTesto lblCompilazioneRichestaDacquisto = new CampoTesto();
		lblCompilazioneRichestaDacquisto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompilazioneRichestaDacquisto.setText("Compilazione Richesta D'Acquisto");
		lblCompilazioneRichestaDacquisto.setEditable(false);
		getContentPane().add(lblCompilazioneRichestaDacquisto, BorderLayout.NORTH);
		
	}
	
	
	public static RdaView getInstance(){
		if(instance == null)
			instance = new RdaView();
		
		return instance;
	}
	
	public void nuovaSchedaRda(Item[] datiItems){
		this.tb = new TabRda();
		this.nlRrda = new PopupNewLineRDA();
		this.nlRrda.setElements(datiItems);
		add(tb);
	}
	
	public void showMakeNewLineRda(){
		this.nlRrda.setVisible(true);
	}
	
	public void hideMakeNewLineRda(){
		this.nlRrda.setVisible(false);
	}
	
	
	public void hideFornitori(){
		this.of.setVisible(false);
	}
	
	public void aggiungiRiga(Object[] insert) {
		this.tb.aggiungiRigaRda(insert);
	}
	
}