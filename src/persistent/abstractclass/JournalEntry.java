package persistent.abstractclass;

import java.util.Date;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * @author IsilinBN
 *
 */
public abstract class JournalEntry implements InterfaceModel {
	protected int ID = -1;
	protected String visibility = "";
	protected Date datePost = new Date();
	protected String title = "";
	protected String content = "";
	protected int userID = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "JournalEntry");
		}
		return this.ID;
	}
	
	/**
	 * @return the visibility
	 */
	public String getVisibility() {
		return this.visibility;
	}
	
	/**
	 * @return the datePost
	 */
	public Date getDatePost() {
		return this.datePost;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * @return the userID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.userID == -1) {
			throw new NotFoundParameter("userID", "JournalEntry");
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
	 * @param visibility the visibility to set
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	/**
	 * @param datePost the datePost to set
	 */
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
