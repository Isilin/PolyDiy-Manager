package persistent.abstractclass;

import java.util.List;

import common.exception.dev.NotFoundParameter;
import common.set.ListOfID;
import persistent.common.Address;

/**
 * @author Isilin 
 * @version 1.1
 * @since 2016-04-02
 */
public abstract class Account implements InterfaceModel {
	public final static int FIRST = 0;
	public final static int LAST = 1;
	
	protected final static int ADMIN = 0;
	protected final static int USER = 1;
	protected final static int SELLER = 2;
	
	protected String login = "";
	protected String password = "";
	protected int ID = -1;
	protected String email = "";
	protected String[] name = new String[2];
	protected Address address = new Address();
	
	protected int[] profilesID = new int[3];
	protected List<Integer> commentIDs = new ListOfID("commentIDs", "Account");
	protected List<Integer> tutorialIDs = new ListOfID("tutorialIDs", "Account");
	
	public Account() {
		this.name[Account.FIRST] = "";
		this.name[Account.LAST] = "";
		
		this.profilesID[Account.ADMIN] = -1;
		this.profilesID[Account.USER] = -1;
		this.profilesID[Account.SELLER] = -1;
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
	 * @return true if there is an administrator ID
	 */
	public Boolean isAdmin() {
		return this.profilesID[Account.ADMIN] != -1;
	}
	
	/**
	 * @return the administrator ID
	 * @throws NotFoundParameter 
	 */
	public int getAdminID() throws NotFoundParameter {
		if(this.profilesID[Account.ADMIN] == -1) {
			throw new NotFoundParameter("adminID", "Account");
		}
		return this.profilesID[Account.ADMIN];
	}
	
	/**
	 * @return true if there is a user ID
	 */
	public Boolean isUser() {
		return this.profilesID[Account.USER] != -1;
	}
	
	/**
	 * @return the user ID
	 * @throws NotFoundParameter 
	 */
	public int getUserID() throws NotFoundParameter {
		if(this.profilesID[Account.USER] == -1) {
			throw new NotFoundParameter("userID", "Account");
		}
		return this.profilesID[Account.USER];
	}
	
	/**
	 * @return true if there is an seller ID
	 */
	public Boolean isSeller() {
		return this.profilesID[Account.SELLER] != -1;
	}
	
	/**
	 * @return the seller ID
	 * @throws NotFoundParameter 
	 */
	public int getSellerID() throws NotFoundParameter {
		if(this.profilesID[Account.SELLER] == -1) {
			throw new NotFoundParameter("sellerID", "Account");
		}
		return this.profilesID[Account.SELLER];
	}
	
	/**
	 * @return List of comment's IDs
	 */
	public List<Integer> getCommentIDs() {
		return this.commentIDs;
	}
	
	/**
	 * @return List of tutorial's IDs
	 */
	public List<Integer> getTutorialIDs() {
		return this.tutorialIDs;
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

	/**
	 * @param adminID the administrator ID to set
	 */
	public void setAdminID(int adminID) {
		this.profilesID[Account.ADMIN] = adminID;
	}

	/**
	 * @param userID the user ID to set
	 */
	public void setUserID(int userID) {
		this.profilesID[Account.USER] = userID;
	}

	/**
	 * @param sellerID the seller ID to set
	 */
	public void setSellerID(int sellerID) {
		this.profilesID[Account.SELLER] = sellerID;
	}
	
	/**
	 * @param commentIDs the comment's IDs to set
	 */
	public void setCommentIDs(List<Integer> commentIDs) {
		this.commentIDs = commentIDs;
	}
	
	/**
	 * @param commentIDs the tutorial's IDs to set
	 */
	public void setTutorialIDs(List<Integer> tutorialIDs) {
		this.tutorialIDs = tutorialIDs;
	}
}
