package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class CategoryProduct implements InterfaceModel {
	protected int ID = -1;
	protected String title = "";
	protected String description = "";
	protected String shortDescription = "";
	protected int sellerID = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "CategoryProduct");
		}
		return this.ID;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return the shortDescription
	 */
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	/**
	 * @return the sellerID
	 * @throws NotFoundParameter 
	 */
	public int getSellerID() throws NotFoundParameter {
		if(this.sellerID == -1) {
			throw new NotFoundParameter("sellerID", "CategoryProduct");
		}
		return this.sellerID;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param shortDescription the shortDescription to set
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	/**
	 * @param sellerID the sellerID to set
	 */
	public void setSellerID(int sellerID) {
		this.sellerID = sellerID;
	}
}
