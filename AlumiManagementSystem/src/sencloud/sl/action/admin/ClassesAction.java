package sencloud.sl.action.admin;


import java.io.File;
import java.util.List;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Classes;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.util.FileUtil;
import sencloud.sl.util.PageUtil;


public class ClassesAction extends BaseAction{
	/**
	 * 班级管理类
	 */
	private static final long serialVersionUID = 1L;
	private List<Classes> classesList_;
	private String classesName;					//班级名称
	private String classesRemarks;				//班级备注
	private String idStr;						//id组合字符串
	private Classes classes;
	private int tagId;
	//以下三个参数是批量导入excel,处理excel文件
	protected File uploadExcel;														//文件
	protected String uploadExcelFileName;											//文件名,好像前缀必须要跟文件相同
	protected static String[] allowFileType = { "xls", "XLS", "xlsx", "XLSX" };     //控制文件类型
	private List<StuInfor> stuInforList;
	/**	
	 * 获取班级列表
	 * */
	public String getClassesList(){
		totalRecord = classesService.getClassesNums(); 	
		System.out.println(totalRecord);
		PageUtil pageUtil = new PageUtil(currentPage, totalRecord);												
		totalPages = pageUtil.getTotalPages();
		classesList_ = classesService.getClassesList(pageUtil);
		return SUCCESS;
	}
	/**
	 * 添加班级
	 * */
	public String addClasses(){
		try{
			classesService.addClasses(classesName, classesRemarks);
			response = "{success:true,msg:'恭喜：已成功进行存储'}";
		}catch(Exception e){
			response = "{success:false,msg:'sorry：存储失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 删除
	 * */
	public String deleteClasses(){
		try{
			classesService.deleteClasses(idStr);
			response = "{success:true,msg:'恭喜：已成功删除'}";
		}catch(Exception e){
			response = "{success:false,msg:'sorry：删除失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 显示修改
	 * */
	public String showUpdateClasses(){
		classes = classesService.getClassesById(tagId);
		return SUCCESS;
	}
	/**
	 * 进行修改
	 * */
	public String updateClasses(){
		try{
			classesService.updateClasses(tagId, classesName, classesRemarks);
			response = "{success:true,msg:'恭喜：已成功修改'}";
		}catch(Exception e){
			response = "{success:false,msg:'sorry：修改失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * 批量添加班级
	 * */
	public String batchAdd(){
		try{
			System.out.println("名字"+uploadExcelFileName+"文件内容"+uploadExcel);
			if ((uploadExcelFileName == null) || (uploadExcelFileName.equals(""))) {
		        response = "{success:false,msg:'文件名不能为空！'}";
		    }
		    if (!(FileUtil.validateFileType(uploadExcelFileName, allowFileType))) {   		//validateFileType方法在FileUtil中,返回的是boolean值
		        response = "{success:false,msg:'文件类型不正确!'}";
		    }
		    classesExcelBatchInput.uploadStu(uploadExcel);									//只传入一个excel文件
		    response = "{success:true,msg:'"+classesExcelBatchInput.getFinalMsg()+"'}";		//得到结果的回复
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry: 导入失败'}";
		}
		return SUCCESS;
	}
	/**
	 * 获取班级的学生
	 * */
	public String getClassesStu(){
		stuInforList = stuInforService.getClassesStu(tagId);
		return SUCCESS;
	}
	
	
	public List<Classes> getClassesList_() {
		return classesList_;
	}
	public void setClassesList_(List<Classes> classesList) {
		classesList_ = classesList;
	}
	public String getClassesRemarks() {
		return classesRemarks;
	}
	public void setClassesRemarks(String classesRemarks) {
		this.classesRemarks = classesRemarks;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
	public String getIdStr() {
		return idStr;
	}
	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public File getUploadExcel() {
		return uploadExcel;
	}
	public void setUploadExcel(File uploadExcel) {
		this.uploadExcel = uploadExcel;
	}
	public String getUploadExcelFileName() {
		return uploadExcelFileName;
	}
	public void setUploadExcelFileName(String uploadExcelFileName) {
		this.uploadExcelFileName = uploadExcelFileName;
	}
	public List<StuInfor> getStuInforList() {
		return stuInforList;
	}
	public void setStuInforList(List<StuInfor> stuInforList) {
		this.stuInforList = stuInforList;
	}
	
}
