package sencloud.sl.action.admin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import sencloud.sl.base.BaseAction;
import sencloud.sl.commons.CommonValue;
import sencloud.sl.entity.Admin;
import sencloud.sl.entity.Classes;
import sencloud.sl.entity.Contacts;
import sencloud.sl.entity.DocProtitle;
import sencloud.sl.entity.Major;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.entity.TeaProtitle;
import sencloud.sl.util.FileUtil;
import sencloud.sl.util.PageUtil;
import sencloud.sl.util.SCUtils;


import com.opensymphony.xwork2.ActionContext;

public class StuInforAction extends BaseAction{
	/**
	 * 该类是学生信息的一些处理
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StuInforAction.class);//日志文件
	
	private StuInfor stuInfor;
	private List<Classes> classesList;
	private List<Major> majorList = new ArrayList<Major>();
	private List<StuInfor> inforList;
	private List<StuInfor> stuList = new ArrayList<StuInfor>();
	private List<Contacts> contactsList = new ArrayList<Contacts>();
	private String password;
	private Integer classesId;
	private String classesStr;
	private Integer majorId;
	private String major;
	private String city;
	private int tagId;
	private String idStr;
	private String idStuStr;
	//上传的文件
	private File upload;
	//上传的文件名，通常为XXFileName,还有事上传的文件类型：XXContentType
	private String uploadFileName;
	private String type; 													//判断是删除还是还原
	private String showType;												//显示的类型
	//private String major;
	private String address;													//就业省市
	private String sourceCity;												//生源省市
	private Classes classes;
	private String authorization;
	//搜索
	private int searchType;
	private String searchContext;
	//统计不同专业的人数
	private int eye7;														//眼7
	private int eye5;														//眼5
	private int eye3;														//眼3
	private int eyeb;														//眼博
	private int eyes;														//眼硕
	private int eyetea;														//教职工
	private int eyejx;														//继续教育
	//以下三个参数是批量导入excel,处理excel文件
	protected File uploadExcel;														//文件
	protected String uploadExcelFileName;											//文件名,好像前缀必须要跟文件相同
	protected static String[] allowFileType = { "xls", "XLS", "xlsx", "XLSX" };     //控制文件类型
	private List<DocProtitle> docProtitleList;
	private List<TeaProtitle> teaProtitleList;
	private Integer teaProtitleId;
	private Integer docProtitleId;
	private Integer userId;
	private Integer[] ids;
	
	
	/**
	 * 获取学生所有集合含分页
	 * 可按省份进行分类查找
	 * */
	public String getStuInforList(){
		/**
		 * 这里使用log时并没有直接使用log.debug，而是先进行判断，因为如果判断为false，那个该方法在编译的时候能直接将该代码块删除，
		 * 执行效率会提高，（C1）
		 * */
		if("联络员".equals(ActionContext.getContext().getSession().get("adminType")) || "普通校友".equals(ActionContext.getContext().getSession().get("adminType"))){
			Integer userId = (Integer)ActionContext.getContext().getSession().get("userId");
			classesId = stuInforService.getInforById(userId).getClasses().getClassesId();
			System.out.println("班级id是 = "+classesId);
		}
//		Integer userId = (Integer)ActionContext.getContext().getSession().get("userId");
//		classesId = stuInforService.getInforById(userId).getClasses().getClassesId();
//		System.out.println("班级id是 = "+classesId);
		//进行数据的初始化
		initialize();
		//总的信息条数
		totalRecord = stuInforService.getStuInforNums(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId); 		// 
		PageUtil pageUtil = new PageUtil(currentPage, totalRecord);	
		//总的页面数
		totalPages = pageUtil.getTotalPages();
		//信息的集合
		inforList = stuInforService.getStuInforList(pageUtil, city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		//获取各个专业的人数
		getMajorStu(totalRecord);
		//班级与专业
		getClassesAndMajor();
		//获得职称
		getProtitleList();
		return SUCCESS;
	}
	/**
	 * 根据省市显示分布
	 * */
	public String showSpread(){
		initialize();
		getClassesAndMajor();
		System.out.println("就业城市与生源  = "+ city + "   "+ sourceCity);
		totalRecord = stuInforService.getStuInforNums(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		getMajorStu(totalRecord);
		totalRecord = stuInforService.getStuInforNums(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		inforList = stuInforService.getStuInforList(city, major, showType, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		return SUCCESS;
	}
	
	/**
	 * 显示添加页面
	 * */
	public String showAddInfor(){
		//获取班级和专业
		getClassesAndMajor();
		getProtitleList();
		return SUCCESS;
	}
	private void getProtitleList(){
		//获取医师职称和教师职称
		docProtitleList = commonService.findAll(DocProtitle.class);
		teaProtitleList = commonService.findAll(TeaProtitle.class);
	}
	/**
	 * 进行学生信息的添加
	 * @throws UnsupportedEncodingException 
	 * */
	public String addInfor() throws UnsupportedEncodingException{
		try{
			//System.out.println(upload);
			if(upload!=null&&!"".equals(upload)){
				saveUserPhoto();
			}
			stuInfor.setDeleteType("1");
			/**
			 * 好像struts2的form表单提交好像不支持外键的提交的
			 * */
			stuInfor.setClasses(classesService.getClassesById(classesId));
			majorId = Integer.valueOf(major);
			stuInfor.setMajorId(majorId);
			stuInfor.setMajor(majorService.getMajorById(Integer.valueOf(major)));
			//密码默认为身份证的后6位
			String psw = null;
			if(stuInfor.getStuSfzh() != null && !"".equals(stuInfor.getStuSfzh()) && stuInfor.getStuSfzh().length() > 6){
				psw = stuInfor.getStuSfzh().substring(stuInfor.getStuSfzh().length()-6,stuInfor.getStuSfzh().length());
				psw = SCUtils.encryptBasedMd5(psw);
			}
			stuInfor.setPassword(psw);
			//职称
			DocProtitle docProtitle = commonService.findById(DocProtitle.class, docProtitleId);
			TeaProtitle teaProtitle = commonService.findById(TeaProtitle.class, teaProtitleId);
			stuInfor.setDocProtitle(docProtitle);
			stuInfor.setTeaProtitle(teaProtitle);
			stuInforService.save(stuInfor);
			log.info("成功进行校友的添加，添加的校友姓名为  "+stuInfor.getStuName()+", 学号为  "+stuInfor.getStuNum());
			response = "{success:true,msg:'OK'}";
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry：Failed'}";
		}
		
		return SUCCESS;
	}
	/**
	 * 显示学生的信息详情
	 * */
	public String showInforDetail(){
		getClassesAndMajor();
		//获取医师职称和教师职称
		getProtitleList();
		stuInfor = stuInforService.getInforById(tagId);
		return SUCCESS;
	}
	/**
	 * 对考生信息进行彻底的删除
	 * */
	public String thoroughDelete(){
		try{
			//stuInforService.thoroughDelete(ids);
			if(ids != null && ids.length > 0){
				for(Integer id : ids){
					stuInforService.delete(id);
				}
			}
			response = "{success:true,msg:'OK'}";
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry：Failed'}";
		}
		return SUCCESS;
	}
	/**
	 * 进行更新
	 * */
	public String inforUpdate(){
		try{
			//进行照片的处理
			if(upload!=null&&!"".equals(upload)){
				saveUserPhoto();
			}
			//进行更新
			stuInfor.setDeleteType("1");
			stuInfor.setClasses(classesService.getClassesById(classesId));
			stuInfor.setMajor(majorService.getMajorById(Integer.valueOf(major)));
//			if(docProtitleId != 0){
//				stuInfor.setDocProtitle(commonService.findById(DocProtitle.class, docProtitleId));
//			}
//			if(teaProtitleId != 0){
//				stuInfor.setTeaProtitle(commonService.findById(TeaProtitle.class, teaProtitleId));
//			}
			stuInfor.setPassword(password);
			stuInforService.update(stuInfor);
			log.info("信息的更改，更改的校友姓名为  "+stuInfor.getStuName()+", 学号为  "+stuInfor.getStuNum());
			response = "{success:true,msg:'OK'}";
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'Failed'}";
		}
		return SUCCESS;
	}
	/**
	 * 伪删除与还原，就是将字段delete_sign设为0即可
	 * */
	public String fakeDelete(){
		System.out.println("类型"+ type);
		try{
			stuInforService.updateDeleteSign(idStr, type);
			System.out.println("已成功还原");
			response = "{success:true,msg:'OK'}";
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry：Failed'}";
		}
		return SUCCESS;
	}
	/**
	 * 显示授权界面
	 * */
	public String showAuthorization(){
		//最好能查询所有被选校友的信息
		String[] ids = idStr.split("-");
		for(String id: ids){
			StuInfor stuInfor = stuInforService.getInforById(Integer.valueOf(id));
			//System.out.println("校友信息  = "+stuInfor.getStuName());
			stuList.add(stuInfor);
		}
		return SUCCESS;
	}
	/**
	 * 进行权限的授予
	 * */
	public String authorization(){
		try{
			stuInforService.authorization(idStr, authorization);
		    response = "{success:true}";	
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false}";
		}
		return SUCCESS;
	}
	/**
	 * 显示各个专业的人数
	 * */
	public String majorStuNum(){
		System.out.println("传过来的城市为 ="+city);
		initialize();
		//获取所有的专业
		getClassesAndMajor();
		try{
			//Map<String, Integer> map = new HashMap<String, Integer>();
			StringBuffer sb = new StringBuffer();
			for(int i = 0;i< majorList.size(); i++){
				Integer stuNum = stuInforService.getStuInforList(city.trim(), majorList.get(i).getMajorName(), "0", "0", 0, "0", 0, sourceCity.trim(),0,0).size();
				//map.put(majorList.get(i).getMajorName(), stuNum);
				sb.append(majorList.get(i).getMajorName()+":"+stuNum+"<br/>");
			}
			System.out.println(sb.toString());
		    response = "{success:true,tip:'"+sb.toString()+"'}";	
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false}";
		}
		return SUCCESS;
	}
	/**
	 * excel批量导入
	 * */
	public String excelUpload(){
		System.out.println("批量导入的文件  = " + uploadExcel);
		try{
			if ((uploadExcelFileName == null) || (uploadExcelFileName.equals(""))) {
		        response = "{success:false,msg:'文件名不能为空！'}";
		    }
		    if (!(FileUtil.validateFileType(uploadExcelFileName, allowFileType))) {   //validateFileType方法在FileUtil中,返回的是boolean值
		        response = "{success:false,msg:'文件类型不正确!'}";
		    }
		    excelBatchInput.uploadStu(uploadExcel);									//只传入一个excel文件
		    response = "{success:true,msg:'"+excelBatchInput.getFinalMsg()+"'}";	//得到结果的回复
		}catch (Exception e) {
			e.printStackTrace();
			response = "{success:false,msg:'sorry: 导入失败'}";
		}
		return SUCCESS;
	}
	/**
	 * 导出excel操作，get方法名必须与struts.xml中指定的文件下载方法名对应
	 * */
	public InputStream getExportInfor() throws Exception{
		idStr = java.net.URLDecoder.decode(idStr, "UTF-8");				//进行编码的转换，导出的项
		showType = java.net.URLDecoder.decode(showType, "UTF-8");	
		address = java.net.URLDecoder.decode(address, "UTF-8");	
		idStuStr = java.net.URLDecoder.decode(idStuStr, "UTF-8");	
		searchContext = java.net.URLDecoder.decode(searchContext, "UTF-8");
		sourceCity = java.net.URLDecoder.decode(sourceCity, "UTF-8");
		System.out.println("kank "+ idStr+ showType+ address+ idStuStr+ searchContext+ sourceCity+classesStr);
		Integer classesId = Integer.valueOf(classesStr.trim());
		initialize();
		System.out.println(idStr + major+ showType+ address+ idStuStr+searchContext+searchType );
		return this.stuInforService.getInputStream(city, major, showType, address, idStr, idStuStr, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId); 
		/**
		 * 有些图片的下载一般使用前台的超链接下载即可，但是如果是中文的的话那样处理就会有问题，因此我们需要后台操作，只需要路径知道
		 * 即可 ServletActionContext.getServletContext().getResourceAsStream("路径");路径应该是项目的相对路径，如\images\logo.zip
		 * */
	}
	/**
	 * 进行头像的处理
	 * */
	private void saveUserPhoto(){
		try {
			String[] fileMsg = getFileMsg(getUploadFileName());
			String path = ServletActionContext.getServletContext().getRealPath("/stuPhoto/");
			File directory = new File(path);
			if (!directory.exists()) {
				log.info("directory:stuPhoto dosen't exist");
				if (directory.mkdir()) {
					log.info("directory: stuPhoto created successfully!");
				}
			} else {
				log.info("directory exist");
			}
			//对照片的名称进行重命名
			StringBuilder sb = new StringBuilder().append(new Date().getTime())
					.append(".").append(fileMsg[1]);
			String dbSavePath = path + "/" + sb.toString();
			log.debug("uploadName:" + getUploadFileName()
					+ ",savePath:" + dbSavePath);

			BufferedOutputStream out = null;
			BufferedInputStream in = null;
			try {
				in = new BufferedInputStream(new FileInputStream(getUpload()),
						CommonValue.BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(new File(
						dbSavePath)), CommonValue.BUFFER_SIZE);
				byte[] buffer = new byte[CommonValue.BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
				out.flush();
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
			stuInfor.setStuPhotoPath("/AlumiManagementSystem/stuPhoto" + "/" + sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获得图片的后缀名
	 * */
	private static String[] getFileMsg(String fileName)  {
        int pos = fileName.lastIndexOf(".");
        return new  String[]{fileName.substring(pos),fileName.substring(pos+1)};
   } 
	/**
	 * 对属性进行初始化
	 * */
	private void initialize(){
		if(city == null){
			city = "0";
		}
		if(showType == null){
			showType = "0";
		}
		if(address == null){
			address = "0";
		}
		if(searchContext == null || "- - -关键字- - -".equals(searchContext)){
			searchContext = "0";
		}
		if(major == null|| "0".equals(major)){
			if("普通管理员".equals(ActionContext.getContext().getSession().get("adminType"))){
				Admin admin = adminService.getAdminById((Integer)ActionContext.getContext().getSession().get("userId"));
				major = admin.getManageRange();
			}else{
				major = "0";	
			}
		}
		if(classesId == null){
			classesId = 0;
		}else{
			classes = classesService.getClassesById(classesId);
		}
		if(sourceCity == null){
			sourceCity = "0";
		}
		if(docProtitleId == null){
			docProtitleId = 0;
		}
		if(teaProtitleId == null){
			teaProtitleId = 0;
		}
	}
	/**
	 * 统计各个专业的人数
	 * */
	private void getMajorStu(int totalRecord){
		initialize();
		/**
		 * 考虑1：
		 * 开始打算这样来打算计算各个专业的人数，但发现有一点不行就是：这里对专业进行了硬编码，这样的话的专业的增加减少
		 * 对这里都不会有影响，这样跟数据库就会不同步了，而且这样写也比较麻烦，每个专业都要调用相同方法一次；
		 * 后来再三思索决定直接让ftl页面端调用服务层代码
		 * 考虑2：
		 * 客户端调用时传递的参数如此多，而且这些参数的获得比较麻烦，并且如果专业多的话客户端的页面就比较难控制，
		 * 综合考虑还是先如此使用吧
		 * */
		eye7 = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_7, docProtitleId, teaProtitleId);
		eye5 = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_5, docProtitleId, teaProtitleId);
		eye3 = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_3, docProtitleId, teaProtitleId);
		eyeb = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_B, docProtitleId, teaProtitleId);
		eyes = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_S, docProtitleId, teaProtitleId);
		eyetea = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_TEA, docProtitleId, teaProtitleId);
		eyejx = stuInforService.getEyeNums(city, showType, address, searchType, searchContext, classesId, sourceCity, major, CommonValue.EYE_GO, docProtitleId, teaProtitleId);
	}
	/**
	 * 获取所有的班级和专业
	 * */
	private void getClassesAndMajor(){
		//班级与专业
		classesList = classesService.getClassesList();
		//普通管理员有自己专门负责的部门（按专业进行划分）
		if("普通管理员".equals(ActionContext.getContext().getSession().get("adminType"))){
			Admin admin = adminService.getAdminById((Integer)ActionContext.getContext().getSession().get("userId"));
			String[] majors = admin.getManageRange().split("-");
			for(String maj: majors){
				Major major = majorService.getMajorByName(maj);
				majorList.add(major);
			}
		}else{
			majorList = majorService.getMajorList();
		}
	}

