/*package sencloud.sl.util.mail;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Test {
	public static void testImageMail(){
		   //创建和环境有关的Session对象.  该session对象中包含了连接邮件服务器的地址.. 端口.. 协议
		   Properties  properties = new Properties();
		   //指定发送的协议
		   properties.setProperty("mail.transport.protocol", "smtp");
		   //指定邮件服务器的地址
		   properties.setProperty("mail.host", "127.0.0.1");
		   //通过javamail发送邮件的时候,会把具体的发送命令打印出来
		   properties.setProperty("mail.debug", "true");
		   Session  session = Session.getDefaultInstance(properties);
		   //创建一个代表一封邮件的Message对象
		   Message  message = new MimeMessage(session);
		   //设置发件人...
		   try {
			  //message.setFrom(new InternetAddress("xxxxxx"));
			  *//** BCC:密送CC:抄送To:发送 *//*
			  //message.setRecipient(RecipientType.TO, new InternetAddress("xxxxxx"));
			  //设置邮件的主题
			  message.setSubject("这是一个简单的邮件");
			  Multipart  multipart = new MimeMultipart("mixed");
			  //创建一个装显示图片的html
			  MimeBodyPart  html = new MimeBodyPart();
			  //要使用cid来指定具体的资源id
			  html.setContent("<img src='cid:pic'>", "text/html");
			  //创建一个图片的mimebodypart
			  MimeBodyPart image = new MimeBodyPart();
			  //将一个图片做具体的数据出过来
			  image.setDataHandler(new DataHandler(new FileDataSource(new File("F:\\1345902186723.gif"))));
			  image.setHeader("Content-ID", "<pic>");;
			  multipart.addBodyPart(html);
			  multipart.addBodyPart(image);
			  //设置一个复杂类型的邮件内容
			  message.setContent(multipart);
			  //可以通过Session对象找得到发送对象Transport...
			  Transport transport = session.getTransport();
			  //通过发送对象去连接邮件服务器... 提供链接服务器的用户名而不是邮件的地址,不带@符号的
			  transport.connect("smtp.qq.com", "544921534@qq.com", "sl6422329100");
			  //连接上后发送邮件(Message),发送给指定的地址
			  transport.sendMessage(message, message.getAllRecipients());
			  //关闭连接
			  transport.close();
		   } catch (Exception e) {
			   e.printStackTrace();
		  }
	}
	public static void main(String[] args) {
		testImageMail();
	}
}
*/

package sencloud.sl.util.mail;

public class Test {
	public static void main(String[] args){
		try {
			   //这个类主要是设置邮件
			  MailSenderInfo mailInfo = new MailSenderInfo("smtp.qq.com", "908813343@qq.com", "admin"); 
			  mailInfo.setToAddress("908813343@qq.com"); 
			  String IP = "http://www.oschina.net";//这里是服务器的域名或是ip地址
			  String content =  "<img id='NewsPic' src='/img/logo/android.png' /><p>测试</p>";
			  //替换绝对地址
			  content = ImageUtil.replaceRelativeToAbsolute(content, IP);
			  System.out.println(content);
 			  mailInfo.setSubject("html测试"); 
			  mailInfo.setContent(content); 
//			  String fileNames="C:\\Users\\WWF\\Pictures\\哈哈.jpg";
//			  String fileNames2 ="C:\\Users\\WWF\\Pictures\\360截图20120425130357742.jpg";
//			  List<String> attachFileNames = new ArrayList<String>();
//			  attachFileNames.add(fileNames);
//			  attachFileNames.add(fileNames2);
//			  mailInfo.setAttachFileNames(attachFileNames);
			  //mailInfo.setReceipt(false);默认邮件阅读回执为true
			  //发送邮件，以html形式发送
		      boolean ok = MailSender.sendHtmlMail(mailInfo);
		      if (ok) {
				System.out.println("发送成功");
			}
		      else {
		    	  System.out.println("发送失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
     
	}
}