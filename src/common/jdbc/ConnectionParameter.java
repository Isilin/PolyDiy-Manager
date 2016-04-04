package common.jdbc;

/**
 * @author IsilinBN
 *
 */
public class ConnectionParameter {
	String user = "";
	String password = "";
	String url = "";
	
	/**
	 * @return the user
	 */
	public String getUser() {
		return this.user;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
