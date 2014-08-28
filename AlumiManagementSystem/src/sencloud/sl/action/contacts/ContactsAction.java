/**
 * 
 */
package sencloud.sl.action.contacts;

import com.opensymphony.xwork2.ActionContext;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Contacts;
import sencloud.sl.entity.StuInfor;

/**
 * 操作通讯录CURD的Action类
 * @author farryxia
 * 
 */
public class ContactsAction extends BaseAction {

	private String userName;
	private String contactPhoneNum;
	private String contactAddress;
	private Integer contactsId;
	private Integer[] ids;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 添加通讯录
	 * 
	 * @return
	 */
	public String addContacts() {
		Contacts contacts = new Contacts();
		try {
			Integer currentUserId = (Integer) ActionContext.getContext()
					.getSession().get("userId");
			contacts.setCurrentUserId(currentUserId);
			contacts.setContactPhoneNum(contactPhoneNum);
			contacts.setContactAddress(contactAddress);
			contacts.setUserName(userName);
			contactsService.save(contacts);
			response = "{success:true}";
		} catch (Exception e) {
			response = "{success:false}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 删除通讯录
	 * 
	 * @return
	 */
	public String deleteContacts() {
		try {
			contactsService.delete(contactsId);
			response = "{success:true}";
		} catch (Exception e) {
			response = "{success:false}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 批量删除通讯录
	 * 
	 * @return
	 */
	public String batchDeleteContacts() {
		try {
			if (ids != null && ids.length > 0) {
				for (Integer id : ids) {
					contactsService.delete(id);
				}
				response = "{success:true}";
			}
		} catch (Exception e) {
			response = "{success:false}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 修改通讯录
	 * 
	 * @return
	 */
	public String updataContacts() {
		try {
			if (contactsId != null) {
				Contacts contacts = contactsService.getContactsById(contactsId);
				if (contacts != null) {
					Integer currentUserId = (Integer) ActionContext
							.getContext().getSession().get("userId");
					contacts.setUserName(userName);
					contacts.setContactPhoneNum(contactPhoneNum);
					contacts.setContactAddress(contactAddress);
					contacts.setCurrentUserId(currentUserId);
					contactsService.updata(contacts);
				}
			}
			response = "{success:true}";
		} catch (Exception e) {
			response = "{success:false}";
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String batchAdd2Contacts(){
		try {
			if (ids != null && ids.length > 0) {
				for (Integer id : ids) {
					StuInfor stuInfo = stuInforService.getInforById(id);
					Contacts contacts = new Contacts();
					contacts.setUserName(stuInfo.getStuName());
					contacts.setContactAddress(stuInfo.getStuWorkAddress());
					contacts.setContactPhoneNum(stuInfo.getStuTelephone());
					contacts.setUserId(stuInfo.getStuId());
					Integer currentUserId = (Integer)ActionContext.getContext().getSession().get("userId");
					contacts.setCurrentUserId(currentUserId);
					contacts.setAccount(stuInfo.getStuNum());//添加学号
					Contacts contactsExist = contactsService.getContactsByUserId(stuInfo.getStuId());
					if(contactsExist != null){
						contactsExist.setContactAddress(stuInfo.getStuWorkAddress());
						contactsExist.setContactPhoneNum(stuInfo.getStuTelephone());
						contactsExist.setUserId(stuInfo.getStuId());
						contactsExist.setCurrentUserId(currentUserId);
						contactsExist.setUserName(stuInfo.getStuName());
						contactsExist.setAccount(stuInfo.getStuNum());//更新学号
						contactsService.updata(contactsExist);
					}else{
						contactsService.save(contacts);
					}
				}
				response = "{success:true}";
			}
		} catch (Exception e) {
			response = "{success:false}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getContactsId() {
		return contactsId;
	}

	public void setContactsId(Integer contactsId) {
		this.contactsId = contactsId;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

}
