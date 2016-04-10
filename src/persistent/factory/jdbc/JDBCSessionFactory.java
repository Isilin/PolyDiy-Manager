/**
 * 
 */
package persistent.factory.jdbc;

import java.util.Arrays;
import java.util.List;

import common.exception.dev.ErrorConnectionException;
import common.exception.dev.IncorrectMethodArguments;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;
import persistent.abstractclass.Session;
import persistent.factory.SessionFactory;
import persistent.jdbc.JDBCSession;

/**
 * @author IsilinBN
 *
 */
public class JDBCSessionFactory extends SessionFactory {

	/* (non-Javadoc)
	 * @see persistent.factory.SessionFactory#buildSessionWithToken(int)
	 */
	@Override
	public Session buildEmptySession() throws ErrorConnectionException {
		return new JDBCSession();
	}

	/* (non-Javadoc)
	 * @see persistent.factory.SessionFactory#buildSessionByID(int)
	 */
	@Override
	public Session buildSessionByID(int ID) throws ErrorConnectionException, NotUniqueAttribute, NotExistingTuple {
		Session session = new JDBCSession();
		List<String> keys = Arrays.asList("id");
		List<String> values = Arrays.asList(Integer.toString(ID));
		
		try {
			session.loadFromKeys(keys, values);
		} catch (IncorrectMethodArguments e) {
			System.err.println(e.getLocalizedMessage());
		}
		return session;
	}

}
