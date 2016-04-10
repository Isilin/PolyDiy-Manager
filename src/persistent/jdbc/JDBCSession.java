/**
 * 
 */
package persistent.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.dev.AlreadyExistTuple;
import common.exception.dev.ErrorConnectionException;
import common.exception.dev.IncorrectMethodArguments;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;
import common.jdbc.JDBConnection;
import persistent.abstractclass.Session;

/**
 * @author IsilinBN
 *
 */
public class JDBCSession extends Session {
	private JDBConnection connection = null;
	
	public JDBCSession() throws ErrorConnectionException {
		super();
		this.connection = JDBConnection.getInstance();
	}

	/* (non-Javadoc)
	 * @see persistent.common.InterfaceModel#isExisting()
	 */
	@Override
	public Boolean isExisting() {
		PreparedStatement stmt = null;
		Boolean hasResult = false;
		try {
			stmt = this.connection.getPreparedStatement("SELECT token FROM session WHERE id_account=?");
			stmt.setInt(1, this.ID);
			stmt.execute();
			hasResult = JDBConnection.hasResult(stmt);
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return hasResult;
	}

	/* (non-Javadoc)
	 * @see persistent.common.InterfaceModel#hasChanged()
	 */
	@Override
	public Boolean hasChanged() {
		PreparedStatement stmt = null;
		Boolean hasChanged = false;
		try {
			if(this.isExisting()) {
				stmt = this.connection.getPreparedStatement(
						"SELECT token FROM session WHERE id_account=? AND token=?;");
				stmt.setInt(1, this.ID);
				stmt.setString(2, this.token);
				stmt.execute();
				Boolean hasResult = JDBConnection.hasResult(stmt);
				stmt.close();
				hasChanged =  !hasResult;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return hasChanged;
	}

	/* (non-Javadoc)
	 * @see persistent.common.InterfaceModel#loadFromKeys(java.util.List, java.util.List)
	 */
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues)
			throws NotUniqueAttribute, IncorrectMethodArguments, NotExistingTuple {
		PreparedStatement stmt;
		if(columnNames.size() != 1) {
			throw new NotUniqueAttribute("", "Session");
		}
		if(columnNames.size() != columnValues.size()) {
			throw new IncorrectMethodArguments("JDBCSession", "loadFromKeys");
		}
		try {
			switch(columnNames.get(0)) {
			case "ID":
				stmt = this.connection.getPreparedStatement("SELECT * FROM Session WHERE id_account=?;");
				stmt.setInt(1, Integer.parseInt(columnValues.get(0)));
				break;
			case "token":
				stmt = this.connection.getPreparedStatement("SELECT * FROM Session WHERE token=?;");
				stmt.setString(1, columnValues.get(0));
				break;
			default:
				throw new NotUniqueAttribute(columnNames.get(0), "Session");
			}
			stmt.execute();
			
			if(JDBConnection.hasResult(stmt)) {
				ResultSet result = stmt.getResultSet();
				this.ID = result.getInt("id_account");
				this.token = result.getString("token");
			} else {
				throw new NotExistingTuple("Session");
			}
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	/* (non-Javadoc)
	 * @see persistent.common.InterfaceModel#insert()
	 */
	@Override
	public void insert() throws AlreadyExistTuple {
		if(!this.isExisting()) {
			PreparedStatement stmt = null;
			try {
				stmt = this.connection.getPreparedStatement(
						"INSERT INTO Account(id_account, token) VALUES(?,?);");
				stmt.setInt(1, this.ID);
				stmt.setString(2, this.token);
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			throw new AlreadyExistTuple("Session");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.common.InterfaceModel#update()
	 */
	@Override
	public void update() throws NotExistingTuple {
		if(this.isExisting()) {
			PreparedStatement stmt = null;
			try {
				stmt = this.connection.getPreparedStatement(
						"UPDATE Session SET (token)=(?) WHERE id_account=?;");
				stmt.setString(1, this.token);
				stmt.setInt(2, this.ID);
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			throw new NotExistingTuple("Session");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.common.InterfaceModel#delete()
	 */
	@Override
	public void delete() {
		PreparedStatement stmt = null;
		try {
			stmt = this.connection.getPreparedStatement("DELETE FROM Session WHERE id_account=?;");
			stmt.setInt(1, this.ID);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
