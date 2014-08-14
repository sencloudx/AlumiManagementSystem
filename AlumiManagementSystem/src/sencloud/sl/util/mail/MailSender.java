package sencloud.sl.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date; 
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address; 
import javax.mail.BodyPart;
import javax.mail.Message; 
import javax.mail.MessagingException;
import javax.mail.Multipart; 
import javax.mail.Session; 
import javax.mail.Transport; 
import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeBodyPart; 
import javax.mail.internet.MimeMessage; 
import javax.mail.internet.MimeMultipart; 
import javax.mail.internet.MimeUtility;

/**
 * 发送邮件，支持附件，多接收人
 * @author WWF
 *
 */
public class MailSender  { 
	/**
	 * 错误信息
	 */
	public static String errorMessage="";
	
/** 
  * 发送邮件 ，支持群发，群发收件人地址请以英文的";"号隔开
  * @param mailInfo 待发送的邮件的信息 
  * @return 是否发送成功
  */ 
	public static void sendMail(MailSenderInfo mailInfo) { 
	  // 判断是否需要身份认证 
	  MyAuthenticator authenticator = null; 
	  Properties pro = mailInfo.getProperties();
  	  // Setup mail server
	  pro.put("mail.smtp.host", mailInfo.getMailServerHost());
      // Get session
	  pro.put("mail.smtp.auth", "true"); //这样才能通过验证

	  if (mailInfo.isValidate()) { 
	  // 如果需要身份认证，则创建一个密码验证器 
		authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword()); 
	  }
	  // 根据邮件会话属性和密码验证器构造一个发送邮件的session ，mailSession = Session.getDefaultInstance(props,sa);改成mailSession = Session.getInstance(props,sa);就是新创建一个session,
	  Session sendMailSession = Session.getInstance(pro,authenticator); 
	  try { 
	  // 根据session创建一个邮件消息 
	  Message mailMessage = new MimeMessage(sendMailSession); 
	  // 创建邮件发送者地址 
	  Address from = new InternetAddress(mailInfo.getFromAddress()); 
	  // 设置邮件消息的发送者 
	  mailMessage.setFrom(from); 
	  // 创建邮件的接收者地址，并设置到邮件消息中 ,支持多个接受者，用英文的";"隔开
	  System.out.println("地址是 mail = "+mailInfo.getToAddress());
	  String[] tos = mailInfo.getToAddress().split(";");
	  List<Address> addresses = new ArrayList<Address>();
	  for (String to : tos) {
		  if (!to.trim().equals("")) {
			  System.out.println(to);
			  Address toAddress = new InternetAddress(to.trim());
			  addresses.add(toAddress);
		}
	}
	  Address [] toAddresses = new Address[addresses.size()];
	  for (int i = 0; i < addresses.size(); i++) {
		toAddresses[i] = addresses.get(i);
	}
	  //Address to = new InternetAddress(mailInfo.getToAddress()); 
//	  Address [] toAddresses = (Address[]) addresses.toArray();
	  mailMessage.setRecipients(Message.RecipientType.TO,toAddresses); 
	  
	  if (mailInfo.isReceipt()) {
		mailMessage.setHeader("Disposition-Notification-To", "1");
	}
	  //设置邮件的重要性
	  mailMessage.setHeader("Importance", "High");//  重要度    [High|Normal|Low]
	  // 设置邮件消息的主题 
	  mailMessage.setSubject(mailInfo.getSubject()); 
	  // 设置邮件消息发送的时间 
	  mailMessage.setSentDate(new Date()); 
	  // 设置邮件消息的主要内容 
	  //String mailContent = mailInfo.getContent(); 
	  //mailMessage.setText(mailContent); 
	  
	  //添加正文
	  MimeBodyPart mimeBodyPart = new MimeBodyPart();
	  /*mimeBodyPart.setText(mailContent);
	  Multipart multipart = new MimeMultipart();
	  multipart.addBodyPart(mimeBodyPart);*/
	  
	  Multipart multipart = new MimeMultipart(); 
	  // 创建一个包含HTML内容的MimeBodyPart 
	  BodyPart html = new MimeBodyPart(); 
	  // 设置HTML内容 
	  html.setContent(mailInfo.getContent(), "text/html; charset=utf-8"); 
	  multipart.addBodyPart(html); 
	  // 将MiniMultipart对象设置为邮件内容 
	  mailMessage.setContent(multipart); 
	  
	  
	  //添加附件，支持多个附件添加
	  List<String> attachFileNames = mailInfo.getAttachFileNames();
	  if (attachFileNames!=null) {
		  if (attachFileNames.size()>0) {
			  for (String string : attachFileNames) {
				  mimeBodyPart = new MimeBodyPart();
				  DataSource source = new FileDataSource(string);
				  mimeBodyPart.setDataHandler(new DataHandler(source));
				  //编码文件名，防止中文乱码
				  try {
					mimeBodyPart.setFileName(MimeUtility.encodeText(string));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				  multipart.addBodyPart(mimeBodyPart);
			  }
		}
	  }
	
	  
	  mailMessage.setContent(multipart);
	  
	  // 发送邮件 
	  Transport.send(mailMessage);
	  } catch (Exception ex) { 
		  errorMessage = ex.getMessage();
		  ex.printStackTrace(); 
	  } 
	} 
	
