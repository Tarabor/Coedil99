package coedil99.ui.template;

import javax.swing.JTabbedPane;

public class TabSchede extends JTabbedPane{
	
	private int tab_counter;
	
	public TabSchede(){
		super(JTabbedPane.TOP);
		tab_counter = 0;
	}
	
	public int getTabCount(){
		return tab_counter;
	}
	
	public void increaseTabCount(){
		tab_counter++;
	}
	
	public void decreaseTabCount(){
		if(tab_counter !=1)
			tab_counter--;
	}
}