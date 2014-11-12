package coedil99.factory;

import coedil99.model.MMagazzino;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.model.strategy.ITotaleStrategy;

public class MagazzinoFactory implements AbstractFactory {
	private MagazzinoFactory instance;

	public MagazzinoFactory getInstance() {
		if(instance == null)
			instance = new MagazzinoFactory();
				
		return instance;
	}

	public MMagazzino creaMMagazzino() {
		throw new UnsupportedOperationException();
	}

	public MRaccoglitoreRDA creaMRaccoglitoreMDA() {
		throw new UnsupportedOperationException();
	}

	public EvasoState creaEvastoState() {
		throw new UnsupportedOperationException();
	}

	public NonEvasoState creaNonEvasoState() {
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