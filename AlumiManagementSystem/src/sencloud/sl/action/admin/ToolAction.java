package sencloud.sl.action.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.OperateLog;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.util.Unzip;


public class ToolAction extends BaseAction implements ServletResponseAware,ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<StuInfor> stuInforList;
	private static String[] prefixs = {".jpg", ".png", ".gif"};
	private String response;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private static final int BUFFER_SIZE = 16 * 1024 ;
	private List<OperateLog> operateLogList;
	protected javax.servlet.http.HttpServletResponse responseTrue;
	protected javax.servlet.http.HttpServletRequest request;
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	/**
	 * 显示照片筛选界面
	 * */
	public String showSelect(){
		stuInforList = stuInforService.getStuInforList();
		return SUCCESS;
	}
	/**
	 * 进行照片的筛选
	 * @throws FileNotFoundException 
	 * */
	public String select() throws FileNotFoundException{
		try{
			String newPath = ServletActionContext.getServletContext().getRealPath("/stuPhoto");;
			showSelect();
			//进行筛选与上传
			GetSelectFileName(newPath, stuInforList, prefixs);
			response = "{success:true}";
		}catch (Exception e) {
			System.out.println("筛选失败");
			response = "{success:false}";
		}
		
		
		return SUCCESS;
	}
	
	/**
	 * @param fileAbsolutePath 需要遍历的文件目录
	 * @param newFilePath 放符合文件的路径
	 * @param selectName 符合条件的图片名称[现在为校友对象集合]
	 * @param prefixs 符合遍历条件的后缀名
	 * @throws FileNotFoundException 
	 * 
	 * 
	 * */
    public void GetSelectFileName(String newFilePath, List<StuInfor> selectName, String[] prefixs) throws FileNotFoundException
    {
         //File file = new File(fileAbsolutePath);
    	String path = ServletActionContext.getServletContext().getRealPath("uploadPhoto");
    	//File file = new File(path+"/"+fileAbsolutePath);
    	File file = new File(path);
         //文件内的文件
         File[] subFile = file.listFiles();
         //对所有的文件进行遍历
         for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++)
         {
             //判断是否为文件夹
             if (!subFile[iFileLength].isDirectory())
             {
                 String tempName = subFile[iFileLength].getName();
                 //先判断该文件名是否符合扩展名
                 for(int prefixLength = 0; prefixLength < prefixs.length; prefixLength++){
                	 //如果符合指定的后缀
                	 if(tempName.toLowerCase().endsWith(prefixs[prefixLength])){
                		 String[] tempNameSplit = tempName.split("\\.");
                		 //是否符合筛选的要求
                		 for(StuInfor name: selectName){
                			 if (name.getStuSfzh().equals(tempNameSplit[0]))
                             {
                				 System.out.println("筛选的身份证号 = "+name.getStuSfzh());
                				 //将符合条件的文件放入另一个指定的文件夹
                				 Copy(path+"/"+tempName, newFilePath);
                				 //进行数据库的存储
                				 savePhoto(name.getStuSfzh(), "stuPhoto/"+tempName);
                             }
                		 }
                     }
                 }
             }
         }
    }
    /**
     * 用流的方式进行文件的复制
     * */
    public void Copy(String oldPath, String newPath)  
    {  
    try {  
	    int bytesum = 0;  
	    int byteread = 0;
	    File newFile = new File(newPath);
	    if(!newFile.exists()){
	    	newFile.mkdirs();
	    }
	    File oldfile = new File(oldPath);  
	    if (oldfile.exists()) {  
		    InputStream is = new FileInputStream(oldPath);  
		    
		    FileOutputStream fs = new FileOutputStream(newPath+"/"+oldfile.getName());  
		    byte[] buffer = new byte[1444];  
		    while ((byteread = is.read(buffer)) != -1) {  
			    bytesum += byteread;  
			    System.out.println(bytesum);  
			    fs.write(buffer, 0, byteread);  
		    }  
		    is.close();
		    fs.close();
	    }  
    }  
    catch (Exception e) {  
	    System.out.println( "error ");  
	    e.printStackTrace();  
    	}  
    }
    /**
     * 进行文件的上传
     * @throws IOException 
     * */
    public String uploadFile() throws IOException{
//    	responseTrue.setCharacterEncoding("UTF-8");
    	responseTrue.setContentType("text/html;charset= UTF-8");
		PrintWriter outTrue = responseTrue.getWriter();
    	System.out.println("被调用的次数");
    	try {
			String path = ServletActionContext.getServletContext().getRealPath("uploadPhoto");
			File directory = new File(path);
			if (!directory.exists()) {
				directory.mkdir();
			}
			String dbSavePath = path + "/" + getUploadFileName();
			BufferedOutputStream out = null;
			BufferedInputStream in = null;
			try {
				in = new BufferedInputStream(new FileInputStream(getUpload()),
						BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(new File(
						dbSavePath)), BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
				System.out.println("路径"+dbSavePath);
				//进行解压缩包
				Unzip.unZip(dbSavePath);
				out.flush();
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
			//response = "{\"success\":true,\"msg\":\"恭喜：上传成功\"}";
			outTrue.println("<script>parent.callback('上传成功')</script>"); 
		}catch (Exception e) {
			e.printStackTrace();
			//response = "{\"success\":false,\"msg\":\"sorry：失败，请重新上传\"}";
			outTrue.println("<script>parent.callback('上传失败')</script>"); 
		}
		return null;
    }
    
    
    public void savePhoto(String sfzh, String stuPhotoPath){
    	StuInfor stuInfor = stuInforService.getInforBySfz(sfzh);
    	stuInfor.setStuPhotoPath(stuPhotoPath);
    	stuInforService.update(stuInfor);
    	System.out.println("保存成功");
    }
    
    /**
     * 获取日志信息
     * */
    public String logList(){
    	operateLogList = commonService.findAll(OperateLog.class);
    	return SUCCESS;
    }
    
    
	public List<StuInfor> getStuInforList() {
		return stuInforList;
	}
	public String getResponse() {
		return response;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.responseTrue = response;
		
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	public List<OperateLog> getOperateLogList() {
		return operateLogList;
	}
	public void setOperateLogList(List<OperateLog> operateLogList) {
		this.operateLogList = operateLogList;
	}
    
}
