package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class Estimate implements InterfaceModel {
	protected int ID = -1;
	protected int productID = -1;
	protected int userID = -1;
	protected int price = 0;
	protected int quantity = 0;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Estimate");
		}
		return this.ID;
	}
	
	/**
	 * @return the productID
	 * @throws NotFoundParameter 
	 */
	public int getProductID() throws NotFoundParameter {
		if(this.productID == -1) {
			throw new NotFoundParameter("productID", "Estimate");
		}
		return this.productID;
	}
	
	/**
	 * @return the userID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.userID == -1) {
			throw new NotFoundParameter("userID", "Estimate");
		}
		return this.userID;
	}
	
	/**
	 * @return the price
	 */
	public int getPrice() {
		return this.price;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param productID the productID to set
	 */
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
