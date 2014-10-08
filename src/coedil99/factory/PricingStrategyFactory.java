package coedil99.factory;

import coedil99.model.strategy.BullonePercentDiscountStrategy;
import coedil99.model.strategy.ITotaleStrategy;
import coedil99.model.strategy.SogliaDiscountStrategy;


public class PricingStrategyFactory {

	private static PricingStrategyFactory instance;
	
	private BullonePercentDiscountStrategy bulloneStrategy = new BullonePercentDiscountStrategy();
	private SogliaDiscountStrategy sogliaStrategy = new SogliaDiscountStrategy();
	
	public static PricingStrategyFactory getInstance(){
		if(instance == null)
			instance = new PricingStrategyFactory();
		
		return instance;
	}
	
	public ITotaleStrategy getBullonePercentDiscountStrategy() {
		return bulloneStrategy;
	}
	
	public ITotaleStrategy getSogliaDiscountStrategy() {
		return sogliaStrategy;
	}
	
}