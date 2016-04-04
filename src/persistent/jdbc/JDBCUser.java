package persistent.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import common.exception.dev.AlertDriver;
import common.exception.dev.AlreadyExistTuple;
import common.exception.dev.ErrorConnectionException;
import common.exception.dev.IncorrectMethodArguments;
import common.exception.dev.NotExistingTuple;
import common.exception.dev.NotUniqueAttribute;
import common.jdbc.JDBConnection;
import persistent.abstractclass.User;

public class JDBCUser extends User {
	private JDBConnection connection = null;
	
	public JDBCUser() throws ErrorConnectionException, AlertDriver {
		super();
		this.connection = JDBConnection.getInstance();
	}
	
	@Override
	public Boolean isExisting() throws Exception {
		PreparedStatement stmt = this.connection.getPreparedStatement(
				"SELECT id_user FROM User_account WHERE id_user=?;");
		stmt.setInt(1, this.ID);
		stmt.execute();
		Boolean hasResult = JDBConnection.hasResult(stmt);
		stmt.close();
		return hasResult;
	}

	@Override
	public Boolean hasChanged() throws Exception {
		Boolean hasChanged = false;
		if(this.isExisting()) {
			PreparedStatement stmt = this.connection.getPreparedStatement(
					"SELECT id_user FROM User_account WHERE id_user=? AND id_account=?;");
			stmt.setInt(1, this.ID);
			stmt.setInt(2, this.IDaccount);
			stmt.execute();
			Boolean hasResult = JDBConnection.hasResult(stmt);
			stmt.close();
			hasChanged = !hasResult;
		}
		return hasChanged;
	}

	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		PreparedStatement stmt;
		if(columnNames.size() != 1) {
			throw new NotUniqueAttribute("", "User_account");
		}
		if(columnNames.size() != columnValues.size()) {
			throw new IncorrectMethodArguments("JDBCUser", "loadFromKeys");
		}
		switch(columnNames.get(0)) {
		case "ID":
			stmt = this.connection.getPreparedStatement("SELECT * FROM User_account WHERE id_user=?;");
			stmt.setInt(1, Integer.parseInt(columnValues.get(0)));
			break;
		case "IDaccount":
			stmt = this.connection.getPreparedStatement("SELECT * FROM User_account WHERE id_account=?;");
			stmt.setInt(1, Integer.parseInt(columnValues.get(0)));
			break;
		default:
			throw new NotUniqueAttribute(columnNames.get(0), "User_account");
		}
		stmt.execute();
		
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			this.ID = result.getInt("id_user");
			this.IDaccount = result.getInt("id_account");
		} else {
			throw new NotExistingTuple("User_account");
		}
		stmt.close();
		
		stmt = this.connection.getPreparedStatement("SELECT id_journal_entry FROM Journal_entry WHERE id_user=?;");
		stmt.setInt(1, this.ID);
		stmt.execute();
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			do {
				this.journalEntryIDs.add(result.getInt("id_journal_entry"));
			} while(result.next());
		}
		stmt.close();
		
		stmt = this.connection.getPreparedStatement("SELECT id_category FROM Category WHERE id_user=?;");
		stmt.setInt(1, this.ID);
		stmt.execute();
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			do {
				this.categoryIDs.add(result.getInt("id_category"));
			} while(result.next());
		}
		stmt.close();
		
		// TODO proposedActivityCategory : generate table
		/*stmt = this.connection.getPreparedStatement("SELECT id_category FROM Category WHERE id_user=?");
		stmt.setInt(1, this.ID);
		stmt.execute();
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			do {
				this.categoryIDs.add(result.getInt("id_category"));
			} while(result.next());
		}
		stmt.close();*/
		
		stmt = this.connection.getPreparedStatement(
				"SELECT id_wishlist FROM Wishlist WHERE id_user=? AND label!='Cart';");
		stmt.setInt(1, this.ID);
		stmt.execute();
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			do {
				this.wishlistIDs.add(result.getInt("id_wishlist"));
			} while(result.next());
		}
		stmt.close();
		
		stmt = this.connection.getPreparedStatement(
				"SELECT id_wishlist FROM Wishlist WHERE id_user=? AND label!='Cart';");
		stmt.setInt(1, this.ID);
		stmt.execute();
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			this.cartID = result.getInt("id_wishlist");
		}
		stmt.close();
		
		// TODO requestedEstimate : generate table
		/*stmt = this.connection.getPreparedStatement(
				"SELECT id_wishlist FROM Wishlist WHERE id_user=? AND label!='Cart';");
		stmt.setInt(1, this.ID);
		stmt.execute();
		if(JDBConnection.hasResult(stmt)) {
			ResultSet result = stmt.getResultSet();
			do {
				this.wishlistIDs.add(result.getInt("id_wishlist"));
			} while(result.next());
		}
		stmt.close();*/
	}

	@Override
	public void insert() throws Exception {
		if(!this.isExisting()) {
			PreparedStatement stmt = this.connection.getPreparedStatement(
					"INSERT INTO User_account(id_account) VALUES(?);");
			stmt.setInt(1, this.IDaccount);
			stmt.execute();
			stmt.close();
		} else {
			throw new AlreadyExistTuple("User_account");
		}
	}

	@Override
	public void update() throws Exception {
		if(this.isExisting()) {
			PreparedStatement stmt = this.connection.getPreparedStatement(
					"UPDATE User_account SET (id_account)=(?) WHERE id_user=?;");
			stmt.setInt(1, this.IDaccount);
			stmt.setInt(2, this.ID);
			stmt.execute();
			stmt.close();
		} else {
			throw new NotExistingTuple("User_account");
		}
	}

	@Override
	public void delete() throws Exception {		
		PreparedStatement stmt = this.connection.getPreparedStatement("DELETE FROM User_account WHERE id_user=?;");
		stmt.setInt(1, this.ID);
		stmt.execute();
		stmt.close();
	}

}
