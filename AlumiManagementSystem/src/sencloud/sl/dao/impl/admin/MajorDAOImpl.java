package sencloud.sl.dao.impl.admin;

import sencloud.sl.dao.admin.MajorDAO;
import sencloud.sl.entity.Major;

@SuppressWarnings("unchecked")
public class MajorDAOImpl extends GenericHibernateDAO<Major> implements MajorDAO {
	
	public MajorDAOImpl(){
		super(Major.class);
	}
	
}
