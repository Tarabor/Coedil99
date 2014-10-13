package coedil99.utility;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class StrictInputVerifier extends InputVerifier {
    private String validString;

    public StrictInputVerifier(String validString) {
        this.validString = validString;
    }
	public boolean verify(JComponent input) {	
		return !validString.equals(((JTextField) input).getText());
    }
}