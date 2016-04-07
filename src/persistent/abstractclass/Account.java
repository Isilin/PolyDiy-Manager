package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import persistent.common.Address;
import persistent.common.InterfaceModel;

/**
 * @author Isilin 
 * @version 1.1
 * @since 2016-04-02
 */
public abstract class Account implements InterfaceModel {
	protected String login = "";
	protected String password = "";
	protected int ID = -1;
	protected String email = "";
	protected String[] name = new String[2];
	protected Address address = new Address();
	
	public Account() {
	}
	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return this.login;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "Account");
		}
		return this.ID;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * @return the name
	 */
	public String[] getName() {
		return this.name;
	}
	
	/**
	 * @return the address
	 * @throws NotFoundParameter 
	 */
	public Address getAddress() throws NotFoundParameter {
		if(this.address == null) {
			throw new NotFoundParameter("address", "Account");
		}
		return this.address;
	}
	
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String[] name) {
		this.name = name;
	}
	
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
