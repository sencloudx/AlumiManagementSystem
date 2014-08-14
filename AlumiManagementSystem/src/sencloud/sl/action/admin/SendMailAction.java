package sencloud.sl.action.admin;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.cxf.message.Attachment;
import org.apache.struts2.ServletActionContext;

import sencloud.sl.base.BaseAction;
import sencloud.sl.service.admin.StuInforService;
import sencloud.sl.util.mail.ImageUtil;
import sencloud.sl.util.mail.MailSender;
import sencloud.sl.util.mail.MailSenderInfo;


import com.opensymphony.xwork2.ActionContext;

public class SendMailAction extends BaseAction{
	/**
	 * 邮件发送
	 */
	private static final long serialVersionUID = 1L;
	private static final String IPAddress = "http://192.168.1.107:8090";
	private String subject;					//主题
	private String message; 				//内容
	private String file; 					//附件
	private String response;
	private String idStr;
	
	
	
	private static HttpServletResponse getResponse1() {
		return ServletActionContext.getResponse();
	}
	@Override
	public String execute() throws Exception {
		System.out.println(message);
//		getResponse1().setCharacterEncoding("UTF-8");
		getResponse1().setContentType("text/html;charset= UTF-8");
		PrintWriter out = getResponse1().getWriter();
		try{
			MailSenderInfo mailInfo = new MailSenderInfo("smtp.qq.com", "544921534@qq.com", "sl6422329100"); 
			//mailInfo.setFromAddress(fromAddress); 
			mailInfo.setToAddress(idStr);
			mailInfo.setSubject(subject); 
			//将编辑器中图片的相对地址转化为绝对地址
			//String path = System.getProperty("user.dir").replace("bin", "webapps");
			//System.out.println(path);
			//System.out.println(message);
			//System.out.println(ImageUtil.replaceRelativeToAbsolute(message, IPAddress));
		    mailInfo.setContent(ImageUtil.replaceRelativeToAbsolute(message, IPAddress)); 
		    //处理附件
		    /*List<String> attachmentList = new ArrayList<String>();
		    String attachIdStr = (String)ActionContext.getContext().getSession().get("idStr");
		    if(attachIdStr != null && attachIdStr != ""){
		    	String[] attachIds = attachIdStr.split(",");
				for(String attachId: attachIds){
					Attachment attachment = commonService.findById(Attachment.class, Integer.valueOf(attachId));
					String path = ServletActionContext.getServletContext().getRealPath(savePath);
					attachmentList.add(path+"/"+attachment.getAttachmentPath());
				}
				mailInfo.setAttachFileNames(attachmentList);
		    }*/
			mailInfo.setReceipt(false);						//默认邮件阅读回执为true
			//这个类主要来发送邮件
			boolean ok = MailSender.sendHtmlMail(mailInfo);
			if(ok){
				response = "{success:true}";	
			}else{
				response = "{success:false}";	
			}
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false}";	
		}
		return SUCCESS;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getResponse() {
		return response;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public void setStuInforService(StuInforService stuInforService) {
		this.stuInforService = stuInforService;
	}
	
	public static void main(String[] args) {
		MailSenderInfo mailInfo = new MailSenderInfo("smtp.sina.com", "sl544921534@sina.cn", "sl6422329100"); 
		//mailInfo.setFromAddress(fromAddress); 
		mailInfo.setToAddress("544921534@qq.com");
		mailInfo.setSubject("你好"); 
	    mailInfo.setContent("我很好"); 
		mailInfo.setReceipt(false);						//默认邮件阅读回执为true
		//这个类主要来发送邮件
	    MailSender.sendMail(mailInfo);			//发送文体格式
	    System.out.println("发送成功");
	}
}
