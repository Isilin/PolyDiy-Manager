package persistent.jdbc.list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.exception.UnknownIDProductException;
import common.exception.dev.AlertDriver;
import common.exception.dev.AlreadyExistTuple;
import common.exception.dev.ErrorConnectionException;
import common.exception.dev.NotExistingTuple;
import common.jdbc.JDBCComponent;
import persistent.abstractclass.list.ProductWishList;

/**
 * the jdbc version of ProductWishList
 * @author loicd_000
 *
 */
public class JDBCProductWishList extends ProductWishList{
	private JDBCComponent component = null;

	/**
	 * @param ID
	 * @param IDWishList
	 * @param quantity
	 * @param unitPrice
	 * @throws ErrorConnectionException
	 * @throws UnknownIDProductException
	 * @throws AlertDriver
	 */
	public JDBCProductWishList(int ID, int IDWishList, int quantity, float unitPrice) 
			throws ErrorConnectionException, UnknownIDProductException, AlertDriver {
		super(ID, IDWishList);
		this.component = new JDBCComponent();
				
		try {
			ResultSet result = this.component.select("*", "product", "id_product = '" + this.IDProduct + "'");
			if (result.first()) {
				this.name = result.getString("name");
				this.description = result.getString("description");
				this.unitPrice = unitPrice;
				this.quantity = quantity;
			} else {
				throw new UnknownIDProductException(ID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#isExisting()
	 */
	@Override
	public Boolean isExisting() throws Exception {
		this.component = new JDBCComponent();
		ResultSet result = this.component.select("*", "item_wishlist "
				, "id_wishlist = " +   this.IDWishList +" AND id_product = " + this.IDProduct );
		return result.first();
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#insert()
	 */
	@Override
	public void insert() throws Exception {
		this.component = new JDBCComponent();
		
		if (!this.isExisting()) {
			this.component.insert("item_wishlist(id_wishlist, id_product, quantity, unitprice )",
					" '" + this.IDWishList + "', '" + this.IDProduct + "' , '" + this.quantity + "' , '" + this.unitPrice + "'");
		} else {
			throw new AlreadyExistTuple("WishList");
		}
		
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#update()
	 */
	@Override
	public void update() throws Exception {
		this.component = new JDBCComponent();
		if(this.isExisting()) {
			this.component.update("(id_wishlist, id_product, quantity, unitprice) = (" + this.IDWishList + "," 
		                           + this.IDProduct + "," + this.quantity + "," + this.unitPrice + ")",
		                           "item_wishlist", "id_product = " + this.IDProduct + "AND id_wishlist = " + this.IDWishList );
		} else {
			throw new NotExistingTuple("item_wishlist");
		}
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#delete()
	 */
	@Override
	public void delete() throws Exception {
		this.component = new JDBCComponent();
		this.component.delete("item_wishList", "id_product = " + this.IDProduct + " AND id_wishlist = " + this.IDWishList);
		
		
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#hasChanged()
	 */
	@Override
	public Boolean hasChanged() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistent.abstractclass.InterfaceModel#loadFromKeys(java.util.List, java.util.List)
	 */
	@Override
	public void loadFromKeys(List<String> columnNames, List<String> columnValues) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
