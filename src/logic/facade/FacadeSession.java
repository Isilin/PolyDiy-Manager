package logic.facade;

import common.exception.dev.NotFoundParameter;
import common.exception.user.ErrorPasswordException;
import logic.session.LoginChecker;
import logic.session.SessionHandler;
import persistent.abstractclass.Account;
import persistent.abstractclass.Session;

/**
 * This class contains a function to connect the user.
 * 
 * @author Pierre Casati
 * @version 1.0
 * @since 2016-03-03
 */
public class FacadeSession {
	public FacadeSession() {

	}

	/**
	 * This function connect the user. And return a token of the connection.
	 * 
	 * @author Pierre Casati
	 * @version 1.0
	 * @since 2016-03-03
	 * @param String
	 *            : Login
	 * @param String
	 *            : password
	 * @return String : the token of the connection is returned.
	 * @throws Exception 
	 * @throws NotFoundParameter 
	 */
	public Session login(Account account) throws Exception {
		Session session = null;
		LoginChecker checker = new LoginChecker();
		checker.generateAccount(account.getLogin());
		if (checker.isValidPassword(account.getPassword())) {
			SessionHandler handler = new SessionHandler();
			session = handler.login(checker.getAccount().getID());
		} else {
			throw new ErrorPasswordException();
		}
		return session;
	}
	
	public void logout(int ID) throws Exception {
		SessionHandler handler = new SessionHandler();
		handler.logout(ID);
	}

}
