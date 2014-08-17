/**
 * 
 */
package sencloud.sl.entity;

/**
 * @author farryxia
 * 
 */
public class Contacts {

	// Fields

	private Integer contactsId;
	private String userName;
	private String contactPhoneNum;
	private String contactAddress;
	private Integer userId;
	private Integer currentUserId;

	public Contacts() {
		super();
	}

	public Contacts(Integer contactsId, String userName,
			String contactPhoneNum, String contactAddress, Integer userId,
			Integer currentUserId) {
		super();
		this.contactsId = contactsId;
		this.userName = userName;
		this.contactPhoneNum = contactPhoneNum;
		this.contactAddress = contactAddress;
		this.userId = userId;
		this.currentUserId = currentUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}

	public String getContactPhoneNum() {
		return contactPhoneNum;
	}

	public void setContactPhoneNum(String contactPhoneNum) {
		this.contactPhoneNum = contactPhoneNum;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}

}
