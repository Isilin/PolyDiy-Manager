package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class Task implements InterfaceModel {
	protected int ID = -1;
	protected String title = "";
	protected int activityID = -1;
	protected int categoryID = -1;
	protected int userID = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Task");
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
	 * @return the activityID
	 * @throws NotFoundParameter 
	 */
	public int getActivityID() throws NotFoundParameter {
		if(this.activityID == -1) {
			throw new NotFoundParameter("activityID", "Task");
		}
		return this.activityID;
	}
	
	/**
	 * @return the categoryID
	 * @throws NotFoundParameter 
	 */
	public int getCategoryID() throws NotFoundParameter {
		if(this.categoryID == -1) {
			throw new NotFoundParameter("categoryID", "Task");
		}
		return this.categoryID;
	}
	
	/**
	 * @return the userID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.userID == -1) {
			throw new NotFoundParameter("userID", "Task");
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
	 * @param activityID the activityID to set
	 */
	public void setActivityID(int activityID) {
		this.activityID = activityID;
	}
	
	/**
	 * @param categoryID the categoryID to set
	 */
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
