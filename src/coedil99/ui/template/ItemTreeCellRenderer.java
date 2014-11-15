package coedil99.ui.template;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.DefaultMutableTreeNode; 

import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Trave;

public class ItemTreeCellRenderer implements TreeCellRenderer {
	
	private JLabel label;

	public ItemTreeCellRenderer() {
        label = new JLabel();
    }

	@Override
	public Component getTreeCellRendererComponent(JTree arg0, Object value, boolean arg2, boolean arg3, boolean arg4, int arg5, boolean arg6) {
		Object o = ((DefaultMutableTreeNode) value).getUserObject();
        if (o instanceof Lastra) {
        	java.net.URL imgURL = ItemTreeCellRenderer.class.getResource("../content/img/Lastra.gif");
            label.setIcon(new ImageIcon(imgURL));
            label.setText("Mat: " + ((Lastra) o).getMateriale());
        } else
        if (o instanceof Trave) {
        	java.net.URL imgURL = ItemTreeCellRenderer.class.getResource("../content/img/Trave.gif");
            label.setIcon(new ImageIcon(imgURL)); 
            label.setText("Lung: " + ((Trave) o).getLunghezza() + " m");
        } else
        if (o instanceof Bullone) {
        	java.net.URL imgURL = ItemTreeCellRenderer.class.getResource("../content/img/Bullone.gif");
            label.setIcon(new ImageIcon(imgURL));
            label.setText("Diam: " + ((Bullone) o).getDiametro() + " mm");
        } else {
            label.setIcon(null);
            label.setText("" + value);
        }
        return label;
	}
	

}