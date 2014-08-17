/**
 * 
 */
package sencloud.sl.service.impl.admin;

import java.util.List;

import org.apache.log4j.Logger;

import sencloud.sl.dao.admin.ContactsDAO;
import sencloud.sl.entity.Contacts;
import sencloud.sl.service.admin.ContactsService;

/**
 * @author farryxia
 *
 */
public class ContactsServiceImpl implements ContactsService{

	private static final Logger log = Logger.getLogger(ContactsServiceImpl.class);

	private ContactsDAO contactsDAO;
	
	public void setContactsDAO(ContactsDAO contactsDAO) {
		this.contactsDAO = contactsDAO;
	}

	public ContactsDAO getContactsDAO() {
		return contactsDAO;
	}

	/**
	 * 保存通讯录
	 */
	@Override
	public String save(Contacts contacts) {
		contactsDAO.makePersistence(contacts);
		return contacts.getContactPhoneNum();
	}

	/**
	 * 通过id查询通讯录信息
	 */
	@Override
	public Contacts getContactsById(Integer id) {
		return contactsDAO.findById(id);
	}

	/**
	 * 更新通讯录信息
	 */
	@Override
	public void updata(Contacts contacts) {
		contactsDAO.updata(contacts);
	}

	/**
	 * 删除通讯录信息
	 */
	@Override
	public void delete(Integer id) {
		contactsDAO.delete(id);
	}

	/**
	 * 通过加入通讯录的userId查询通讯录信息
	 */
	@Override
	public Contacts getContactsByUserId(Integer userId) {
		return contactsDAO.getContactsByUserId(userId);
	}

	@Override
	public Contacts merge(Contacts contacts) {
		return null;
	}

	@Override
	public List<Contacts> queryContactsList(Integer currentUserId) {
		return contactsDAO.queryContactsList(currentUserId);
	}

	@Override
	public Integer getContactsNum(Integer currentUserId) {
		return contactsDAO.getContactsNum(currentUserId);
	}

	@Override
	public List<Contacts> queryContactsPage(Integer currentUserId,
			Integer PageFirRecord, Integer PageNum) {
		return contactsDAO.queryContactsPage(currentUserId, PageFirRecord, PageNum);
	}
}
