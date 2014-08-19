package sencloud.sl.base;

import java.util.List;

import sencloud.sl.service.admin.AdminService;
import sencloud.sl.service.admin.ClassesService;
import sencloud.sl.service.admin.CommonService;
import sencloud.sl.service.admin.ContactsService;
import sencloud.sl.service.admin.ExcelBatchInput;
import sencloud.sl.service.admin.LoginService;
import sencloud.sl.service.admin.MajorService;
import sencloud.sl.service.admin.QuestionBankService;
import sencloud.sl.service.admin.QuestionnaireService;
import sencloud.sl.service.admin.ResumeService;
import sencloud.sl.service.admin.StuInforService;


import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	/**
	 * @author shenliang 2012-04-09
	 * action的基类
	 * */
	
	private static final long serialVersionUID = 1L;	//版本统一
	
	protected String response;
	protected String request;
	protected final static String SUCCESS = "success";
	protected final static String FAILURE = "failure";
	protected final static String INPUT = "input";
	// 以下三个参数是分页需返回
	protected int currentPage = 1; 	// 当前页数
	protected int totalPages; 		// 总页数
	protected int totalRecord; 		// 总记录数
	/**
	 * 由于省市不会怎么变动这里不存储于数据库，而是使用spring容器进行注入
	 * */
	protected List<String> cityList;											//所有的省市集合
	
	protected StuInforService stuInforService;
	protected ExcelBatchInput excelBatchInput;
	protected ClassesService classesService;
	protected MajorService majorService;
	protected ExcelBatchInput classesExcelBatchInput;
	protected ExcelBatchInput majorExcelBatchInput;
	protected LoginService loginService;
	protected QuestionBankService queBankService;
	protected AdminService adminService;
	protected CommonService commonService;
	protected QuestionnaireService questionnaireService;
	protected ContactsService contactsService;
	protected ResumeService resumeService;
	
	public ResumeService getResumeService() {
		return resumeService;
	}

	public void setResumeService(ResumeService resumeService) {
		this.resumeService = resumeService;
	}

	public ContactsService getContactsService() {
		return contactsService;
	}

	public void setContactsService(ContactsService contactsService) {
		this.contactsService = contactsService;
	}

	public ExcelBatchInput getExcelBatchInput() {
		return excelBatchInput;
	}

	public void setExcelBatchInput(ExcelBatchInput excelBatchInput) {
		this.excelBatchInput = excelBatchInput;
	}

	public StuInforService getStuInforService() {
		return stuInforService;
	}

	public void setStuInforService(StuInforService stuInforService) {
		this.stuInforService = stuInforService;
	}

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String getResponse() {
		return response;
	}
	

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
	

	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public MajorService getMajorService() {
		return majorService;
	}

	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}

	public ClassesService getClassesService() {
		return classesService;
	}

	public void setClassesService(ClassesService classesService) {
		this.classesService = classesService;
	}

	public ExcelBatchInput getClassesExcelBatchInput() {
		return classesExcelBatchInput;
	}

	public void setClassesExcelBatchInput(ExcelBatchInput classesExcelBatchInput) {
		this.classesExcelBatchInput = classesExcelBatchInput;
	}

	public List<String> getCityList() {
		return cityList;
	}

	public void setCityList(List<String> cityList) {
		this.cityList = cityList;
	}

	public ExcelBatchInput getMajorExcelBatchInput() {
		return majorExcelBatchInput;
	}

	public void setMajorExcelBatchInput(ExcelBatchInput majorExcelBatchInput) {
		this.majorExcelBatchInput = majorExcelBatchInput;
	}
	
	public QuestionBankService getQueBankService() {
		return queBankService;
	}

	public void setQueBankService(QuestionBankService queBankService) {
		this.queBankService = queBankService;
	}

	public LoginService getLoginService() {
		return loginService;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public QuestionnaireService getQuestionnaireService() {
		return questionnaireService;
	}

	public void setQuestionnaireService(QuestionnaireService questionnaireService) {
		this.questionnaireService = questionnaireService;
	}
}
