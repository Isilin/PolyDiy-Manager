package common.jdbc;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jackson.map.ObjectMapper;

import common.exception.dev.AlertDriver;
import common.exception.dev.ErrorConnectionException;

/**
 * This class crate a connection to the DB with JDBC.
 * This class use the pattern Singleton, because we cannot have more than one connection.
 * 
 * @author loicd_000
 * @version 1.0
 * @since 2016-03-02
 */ 
public class JDBConnection {
	private Connection connection;
	static JDBConnection instance;
	
	/**
	 * @param user
	 * @param password
	 * @param URL
	 * @throws ErrorConnectionException
	 * @throws AlertDriver
	 */
	private JDBConnection(ConnectionParameter parameters) throws ErrorConnectionException, AlertDriver {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			throw new AlertDriver();
		}
		try {
			this.connection = DriverManager.getConnection(parameters.getUrl(), 
														parameters.getUser(), 
														parameters.getPassword());
		} catch (SQLException e) {
			throw new ErrorConnectionException();
		}
	}
	
	/**
	 * getInstance() return a JDBConnection. 
	 * Use the pattern singleton to have only one connection.
	 * 
	 * @author loicd_000
	 * @version 1.0
	 * @since 2016-03-02
	 * @return JDBConnection
	 * @throws AlertDriver 
	 */
	public static JDBConnection getInstance() throws ErrorConnectionException, AlertDriver {
		if (JDBConnection.instance == null) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				ConnectionParameter parameters = mapper.readValue(new File("src/config/connection.json"), 
																	ConnectionParameter.class);
				JDBConnection.instance = new JDBConnection(parameters);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return JDBConnection.instance;
	}
	
	/**
	 * @return a statement provided by the connection
	 * @throws SQLException
	 */
	public Statement getStatement() throws SQLException {
		return this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
											   ResultSet.CONCUR_READ_ONLY,
											   ResultSet.HOLD_CURSORS_OVER_COMMIT);
	}
	
	/**
	 * @param query
	 * @return a prepared statement provided by the connection.
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(String query) throws SQLException {
		return this.connection.prepareStatement(query,
												ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_READ_ONLY,
												ResultSet.HOLD_CURSORS_OVER_COMMIT);
	}
	
	public static Boolean isResult(Statement stmt) throws SQLException {
		ResultSet result = stmt.getResultSet();
		Boolean isResult = false;
		if(result != null) {
			isResult = result.first();
		}
		return isResult;
	}
}
