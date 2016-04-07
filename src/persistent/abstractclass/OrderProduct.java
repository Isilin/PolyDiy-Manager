package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class OrderProduct implements InterfaceModel {
	protected int ID = -1;
	protected int orderID = -1;
	protected int quantity = 0;
	protected float price = 0;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "OrderProduct");
		}
		return this.ID;
	}
	
	/**
	 * @return the orderID
	 * @throws NotFoundParameter 
	 */
	public int getOrderID() throws NotFoundParameter {
		if(this.orderID == -1) {
			throw new NotFoundParameter("OrderID", "OrderProduct");
		}
		return this.orderID;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}
	
	/**
	 * @return the price
	 */
	public float getPrice() {
		return this.price;
	}
	
	/**
	 * @param iDProduct the iD to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 * @param orderID the orderID to set
	 */
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