	/**
	 * 添加至通讯录
	 * @return
	 */
	public String add2Contacts(){
		log.info("添加至通讯录的用户id：   "+ userId);
		try {
			StuInfor stuInfo = stuInforService.getInforById(userId);
			Contacts contacts = new Contacts();
			contacts.setUserName(stuInfo.getStuName());
			contacts.setContactAddress(stuInfo.getStuWorkAddress());
			contacts.setContactPhoneNum(stuInfo.getStuTelephone());
			contacts.setUserId(stuInfo.getStuId());
			Integer currentUserId = (Integer)ActionContext.getContext().getSession().get("userId");
			contacts.setCurrentUserId(currentUserId);
			Contacts contactsExist = contactsService.getContactsByUserId(stuInfo.getStuId());
			if(contactsExist != null){
				contactsExist.setContactAddress(stuInfo.getStuWorkAddress());
				contactsExist.setContactPhoneNum(stuInfo.getStuTelephone());
				contactsExist.setUserId(stuInfo.getStuId());
				contactsExist.setCurrentUserId(currentUserId);
				contactsExist.setUserName(stuInfo.getStuName());
				contactsService.updata(contactsExist);
			}else{
				contactsService.save(contacts);
			}
			response = "{success:true}";
		} catch (Exception e) {
			response = "{success:false}";
		}
		return SUCCESS;
	}
	
