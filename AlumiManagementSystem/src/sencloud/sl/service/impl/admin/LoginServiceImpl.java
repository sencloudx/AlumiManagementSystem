package sencloud.sl.service.impl.admin;

import java.util.HashMap;
import java.util.Map;

import sencloud.sl.action.exception.NameNotFoundException;
import sencloud.sl.action.exception.PwNotMatchException;
import sencloud.sl.dao.admin.AdminDAO;
import sencloud.sl.dao.admin.StuInforDAO;
import sencloud.sl.entity.Admin;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.service.admin.LoginService;


public class LoginServiceImpl implements LoginService {
	private AdminDAO adminDAO;
	private StuInforDAO stuInforDAO;
	@SuppressWarnings("unchecked")
	@Override
	public Map adminLogin(String admName, String admPsw, Integer userType)
			throws NameNotFoundException, PwNotMatchException {
		System.out.println("用户名和密码   = "+admName + admPsw+ userType);
		if(userType == 0){									//表示登陆的是管理员
			Admin admin = adminDAO.findAdminByName(admName);
			if(admin == null){
				throw new NameNotFoundException();
			}else if(!(admin.getAdminPw()).equals(admPsw)){
				throw new PwNotMatchException();
			}else{
				Map map=new HashMap();
				map.put("adminName", admin.getAdminNum());
				//日志中使用
				map.put("userId", admin.getAdminId());
				map.put("admin", admin);
				map.put("adminType", admin.getAdminRight());
				return map;
			}
		}else if(userType == 1){
			StuInfor stuInfor = stuInforDAO.getStuInforByNum(admName);
			if(stuInfor == null){
				throw new NameNotFoundException("没有此用户");
			}else if(!(stuInfor.getPassword()).equals(admPsw)){
				throw new PwNotMatchException("密码或者用户名错误");
			}else{
				Map map=new HashMap();
				map.put("adminName", stuInfor.getStuName());
				map.put("userId", stuInfor.getStuId());
				map.put("adminNum", stuInfor.getStuNum());
				map.put("adminType", stuInfor.getStuType());
				return map;
			}
		}
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		adminDAO.updateEntity(admin);
	}

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public StuInforDAO getStuInforDAO() {
		return stuInforDAO;
	}

	public void setStuInforDAO(StuInforDAO stuInforDAO) {
		this.stuInforDAO = stuInforDAO;
	}
	
	
}
