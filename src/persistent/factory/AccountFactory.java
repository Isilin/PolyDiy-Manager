package persistent.factory;

import common.exception.dev.ErrorConnectionException;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;
import persistent.abstractclass.Account;

/**
 * @author IsilinBN
 *
 */
public abstract class AccountFactory {
	/**
	 * @return an account
	 * @throws ErrorConnectionException 
	 */
	public abstract Account buildEmptyAccount() throws ErrorConnectionException;
	
	/**
	 * @param login
	 * @return
	 * @throws ErrorConnectionException
	 * @throws NotUniqueAttribute
	 * @throws NotExistingTuple
	 */
	public abstract Account buildAccountByLogin(String login) throws ErrorConnectionException, NotUniqueAttribute, NotExistingTuple;
	
	/**
	 * @param ID
	 * @return
	 * @throws ErrorConnectionException
	 * @throws NotUniqueAttribute
	 * @throws NotExistingTuple
	 */
	public abstract Account buildAccountByID(int ID) throws ErrorConnectionException, NotUniqueAttribute, NotExistingTuple;
}
