package persistent.factory.jdbcFactory;
/**
 * @author nassim vachor, loic
 * @version 1.0
 * @since 2016-03-21
 */

import common.exception.NoCartException;
import common.exception.NeedHaveBothIDUserAndLabelException;
import common.exception.WishListAlreadyExistException;
import common.exception.dev.AlertDriver;
import common.exception.dev.ErrorConnectionException;
import persistent.abstractclass.list.Cart;
import persistent.abstractclass.list.SetInfoWishList;
import persistent.abstractclass.list.SetProduct;
import persistent.abstractclass.list.SetWishList;
import persistent.abstractclass.list.WishList;
import persistent.factory.ListFactory;
import persistent.jdbc.JDBCSetProduct;
import persistent.jdbc.list.JDBCCart;
import persistent.jdbc.list.JDBCSetInfoWishList;
import persistent.jdbc.list.JDBCSetWishList;
import persistent.jdbc.list.JDBCWishList;

public class JDBCListFactory extends ListFactory{

	@Override
	public WishList buildWishList(int IDWishList) throws ErrorConnectionException, AlertDriver {
		return new JDBCWishList(IDWishList);
	}
	
	/**
	 * this method build a wish list from an IDUser and a labelWishList
	 * @return The WishList created;
	 */
	@Override
	public WishList buildWishList(int IDUser, String labelWishList) throws WishListAlreadyExistException {
		JDBCWishList wishList = null;
		try {
			wishList = new JDBCWishList(IDUser, labelWishList);
		} catch (NeedHaveBothIDUserAndLabelException e) {
			e.printStackTrace();
		} 
		
		return wishList;
	}

	@Override
	public SetWishList buildSetWishList(int IDUser) throws  AlertDriver, ErrorConnectionException {
		return new JDBCSetWishList(IDUser);
	}

	@Override
	public SetInfoWishList buildSetInfoWishList(int IDUser) throws  AlertDriver, ErrorConnectionException {
		return new JDBCSetInfoWishList(IDUser);
	}

	@Override
	public Cart buildCart(int IDUser) throws ErrorConnectionException, AlertDriver, NoCartException {
		return new JDBCCart(IDUser);
	}

	@Override
	public SetProduct buildSetProduct(int IDSeller) throws ErrorConnectionException, AlertDriver {
		return new JDBCSetProduct(IDSeller);
	}

	@Override
	public SetProduct buildSetProduct() throws ErrorConnectionException, AlertDriver {
		return new JDBCSetProduct();
	}
}
