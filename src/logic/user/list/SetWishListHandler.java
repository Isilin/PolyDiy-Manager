package logic.user.list;

import java.util.Set;

import common.exception.WishListAlreadyExistException;
import common.exception.dev.AlertDriver;
import common.exception.dev.AlreadyExistTuple;
import common.exception.dev.ErrorConnectionException;
import persistent.abstractclass.list.SetWishList;
import persistent.abstractclass.list.WishList;
import persistent.factory.ListFactory;
import persistent.factory.jdbc.JDBCListFactory;

/**
 * Handler for the SetWishListHandler (logic part)
 * @author loicd_000
 *
 */
public class SetWishListHandler {
	ListFactory listFactory = new JDBCListFactory();
	protected SetWishList setWishList = null;
	

	/**
	 * This method create and return the SetWishList with the IDUser in parameter. 
	 * If the instance has already a set wish list, return this existing wishList.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDUser - int
	 * @return SetWishList
	 */
	public SetWishList createAndGetExistingWishList(int IDUser) {
		if (this.setWishList == null) { // if there's no wishList
			try {
				try {
					this.setWishList = listFactory.buildSetWishList(IDUser);
				} catch (AlertDriver e) {
					e.printStackTrace();
				}
			} catch (ErrorConnectionException e) {
				System.err.println("Impossible to return the WishList");
				e.printStackTrace();
			}
		}

		return this.setWishList;
	}
	
	
	/**
	 * 
	 * 
	 * @author loicd_000
	 * @param IDUser
	 * @param label
	 * @throws WishListAlreadyExistException 
	 */
	public void createWishList(int IDUser, String label) throws WishListAlreadyExistException {
		this.setWishList.addElement("0", listFactory.buildWishList(IDUser, label));
		
		try {
			this.setWishList.getElementByKey("0").insert();
		} catch (AlreadyExistTuple e) {
			throw new  WishListAlreadyExistException(label) ;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * This method return a set of the keys contained in this SetWishList
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @return a set of the keys contained in this SetWishList
	 */
	public Set<String> getListID() {
		if (this.setWishList == null) {
			System.err.println("No SetWishlist initialized.");
		} 
		return this.setWishList.getAllKeys() ; 
	}
	

	/**
	 * This method return the wishList (with ID) from the SetWishList of this instance of class.
	 * 
	 * @author loicd_000
	 * @since 2016-03-21
	 * @param IDWishList - String
	 * @return The wishList (with ID) from the SetWishList of this instance of class. Or null.
	 */
	public WishList getWishListWithIDInSetWishList(String IDWishList) {
		if (this.setWishList == null) {
			System.err.println("No ishlist initialized.");
		}  else if (this.setWishList.containsKey(IDWishList) ) {
			System.err.println("The SetWishList don't have any wishList with ID : " + IDWishList);
		}
		
		return this.setWishList.getElementByKey(IDWishList);
	}
	
	
	/**
	 * Return The name of the wishList 
	 * 
	 * @author loicd_000
	 * @param IDWishList - String
	 * @return The name of the wishList
	 */
	public String getNameWishList(String IDWishList) {
		if (this.setWishList == null) {
			System.err.println("No SetWishlist initialized.");
		} else if (this.setWishList.containsKey(IDWishList) ) {
			System.err.println("The SetWishList don't have any wishList with ID : " + IDWishList);
		}
		
		return this.setWishList.getElementByKey(IDWishList).getLabel();
	}
	


	/**
	 * Delete all elements of the IDwishlist in parameter
	 * @param iDWishList - the wishliste to delete
	 * @throws Exception 
	 */
	
	public void deleteWishList(int IDWishList) throws Exception {
		this.setWishList.getElementByKey(String.valueOf(IDWishList)).delete();
	}


	/**
	 * the number of products in the wishlist
	 * @param IDWishList
	 * @return the number of products in the wishlist
	 */
	public int getNumberOfProductsInWishList(int IDWishList) {
		return this.setWishList.getElementByKey(String.valueOf(IDWishList)).getNumberOfProductInWishList();
	}
	
}
