/*
 * FCKeditor - The text editor for internet
 * Copyright (C) 2003-2005 Frederico Caldeira Knabben
 * 
 * Licensed under the terms of the GNU Lesser General Public License:
 * 		http://www.opensource.org/licenses/lgpl-license.php
 * 
 * For further information visit:
 * 		http://www.fckeditor.net/
 * 
 * File Name: SimpleUploaderServlet.java
 * 	Java File Uploader class.
 * 
 * Version:  2.3
 * Modified: 2005-08-11 16:29:00
 * 
 * File Authors:
 * 		Simone Chiaretta (simo@users.sourceforge.net)
 */ 
 
package sencloud.sl.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


import org.apache.commons.fileupload.*;


@SuppressWarnings("serial")
public class SimpleUploaderServlet extends HttpServlet {
	
	private static String baseDir;
	private static boolean debug=false;
	private static boolean enabled=false;
	private static Hashtable allowedExtensions;
	private static Hashtable deniedExtensions;

	 public void init() throws ServletException {
	 	//获取的debug是true
	 	debug=(new Boolean(getInitParameter("debug"))).booleanValue();
	 	
	 	//if(debug) System.out.println("\r\n---- SimpleUploaderServlet initialization started ----");
	 	//得到路径
		baseDir=getInitParameter("baseDir");
		enabled=(new Boolean(getInitParameter("enabled"))).booleanValue();
		if(baseDir==null)
			baseDir="/UserFiles/";
		//得到该路径在服务器上的绝对路径
		String realBaseDir=getServletContext().getRealPath(baseDir);
		File baseFile = new File(realBaseDir);
		if(!baseFile.exists()){
			//不存在就进行创建
			baseFile.mkdir();
		}
		
		allowedExtensions = new Hashtable(3);
		deniedExtensions = new Hashtable(3);
		//允许上传的文件类型		
		allowedExtensions.put("File",stringToArrayList(getInitParameter("AllowedExtensionsFile")));
		//不允许上传的文件类型
		deniedExtensions.put("File",stringToArrayList(getInitParameter("DeniedExtensionsFile")));

		allowedExtensions.put("Image",stringToArrayList(getInitParameter("AllowedExtensionsImage")));
		deniedExtensions.put("Image",stringToArrayList(getInitParameter("DeniedExtensionsImage")));
		
		allowedExtensions.put("Flash",stringToArrayList(getInitParameter("AllowedExtensionsFlash")));
		deniedExtensions.put("Flash",stringToArrayList(getInitParameter("DeniedExtensionsFlash")));
		
		if(debug) System.out.println("---- SimpleUploaderServlet initialization completed ----\r\n");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (debug) System.out.println("--- BEGIN DOPOST ---");

		response.setContentType("text/html; charset=UTF-8");
		response.setHeader("Cache-Control","no-cache");
		PrintWriter out = response.getWriter();
		

		String typeStr=request.getParameter("Type");
		
		String currentPath=baseDir+typeStr;
		String currentDirPath=getServletContext().getRealPath(currentPath);
		currentPath=request.getContextPath()+currentPath;
		
		if (debug) System.out.println(currentDirPath);
		
		String retVal="0";
		String newName="";
		String fileUrl="";
		String errorMessage="";
		
		if(enabled) {		
			DiskFileUpload upload = new DiskFileUpload();
			upload.setHeaderEncoding("utf-8");
			try {
				List items = upload.parseRequest(request);
				
				Map fields=new HashMap();
				
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
				    FileItem item = (FileItem) iter.next();
				    if (item.isFormField())
				    	fields.put(item.getFieldName(),item.getString());
				    else
				    	fields.put(item.getFieldName(),item);
				}
				FileItem uplFile=(FileItem)fields.get("NewFile");
				String fileNameLong=uplFile.getName();
				fileNameLong=fileNameLong.replace('\\','/');
				String[] pathParts=fileNameLong.split("/");
				String fileName=pathParts[pathParts.length-1];
				
				//后缀
				String ext=getExtension(fileName);
				
				String nameWithoutExt=getNameWithoutExtension(fileName);
				newName=nameWithoutExt+"."+ext;
				File pathToSave=new File(currentDirPath,newName);
				fileUrl=currentPath+"/"+newName;
				if(extIsAllowed(typeStr,ext)) {
					int counter=1;
					while(pathToSave.exists()){
						newName=nameWithoutExt+"("+counter+")"+"."+ext;
						fileUrl=currentPath+"/"+newName;
						retVal="201";
						pathToSave=new File(currentDirPath,newName);
						counter++;
					}
					uplFile.write(pathToSave);
				}
				else {
					retVal="202";
					errorMessage="";
					//if (debug) System.out.println("Invalid file type: " + ext);	
				}
			}catch (Exception ex) {
				if (debug) ex.printStackTrace();
				retVal="203";
			}
		}
		else {
			retVal="1";
			errorMessage="This file uploader is disabled. Please check the WEB-INF/web.xml file";
		}
		
		
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.OnUploadCompleted("+retVal+",'"+fileUrl+"','"+newName+"','"+errorMessage+"');");
		out.println("</script>");
		out.flush();
		out.close();
	
		//if (debug) System.out.println("--- END DOPOST ---");	
		
	}


	/*
	 * This method was fixed after Kris Barnhoorn (kurioskronic) submitted SF bug #991489
	 */
  	private static String getNameWithoutExtension(String fileName) {
  			Double random=(Math.random()*100000);
  			String randomString=random.toString();
  			randomString=randomString.substring(0, randomString.lastIndexOf("."));
  			String dataString=String.valueOf(new Date().getTime()); 
    		return (dataString+randomString);
    	}
    	
	/*
	 * This method was fixed after Kris Barnhoorn (kurioskronic) submitted SF bug #991489
	 */
	private String getExtension(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")+1);
	}
	/**
	 * 对获取到的上传的图片格式进行切割，然后返回list集合
	 * */
	 private ArrayList stringToArrayList(String str) {
		 if(debug) System.out.println(str);
		 String[] strArr=str.split("\\|");
		 ArrayList tmp=new ArrayList();
		 if(str.length()>0) {
			 for(int i=0;i<strArr.length;++i) {
			 		if(debug) System.out.println(i +" - "+strArr[i]);
			 		tmp.add(strArr[i].toLowerCase());
				}
			}
			return tmp;
	 }


	/**
	 * Helper function to verify if a file extension is allowed or not allowed.
	 */
	 
	 private boolean extIsAllowed(String fileType, String ext) {
	 		
	 		ext=ext.toLowerCase();
	 		
	 		ArrayList allowList=(ArrayList)allowedExtensions.get(fileType);
	 		ArrayList denyList=(ArrayList)deniedExtensions.get(fileType);
	 		
	 		if(allowList.size()==0)
	 			if(denyList.contains(ext))
	 				return false;
	 			else
	 				return true;

	 		if(denyList.size()==0)
	 			if(allowList.contains(ext))
	 				return true;
	 			else
	 				return false;
	 
	 		return false;
	 }

}

