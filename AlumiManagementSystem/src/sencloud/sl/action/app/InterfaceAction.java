/**
 * 
 */
package sencloud.sl.action.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Resume;
import sencloud.sl.entity.Contacts;
import sencloud.sl.util.JsonUtils;

/**
 * 手机端接口Action
 * @author farryxia
 * 
 */
public class InterfaceAction extends BaseAction {

    private String paramsJson;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** logger */
	private static final Logger logger = LoggerFactory
			.getLogger(InterfaceAction.class);

	public void doAction() throws Exception {
		System.out.println(paramsJson);//打印出json参数
		Map paramsMap = JsonUtils.toMap(paramsJson);//将参数转为map的参数
		String method = (String) paramsMap.get("cmd");//获取cmdkey，得到操作类型
		LinkedHashMap<String, String> params = (LinkedHashMap<String, String>) paramsMap.get("params");
		//操作类型：登陆
		//需要的参数：	"cmd":"signin",
		//			params:"{
		//						"userName":"userName",
		//						"password":"password"
		//					}"	
		if("signin".equals(method)){//操作类型登陆
			String userName = params.get("userName");
			String password = params.get("password");
			signin(userName, password);
		}
		//操作类型：个人信息
		//需要的参数：	"cmd":"stuinfo",
		//			params:"{
		//						"stuId":"stuId"
		//					}"	
		if("stuinfo".equals(method)){//操作类型：个人信息
			int stuId =Integer.parseInt(params.get("stuId")) ;
			stuinfo(stuId);
		}
		//操作类型：个人履历
		//需要的参数：	"cmd":"sturesume",
		//			params:"{
		//						"adminNum":"31251P37"
		//					}"	
		if("sturesume".equals(method)){
			String adminNum =params.get("adminNum") ;
			stuResume(adminNum);
		}
		//操作类型：更新履历
		//需要的参数：	"cmd":"updateReusme",
		//			params:"{
		//						"resumeId"		:	"stuId"，
		//						"startTM"  		:	"stuId",
		//						"endTM"    		:	"stuId",
		//						"resumeCompany"	:	"stuId",
		//						"resumePost"	:	"stuId",
		//						"resumeDesc"	:	"stuId"
		//					}"	
		if("updateReusme".equals(method)){
			//int resumeId,String startTM,String endTM,String resumeCompany,String resumePost,String resumeDesc
			int resumeId =Integer.parseInt(params.get("resumeId")) ;
			String startTM=params.get("startTM");
			String endTM=params.get("endTM");
			String resumeCompany = params.get("resumeCompany");
			String resumePost = params.get("resumePost");
			String resumeDesc = params.get("resumeDesc");
			updateReusme(resumeId,startTM,endTM,resumeCompany,resumePost,resumeDesc);
		}
		//操作类型：新增履历
		//需要的参数：	"cmd":"addReusme",
		//			params:"{
		//						"resumeId"		:	"stuId"，
		//						"startTM"  		:	"stuId",
		//						"endTM"    		:	"stuId",
		//						"resumeCompany"	:	"stuId",
		//						"resumePost"	:	"stuId",		
		//						"resumeDesc"	:	"stuId"
		//					}"	
		if("addReusme".equals(method)){
			//String startTM,String endTM,String resumeCompany,String resumePost,String resumeDesc
			String startTM=params.get("startTM");
			String endTM=params.get("endTM");
			String resumeCompany = params.get("resumeCompany");
			String resumePost = params.get("resumePost");
			String resumeDesc = params.get("resumeDesc");
			addReusme(startTM,endTM,resumeCompany,resumePost,resumeDesc);
		}
		//操作类型：查看	系人
		//需要的参数：	"cmd":"viewContacts",
		//			params:"{
		//						"stuId":"stuId"
		//					}"
		if("viewContacts".equals(method)){
			int stuId =Integer.parseInt(params.get("stuId")) ;//当前登陆者的
			viewContacts(stuId);
		}
		else{
			errorParams();
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
					Map map = loginService.adminLogin(userName, password, 1);//参数：用户名，密码，用户类型
					if(map != null){
						userMap.put("detail", map);
						userMap.put("success", 0);
						userMap.put("msg", "登录成功");
					}
				} catch (Exception e) {
					userMap.put("detail", "");
					userMap.put("success", 1);
					userMap.put("msg", e.getMessage());
				}
			}
		} catch (Exception e) {
			userMap.put("detail", "");
			userMap.put("success", 1);
			userMap.put("msg", e.getMessage());
		}
	    userJson = JsonUtils.toJson(userMap);
		out.println(userJson);
		out.flush();
		out.close();
	}

	public String getParamsJson() {
		return paramsJson;
	}

	public void setParamsJson(String paramsJson) {
		this.paramsJson = paramsJson;
	}
	
	/**
	 * 手机端个人信息接口
	 * @param stuId 用户Id
	 * @throws Exception
	 */
	public void stuinfo(int stuId) {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> userMap = new HashMap<String, Object>();
	    try {
	    	out = response.getWriter();
			if(stuId != 0){
				try {
				//	Map map =stuInforService.getInforById(stuId);//参数：用户名，密码，用户类型
					Map map =stuInforService.getStuInfo(stuId);
					if(!map.isEmpty()){
						//JsonUtils.toJson(value)
						userMap.put("detail", map);
						userMap.put("success", 0);
						userMap.put("msg", "个人信息展示");
					}
					else{
						userMap.put("detail", "");
						userMap.put("success", 1);
						userMap.put("haha", "test");
						userMap.put("msg", "未搜索到当前用户信息");
					}
				} catch (Exception e) {
					userMap.put("detail", "");
					userMap.put("success", 1);
					userMap.put("msg", e.getMessage());
				}
			}
			else{
				userMap.put("detail", "");
				userMap.put("success", 1);
				userMap.put("msg", "当前用户不存在");
			}
		} catch (Exception e) {
			userMap.put("detail", "");
			userMap.put("success", 1);
			userMap.put("msg", e.getMessage());
		}
	    userJson = JsonUtils.toJson(userMap);
		out.println(userJson);
		out.flush();
		out.close();
	}
	
	/**
	 * 手机端个人履历接口
	 * @param adminNum 用户学号
	 * @throws Exception
	 */
	public void stuResume(String adminNum){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> userMap = new HashMap<String, Object>();
		 try {
		    	out = response.getWriter();
				if(adminNum != null){
					try {
						List<Resume>	resumeList =resumeService.queryResumeList(adminNum);
						if(resumeList.size()>0){
							//JsonUtils.toJson(value)
							userMap.put("detail", resumeList);
							userMap.put("success", 0);
							userMap.put("msg", "查看个人履历");
			
						}
						else{
							userMap.put("detail", "");
							userMap.put("success", 1);
							userMap.put("msg", "未搜索到当前用户履历");
						}
					} catch (Exception e) {
						userMap.put("detail", "");
						userMap.put("success", 1);
						userMap.put("msg", e.getMessage());
					}
				}
				else{
					userMap.put("detail", "");
					userMap.put("success", 1);
					userMap.put("msg", "当前用户不存在");
				}
			} catch (Exception e) {
				userMap.put("detail", "");
				userMap.put("success", 1);
				userMap.put("msg", e.getMessage());
			}
		    userJson = JsonUtils.toJson(userMap);
			out.println(userJson);
			out.flush();
			out.close();
	}
	
	/**
	 * 手机端更新履历
	 * @param resumeId 履历Id
	 * @param startTM 开始时间
	 * @param endTM 结束时间
	 * @param resumeCompany 公司单位
	 * @param resumePost 担任职务
	 * @param resumeDesc 履历
	 * @throws Exception
	 */
	public void updateReusme(int resumeId,String startTM,String endTM,String resumeCompany,String resumePost,String resumeDesc){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> returnMap = new HashMap<String, Object>();
		try{
			out = response.getWriter();
			Resume resume=resumeService.getResumeById(resumeId);
			resume.setStartTM(startTM);
			resume.setEndTM(endTM);
			resume.setResumeCompany(resumeCompany);
			resume.setResumePost(resumePost);
			resume.setResumeDesc(resumeDesc);
			//resumeService.update(resume);
			try{
				resumeService.update(resume);
				returnMap.put("detail", "OK");
				returnMap.put("success", 1);
				returnMap.put("msg","更新成功");
			}
			catch (Exception e) {
				returnMap.put("detail", "");
				returnMap.put("success", 1);
				returnMap.put("msg", e.getMessage());
			}
			
		}
		catch (Exception e) {
			returnMap.put("detail", "");
			returnMap.put("success", 1);
			returnMap.put("msg", e.getMessage());
		}
		
		
	    userJson = JsonUtils.toJson(returnMap);
		out.println(userJson);
		out.flush();
		out.close();
	}
	
	/**
	 * 手机端查看通讯录
	 * @param stuId 当前登陆用户Id
	 * @throws Exception
	 */
	public void viewContacts(int currentUserId){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> contactsMap = new HashMap<String, Object>();
	    try {
	    	out = response.getWriter();
			if(currentUserId != 0){
				try {
				//	Map map =stuInforService.getInforById(stuId);//参数：用户名，密码，用户类型
					java.util.List<Contacts> contactsList =contactsService.queryContactsList(currentUserId);
					if(contactsList.size()>0){
						//JsonUtils.toJson(value)
						contactsMap.put("detail", contactsList);
						contactsMap.put("success", 0);
						contactsMap.put("msg", "查询成功");
					}
				} catch (Exception e) {
					contactsMap.put("detail", "");
					contactsMap.put("success", 1);
					contactsMap.put("msg", e.getMessage());
				}
			}
		} catch (Exception e) {
			contactsMap.put("detail", "");
			contactsMap.put("success", 1);
			contactsMap.put("msg", e.getMessage());
		}
	    userJson = JsonUtils.toJson(contactsMap);
		out.println(userJson);
		out.flush();
		out.close();
	}
	
	
	public void errorParams(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> returnMap = new HashMap<String, Object>();
		try {
			out = response.getWriter();
			returnMap.put("detail", "");
			returnMap.put("success", 1);
			returnMap.put("msg", "操作错误");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			returnMap.put("detail", "");
			returnMap.put("success", 1);
			returnMap.put("msg", e.getMessage());
		}
		 userJson = JsonUtils.toJson(returnMap);
		out.println(userJson);
		out.flush();
		out.close();
	}
	
	/**
	 * 手机端新增履历
	 * @param startTM 开始时间
	 * @param endTM 结束时间
	 * @param resumeCompany 公司单位
	 * @param resumePost 担任职务
	 * @param resumeDesc 履历
	 * @throws Exception
	 */
	public void addReusme(String startTM,String endTM,String resumeCompany,String resumePost,String resumeDesc){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		String userJson = null;
		Map<String,Object> returnMap = new HashMap<String, Object>();
		try{
			out = response.getWriter();
			Resume resume=new Resume();
			resume.setStartTM(startTM);
			resume.setEndTM(endTM);
			resume.setResumeCompany(resumeCompany);
			resume.setResumePost(resumePost);
			resume.setResumeDesc(resumeDesc);
			//resumeService.update(resume);
			try{
				resumeService.save(resume);
				returnMap.put("detail", "OK");
				returnMap.put("success", 1);
				returnMap.put("msg","新增成功");
			}
			catch (Exception e) {
				returnMap.put("detail", "");
				returnMap.put("success", 1);
				returnMap.put("msg", e.getMessage());
			}
			
		}
		catch (Exception e) {
			returnMap.put("detail", "");
			returnMap.put("success", 1);
			returnMap.put("msg", e.getMessage());
		}
		
		
	    userJson = JsonUtils.toJson(returnMap);
		out.println(userJson);
		out.flush();
		out.close();
	}
	
}
