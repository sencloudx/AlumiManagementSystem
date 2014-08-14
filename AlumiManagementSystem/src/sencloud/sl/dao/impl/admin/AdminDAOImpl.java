package sencloud.sl.dao.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.AdminDAO;
import sencloud.sl.entity.Admin;


@SuppressWarnings("unchecked")
public class AdminDAOImpl extends GenericHibernateDAO<Admin> implements AdminDAO{
	public AdminDAOImpl(){
		super(Admin.class);
	}
	
	@Override
	public Admin findAdminByName(String adminName) {
		String hql = "from Admin as ad where ad.adminNum = '"+adminName+"'";
		List<Admin> adminList = findListByHQL(hql);
		System.out.println(adminList);
		if(adminList == null|| adminList.size() == 0){
			return null;
		}else{
			return adminList.get(0);
		}
	}
}
