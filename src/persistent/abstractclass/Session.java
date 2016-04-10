package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.InterfaceModel;

public abstract class Session implements InterfaceModel{
	protected int ID;
	protected String token;
	
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Session");
		}
		return this.ID;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
}
