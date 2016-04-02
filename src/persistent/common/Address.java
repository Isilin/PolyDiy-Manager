package persistent.common;

/**
 * @author IsilinBN
 * A class for address type.
 */
public class Address {
	protected String road = "";
	protected String postal = "";
	protected String city = "";
	protected String country = "";
	
	/**
	 * @return the road
	 */
	public String getRoad() {
		return this.road;
	}
	
	/**
	 * @return the postal
	 */
	public String getPostal() {
		return this.postal;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}
	
	/**
	 * @param road the road to set
	 */
	public void setRoad(String road) {
		this.road = road;
	}
	
	/**
	 * @param postal the postal to set
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}
	
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
