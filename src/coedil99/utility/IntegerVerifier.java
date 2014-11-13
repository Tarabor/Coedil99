package coedil99.utility;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class IntegerVerifier extends InputVerifier{
    private String number;

	public IntegerVerifier(String number) {
        this.number = number;
    }
	
	@Override
	public boolean verify(JComponent input) {
		String numberInserito = ((JTextField) input).getText();
		if(number.equals(numberInserito)){
	        return false;
		}
	    try {
	        Integer value = Integer.parseInt(numberInserito);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

}