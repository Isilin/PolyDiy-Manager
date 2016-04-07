package persistent.abstractclass;

import java.util.Date;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * @author IsilinBN
 *
 */
public abstract class Order implements InterfaceModel {
	protected int ID = -1;
	protected Date dateOrder = new Date();
	protected int totalPrice = 0;
	protected String deliveryAddress = "";
	protected int userID = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Order");
		}
		return this.ID;
	}
	
	/**
	 * @return the dateOrder
	 */
	public Date getDateOrder() {
		return this.dateOrder;
	}
	
	/**
	 * @return the totalPrice
	 */
	public int getTotalPrice() {
		return this.totalPrice;
	}
	
	/**
	 * @return the deliveryAddress
	 */
	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}
	
	/**
	 * @return the userID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.userID == -1) {
			throw new NotFoundParameter("userID", "Order");
		}
		return this.userID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param dateOrder the dateOrder to set
	 */
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
