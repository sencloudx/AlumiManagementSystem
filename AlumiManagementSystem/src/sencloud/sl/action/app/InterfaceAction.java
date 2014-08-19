/**
 * 
 */
package sencloud.sl.action.app;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.util.JsonUtils;

/**
 * 手机端接口Action
 * @author farryxia
 * 
 */
public class InterfaceAction extends BaseAction {

	private String method;
	private String userName;
	private String password;
    private Integer userType;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** logger */
	private static final Logger logger = LoggerFactory
			.getLogger(InterfaceAction.class);

	public void doAction() throws Exception {
		System.out.println(method + "," + userName + "," + password);
		if("login".equals(method)){
			login(userName, password);
		}
	}

	/**
	 * 手机端登录接口
	 * @param userName 登录用户名
	 * @param password 登录密码（客户端需要通过MD5和Base64加密）
	 * @throws Exception
	 */
	public void login(String userName, String password) {
		logger.info("method is " + userName);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> userMap = new HashMap<String, Object>();
	    try {
	    	out = response.getWriter();
			if(userName != null && !"".equals(userName)){
				try {
					Map map = loginService.adminLogin(userName, password, userType);
					if(map != null){
						userMap.put("data", map);
						userMap.put("success", 0);
						userMap.put("msg", "登录成功");
					}
				} catch (Exception e) {
					userMap.put("data", "");
					userMap.put("success", 1);
					userMap.put("msg", e.getMessage());
				}
				
			}
		} catch (Exception e) {
			userMap.put("data", "");
			userMap.put("success", 1);
			userMap.put("msg", e.getMessage());
		}
	    userJson = JsonUtils.toJson(userMap);
		out.println(userJson);
		out.flush();
		out.close();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}
}
