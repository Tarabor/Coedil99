package coedil99.Model;

import coedil99.PersistentModel.APersistentModel;

public interface AModel {

	public APersistentModel getPersistentModel();

	public void setPersistentModel(APersistentModel model);
}