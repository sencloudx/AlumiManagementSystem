package sencloud.sl.dao.impl.admin;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import sencloud.sl.dao.admin.CommonDAO;


public class CommonDAOImpl extends HibernateDaoSupport implements CommonDAO {

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> findAll(Class<T> entityclass) {
		String hql = "from "+entityclass.getName()+"";
		return this.getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T findById(Class<T> entityClass, Integer id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public <T> void remove(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public <T> void sava(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public <T> void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}
}