	/**
	 * 以HTML格式发送邮件
	 * @param mailInfo 待发送的邮件信息
	 */
	public static boolean sendHtmlMail(MailSenderInfo mailInfo) {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		pro.put("mail.smtp.host", mailInfo.getMailServerHost());
		pro.put("mail.smtp.auth", "true"); //这样才能通过验证
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(),mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		//开启调试
//		sendMailSession.setDebug(true);
		try {
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address from = new InternetAddress(mailInfo.getFromAddress());
			// 设置邮件消息的发送者
			mailMessage.setFrom(from);
			// 创建邮件的接收者地址，并设置到邮件消息中，支持多人接收
			String[] tos = mailInfo.getToAddress().split(";");
			List<Address> addresses = new ArrayList<Address>();
			for (String to : tos) {
				if (!to.trim().equals("")) {
					System.out.println(to);
					Address toAddress = new InternetAddress(to.trim());
					addresses.add(toAddress);
				}
			}
			Address[] toAddresses = new Address[addresses.size()];
			for (int i = 0; i < addresses.size(); i++) {
				toAddresses[i] = addresses.get(i);
			}
			// Address to = new InternetAddress(mailInfo.getToAddress());
			// Address [] toAddresses = (Address[]) addresses.toArray();
			mailMessage.setRecipients(Message.RecipientType.TO, toAddresses);
			
			if (mailInfo.isReceipt()) {
				mailMessage.setHeader("Disposition-Notification-To", "1");
			}
			
			// 设置邮件消息的主题
			mailMessage.setSubject(mailInfo.getSubject());
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
			Multipart mainPart = new MimeMultipart();
			// 创建一个包含HTML内容的MimeBodyPart
			MimeBodyPart html = new MimeBodyPart();
			// 设置HTML内容
			html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
			mainPart.addBodyPart(html);
			
			// 添加附件，支持多个附件添加
			List<String> attachFileNames = mailInfo.getAttachFileNames();
			if (attachFileNames != null) {
				if (attachFileNames.size() > 0) {
					for (String string : attachFileNames) {
						MimeBodyPart mimeBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(string);
						mimeBodyPart.setDataHandler(new DataHandler(source));
						// 编码文件名，防止中文乱码
						try {
							mimeBodyPart.setFileName(MimeUtility.encodeText(string));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						mainPart.addBodyPart(mimeBodyPart);
					}
				}
			}
			
			// 将MiniMultipart对象设置为邮件内容
			mailMessage.setContent(mainPart);
			// 发送邮件
			Transport.send(mailMessage);
			return true;
		} catch (MessagingException ex) {
			ex.printStackTrace();
		}
		return false;
	}

}