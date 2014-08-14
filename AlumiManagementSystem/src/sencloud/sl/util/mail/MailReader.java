package sencloud.sl.util.mail;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

/**
 * 读取邮件
 */
public class MailReader {
	
	@SuppressWarnings("deprecation")
	public static List<MailReaderInfo> readMail(String imapServerHost, String username, String password){
		List<MailReaderInfo> mailReaderInfos = new ArrayList<MailReaderInfo>();
		Store store = null;
		Folder folder = null;
		try {
				//获取默认会话
			   Properties props = System.getProperties();
//			   props.setProperty("mail.imap.auth.login.disable", "true"); 
			   Session session = Session.getDefaultInstance(props, null);
			   //打开调试模式
//			   session.setDebug(true);
			   //使用POP3会话机制，连接服务器
			   store = session.getStore("pop3");
			   store.connect(imapServerHost, username, password);
			   //获取默认文件夹
			   folder = store.getDefaultFolder();
			   if (folder == null) {
				   throw new Exception("No default folder");
			   }
			   //如果是收件箱
			   folder =  folder.getFolder("INBOX");
			   if (folder == null) {
				   		throw new Exception("No POP3 INBOX");
			   }
			   //使用读写方式打开收件箱
			   folder.open(Folder.READ_WRITE);
			   //得到文件夹信息，获取邮件列表
			   Message[] msgs = folder.getMessages();
			   
			   //开始生成MailReadInfo对象
			   for (int i = 0; i < msgs.length; i++) {
				   Message message = msgs[i];
				   MailReaderInfo mailReaderInfo = new MailReaderInfo();
				   
				   //获得发件人，多个发件人已";"号隔开
				   String fromAddress="";
				   if (message.getFrom()!=null) {
					   for (Address from : message.getFrom()) {
						   fromAddress+=MimeUtility.decodeText(from.toString())+";";
					   }
				   }else {
					fromAddress="没有发件人";
				   }
				   
				   mailReaderInfo.setFormAddress(fromAddress);
				   
//				   System.out.println("发件人="+fromAddress);
				   
				   //获得收件人，多个收件人用";"号隔开
				   String toAddress="";
				   if (message.getAllRecipients()!=null) {
					  
					   for (Address to : message.getAllRecipients()) {
						   if (to!=null) {
							   toAddress+=MimeUtility.decodeText(to.toString())+";";
						   }
					   }
				   }else {
					   toAddress ="无指定收件人！";
				   }
//				   System.out.println("收件人="+toAddress);
				   
				   
				   mailReaderInfo.setToAddress(toAddress);
				   //收件时间
				   if (message.getSentDate()!=null) {
					   mailReaderInfo.setDate(MimeUtility.decodeText(message.getSentDate().toLocaleString()));
				   }else {
					   mailReaderInfo.setDate("没有收件时间");
				   }
//				   System.out.println("收件时间="+mailReaderInfo.getDate());
				   
				   //邮件内容处理
				   String content="";
				   List<String> attachments = new ArrayList<String>();
				   //假如邮件是多部分的，则可能包含附件，也可使用part.isMimeType("multipart/*")判断 
				   if (message.getContent().getClass().equals(MimeMultipart.class) ) {
					   Multipart multipart = (Multipart) message.getContent();
					   for (int j = 0; j < multipart.getCount(); j++) {
						   BodyPart bodyPart = multipart.getBodyPart(j);
//						   System.out.println((j+1)+"="+bodyPart.getDisposition());
						   String dispostion = bodyPart.getDisposition();
						   //判断是否有附件。有的话保存，并存到D盘的attachment文件夹中
						   if((dispostion!=null)&&(dispostion.toLowerCase().equals(Part.ATTACHMENT)||dispostion.toLowerCase().equals(Part.INLINE))){
			                    String filename = MimeUtility.decodeText(bodyPart.getFileName());
			                    if (filename.lastIndexOf("_")!=-1) {
			                    	filename = filename.substring(filename.lastIndexOf("_")+1);
								}else if (filename.lastIndexOf("\\")!=-1) {
									filename = filename.substring(filename.lastIndexOf("\\")+1);
								}
			                    //保存附件
			                    String path = saveFile(filename,bodyPart.getInputStream());
			                    if (!path.equals("error")) {
			                    	System.out.println("保存成功");
			                    	attachments.add(path);
								}else {
									System.out.println("保存失败");
								}
			                }
						   else {
							   content = bodyPart.getContent().toString();
						}
					   }
				}else {
					content =  message.getContent().toString();
				}
				   System.out.println("正文="+content);
				   
				   //保存正文
				   mailReaderInfo.setContent(content);
				   //获得邮件主题
				   mailReaderInfo.setSubject(message.getSubject());
				   //保存附件
				   if (attachments!=null) {
					   mailReaderInfo.setAttachments(attachments);
				   }	
				   mailReaderInfos.add(mailReaderInfo);
			   }
			   
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			   //释放资源
			   try{
			    if (folder!=null){
			    	//删除文件，添加folder.delete(true);
			    	folder.delete(true);
			    	folder.close(false);
			    }
			    if (store!=null){
			    	store.close();
			    }
			   }catch (Exception ex2) {
			    ex2.printStackTrace();
			   }
			  }
		
		return mailReaderInfos;
	}
	
	
	 private static String saveFile(String filename, InputStream inputStream) throws IOException {
		 try {
			 	BufferedOutputStream bos = null;
			 	BufferedInputStream bis = null;
			 	File storefile = new File("D:\\attachment\\"+filename);
			 	File dir = storefile.getParentFile();
			 	if (!dir.exists()) {
					dir.mkdirs();
				}
	        	bos = new BufferedOutputStream(new FileOutputStream(storefile));
	            bis = new BufferedInputStream(inputStream);
	            int c;
	            while((c= bis.read())!=-1){
	                bos.write(c);
	                bos.flush();
	            }
	            return storefile.getName();
			} catch (Exception e) {
				e.printStackTrace();
				return "error";
			}
	    }
	 
	 /**
	  * 判断邮件是否已读
	  * @param message 读取到的邮件
	  * @return 是否已读
	  * @throws MessagingException
	  */
	 public static boolean isRead(Message message)throws MessagingException {
		  Flag[] flags = message.getFlags().getSystemFlags();
		  for (Flag f : flags) {
		   if (f.equals(Flag.SEEN))
		    return true;
		  }
		  return false;
	 }
	
	
	public static void main(String[] args) {
//		List<MailReaderInfo> readers =  readMail();
//		System.out.println("真正正文="+readers.get(0).getContent());
		String string = "13@小萨aa@123@@@小萨aa@163.com@@@@@ ";
		String[] strings = string.split("@");
		for (int i = 0; i < strings.length; i++) {
			System.err.println((i+1)+"="+strings[i]);
		}
	}

}
