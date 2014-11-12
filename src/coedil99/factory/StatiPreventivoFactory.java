package coedil99.factory;

import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.model.MMagazzino;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.model.strategy.ITotaleStrategy;

public class StatiPreventivoFactory implements AbstractFactory {
	private StatiPreventivoFactory instance;

	public StatiPreventivoFactory getInstance() {
		if(instance == null)
			instance = new StatiPreventivoFactory();
				
		return instance;
	}

	public EvasoState creaEvasoState() {
		throw new UnsupportedOperationException();
	}

	public NonEvasoState creaNonEvasoState() {
		throw new UnsupportedOperationException();
	}

	public EvasoState creaEvastoState() {
		throw new UnsupportedOperationException();
	}

	public MMagazzino creaMMagazzino() {
		throw new UnsupportedOperationException();
	}

	public MRaccoglitoreRDA creaMRaccoglitoreRDA() {
		throw new UnsupportedOperationException();
	}

	public ITotaleStrategy getSogliaDiscountStrategy() {
		throw new UnsupportedOperationException();
	}

	public ITotaleStrategy getBullonePercentDiscountStrategy() {
		throw new UnsupportedOperationException();
	}
}