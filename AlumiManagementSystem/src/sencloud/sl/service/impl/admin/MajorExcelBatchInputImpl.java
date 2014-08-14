package sencloud.sl.service.impl.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import sencloud.sl.dao.admin.MajorDAO;
import sencloud.sl.entity.Major;
import sencloud.sl.service.admin.ExcelBatchInput;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
/**
 * jxl确实好像有很多方面的问题，好像不支持xlsx
 * 有待解决
 * 而且这个好像在解析excel表格的行数时好像都是多几行的
 * */
public class MajorExcelBatchInputImpl implements ExcelBatchInput {
	private Sheet sheet;
	private String[][] excelValue;
	private int successRow;
	private int failRow;
	private StringBuilder msg=new StringBuilder();
	private String finalMsg;
	private MajorDAO majorDAO;
	
	/**
	 * excel导入的总方法
	 */
	public String uploadStu(File upload) {
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
	    		if(DBValue[0] != ""){
	    			if (validateInfor(i,DBValue)){
		    			successRow += 1;
		    			finalInsert(DBValue);
		    		} else {
		    			failRow += 1;
		    		}
	    		}
	    	}
	    		finalMsg = "录入成功结束："+"</br>"+"目标导入班级："+(successRow+failRow)+"</br>"
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
	
	//验证岗位是否重复
	private boolean validateNumRepeat(int i,String[] DBValue){
		boolean bolValidate=true;
		/**
		 * 主要检查学号是否有重复
		 * 这里需要改进，因为这里会每插入一条就会进行一次数据库的搜索
		 * */
		String hql = "from Major";
		List<Major> majorList = majorDAO.findListByHQL(hql);
		for(Major major: majorList){
			if(major.getMajorName().equals(DBValue[0]) && DBValue[0]!=""){
				bolValidate=false;
				msg.append("错误信息：第"+i+"专业的名称与数据库已存储的重复,该名称是["+DBValue[0]+"],请检查！</br>");
				return bolValidate;
			}
		}
		return bolValidate;
	}
	
	
	//最终插入数据,这里需要修改
	private void finalInsert(String[] DBValue){
		Major major = new Major();
		major.setMajorName(DBValue[0]);
		major.setMajorRemarks(DBValue[1]);
		majorDAO.makePersitent(major);
	}
	
	
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
	public MajorDAO getMajorDAO() {
		return majorDAO;
	}
	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}
	
}
