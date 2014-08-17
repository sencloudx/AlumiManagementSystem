/**
 * 
 */
package sencloud.sl.dao.impl.admin;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import sencloud.sl.dao.admin.ContactsDAO;
import sencloud.sl.entity.Contacts;

/**
 * @author farryxia
 * 
 */
@SuppressWarnings("unchecked")
public class ContactsDAOImpl extends GenericHibernateDAO<Contacts> implements
		ContactsDAO {

	public ContactsDAOImpl() {
		super(Contacts.class);
	}

	public ContactsDAOImpl(Class<Contacts> persistentClass) {
		super(Contacts.class);
	}

	@Override
	public String makePersistence(Contacts contacts) {
		this.getHibernateTemplate().save(contacts);
		return contacts.getContactPhoneNum();
	}

	/**
	 * 通过id查询通讯录信息
	 */
	@Override
	public Contacts getContactsById(Integer id) {
		return this.getHibernateTemplate().get(Contacts.class, id);
	}

	/**
	 * 更新通讯录信息
	 */
	@Override
	public void updata(Contacts contacts) {
		this.getHibernateTemplate().update(contacts);
	}

	/**
	 * 删除通讯录信息
	 */
	@Override
	public void delete(Integer id) {
		this.getHibernateTemplate().delete(this.getHibernateTemplate().get(Contacts.class, id));
	}

	/**
	 * 通过加入通讯录的userId查询通讯录信息
	 */
	@Override
	public Contacts getContactsByUserId(Integer userId) {
		String hql = "from Contacts as con where con.userId = '"+userId+"'";
		List<Contacts> contactsList = findListByHQL(hql);
		if(contactsList != null && contactsList.size() > 0){
			return contactsList.get(0);
		}
		return null;
	}

	@Override
	public Contacts merge(Contacts contacts) {
		return this.getHibernateTemplate().merge(contacts);
	}

	/**
	 * 查询当前校友所有的通讯录
	 */
	@Override
	public List<Contacts> queryContactsList(Integer currentUserId) {
		String hql = "from Contacts as con where con.currentUserId = '"+currentUserId+"'";
		List<Contacts> contactsList = findListByHQL(hql);
		return contactsList;
	}

	@Override
	public Integer getContactsNum(Integer currentUserId) {
		String hql = "from Contacts as con where con.currentUserId = '"+currentUserId+"'";
		List<Contacts> contactsList = findListByHQL(hql);
		Integer totalNum = 0;
		if(contactsList != null){
			totalNum = contactsList.size();
		}
		return totalNum;
	}

	@Override
	public List<Contacts> queryContactsPage(Integer currentUserId,
			final Integer pageFirRecord, final Integer pageNum) {
		final String hql = "from Contacts as con where con.currentUserId = '"+currentUserId+"'";
		List<Contacts> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
		    throws HibernateException, SQLException 
		    {
				Query query = session.createQuery(hql);
				query.setFirstResult(pageFirRecord);
				query.setMaxResults(pageNum);
				List list = query.list();
				return list;
			}
			});
		return list.size()>0?list:null;
	}

}
