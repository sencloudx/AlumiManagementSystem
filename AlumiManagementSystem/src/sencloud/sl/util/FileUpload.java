package sencloud.sl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.activation.DataHandler;

public class FileUpload {
	 /**     
	  * <b>function:</b>传递文件     
	  * @author shenliang     
	  * @createDate 2011-11-29    
	  * @param handler DataHandler这个参数必须    
	  * @param fileName 文件名称     
	  * @return upload Info     
	  */
	public static String fileUpload(DataHandler handler, String fileName){
		
	       if (fileName != null && !"".equals(fileName)) {            
	    	   File file = new File(fileName);            
	    	   if (handler != null) {                
	    		   InputStream is = null;                
	    		   FileOutputStream fos = null;                
	    		   try {                    
	    			   is = handler.getInputStream();                    
	    			   fos = new FileOutputStream(file);                    
	    			   byte[] buff = new byte[1024 * 8];                    
	    			   int len = 0;                    
	    			   while ((len = is.read(buff)) > 0) {                        
	    				   fos.write(buff, 0, len);                    
	    				   }                
	    			   } catch(FileNotFoundException e) {                    
	    				   return "fileNotFound";                
	    				   } catch (Exception e) {                    
	    					   return "upload File failure";                
	    					   } finally {                    
	    						   try {                        
	    							   if (fos != null) {                            
	    								   fos.flush();                            
	    								   fos.close();                        
	    								   }                        
	    							   if (is != null) {                            
	    								   is.close();                        
	    								   }                    
	    							   } catch (Exception e) {                        
	    								   e.printStackTrace();                    
	    								   }                
	    							   }                
	    					   return "file absolute path:" + file.getAbsolutePath();            
	    					   } else {                
	    						   return "handler is null";            
	    				}        
	    	   		} else {            
	    	   			return "fileName is null";        
	    		   }    
	       }
}
