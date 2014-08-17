/**
 * 
 */
package sencloud.sl.service.admin;

import java.util.List;

import sencloud.sl.entity.Contacts;

/**
 * @author farryxia
 * 
 */
public interface ContactsService {

	/**
	 * 对对象进行存储
	 * 
	 * @param contacts
	 * @return
	 */
	public String save(Contacts contacts);

	/**
	 * 通过id查询通讯录
	 * 
	 * @param id
	 * @return
	 */
	public Contacts getContactsById(Integer id);

	/**
	 * 修改通讯录
	 * 
	 * @param contacts
	 */
	public void updata(Contacts contacts);

	/**
	 * 删除通讯录
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * 通过userId 查找通讯录
	 * 
	 * @param userId
	 * @return
	 */
	public Contacts getContactsByUserId(Integer userId);

	/**
	 * 更新合并数据
	 * 
	 * @param contacts
	 * @return
	 */
	public Contacts merge(Contacts contacts);

	/**
	 * 查询当前校友的通讯录
	 * 
	 * @return
	 */
	public List<Contacts> queryContactsList(Integer currentUserId);

	/**
	 * 查询当前校友的通讯录的总数
	 * 
	 * @param currentUserId
	 * @return
	 */
	public Integer getContactsNum(Integer currentUserId);

	/**
	 * 查询当前校友的通讯录(分页)
	 * 
	 * @return
	 */
	public List<Contacts> queryContactsPage(Integer currentUserId,
			Integer PageFirRecord, Integer PageNum);
}
