package coedil99.factory;

import coedil99.model.strategy.BullonePercentDiscountStrategy;
import coedil99.model.strategy.ITotaleStrategy;
import coedil99.model.strategy.SogliaDiscountStrategy;
import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.model.MMagazzino;
import coedil99.model.MRaccoglitoreRDA;

public class PricingStrategyFactory implements AbstractFactory {
	private static PricingStrategyFactory instance;

	public static PricingStrategyFactory getInstance() {
		if(instance == null)
			instance = new PricingStrategyFactory();
				
		return instance;
	}

	public ITotaleStrategy getBullonePercentDiscountStrategy() {
		return new BullonePercentDiscountStrategy();
	}

	public ITotaleStrategy getSogliaDiscountStrategy() {
		return new SogliaDiscountStrategy();
	}

	public EvasoState creaEvastoState() {
		throw new UnsupportedOperationException();
	}

	public NonEvasoState creaNonEvasoState() {
		throw new UnsupportedOperationException();
	}

	public MMagazzino creaMMagazzino() {
		throw new UnsupportedOperationException();
	}

	public MRaccoglitoreRDA creaMRaccoglitoreRDA() {
		throw new UnsupportedOperationException();
	}
}