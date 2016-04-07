package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class Notification implements InterfaceModel {
	int ID = -1;
	String content = "";
	int profileID = -1;
	String typeElement = "";
	int elementID = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Notification");
		}
		return this.ID;
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * @return the profileID
	 * @throws NotFoundParameter 
	 */
	public int getProfileID() throws NotFoundParameter {
		if(this.profileID == -1) {
			throw new NotFoundParameter("profileID", "Notification");
		}
		return this.profileID;
	}
	/**
	 * @return the typeElement
	 */
	public String getTypeElement() {
		return this.typeElement;
	}
	/**
	 * @return the elementID
	 * @throws NotFoundParameter 
	 */
	public int getElementID() throws NotFoundParameter {
		if(this.elementID == -1) {
			throw new NotFoundParameter("elementID", "Administrator");
		}
		return this.elementID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @param profileID the profileID to set
	 */
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
	/**
	 * @param typeElement the typeElement to set
	 */
	public void setTypeElement(String typeElement) {
		this.typeElement = typeElement;
	}
	/**
	 * @param elementID the elementID to set
	 */
	public void setElementID(int elementID) {
		this.elementID = elementID;
	}
}
