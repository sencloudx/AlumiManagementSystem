package sencloud.sl.dao.admin;

import sencloud.sl.entity.Admin;

public interface AdminDAO extends GenericDAO<Admin>{
	/**
	 * 登录相关，根据账号来查找用户
	 * */
	public Admin findAdminByName(String adminName);
	
}
