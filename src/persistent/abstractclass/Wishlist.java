package persistent.abstractclass;

import java.util.HashMap;
import java.util.Map;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * @author IsilinBN
 *
 */
public abstract class Wishlist implements InterfaceModel {
	protected int ID = -1;
	protected String label = "";
	protected int userID = -1;
	protected Map<Integer, WishlistProduct> products = new HashMap<Integer, WishlistProduct>();
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Wishlist");
		}
		return this.ID;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * @return the userID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.userID == -1) {
			throw new NotFoundParameter("userID", "Wishlist");
		}
		return this.userID;
	}
	
	/**
	 * @return the products
	 */
	public Map<Integer, WishlistProduct> getProducts() {
		return this.products;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	/**
	 * @param products the products to set
	 */
	public void setProducts(Map<Integer, WishlistProduct> products) {
		this.products = products;
	}
}
