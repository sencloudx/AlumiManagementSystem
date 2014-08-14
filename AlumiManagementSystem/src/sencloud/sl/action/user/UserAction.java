package sencloud.sl.action.user;

import java.util.Map;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.StuInfor;


import com.opensymphony.xwork2.ActionContext;

public class UserAction extends BaseAction{
	/**
	 * 校友的相关操作
	 */
	private static final long serialVersionUID = 1L;
	private StuInfor stuInfor;
	
	/**
	 * 获取校友自己的信息
	 * */
	public String getInforDetail(){
		ActionContext ctx = ActionContext.getContext();
    	Map session = ctx.getSession();
    	System.out.println("kank "+(String)session.get("adminNum"));
    	//获取登录的账号，然后根据账号进行查找
    	stuInfor = stuInforService.getStuInforByNum((String)session.get("adminNum"));
		return SUCCESS;
	}
	
	
	public StuInfor getStuInfor() {
		return stuInfor;
	}

	public void setStuInfor(StuInfor stuInfor) {
		this.stuInfor = stuInfor;
	}
	
}
