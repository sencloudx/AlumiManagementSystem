package sencloud.sl.util;

import java.io.File;
import java.io.FilenameFilter;

public class FileUtil {
		/**
	    * 验证文件的类型
	    * 
	    * @param fileName        文件的名称
	    * @param allowFileType	 允许的文件类型
	    */
	   public static boolean validateFileType(String fileName,String[] allowFileType){  //传递进来文件名，和运行的文件后缀名
		   boolean isFileRight=false;
		   String[] fileMsg = getFileSuffix(fileName);    //调用后面的getFileSuffix()方法
		   for(int i=0;i<allowFileType.length;i++){
			   if(fileMsg[1].equals(allowFileType[i])){		//当得到的文件后缀名跟指定的后缀名相同时，返回true
				   isFileRight=true;
				   break;
			   }
		   }
		   return isFileRight;
	   }
	     /**
		   * 获得文件的后缀名和文件名
		   * 
		   * @param fileName		文件的名称
		   * @return				一维是文件名，二维是文件后缀名
		   */
		   public static String[] getFileSuffix(String fileName){
			   int pos = fileName.lastIndexOf(".");
		        return new  String[]{fileName.substring(pos),fileName.substring(pos+1)};
		   }
		  
		   
		   /**
		    * 指定目录下的文件操作
		    * */
		   public static void listRoots() {
			    // 将根目录存入File数组roots中
			    File[] roots = File.listRoots();
			    // 打印出根目录
			    try {
			     for (int i = 0; i < roots.length; i++) {
			      System.out.println("======================================");
			      System.out.println("根目录" + roots[i] + "的文件列表:");
			      // System.out.println("该目录的容量为:"+roots[i].length());只有文件才有此方法才会返回字节长度,目录为0
			      System.out.println("======================================\n");
			      // 打印出根目录下的文件
			      File[] rootfile = roots[i].listFiles();
			      for (File rf : rootfile) {
			       System.out.println(rf);
			       // System.out.println("------------------------------------");
			      }

			     }
			    } catch (RuntimeException e) {
			    	e.printStackTrace();
			    }

			}

			// 删除指定文件或一些文件
			public static void deleteFiles(String path, String inname, String inextension) {
			    //boolean status = true;
			    FileManagerFilter fmf = new FileManagerFilter(inname, inextension);
			    File file = new File(path);
			    File[] filelist = file.listFiles(fmf);

			    // System.out.println(filelist.length); 此语句用于测试
			    if (filelist.length != 0) {
			     System.out.println("**************删除文件*************");
			     for (File fl : filelist) {

			      // boolean delfil = fl.delete();

			      System.out.println(fl + (fl.delete() ? " 成功" : " 没有成功")
			        + "被删除!");
			     }
			    } else {
			     System.out.println("根据您所给的条件,没有找到要删除的文件!");
			    }

			}

			// 删除所有目录下所有文件,但是目录没有删除,哈哈其实效果一样
			public static void deletAllFile() {
			    File[] roots = File.listRoots();
			    for (int i = 0; i < roots.length; i++) {
			     if (roots[i].isDirectory()) {
			    	 FileUtil.deleteFiles(roots[i].toString(), "*", "*");
			     }
			    }
			}
}


class FileManagerFilter implements FilenameFilter {
	private String name;

	private String extension;

	public FileManagerFilter(String name, String extension) {
	    this.name = name;
	    this.extension = extension;

	}

	public boolean accept(File dir, String filename) {
	    boolean fileOK = true;
	    if (name == "*"&&extension=="*") {
	     return fileOK = true;

	    }
	    if (name != null) {
	     // 不大解理"&="的运行过程,
	     fileOK &= filename.startsWith(name);

	    }
	    if (extension != null) {
	     fileOK &= filename.endsWith('.' + extension);
	    }

	    return fileOK;
	}

	}

