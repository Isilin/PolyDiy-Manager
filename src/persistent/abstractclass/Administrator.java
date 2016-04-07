package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

/**
 * @author IsilinBN
 *
 */
public abstract class Administrator implements InterfaceModel {
	protected int ID = -1;
	protected int IDaccount = -1;
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Administrator");
		}
		return this.ID;
	}
	
	/**
	 * @return the iDaccount
	 * @throws NotFoundParameter 
	 */
	public int getIDaccount() throws NotFoundParameter {
		if(this.IDaccount == -1) {
			throw new NotFoundParameter("IDaccount", "Administrator");
		}
		return this.IDaccount;
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
}
