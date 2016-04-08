package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class Category implements InterfaceModel {
	protected int ID = -1;
	protected String title = "";
	protected String description = "";
	protected int userID = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Category");
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
	 * @return the userID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.userID == -1) {
			throw new NotFoundParameter("userID", "Category");
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
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
