package sencloud.sl.action.admin;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import sencloud.sl.base.BaseAction;
import sencloud.sl.commons.CommonValue;
import sencloud.sl.entity.Admin;
import sencloud.sl.entity.Classes;
import sencloud.sl.entity.DocProtitle;
import sencloud.sl.entity.TeaProtitle;
import sencloud.sl.util.SCUtils;
import sencloud.sl.entity.Resume;

import com.opensymphony.xwork2.ActionContext;

/**
 * 该类处理履历的处理action
 * */
public class ResumeAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StuInforAction.class);//日志文件
	
	//定义resume对象
		private Resume resume;
		private String start_time;
		private String end_time;
		private String company;
		private String post;
		private String desc;

	
	

	public String addResume() throws UnsupportedEncodingException{
try{
			
			
			//这里是对其简历的基本添加
			Resume resumeAdd = new Resume();
			resumeAdd.setResumeCompany(company);
			resumeAdd.setResumeDesc(desc);
			resumeAdd.setResumePost(post);
			resumeAdd.setEndTM(end_time);
			resumeAdd.setStartTM(start_time);
			
			
			int i=resumeService.save(resumeAdd);
			System.out.println("保存是否成功："+i);
			response = "{success:true,id:'"+i+"'}";
			
			
			//log.info("成功进行校友的添加，添加的校友姓名为  "+stuInfor.getStuName()+", 学号为  "+stuInfor.getStuNum());
			//response = "{success:true,msg:'OK'}";
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry：Failed'}";
		}
		
		return SUCCESS;
		
	}
	

	
	
	
	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	
	
}
