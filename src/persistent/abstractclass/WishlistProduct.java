package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;

/**
 * @author IsilinBN
 *
 */
public abstract class WishlistProduct extends Product {
	protected int ID = -1;
	protected int wishlistID = -1;
	protected int quantity = 0;
	protected float savedUnitPrice = 0;

	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "WishlistProduct");
		}
		return this.ID;
	}
	
	/**
	 * @return the wishlistID
	 * @throws NotFoundParameter 
	 */
	public int getWishlistID() throws NotFoundParameter {
		if(this.wishlistID == -1) {
			throw new NotFoundParameter("wishlistID", "WishlistProduct");
		}
		return this.wishlistID;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * @return the savedUnitPrice
	 */
	public float getSavedUnitPrice() {
		return this.savedUnitPrice;
	}
	
	/**
	 * @param iDProduct the iD to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 * @param wishlistID the wishlistID to set
	 */
	public void setWishlistID(int wishlistID) {
		this.wishlistID = wishlistID;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @param savedUnitPrice the savedUnitPrice to set
	 */
	public void setSavedUnitPrice(int savedUnitPrice) {
		this.savedUnitPrice = savedUnitPrice;
	}

}
