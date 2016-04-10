package persistent.factory;

import common.exception.dev.ErrorConnectionException;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;
import persistent.abstractclass.Session;

/**
 * @author IsilinBN
 *
 */
public abstract class SessionFactory {
	/**
	 * @param ID
	 * @return
	 * @throws ErrorConnectionException 
	 * @throws NotExistingTuple 
	 * @throws NotUniqueAttribute 
	 */
	public abstract Session buildEmptySession() throws ErrorConnectionException;
	
	/**
	 * @param ID
	 * @return
	 * @throws ErrorConnectionException 
	 * @throws NotExistingTuple 
	 * @throws NotUniqueAttribute 
	 */
	public abstract Session buildSessionByID(int ID) throws ErrorConnectionException, NotUniqueAttribute, NotExistingTuple;
}
