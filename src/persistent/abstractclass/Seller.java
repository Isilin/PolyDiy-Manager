package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * A seller contains ID, nameShop, description, siret and website.
 * A seller is created with his ID.
 * 
 * @author IsilinBN
 * @version 1.1
 * @since 2016-04-07
 */

public abstract class Seller implements InterfaceModel{
	protected int ID = -1;
	protected int IDaccount = -1;
	protected String nameShop = "";
	protected String description = "";
	protected String siret = "";
	protected String website = "";
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Seller");
		}
		return this.ID;
	}
	
	/**
	 * @return the iDaccount
	 * @throws NotFoundParameter 
	 */
	public int getIDaccount() throws NotFoundParameter {
		if(this.IDaccount == -1) {
			throw new NotFoundParameter("IDaccount", "Seller");
		}
		return this.IDaccount;
	}
	
	/**
	 * @return the nameShop
	 */
	public String getNameShop() {
		return this.nameShop;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * @return the siret
	 */
	public String getSiret() {
		return this.siret;
	}
	
	/**
	 * @return the website
	 */
	public String getWebsite() {
		return this.website;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param iDaccount the iDaccount to set
	 */
	public void setIDaccount(int iDaccount) {
		IDaccount = iDaccount;
	}
	
	/**
	 * @param nameShop the nameShop to set
	 */
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param siret the siret to set
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
}
