package sencloud.sl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;

public class LogResFilter implements Filter {
	
	private final static double DEFAULT_USERID= 0.0;   
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;  
        HttpSession session= req.getSession();  
        if (session==null){  
            MDC.put("userId",DEFAULT_USERID);
            MDC.put("userType",DEFAULT_USERID);  
        }  
        else{  
            //StuInfor stuInfor =(StuInfor)session.getAttribute("admin"); 
        	//用户的id
        	Integer userId = (Integer)session.getAttribute("userId");
        	//用户的类型
        	String adminType = (String)session.getAttribute("adminType");
            if (userId == null&& adminType == null){  
                MDC.put("userId",DEFAULT_USERID);  
                MDC.put("userType",DEFAULT_USERID);  
            }  
            else  
            {  
            	MDC.put("userId", userId);  
                MDC.put("userType", adminType);  
            }  
        }  
       chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
