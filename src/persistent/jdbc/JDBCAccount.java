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
import persistent.abstractclass.Account;

/**
 * This class extends from account. 
 * When you create the JDBCaccount you connect to the database to get the real password and the id.
 * If the login doesn't exist, throws UnknowLoginExcetion.
 * If the connection fail, throws ErrorConnectionException.
 * 
 * @author Isilin
 * @version 1.1
 * @since 2016-04-04
 *
 */
public class JDBCAccount extends Account {
	private JDBConnection connection = null;
	
	public JDBCAccount() throws ErrorConnectionException {
		super();
		this.connection = JDBConnection.getInstance();
	}

	@Override
	public Boolean isExisting() {
		PreparedStatement stmt = null;
		Boolean hasResult = false;
		try {
			stmt = this.connection.getPreparedStatement("SELECT id_account FROM Account WHERE id_account=?;");
			stmt.setInt(1, this.ID);
			stmt.execute();
			hasResult = JDBConnection.hasResult(stmt);
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return hasResult;
	}

	@Override
	public Boolean hasChanged() {
		PreparedStatement stmt = null;
		Boolean hasChanged = false;
		try {
			if(this.isExisting()) {
				stmt = this.connection.getPreparedStatement(
						"SELECT id_account FROM Account WHERE id_account=? AND login=? AND password=? AND email=? AND first_name=? AND last_name=? AND road=? AND city=? AND postal_code=?;");
				stmt.setInt(1, this.ID);
				stmt.setString(2, this.login);
				stmt.setString(3, this.password);
				stmt.setString(4, this.email);
				stmt.setString(5, this.name[Account.FIRST]);
				stmt.setString(6, this.name[LAST]);
				stmt.setString(7, this.address.getRoad());
				stmt.setString(8, this.address.getCity());
				stmt.setString(9, this.address.getPostal());
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

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws NotUniqueAttribute, IncorrectMethodArguments, NotExistingTuple {
		PreparedStatement stmt;
		if(columnNames.size() != 1) {
			throw new NotUniqueAttribute("", "Account");
		}
		if(columnNames.size() != columnValues.size()) {
			throw new IncorrectMethodArguments("JDBCAccount", "loadFromKeys");
		}
		try {
			switch(columnNames.get(0)) {
			case "ID":
				stmt = this.connection.getPreparedStatement("SELECT * FROM Account WHERE id_account=?;");
				stmt.setInt(1, Integer.parseInt(columnValues.get(0)));
				break;
			case "login":
				stmt = this.connection.getPreparedStatement("SELECT * FROM Account WHERE login=?;");
				stmt.setString(1, columnValues.get(0));
				break;
			default:
				throw new NotUniqueAttribute(columnNames.get(0), "Account");
			}
			stmt.execute();
			
			if(JDBConnection.hasResult(stmt)) {
				ResultSet result = stmt.getResultSet();
				this.ID = result.getInt("id_account");
				this.login = result.getString("login");
				this.password = result.getString("password");
				this.email = result.getString("email");
				this.name[Account.FIRST] = result.getString("first_name");
				this.name[Account.LAST] = result.getString("last_name");
				this.address.setRoad(result.getString("road"));
				this.address.setCity(result.getString("city"));
				this.address.setPostal(result.getString("postal_code"));
			} else {
				throw new NotExistingTuple("Account");
			}
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void insert() throws AlreadyExistTuple {
		if(!this.isExisting()) {
			PreparedStatement stmt = null;
			try {
				stmt = this.connection.getPreparedStatement(
						"INSERT INTO Account(login, password, email, first_name, last_name, road, city, postal_code) VALUES(?,?,?,?,?,?,?,?);");
				stmt.setString(1, this.login);
				stmt.setString(2, this.password);
				stmt.setString(3, this.email);
				stmt.setString(4, this.name[Account.FIRST]);
				stmt.setString(5, this.name[LAST]);
				stmt.setString(6, this.address.getRoad());
				stmt.setString(7, this.address.getCity());
				stmt.setString(8, this.address.getPostal());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			throw new AlreadyExistTuple("Account");
		}
	}

	@Override
	public void update() throws NotExistingTuple {
		if(this.isExisting()) {
			PreparedStatement stmt = null;
			try {
				stmt = this.connection.getPreparedStatement(
						"UPDATE Account SET (login, password, email, first_name, last_name, road, city, postal_code)=(?,?,?,?,?,?,?,?) WHERE id_account=?;");
				stmt.setString(1, this.login);
				stmt.setString(2, this.password);
				stmt.setString(3, this.email);
				stmt.setString(4, this.name[Account.FIRST]);
				stmt.setString(5, this.name[LAST]);
				stmt.setString(6, this.address.getRoad());
				stmt.setString(7, this.address.getCity());
				stmt.setString(8, this.address.getPostal());
				stmt.setInt(9, this.ID);
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		} else {
			throw new NotExistingTuple("Account");
		}
	}

	@Override
	public void delete() {
		PreparedStatement stmt = null;
		try {
			stmt = this.connection.getPreparedStatement("DELETE FROM Account WHERE id_account=?;");
			stmt.setInt(1, this.ID);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
	}
}
