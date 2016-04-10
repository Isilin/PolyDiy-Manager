package persistent.factory.jdbc;

import java.util.Arrays;
import java.util.List;

import common.exception.dev.ErrorConnectionException;
import common.exception.dev.IncorrectMethodArguments;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;
import persistent.abstractclass.Account;
import persistent.factory.AccountFactory;
import persistent.jdbc.JDBCAccount;

/**
 * @author IsilinBN
 *
 */
public class JDBCAccountFactory extends AccountFactory {

	/* (non-Javadoc)
	 * @see persistent.factory.AccountFactory#buildEmptyAccount()
	 */
	@Override
	public Account buildEmptyAccount() throws ErrorConnectionException {
		return new JDBCAccount();
	}

	/* (non-Javadoc)
	 * @see persistent.factory.AccountFactory#buildAccountWithLogin(java.lang.String)
	 */
	@Override
	public Account buildAccountByLogin(String login) throws ErrorConnectionException, NotUniqueAttribute, NotExistingTuple {
		Account account = new JDBCAccount();
		
		List<String> keys = Arrays.asList("login");
		List<String> values = Arrays.asList(login);
		
		try {
			account.loadFromKeys(keys, values);
		} catch (IncorrectMethodArguments e) {
			System.err.println(e.getMessage());
		}
		return account;
	}

	/* (non-Javadoc)
	 * @see persistent.factory.AccountFactory#buildAccountWithID(int)
	 */
	@Override
	public Account buildAccountByID(int ID) throws ErrorConnectionException, NotUniqueAttribute, NotExistingTuple {
		Account account = new JDBCAccount();
		
		List<String> keys = Arrays.asList("id");
		List<String> values = Arrays.asList(Integer.toString(ID));
		
		try {
			account.loadFromKeys(keys, values);
		} catch (IncorrectMethodArguments e) {
			System.err.println(e.getMessage());
		}
		return account;
	}

}
