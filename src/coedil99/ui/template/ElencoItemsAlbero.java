package coedil99.ui.template;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import coedil99.persistentmodel.Item;
import coedil99.ui.Coedil99View;
import coedil99.ui.content.TabContent;
import coedil99.utility.Service;

/*
 * Questa classe verrà utilizzata per predisporre il modello da inserire nell'elenco ad albero
 * da studiare http://docs.oracle.com/javase/tutorial/uiswing/components/tree.html
 * 
 */

public class ElencoItemsAlbero extends JInternalFrame implements TreeSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final String ICON_EXPLORER = "/coedil99/ui/img/explorer-icon.png";
	JTree tree;
	
	public ElencoItemsAlbero(String nome) {
		super(nome);
		
		this.setFrameIcon(new ImageIcon(ElencoItemsAlbero.class.getResource(ICON_EXPLORER)));
		this.getContentPane().setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{129, 0};
		gridBagLayout.rowHeights = new int[]{345, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		this.getContentPane().setLayout(gridBagLayout);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Elenco Items");
		createNodes(top);

		//Create a tree that allows one selection at a time.
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		//Listen for when the selection changes.
		tree.addTreeSelectionListener(this);
		
		tree.setCellRenderer(new ItemTreeCellRenderer());
		
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.anchor = GridBagConstraints.NORTH;
		gbc_tree.fill = GridBagConstraints.HORIZONTAL;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		getContentPane().add(tree, gbc_tree);
	}
	
	private void createNodes(DefaultMutableTreeNode top) {
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
		top.add(node_1);
		top.add(node_2);
		top.add(node_3);
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

    /** Required by TreeSelectionListener interface. */
	@Override
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
        	Coedil99View.getInstance().
        	getObserver(Coedil99View.getInstance().getCurrentPreventivo()).
        	addRow(nodeInfo.getClass().getName().split("\\.")[2]);
        	System.out.println("ciao, inserito elemento: " + nodeInfo.getClass().getName().split("\\.")[2]);
        } else {
            
        }
    }
	
}