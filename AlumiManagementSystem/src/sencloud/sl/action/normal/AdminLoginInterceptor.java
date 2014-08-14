package sencloud.sl.action.normal;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

//这是管理员登录的一个拦截器
public class AdminLoginInterceptor extends AbstractInterceptor{
	/**
	 *@author sl 2011-11-16
	 *@拦截未登陆的用户
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext act=invocation.getInvocationContext();
		Map session=act.getSession();
		String adminName=(String)session.get("adminName");
		if(adminName!=null){
			return invocation.invoke();
		}
		return "adminLogin";//未登录
	}
}