	public String myContactsList(){
		Integer currentUserId = (Integer)ActionContext.getContext().getSession().get("userId");
		totalRecord = contactsService.getContactsNum(currentUserId);
		PageUtil pageUtil = new PageUtil(currentPage, totalRecord);
		//总的页面数
		totalPages = pageUtil.getTotalPages();
		contactsService.queryContactsPage(currentUserId, pageUtil.getPageFirRecord(), pageUtil.getShowRecordNum());
		contactsList = contactsService.queryContactsList(currentUserId);
		return SUCCESS;
	}
	
	/**
	 * 以下是get与set方法
	 * */
	public int getEye7() {
		return eye7;
	}

	public void setEye7(int eye7) {
		this.eye7 = eye7;
	}

	public int getEye5() {
		return eye5;
	}

	public void setEye5(int eye5) {
		this.eye5 = eye5;
	}

	public int getEye3() {
		return eye3;
	}
	
	public void setEye3(int eye3) {
		this.eye3 = eye3;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public String getSearchContext() {
		return searchContext;
	}

	public void setSearchContext(String searchContext) {
		this.searchContext = searchContext;
	}
	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<StuInfor> getInforList() {
		return inforList;
	}

	public void setInforList(List<StuInfor> inforList) {
		this.inforList = inforList;
	}

	public StuInfor getStuInfor() {
		return stuInfor;
	}

	public void setStuInfor(StuInfor stuInfor) {
		this.stuInfor = stuInfor;
	}
	public String getIdStuStr() {
		return idStuStr;
	}
	public void setIdStuStr(String idStuStr) {
		this.idStuStr = idStuStr;
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
	public List<Classes> getClassesList() {
		return classesList;
	}
	public void setClassesList(List<Classes> classesList) {
		this.classesList = classesList;
	}
	public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	public Integer getClassesId() {
		return classesId;
	}
	public void setClassesId(Integer classesId) {
		this.classesId = classesId;
	}
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSourceCity() {
		return sourceCity;
	}
	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}
	public int getEyeb() {
		return eyeb;
	}
	public void setEyeb(int eyeb) {
		this.eyeb = eyeb;
	}
	public int getEyes() {
		return eyes;
	}
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}
	public int getEyetea() {
		return eyetea;
	}
	public void setEyetea(int eyetea) {
		this.eyetea = eyetea;
	}
	public int getEyejx() {
		return eyejx;
	}
	public void setEyejx(int eyejx) {
		this.eyejx = eyejx;
	}
	public String getClassesStr() {
		return classesStr;
	}
	public void setClassesStr(String classesStr) {
		this.classesStr = classesStr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Classes getClasses() {
		return classes;
	}
	public List<StuInfor> getStuList() {
		return stuList;
	}
	public void setAuthorization(String authorization) {
		this.authorization = authorization;
	}
	public List<DocProtitle> getDocProtitleList() {
		return docProtitleList;
	}
	public void setDocProtitleList(List<DocProtitle> docProtitleList) {
		this.docProtitleList = docProtitleList;
	}
	public List<TeaProtitle> getTeaProtitleList() {
		return teaProtitleList;
	}
	public void setTeaProtitleList(List<TeaProtitle> teaProtitleList) {
		this.teaProtitleList = teaProtitleList;
	}
	public Integer getTeaProtitleId() {
		return teaProtitleId;
	}
	public void setTeaProtitleId(Integer teaProtitleId) {
		this.teaProtitleId = teaProtitleId;
	}
	public Integer getDocProtitleId() {
		return docProtitleId;
	}
	public void setDocProtitleId(Integer docProtitleId) {
		this.docProtitleId = docProtitleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Contacts> getContactsList() {
		return contactsList;
	}
	public void setContactsList(List<Contacts> contactsList) {
		this.contactsList = contactsList;
	}
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}
	
}
