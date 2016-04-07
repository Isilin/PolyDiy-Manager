package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * A product contains ID, name, description, unitPrice and stockQuantity.
 * A product is created with his ID.
 * 
 * @author LoicDumas02
 * @version 1.0
 * @since 2016-03-19
 */
public abstract class Product implements InterfaceModel {
	protected int ID = -1;
	protected String name = "";
	protected String description = "";
	protected float unitPrice = 0;
	protected int stockQuantity = 0;
	protected int IDSeller = -1;
	protected int IDCategory = -1;
	
	/**
	 * @return the iDProduct
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Product");
		}
		return this.ID;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return this.unitPrice;
	}
	
	/**
	 * @return the stockQuantity
	 */
	public int getStockQuantity() {
		return this.stockQuantity;
	}
	
	/**
	 * @return the iDSeller
	 * @throws NotFoundParameter 
	 */
	public int getIDSeller() throws NotFoundParameter {
		if(this.IDSeller == -1) {
			throw new NotFoundParameter("IDSeller", "Product");
		}
		return this.IDSeller;
	}
	
	/**
	 * @return the iDCategory
	 * @throws NotFoundParameter 
	 */
	public int getIDCategory() throws NotFoundParameter {
		if(this.IDCategory == -1) {
			throw new NotFoundParameter("IDCategory", "Product");
		}
		return this.IDCategory;
	}
	
	/**
	 * @param iDProduct the iD to set
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	/**
	 * @param stockQuantity the stockQuantity to set
	 */
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	/**
	 * @param iDSeller the iDSeller to set
	 */
	public void setIDSeller(int IDSeller) {
		this.IDSeller = IDSeller;
	}
	
	/**
	 * @param iDCategory the iDCategory to set
	 */
	public void setIDCategory(int IDCategory) {
		this.IDCategory = IDCategory;
	}
}
