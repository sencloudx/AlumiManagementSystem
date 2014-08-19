/**
 * 
 */
package sencloud.sl.action.app;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sencloud.sl.base.BaseAction;
import sencloud.sl.util.JsonUtils;

/**
 * 手机端接口Action
 * @author farryxia
 * 
 */
public class InterfaceAction extends BaseAction {

    private String paramsJon;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** logger */
	private static final Logger logger = LoggerFactory
			.getLogger(InterfaceAction.class);

	public void doAction() throws Exception {
		System.out.println(paramsJon);
		Map paramsMap = JsonUtils.toMap(paramsJon);
		String method = (String) paramsMap.get("cmd");
		LinkedHashMap<String, String> params = (LinkedHashMap<String, String>) paramsMap.get("params");
		if("signin".equals(method)){
			String userName = params.get("userName");
			String password = params.get("password");
			signin(userName, password);
		}
	}

	/**
	 * 手机端登录接口
	 * @param userName 登录用户名
	 * @param password 登录密码（客户端需要通过MD5和Base64加密）
	 * @throws Exception
	 */
	public void signin(String userName, String password) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> userMap = new HashMap<String, Object>();
	    try {
	    	out = response.getWriter();
			if(userName != null && !"".equals(userName)){
				try {
					Map map = loginService.adminLogin(userName, password, 1);
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

	public String getParamsJon() {
		return paramsJon;
	}

	public void setParamsJon(String paramsJon) {
		this.paramsJon = paramsJon;
	}
}
