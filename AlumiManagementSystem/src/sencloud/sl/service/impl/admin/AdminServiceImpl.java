package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.AdminDAO;
import sencloud.sl.entity.Admin;
import sencloud.sl.service.admin.AdminService;


public class AdminServiceImpl implements AdminService{
	private AdminDAO adminDAO;
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}
	@Override
	public List<Admin> getList() {
		String hql = "from Admin as ad where ad.adminRight = '普通管理员'";
		return adminDAO.findListByHQL(hql);
	}
	
	@Override
	public void addAdmin(String adminNum, String adminPw, String idStr) {
		Admin admin = new Admin();
		admin.setAdminNum(adminNum);
		admin.setAdminPw(adminPw);
		admin.setManageRange(idStr);
		admin.setAdminRight("普通管理员");
		adminDAO.makePersitent(admin);
	}
	@Override
	public void delete(String idStr) {
		String[] ids = idStr.split("-");
		for(String id: ids){
			adminDAO.makeTransient(adminDAO.findById(Integer.valueOf(id)));
		}
	}
	@Override
	public Admin getAdminById(int id) {
		return adminDAO.findById(id);
	}
	@Override
	public void update(int id, String adminNum, String adminPw) {
		Admin admin = adminDAO.findById(id);
		admin.setAdminNum(adminNum);
		admin.setAdminPw(adminPw);
		admin.setAdminRight("普通管理员");
		adminDAO.updateEntity(admin);
	}
	
	
}	
