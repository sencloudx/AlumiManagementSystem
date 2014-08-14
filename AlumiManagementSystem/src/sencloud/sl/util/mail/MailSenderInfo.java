package sencloud.sl.util.mail;
/** 
* 发送邮件需要使用的基本信息 
*/ 
import java.util.List;
import java.util.Properties; 
public class MailSenderInfo { 
	// 发送邮件的服务器的IP和端口 
	private String mailServerHost = null;                   //"smtp.sina.com";
	private String mailServerPort = "25"; 
	// 邮件发送者的地址 
	private String fromAddress=	null;						//"mydearq2@sina.com";
	// 邮件接收者的地址 
	private String toAddress; 
	// 登陆邮件发送服务器的用户名和密码 
	private String userName= null;							//"mydearq2@sina.com";
	private String password= null;							//"wwf52072";
	// 是否需要身份验证 
	private boolean validate = true; 
	// 邮件主题 
	private String subject; 
	// 邮件的文本内容 
	private String content; 
	// 邮件附件的文件名 
	private List<String> attachFileNames; 	
	//邮件阅读回执
	private boolean Receipt = true;
	
	public MailSenderInfo(String mailServerHost, String userName, String password){
		this.mailServerHost = mailServerHost;
		this.fromAddress = userName;
		this.userName = userName;
		this.password = password;
	}
	/** 
	  * 获得邮件会话属性 
	  */ 
	public Properties getProperties(){ 
	  Properties p = new Properties(); 
	  p.put("mail.smtp.host", this.mailServerHost); 
	  p.put("mail.smtp.port", this.mailServerPort); 
	  p.put("mail.smtp.auth", validate ? "true" : "false"); 
	  return p; 
	} 
	public String getMailServerHost() { 
	  return mailServerHost; 
	} 
	public void setMailServerHost(String mailServerHost) { 
	  this.mailServerHost = mailServerHost; 
	}
	public String getMailServerPort() { 
	  return mailServerPort; 
	}
	public void setMailServerPort(String mailServerPort) { 
	  this.mailServerPort = mailServerPort; 
	}
	public boolean isValidate() { 
	  return validate; 
	}
	public void setValidate(boolean validate) { 
	  this.validate = validate; 
	}
	
	
	public List<String> getAttachFileNames() {
		return attachFileNames;
	}
	public void setAttachFileNames(List<String> attachFileNames) {
		this.attachFileNames = attachFileNames;
	}
	public String getFromAddress() { 
	  return fromAddress; 
	} 
	public void setFromAddress(String fromAddress) { 
	  this.fromAddress = fromAddress; 
	}
	public String getPassword() { 
	  return password; 
	}
	public void setPassword(String password) { 
	  this.password = password; 
	}
	public String getToAddress() { 
	  return toAddress; 
	} 
	public void setToAddress(String toAddress) { 
	  this.toAddress = toAddress; 
	} 
	public String getUserName() { 
	  return userName; 
	}
	public void setUserName(String userName) { 
	  this.userName = userName; 
	}
	public String getSubject() { 
	  return subject; 
	}
	public void setSubject(String subject) { 
	  this.subject = subject; 
	}
	public String getContent() { 
	  return content; 
	}
	public void setContent(String textContent) { 
	  this.content = textContent; 
	}
	public boolean isReceipt() {
		return Receipt;
	}
	public void setReceipt(boolean receipt) {
		Receipt = receipt;
	}
	
	
} 