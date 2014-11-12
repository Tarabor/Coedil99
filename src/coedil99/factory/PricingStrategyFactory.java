package coedil99.factory;

import coedil99.model.strategy.BullonePercentDiscountStrategy;
import coedil99.model.strategy.ITotaleStrategy;
import coedil99.model.strategy.SogliaDiscountStrategy;


public class PricingStrategyFactory {

	private static PricingStrategyFactory instance;
	
	public static PricingStrategyFactory getInstance(){
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
	
}