package sencloud.sl.action.admin;

import java.io.File;
import java.util.List;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Major;
import sencloud.sl.util.FileUtil;
import sencloud.sl.util.PageUtil;


public class MajorAction extends BaseAction{
	/**
	 * 专业的处理类
	 */
	private static final long serialVersionUID = 1L;
	private List<Major> majorList_;
	private String majorName;
	private String majorRemark;
	private String idStr;
	private Major major;
	private Integer tagId;
	//以下三个参数是批量导入excel,处理excel文件
	protected File uploadExcel;														//文件
	protected String uploadExcelFileName;											//文件名,好像前缀必须要跟文件相同
	protected static String[] allowFileType = { "xls", "XLS", "xlsx", "XLSX" };     //控制文件类型
	/**
	 * 获取专业列表
	 * */
	public String getMajorList(){
		totalRecord = majorService.getMajorNums(); 		
		PageUtil pageUtil = new PageUtil(currentPage, totalRecord);												
		totalPages = pageUtil.getTotalPages();
		majorList_ = majorService.getMajorList(pageUtil);
		return SUCCESS;
	}
	/**
	 * 添加专业
	 * */
	public String addMajor(){
		try{
			System.out.println("看看"+majorName);
			majorService.addMajor(majorName, majorRemark);
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
	public String deleteMajor(){
		try{
			majorService.deleteMajor(idStr);
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
	public String showUpdateMajor(){
		major = majorService.getMajorById(tagId);
		return SUCCESS;
	}
	/**
	 * 进行修改
	 * */
	public String updateMajor(){
		try{
			majorService.updateMajor(tagId, majorName, majorRemark);
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
			if ((uploadExcelFileName == null) || (uploadExcelFileName.equals(""))) {
		        response = "{success:false,msg:'文件名不能为空！'}";
		    }
		    if (!(FileUtil.validateFileType(uploadExcelFileName, allowFileType))) {   		//validateFileType方法在FileUtil中,返回的是boolean值
		        response = "{success:false,msg:'文件类型不正确!'}";
		    }
		    majorExcelBatchInput.uploadStu(uploadExcel);									//只传入一个excel文件
		    response = "{success:true,msg:'"+majorExcelBatchInput.getFinalMsg()+"'}";		//得到结果的回复
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry: 导入失败'}";
		}
		return SUCCESS;
	}
	
	public List<Major> getMajorList_() {
		return majorList_;
	}
	public void setMajorList_(List<Major> majorList) {
		majorList_ = majorList;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public String getMajorRemark() {
		return majorRemark;
	}
	public void setMajorRemark(String majorRemark) {
		this.majorRemark = majorRemark;
	}
	public String getIdStr() {
		return idStr;
	}
	public void setIdStr(String idStr) {
		this.idStr = idStr;
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
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	
}
