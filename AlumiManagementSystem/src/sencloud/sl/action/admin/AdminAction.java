package sencloud.sl.action.admin;

import java.util.List;

import org.apache.log4j.Logger;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Admin;
import sencloud.sl.util.SCUtils;


public class AdminAction extends BaseAction{
	private static final Logger log = Logger.getLogger(AdminAction.class);//日志文件
	/**
	 * 管理员操作类
	 */
	private static final long serialVersionUID = 1L;
	private List<Admin> adminList;
	private String adminNum;
	private String adminPw;
	private String idStr;
	private Integer tagId;
	private Admin admin;
	
	
	/**
	 * 获取普通管理员列表
	 * */
	public String getList(){
		adminList = adminService.getList();
		return SUCCESS;
	}
	/**
	 * 普通管理员添加
	 * */
	public String adminAdd(){
		//log.info("进行普通管理员的添加，添加的管理员为： 账号 = "+adminNum + " 密码= "+adminPw+"  "+idStr);
		adminPw = SCUtils.encryptBasedMd5(adminPw);
		try{
			adminService.addAdmin(adminNum, adminPw, idStr);
			response = "{success:true,msg:'恭喜：已成功进行存储'}";
		}catch(Exception e){
			response = "{success:false,msg:'sorry：存储失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 删除
	 * */
	public String delete(){
		log.info("进行管理员的删除  删除的id字符串：   "+ idStr);
		try{
			adminService.delete(idStr);
			response = "{success:true,msg:'恭喜：已成功进行删除'}";
		}catch(Exception e){
			response = "{success:false,msg:'sorry：删除失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 显示修改
	 * */
	public String showUpdate(){
		System.out.println("看看"+ tagId );
		admin = adminService.getAdminById(tagId);
		System.out.println(admin.getAdminNum());
		return SUCCESS;
	}
	/**
	 * 修改
	 * */
	public String update(){
		adminPw = SCUtils.encryptBasedMd5(adminPw);
		try{
			adminService.update(tagId, adminNum, adminPw);
			response = "{success:true,msg:'恭喜：已成功进行修改'}";
		}catch(Exception e){
			response = "{success:false,msg:'sorry：修改失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
    
	public List<Admin> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	public String getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public String getIdStr() {
		return idStr;
	}
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}	
