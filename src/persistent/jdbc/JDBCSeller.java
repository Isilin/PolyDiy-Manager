package persistent.jdbc;
/**
 * 
 * @author nassim vachor
 * @version 1.0
 * @since 2016-03-21
 */


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import common.exception.UnknownIDSellerException;
import common.exception.dev.AlertDriver;
import common.exception.dev.AlreadyExistTuple;
import common.exception.dev.ErrorConnectionException;
import common.exception.dev.NotExistingTuple;
import common.jdbc.JDBCComponent;
import common.jdbc.SQLCondition;
import persistent.abstractclass.Seller;


public class JDBCSeller extends Seller{
	private JDBCComponent component = null;

	/**
	 * This constructor of JDBCSeller which call seller constructor.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * return Description
	 */
	public JDBCSeller () throws ErrorConnectionException, AlertDriver {
		super();
		this .component = new JDBCComponent();
	}

	/**
	 * This is constructor of JDBCSeller with id, which is the idaccount of this seller
	 * with this id we load all informations of seller froom DB 
	 * 
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param ID
	 */
	public JDBCSeller(int ID) throws ErrorConnectionException, AlertDriver, UnknownIDSellerException {
		super(ID);
		this .component = new JDBCComponent();

		try {
			ResultSet result = this.component.select("*", "seller_account", "id_account = '" + this.ID + "'");
			if (result.first()) {
				this.nameShop = result.getString("nameShop");
				this.description = result.getString("description");
				this.siret = result.getString("siret");
				this.website = result.getString("website");			
			} else {
				throw new UnknownIDSellerException(ID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	
	/**
	 * This method check is the seller exist in DB
	 * 
	 * @author nassim vachor
	 * @since 2016-03-21
	 * @param IDProduct 
	 * @return Boolean
	 */
	@Override
	public Boolean isExisting() throws Exception {
		ResultSet result = this.component.select("*", "Seller_account", "id_account = '" + this.ID + "'");
		return result != null && result.first();
	}

	/**
	 * This method insert row in seller table of the seller exist.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	@Override
	public void insert() throws Exception {
		if(!this.isExisting()) {
			this.component.insert("Seller_account(nameshop,siret,website,description,id_account)", "'" + this.nameShop + "', '"  + this.description + "', '"  + this.siret + "', '"  + this.website + "', '" + this.IDaccount + "'");
		} else {
			throw new AlreadyExistTuple("Seller");
		}
	}
	/**
	 * This method update seller informations in DB if it exists.
	 * @author nassim vachor
	 * @since 2016-03-21
	 * 
	 */
	@Override
	public void update() throws Exception {
		if(this.isExisting()) {
			this.component.update("(nameshop, description, siret, website) = ('" + this.nameShop + "','" + this.description + "','" + this.siret + "','" +this.website + "')", "Seller_account","id_account = '" + this.ID + "'");
		} else {
			throw new NotExistingTuple("Seller");
		}
	}
	@Override
	public Boolean hasChanged() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() throws Exception {
		if(this.isExisting()) {
			this.component.delete("Seller_account", new SQLCondition(Arrays.asList("id_seller"),
																	Arrays.asList(Integer.toString(this.ID))));
		} else {
			throw new NotExistingTuple("Seller_account");
		}
	}
}
