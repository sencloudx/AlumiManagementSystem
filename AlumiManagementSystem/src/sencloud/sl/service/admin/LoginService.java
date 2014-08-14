package sencloud.sl.service.admin;

import java.util.Map;

import sencloud.sl.action.exception.NameNotFoundException;
import sencloud.sl.action.exception.PwNotMatchException;
import sencloud.sl.entity.Admin;


public interface LoginService {
	/**
	 * 管理员登陆验证
	 * 
	 * @param admName
	 * @param admPsw
	 * @return
	 */
	@SuppressWarnings("unchecked")
	Map adminLogin(String admName,String admPsw, Integer userType)
		throws NameNotFoundException, PwNotMatchException;
	/**
	 * 管理员密码更新
	 * */
	public void updateAdmin(Admin admin);
}
