package persistent.abstractclass;

import common.exception.dev.NotFoundParameter;
import common.set.ListOfID;
import persistent.common.InterfaceModel;

public abstract class User implements InterfaceModel {
	protected int ID = -1;
	protected int IDaccount = -1;
	
	protected ListOfID journalEntryIDs = new ListOfID("journalEntryIDs", "User");
	protected ListOfID categoryIDs = new ListOfID("categoryIDs", "User");
	protected ListOfID proposedActivityCategoryIDs = new ListOfID("proposedActivityCategoryIDs", "User");
	protected ListOfID wishlistIDs = new ListOfID("wishlistIDs", "User");
	protected int cartID = -1;
	protected ListOfID requestedEstimateIDs = new ListOfID("requestedEstimateIDs", "User");
	
	/**
	 * @return the iD
	 * @throws NotFoundParameter 
	 */
	public int getID() throws NotFoundParameter {
		if(this.ID == -1) {
			throw new NotFoundParameter("ID", "User");
		}
		return this.ID;
	}
	
	/**
	 * @return the iDaccount
	 * @throws NotFoundParameter 
	 */
	public int getIDaccount() throws NotFoundParameter {
		if(this.IDaccount == -1) {
			throw new NotFoundParameter("IDaccount", "User");
		}
		return this.IDaccount;
	}
	
	/**
	 * @return the journalEntryIDs
	 */
	public ListOfID getJournalEntryIDs() {
		return this.journalEntryIDs;
	}
	
	/**
	 * @return the categoryIDs
	 */
	public ListOfID getCategoryIDs() {
		return this.categoryIDs;
	}
	
	/**
	 * @return the proposedActivityCategoryIDs
	 */
	public ListOfID getProposedActivityCategoryIDs() {
		return this.proposedActivityCategoryIDs;
	}
	
	/**
	 * @return the wishlistIDs
	 */
	public ListOfID getWishlistIDs() {
		return this.wishlistIDs;
	}
	
	/**
	 * @return the cartID
	 */
	public int getCartID() {
		return this.cartID;
	}
	
	/**
	 * @return the requestedEstimateIDs
	 */
	public ListOfID getRequestedEstimateIDs() {
		return this.requestedEstimateIDs;
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
	
	/**
	 * @param journalEntryIDs the journalEntryIDs to set
	 */
	public void setJournalEntryIDs(ListOfID journalEntryIDs) {
		this.journalEntryIDs = journalEntryIDs;
	}
	
	/**
	 * @param categoryIDs the categoryIDs to set
	 */
	public void setCategoryIDs(ListOfID categoryIDs) {
		this.categoryIDs = categoryIDs;
	}
	
	/**
	 * @param proposedActivityCategoryIDs the proposedActivityCategoryIDs to set
	 */
	public void setProposedActivityCategoryIDs(ListOfID proposedActivityCategoryIDs) {
		this.proposedActivityCategoryIDs = proposedActivityCategoryIDs;
	}
	
	/**
	 * @param wishlistIDs the wishlistIDs to set
	 */
	public void setWishlistIDs(ListOfID wishlistIDs) {
		this.wishlistIDs = wishlistIDs;
	}
	
	/**
	 * @param cartID the cartID to set
	 */
	public void setCartID(int cartID) {
		this.cartID = cartID;
	}
	
	/**
	 * @param requestedEstimateIDs the requestedEstimateIDs to set
	 */
	public void setRequestedEstimateIDs(ListOfID requestedEstimateIDs) {
		this.requestedEstimateIDs = requestedEstimateIDs;
	}
}
