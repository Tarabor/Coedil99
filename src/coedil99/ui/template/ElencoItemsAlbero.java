package coedil99.ui.template;

import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import coedil99.persistentmodel.Bullone;
import coedil99.persistentmodel.Trave;
import coedil99.persistentmodel.Lastra;
import coedil99.persistentmodel.Item;
import coedil99.utility.Service;

/*
 * Questa classe verrà utilizzata per predisporre il modello da inserire nell'elenco ad albero
 * da studiare http://docs.oracle.com/javase/tutorial/uiswing/components/tree.html
 * 
 */

public class ElencoItemsAlbero extends DefaultMutableTreeNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ElencoItemsAlbero(String nome) {
		super(nome);
		Item[] items = Service.loadDataItemsFromDB();
		DefaultMutableTreeNode node_1 = new DefaultMutableTreeNode("Bulloni");
		DefaultMutableTreeNode node_2 = new DefaultMutableTreeNode("Travi");
		DefaultMutableTreeNode node_3 = new DefaultMutableTreeNode("Lastre");
		for (int i = 0; i < items.length; i++) {
			if(items[i].getClass().getName().split("\\.")[2].equalsIgnoreCase("Bullone")) {
				node_1.add(new DefaultMutableTreeNode(items[i]));
				//node_1.add(new DefaultMutableTreeNode("Diam: " + ((Bullone) items[i]).getDiametro() + " mm"));
			}
			if(items[i].getClass().getName().split("\\.")[2].equalsIgnoreCase("Trave")) {
				node_2.add(new DefaultMutableTreeNode(items[i]));
				//node_2.add(new DefaultMutableTreeNode("Lung: " + ((Trave) items[i]).getLunghezza() + " m"));
			}
			if(items[i].getClass().getName().split("\\.")[2].equalsIgnoreCase("Lastra")) {
				node_3.add(new DefaultMutableTreeNode(items[i]));
				//node_3.add(new DefaultMutableTreeNode("di: " + ((Lastra) items[i]).getMateriale()));
			}
			
		}
		add(node_1);
		add(node_2);
		add(node_3);
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ElencoItemsAlbero.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
}