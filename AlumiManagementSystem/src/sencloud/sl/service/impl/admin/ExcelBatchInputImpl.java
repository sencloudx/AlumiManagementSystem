package sencloud.sl.service.impl.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import sencloud.sl.dao.admin.ClassesDAO;
import sencloud.sl.dao.admin.MajorDAO;
import sencloud.sl.dao.admin.StuInforDAO;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.service.admin.ExcelBatchInput;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelBatchInputImpl implements ExcelBatchInput {
	private Sheet sheet;
	private String[][] excelValue;
	private int successRow;
	private int failRow;
	private StringBuilder msg=new StringBuilder();
	private String finalMsg;
	private StuInforDAO stuInforDAO;
	private MajorDAO majorDAO;
	private ClassesDAO classesDAO;
	/**
	 * excel导入的总方法
	 */
	public String uploadStu(File upload) {
		System.out.println("学生信息批量上传");
		initExcel(upload);		//初始化
		readExcel();			//读取
		insertIntoDB();	        //插入
		return msg.toString();
	}
	/**
	 * 读取excel文件中数据，保存到sheet对象中
	 * @param upload
	 */
	private void initExcel(File upload) {
	    Workbook rwb = null;
	    try {
	    	InputStream is = new FileInputStream(upload);
	    	rwb = Workbook.getWorkbook(is);

	    	sheet = rwb.getSheet(0);
	    } 	catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	/**
	 * 读取excel中数据进入excelValue数组中
	 * 这里好像有点问题，好像总是比实际的多出几行
	 */
	private void readExcel(){
		excelValue = new String[sheet.getRows()][sheet.getColumns()];
	    for (int i = 0; i < sheet.getRows(); i++)
	    	for (int j = 0; j < sheet.getColumns(); j++) {
	    		Cell cell = sheet.getCell(j, i);
	    		if ("".equals(cell.getContents().toString().trim())){
	    			excelValue[i][j] = "";
	    		}
	    		if (cell.getType() == CellType.LABEL) {
	    			LabelCell labelcell = (LabelCell)cell;
	    			excelValue[i][j] = labelcell.getString().trim();
	    		} else if (cell.getType() == CellType.NUMBER){
	    			excelValue[i][j] = cell.getContents();
	    		} else if (cell.getType() == CellType.DATE) {
	    			DateCell datcell = (DateCell)cell;
	    			excelValue[i][j] = datcell.getDate().toString();
	    		} else {
	    			excelValue[i][j] = cell.getContents().toString().trim();
	    		}
	      }
	  }
	
	/**
	  * 3.保存进入数据库
	  * @param course
	  */
	private void insertIntoDB() {
		int excelRows = excelValue.length;
		//将消息清空
		msg.delete(0, msg.length());
		finalMsg = "";
		successRow = 0;
		failRow = 0;
	    if (excelValue.length > 1) {
	    	for (int i = 1; i < excelRows; i++) {		//从第二排开始，第一排为文字说明
	    		String[] DBValue = excelValue[i];		//取一行数据
	    		//这里保证
	    		if(DBValue[0] != ""){
	    			if (validateInfor(i,DBValue)){
		    			successRow += 1;
		    			finalInsert(DBValue);
		    		} else {
		    			failRow += 1;
		    		}
	    		}
	    		
	    	}
	    		finalMsg = "录入成功结束："+"</br>"+"目标导入学生："+(successRow+failRow)+"</br>"
				+"成功录入数："+(successRow)+"</br>"
				+"失败录入数："+(failRow)+"</br>"
				+msg.toString();
	    	System.out.println(finalMsg);
	    } else {
	    	finalMsg = "excel中无任何数据！";
	    	System.out.println("excel中没有任何数据");
	    }
	}
	
	//最终返回检验结果
	private boolean validateInfor(int i,String[] DBValue){
		Boolean bol=true;
		if(!(validateNumRepeat(i,DBValue))){
			bol=false;
		}
		return bol;
	}
	
	//检查学号是否有重复
	private boolean validateNumRepeat(int i,String[] DBValue){
		boolean bolValidate=true;
		/**
		 * 主要检查学号是否有重复
		 * 这里需要改进，因为这里会每插入一条就会进行一次数据库的搜索
		 * */
		String hql = "from StuInfor";
		List<StuInfor> stuInfors = stuInforDAO.getStuInforListByHQL(hql);
		for(StuInfor stuInfor: stuInfors){
			if(stuInfor.getStuNum().equals(DBValue[1]) && DBValue[1]!=""){
				bolValidate=false;
				msg.append("错误信息：第"+i+"学生的学号与数据库已存储的重复,该学号是["+DBValue[1]+"],导入的学生名字["+DBValue[0]+"],请检查！</br>");
				return bolValidate;
			}
		}
		return bolValidate;
	}
	
	
	//最终插入数据,这里需要修改
	private void finalInsert(String[] DBValue){
			StuInfor stuInfor = new StuInfor();
			stuInfor.setStuName(DBValue[0]);
			stuInfor.setStuNum(DBValue[1]);
			stuInfor.setStuSex(DBValue[2]);
			stuInfor.setStuJg(DBValue[3]);
			stuInfor.setMajor(majorDAO.findById(Integer.valueOf(DBValue[4])));		//majorDAO.findById(Integer.valueOf(DBValue[4]))
			stuInfor.setStuStartTime(DBValue[5]);
			stuInfor.setStuEndTime(DBValue[6]);
			stuInfor.setStuWorkAddress(DBValue[7]);
			stuInfor.setStuWorkPlace(DBValue[8]);
			
			stuInfor.setStuWorkPost(DBValue[9]);
			stuInfor.setStuWorkZc(DBValue[10]);
			stuInfor.setStuPhone(DBValue[11]);
			stuInfor.setStuTelephone(DBValue[12]);
			stuInfor.setStuQq(DBValue[13]);
			
			stuInfor.setStuEmail(DBValue[14]);
			stuInfor.setStuCommAddress(DBValue[15]);
			stuInfor.setStuAddress(DBValue[16]);
			stuInfor.setStuSfzh(DBValue[17]);
			stuInfor.setStuNation(DBValue[18]);
			stuInfor.setStuBirth(DBValue[19]);
			stuInfor.setClasses(classesDAO.findById(Integer.valueOf(DBValue[20])));
			stuInfor.setStuPostcode(DBValue[21]);
			stuInfor.setLastXl(DBValue[22]);
			stuInfor.setLastXw(DBValue[23]);
			stuInfor.setSruHonour(DBValue[24]);
			stuInfor.setStuResume(DBValue[25]);
			stuInfor.setStuType(DBValue[26]);
			stuInfor.setDeleteType("1");
			/**
			 * 密码默认为身份证的后6位，由于发现台湾的身份证为10位的
			 * */
			String psw = "";
			if(DBValue[17].length() == 18){
				psw = DBValue[17].substring(12,18);
				stuInfor.setPassword(psw);
			}else if(DBValue[17].length() == 10){
				psw = DBValue[17].substring(4,10);
				stuInfor.setPassword(psw);
			}else{
				//如果都不是这两个省份证，则存储学号
				stuInfor.setPassword(DBValue[1]);
			}
			
			stuInfor.setStuPhotoPath("0");
			stuInforDAO.makePersistence(stuInfor);
	}
	
	/*public static void main(String[] args) {
		String a = "330122199101021718";
		String psw = a.substring(12,18);
		System.out.println(psw);
	}*/
	
	public Sheet getSheet() {
		return sheet;
	}
	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}
	public String[][] getExcelValue() {
		return excelValue;
	}
	public void setExcelValue(String[][] excelValue) {
		this.excelValue = excelValue;
	}
	public int getSuccessRow() {
		return successRow;
	}
	public void setSuccessRow(int successRow) {
		this.successRow = successRow;
	}
	public int getFailRow() {
		return failRow;
	}
	public void setFailRow(int failRow) {
		this.failRow = failRow;
	}
	public StringBuilder getMsg() {
		return msg;
	}
	public void setMsg(StringBuilder msg) {
		this.msg = msg;
	}
	public String getFinalMsg() {
		return finalMsg;
	}
	public void setFinalMsg(String finalMsg) {
		this.finalMsg = finalMsg;
	}

	public StuInforDAO getStuInforDAO() {
		return stuInforDAO;
	}
	public void setStuInforDAO(StuInforDAO stuInforDAO) {
		this.stuInforDAO = stuInforDAO;
	}
	public MajorDAO getMajorDAO() {
		return majorDAO;
	}
	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}
	public ClassesDAO getClassesDAO() {
		return classesDAO;
	}
	public void setClassesDAO(ClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}
	
}
