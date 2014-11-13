package coedil99.factory;

import coedil99.persistentmodel.EvasoState;
import coedil99.persistentmodel.NonEvasoState;
import coedil99.model.MMagazzino;
import coedil99.model.MRaccoglitoreRDA;
import coedil99.model.strategy.ITotaleStrategy;

public interface AbstractFactory {

	public EvasoState creaEvastoState();

	public NonEvasoState creaNonEvasoState();

	public void creaMMagazzino(int id);

	public void creaMRaccoglitoreRDA(int id);

	public ITotaleStrategy getSogliaDiscountStrategy();

	public ITotaleStrategy getBullonePercentDiscountStrategy();
}