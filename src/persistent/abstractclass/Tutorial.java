package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import common.set.ListOfID;
import persistent.common.InterfaceModel;

/**
 * @author IsilinBN
 *
 */
public abstract class Tutorial implements InterfaceModel {
	protected int ID = -1;
	protected String title = "";
	protected String description = "";
	protected String difficulty = "";
	protected int accountID = -1;
	protected ListOfID activityIDs = new ListOfID("activityIDs", "Tutorial");
	protected ListOfID objectiveIDs = new ListOfID("activityIDs", "Tutorial");
	protected ListOfID taskIDs = new ListOfID("activityIDs", "Tutorial");
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Tutorial");
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
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return this.difficulty;
	}
	
	/**
	 * @return the accountID
	 * @throws NotFoundParameter 
	 */
	public int getAccountID() throws NotFoundParameter {
		if(this.accountID == -1) {
			throw new NotFoundParameter("accountID", "Tutorial");
		}
		return this.accountID;
	}
	
	/**
	 * @return the activityIDs
	 */
	public ListOfID getActivityIDs() {
		return this.activityIDs;
	}
	
	/**
	 * @return the objectiveIDs
	 */
	public ListOfID getObjectiveIDs() {
		return this.objectiveIDs;
	}
	
	/**
	 * @return the taskIDs
	 */
	public ListOfID getTaskIDs() {
		return this.taskIDs;
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
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	/**
	 * @param activityIDs the activityIDs to set
	 */
	public void setActivityIDs(ListOfID activityIDs) {
		this.activityIDs = activityIDs;
	}
	
	/**
	 * @param objectiveIDs the objectiveIDs to set
	 */
	public void setObjectiveIDs(ListOfID objectiveIDs) {
		this.objectiveIDs = objectiveIDs;
	}
	
	/**
	 * @param taskIDs the taskIDs to set
	 */
	public void setTaskIDs(ListOfID taskIDs) {
		this.taskIDs = taskIDs;
	}
}
