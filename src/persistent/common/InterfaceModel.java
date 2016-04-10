package persistent.common;

import java.util.List;

import common.exception.dev.AlreadyExistTuple;
import common.exception.dev.IncorrectMethodArguments;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;

/**
 * @author IsilinBN
 * Declare an interface for data models. A model should implements constructors, getters, setters, 
 * and the following methods.
 */
public interface InterfaceModel {
	/**
	 * Check if a tuple with same primary keys is register.
	 * @return True if a tuple exists with the same primary key, else false.
	 * @throws Exception
	 */
	public abstract Boolean isExisting();
	
	/**
	 * @return True if there is a tuple with same primary key, but different values, else false.
	 * @throws Exception
	 */
	public abstract Boolean hasChanged();
	
	/**
	 * Load model from database by looking for the primary keys.
	 * @param arguments List of primary keys
	 * @throws NotExistingTuple 
	 * @throws IncorrectMethodArguments 
	 * @throws NotUniqueAttribute 
	 * @throws Exception
	 */
	public abstract void loadFromKeys(List<String> columnNames, List<String> columnValues) throws NotUniqueAttribute, IncorrectMethodArguments, NotExistingTuple;
	
	/**
	 * If the model doesn't already exist, create a tuple.
	 * @throws AlreadyExistTuple 
	 * @throws Exception
	 */
	public abstract void insert() throws AlreadyExistTuple;
	
	/**
	 * If the model already exists as a tuple but has changed, update it.
	 * @throws NotExistingTuple 
	 * @throws Exception
	 */
	public abstract void update() throws NotExistingTuple;
	
	/**
	 * If the model is registered, delete it.
	 * @throws Exception
	 */
	public abstract void delete();
}
