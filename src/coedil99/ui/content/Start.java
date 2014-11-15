package coedil99.ui.content;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import coedil99.ui.content.creaProgetto;

public class Start extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextPane textPane;
	private JButton NuovoProgetto;

	/**
	 * Create the panel.
	 */
	public Start() {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBackground(Color.WHITE);
		setOpaque(false);
				
				NuovoProgetto = new JButton("Nuovo ordine");
				NuovoProgetto.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new creaProgetto();
					}
				});
				NuovoProgetto.setMaximumSize(new Dimension(109, 100));
				NuovoProgetto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						textPane.setText("Clicca qui per creare un nuovo ordine.");
					}
					@Override
					public void mouseExited(MouseEvent e) {
						textPane.setText("Benvenuto nella sezione ordini");
					}
				});
				NuovoProgetto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				NuovoProgetto.setIcon(new ImageIcon(Start.class.getResource("/coedil99/ui/img/project_icon.png")));
				NuovoProgetto.setVerticalTextPosition(SwingConstants.BOTTOM);
				NuovoProgetto.setHorizontalTextPosition(SwingConstants.CENTER);
				NuovoProgetto.setFont(new Font("Tahoma", Font.BOLD, 14));
		
				
				textPane = new JTextPane();
				textPane.setAlignmentY(Component.TOP_ALIGNMENT);
				textPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
				textPane.setBackground(UIManager.getColor("Button.background"));
				textPane.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				textPane.setText("Benvenuto in coedil99");
				textPane.setEditable(false);
				GroupLayout groupLayout = new GroupLayout(this);
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(NuovoProgetto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(74, Short.MAX_VALUE))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(NuovoProgetto, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addContainerGap(104, Short.MAX_VALUE))
				);
				setLayout(groupLayout);

	}
}
