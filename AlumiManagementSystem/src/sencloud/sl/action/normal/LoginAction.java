package sencloud.sl.action.normal;

import java.util.Map;

import sencloud.sl.action.exception.NameNotFoundException;
import sencloud.sl.action.exception.PwNotMatchException;
import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Admin;
import sencloud.sl.util.SCUtils;


import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction{
	/**
	 * 用户和管理员登录
	 * @shenliang 2011-11-4
	 */
	private static final long serialVersionUID = 1L;
	
	private String admName;
	private String admPsw;
	private String errorMsg;
	private Integer userType;
	private String newPw;
	private String newPwRepeat;
	/**
	 * 管理员登录
	 * */
	@SuppressWarnings("unchecked")
	public String execute(){
		ActionContext ctx=ActionContext.getContext();
    	Map session=ctx.getSession();
    	if(session.get("adminName")==null){
	    	if(admName==null || admName.trim().equals("") || admPsw.trim()==null
	        			|| admPsw.equals("")){
	        	return INPUT;
	        }
    	}
    	try {
    		if(session.get("adminName")==null){
    			admPsw = SCUtils.encryptBasedMd5(admPsw);
    			Map map = loginService.adminLogin(admName, admPsw, userType);
    			session.putAll(map);
    			return SUCCESS;
    		}else{
    			return SUCCESS;
    		}
		} catch (NameNotFoundException e) {
			errorMsg="该用户不存在";
		} catch (PwNotMatchException e) {
			errorMsg="密码错误";
		}
        return INPUT;
    }
	/**
	 * 管理员修改密码
	 * */
	public String changePw(){
		try {
			System.out.println("数据    = "+newPw+ "   "+newPwRepeat);
			Admin admin = (Admin)ActionContext.getContext().getSession().get("admin");
			newPw = SCUtils.encryptBasedMd5(newPw);
			admin.setAdminPw(newPw);
			loginService.updateAdmin(admin);
			response="{success:true}";
		} catch (Exception e) {
			e.printStackTrace();
			response="{success:false}";
		}
		return SUCCESS;
	}
	/**
	 * 管理员注销
	 * */
	public String exit() throws Exception{
		Map session=ActionContext.getContext().getSession();
		session.remove("admin");
		session.remove("adminName");
		return SUCCESS;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}

	public void setAdmPsw(String admPsw) {
		this.admPsw = admPsw;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	public String getNewPwRepeat() {
		return newPwRepeat;
	}
	public void setNewPwRepeat(String newPwRepeat) {
		this.newPwRepeat = newPwRepeat;
	}
	
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		System.out.println("userType 为 = "+userType);
		this.userType = userType;
	}
	public String getAdmName() {
		return admName;
	}
	public String getAdmPsw() {
		return admPsw;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
