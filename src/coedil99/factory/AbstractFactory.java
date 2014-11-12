package coedil99.factory;

import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.model.MMagazzino;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.model.strategy.ITotaleStrategy;

public interface AbstractFactory {

	public EvasoState creaEvastoState();

	public NonEvasoState creaNonEvasoState();

	public MMagazzino creaMMagazzino();

	public MRaccoglitoreRDA creaMRaccoglitoreRDA();

	public ITotaleStrategy getSogliaDiscountStrategy();

	public ITotaleStrategy getBullonePercentDiscountStrategy();
}