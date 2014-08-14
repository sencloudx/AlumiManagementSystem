package sencloud.sl.dao.impl.admin;

import sencloud.sl.dao.admin.ClassesDAO;
import sencloud.sl.entity.Classes;

@SuppressWarnings("unchecked")
public class ClassesDAOImpl extends GenericHibernateDAO<Classes> implements
		ClassesDAO {
	public ClassesDAOImpl(){
		super(Classes.class);
	}
	
}
