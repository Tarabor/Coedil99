package coedil99.utility;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class FloatVerifier extends InputVerifier{
    private String number;

	public FloatVerifier(String number) {
        this.number = number;
    }
	
	@Override
	public boolean verify(JComponent input) {
		String numberInserito = ((JTextField) input).getText();
		if(number.equals(numberInserito)){
	        return false;
		}
	    try {
	        Float value = Float.parseFloat(numberInserito);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

}
