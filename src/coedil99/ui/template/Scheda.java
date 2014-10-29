package coedil99.ui.template;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

import coedil99.application.controller.CtrlElaboraPreventivo;
import coedil99.ui.Coedil99View;


public class Scheda extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Icon CLOSE_TAB_ICON = new ImageIcon(Scheda.class.getResource("/coedil99/ui/img/close_icon.png"));
	private static final Icon PAGE_ICON = new ImageIcon(Scheda.class.getResource("/coedil99/ui/img/document_icon.png"));
	
	private final JTabbedPane pane; 
	
	public  Scheda( final JTabbedPane pane ){
		
		super(new FlowLayout(FlowLayout.CENTER, 5, 0));
	    this.pane = pane;
		setOpaque(false);

	    JLabel lblTitle = new JLabel(){
	    	
			public String getText() {
                int i = pane.indexOfTabComponent(Scheda.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };
        lblTitle.setIcon(PAGE_ICON);
	    add(lblTitle);

	    JButton btnClose = /*new JButton(CLOSE_TAB_ICON);
	    btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = pane.indexOfTabComponent(Scheda.this);
	            if (i != -1) {
	            	pane.remove(i);
	            }
				
			}
		});
	    btnClose.setPreferredSize(new Dimension(19,19));*/ new TabButton();
	    btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    add(btnClose);
	    setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
	}
	
	private class TabButton extends JButton implements ActionListener {
	
		   private static final long serialVersionUID = 1L;

		   public TabButton() {
			   int size = 15;
	           setPreferredSize(new Dimension(size, size));
			   setToolTipText("Chiudi");
			   setOpaque(false);
			   setUI(new BasicButtonUI());
			   setContentAreaFilled(false);
			   setBorder(BorderFactory.createEtchedBorder());
	           setBorderPainted(false);
			   setRolloverEnabled(true);
			   setBorder(null);
			   setFocusable(false);
			   addMouseListener(buttonMouseListener);
			   addActionListener(this);
	       }
		   
		   public void actionPerformed(ActionEvent e) {
	            int i = pane.indexOfTabComponent(Scheda.this);
	            if (i != -1) {
	            	     	
	            	CtrlElaboraPreventivo.getInstance().chiudiPreventivo(i);
	            }
	       }
		 //paint the cross
		   
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g);
	            Graphics2D g2 = (Graphics2D) g.create();
	            //shift the image for pressed buttons
	            if (getModel().isPressed()) {
	                g2.translate(1, 1);
	            }
	            g2.setStroke(new BasicStroke(2));
	            g2.setColor(Color.BLACK);
	            if (getModel().isRollover()) {
	                g2.setColor(Color.RED);
	            }
	            int delta = 2;
	            g2.drawLine(delta, delta, getWidth() - delta - 1, getHeight() - delta - 1);
	            g2.drawLine(getWidth() - delta - 1, delta, delta, getHeight() - delta - 1);
	            g2.dispose();
	        }
		   
	   }
	private final static MouseListener buttonMouseListener = new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(true);
            }
        }
        public void mouseExited(MouseEvent e) {
            Component component = e.getComponent();
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.setBorderPainted(false);
            }
        }
    };
	   
}
