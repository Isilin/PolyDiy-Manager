package persistent.abstractclass;

import java.util.Date;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * @author IsilinBN
 *
 */
public abstract class Comment implements InterfaceModel {
	protected int ID = -1;
	protected int accountID = -1;
	protected int journalEntryID = -1;
	protected Date dateComment = new Date();
	protected String content = "";
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Comment");
		}
		return this.ID;
	}
	
	/**
	 * @return the accountID
	 * @throws NotFoundParameter 
	 */
	public int getAccountID() throws NotFoundParameter {
		if(this.accountID == -1) {
			throw new NotFoundParameter("accountID", "Comment");
		}
		return this.accountID;
	}
	
	/**
	 * @return the journalEntryID
	 * @throws NotFoundParameter 
	 */
	public int getJournalEntryID() throws NotFoundParameter {
		if(this.journalEntryID == -1) {
			throw new NotFoundParameter("journalEntryID", "Comment");
		}
		return this.journalEntryID;
	}
	
	/**
	 * @return the dateComment
	 */
	public Date getDateComment() {
		return this.dateComment;
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	/**
	 * @param journalEntryID the journalEntryID to set
	 */
	public void setJournalEntryID(int journalEntryID) {
		this.journalEntryID = journalEntryID;
	}
	
	/**
	 * @param dateComment the dateComment to set
	 */
	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
}
