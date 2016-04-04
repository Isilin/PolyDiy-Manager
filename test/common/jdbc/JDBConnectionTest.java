/**
 * 
 */
package common.jdbc;

import static org.junit.Assert.assertNotNull;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import common.exception.dev.AlertDriver;
import common.exception.dev.ErrorConnectionException;

/**
 * @author IsilinBN
 *
 */
public class JDBConnectionTest {
	private JDBConnection connection = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link common.jdbc.JDBConnection#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		try {
			this.connection = JDBConnection.getInstance();
		} catch (ErrorConnectionException | AlertDriver e) {
			e.printStackTrace();
		}
		assertNotNull(this.connection);
		
		try {
			assert(this.connection.getStatement() instanceof Statement);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link common.jdbc.JDBConnection#getStatement()}.
	 */
	@Test
	public void testGetStatement() {
		try {
			this.connection = JDBConnection.getInstance();
			Statement stmt = this.connection.getStatement();
			assertNotNull(stmt);
		} catch (ErrorConnectionException | AlertDriver | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link common.jdbc.JDBConnection#getPreparedStatement(java.lang.String)}.
	 */
	@Test
	public void testGetPreparedStatement() {
		try {
			this.connection = JDBConnection.getInstance();
			PreparedStatement stmt = this.connection.getPreparedStatement("SELECT * FROM Account;");
			assertNotNull(stmt);
		} catch (ErrorConnectionException | AlertDriver | SQLException e) {
			e.printStackTrace();
		}
	}

}
