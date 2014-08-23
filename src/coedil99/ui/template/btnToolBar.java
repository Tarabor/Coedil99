package coedil99.ui.template;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JToggleButton;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

class MenuArrowIcon implements Icon {
	  public void paintIcon(Component c, Graphics g, int x, int y) {
	    Graphics2D g2 = (Graphics2D)g;
	    g2.setPaint(Color.BLACK);
	    g2.translate(x,y);
	    g2.drawLine( 2, 3, 6, 3 );
	    g2.drawLine( 3, 4, 5, 4 );
	    g2.drawLine( 4, 5, 4, 5 );
	    g2.translate(-x,-y);
	  }
	  public int getIconWidth()  { return 9; }
	  public int getIconHeight() { return 9; }
	}

public class btnToolBar extends JToggleButton {
	  private static final Icon i = new MenuArrowIcon();
	  public btnToolBar() {
		    this("", null);
		  }
	  public btnToolBar(Icon icon) {
		    this("", icon);
		  }
	  public btnToolBar(String text) {
		    this(text, null);
		  }
	  public btnToolBar(String text, Icon icon) {
		    super();
		    Action a = new AbstractAction(text) {
		    public void actionPerformed(ActionEvent ae) {
		    	btnToolBar b = (btnToolBar)ae.getSource();
		        if(pop!=null) pop.show(b, 0, b.getHeight());
		      }
		    };
		    a.putValue(Action.SMALL_ICON, icon);
		    setAction(a);
		    setFocusable(false);
		    setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4+i.getIconWidth()));
		  }
		  protected JPopupMenu pop;
		  public void setPopupMenu(final JPopupMenu pop) {
		    this.pop = pop;
		    pop.addPopupMenuListener(new PopupMenuListener() {
		      public void popupMenuCanceled(PopupMenuEvent e) {}
		      public void popupMenuWillBecomeVisible(PopupMenuEvent e) {}
		      public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		        setSelected(false);
		      }
		    });
		  }
		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    Dimension dim = getSize();
		    Insets ins = getInsets();
		    int x = dim.width-ins.right;
		    int y = ins.top+(dim.height-ins.top-ins.bottom-i.getIconHeight())/2;
		    i.paintIcon(this, g, x, y);
		  }
		}
