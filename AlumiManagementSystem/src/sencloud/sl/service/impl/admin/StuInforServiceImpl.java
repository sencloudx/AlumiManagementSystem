package sencloud.sl.service.impl.admin;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import sencloud.sl.dao.admin.AdminDAO;
import sencloud.sl.dao.admin.MajorDAO;
import sencloud.sl.dao.admin.StuInforDAO;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.entity.Major;
import sencloud.sl.service.admin.StuInforService;
import sencloud.sl.util.PageUtil;


public class StuInforServiceImpl implements StuInforService {
	
	private static final Logger log = Logger.getLogger(StuInforServiceImpl.class);
	
	private StuInforDAO stuInforDAO;
	private AdminDAO adminDAO;
	private MajorDAO majorDAO;
	
	public MajorDAO getMajorDAO() {
		return majorDAO;
	}

	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}

	public StuInforDAO getStuInforDAO() {
		return stuInforDAO;
	}

	public void setStuInforDAO(StuInforDAO stuInforDAO) {
		this.stuInforDAO = stuInforDAO;
	}
	
	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public String save(StuInfor stuInfor) {
		stuInforDAO.makePersistence(stuInfor);
		return stuInfor.getStuName();
	}

	@Override
	public List<StuInfor> getStuInforList(PageUtil pageUtil, String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId) {
		return stuInforDAO.getStuInforList(pageUtil.getPageFirRecord(), pageUtil.getShowPageNum(),city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
	}

	@Override
	public int getStuInforNums(String city, String showType, String major,
			String address, int searchType, String searchContext,
			Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId) {
		return stuInforDAO.getSubNums(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
	}
	
	@Override
	public StuInfor getInforById(int id) {
		return stuInforDAO.getInforById(id);
	}

	@Override
	public void thoroughDelete(Integer[] ids) {
		//String[] ids = idStr.split("-");
		for(Integer id: ids){
			StuInfor stuInfor = stuInforDAO.findById(id);
			log.info("成功进行校友的删除，删除的校友姓名为  "+stuInfor.getStuName()+", 学号为  "+stuInfor.getStuNum());
			stuInforDAO.delete(id);
		}
	}

	@Override
	public void update(StuInfor stuInfor) {
		stuInforDAO.update(stuInfor);
	}

	@Override
	public void updateDeleteSign(String idStr, String type) {
		String[] ids = idStr.split("-");
		for(String id: ids){
			StuInfor stuInfor = stuInforDAO.getInforById(Integer.valueOf(id));
			System.out.println("需要删除的id  "+stuInfor.getStuId());
			if("删除".equals(type)){
				stuInfor.setDeleteType("0");
			}else{
				stuInfor.setDeleteType("1");
			}
			stuInforDAO.update(stuInfor);
		}
	}

	@Override
	public List<StuInfor> search(int searchType, String searchContext) {
		String hql = "from StuInfor as stu";
		if(searchType == 0){								//按姓名进行查找
			System.out.println("查找的内容 =  "+searchContext);
			hql = hql + " where stu.stuName like '%"+searchContext+"%'";
		}else if(searchType == 1){							//按学号进行查找
			hql = hql + " where stu.stuNum like '%"+searchContext+"%'";
		}else if(searchType == 2){							//按专业进行查找
			hql = hql + " where stu.stuZy like '%"+searchContext+"%'";
		}else if(searchType == 3){							//按学制进行查找
			hql = hql + " where stu.stuXz like '%"+searchContext+"%'";
		}else if(searchType == 4){							//按省市进行查找
			hql = hql + " where stu.stuWorkAddress like '%"+searchContext+"%'";
		}
		return stuInforDAO.getStuInforListByHQL(hql);
	}

	@Override
/*	public Map adminLogin(String admName, String admPsw)
			throws NameNotFoundException, PwNotMatchException {
		//System.out.println("用户名和密码   = "+admName + admPsw);
		Admin admin = stuInforDAO.findAdminByName(admName);
		if(admin == null){
			throw new NameNotFoundException();
		}else if(!(admin.getAdminPw()).equals(admPsw)){
			throw new PwNotMatchException();
		}else{
			Map map=new HashMap();
			map.put("adminName", admin.getAdminNum());
			map.put("admin", admin);
			return map;
		}
	}

	@Override
	public void updateAdmin(Admin admin) {
		stuInforDAO.updateAdmin(admin);
	}*/
	
	/*
	 * 对excel导出做处理
	 * */
	public InputStream getInputStream(String city, String major, String showType, String address, String idStr, String idStuStr, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId) {
		System.out.println("idStr"+ idStuStr);
		String[] ids = idStr.split("-");
		HSSFWorkbook wb = new HSSFWorkbook();				//使用poi，导入poi的包，首先要生成一个HSSFWorkbook对象
		HSSFSheet sheet = wb.createSheet("sheet1");			//创建excel的sheet
		
		HSSFRow row=sheet.createRow(0);						//创建第一行
		HSSFCell cell=row.createCell((short)0);				//创建第一个单元格
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);			//每个单元格都要设置编码格式
		cell.setCellValue("序号");
		for(int i=0;i<ids.length; i++){
			cell=row.createCell((short)(i+1));				//依次创建单元格
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);		//每个单元格都要设置编码格式
			cell.setCellValue(ids[i]);
		}
		/*
		 * 到此表头已经设计好了,下面就进行数据的插入
		 * */
		List<StuInfor> stuInfors = new ArrayList<StuInfor>();
		if(idStuStr == null|| "0".equals(idStuStr)){
			//根据视图进行excel
			stuInfors = stuInforDAO.getStuInforListByHQL(stuInforDAO.getHQL(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId));
			System.out.println("大小"+ stuInfors.size());
		}else{	
			//选择学生进行导出
			stuInfors = stuInforDAO.getStuInforListByHQL(getHql(idStuStr));
		}
		for(int i=0;i<stuInfors.size();i++){
			StuInfor stuInfor = stuInfors.get(i);				//获得一条记录
			row=sheet.createRow(i+1);							//产生下面的其他行
			cell=row.createCell((short)0);						//第一个单元格
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(i+1);
			
			for(int a=0;a<ids.length; a++){   					//后面的单元格依次显示要显示的内容
				cell=row.createCell((short)(a+1));
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				//下面的判断可以用循环来代替
				if(ids[a].equals("学生学号")){
					cell.setCellValue(stuInfor.getStuNum());
				}else if(ids[a].equals("学生姓名")){
					cell.setCellValue(stuInfor.getStuName());
				}else if(ids[a].equals("学生性别")){
					cell.setCellValue(stuInfor.getStuSex());
				}else if(ids[a].equals("学生专业")){
					cell.setCellValue(stuInfor.getMajor().getMajorName());
				}else if(ids[a].equals("所属班级")){
					cell.setCellValue(stuInfor.getClasses().getClassesName());
				}else if(ids[a].equals("入学年份")){
					cell.setCellValue(stuInfor.getStuStartTime());
				}else if(ids[a].equals("毕业年份")){
					cell.setCellValue(stuInfor.getStuEndTime());
				}else if(ids[a].equals("电子邮箱")){
					cell.setCellValue(stuInfor.getStuEmail());
				}else if(ids[a].equals("通信地址")){
					cell.setCellValue(stuInfor.getStuCommAddress());
				}else if(ids[a].equals("家庭地址")){
					cell.setCellValue(stuInfor.getStuAddress());
				}else if(ids[a].equals("就业省市")){
					cell.setCellValue(stuInfor.getStuWorkAddress());
				}else if(ids[a].equals("工作单位")){
					cell.setCellValue(stuInfor.getStuWorkPlace());
				}else if(ids[a].equals("工作岗位")){
					cell.setCellValue(stuInfor.getStuWorkPost());
				}else if(ids[a].equals("职务职称")){
					cell.setCellValue(stuInfor.getStuWorkZc());
				}else if(ids[a].equals("办公电话")){
					cell.setCellValue(stuInfor.getStuPhone());
				}else if(ids[a].equals("QQ号码")){
					cell.setCellValue(stuInfor.getStuQq());
				}else if(ids[a].equals("手机号码")){
					cell.setCellValue(stuInfor.getStuTelephone());
				}else if(ids[a].equals("身份证号")){
					cell.setCellValue(stuInfor.getStuSfzh());
				}else if(ids[a].equals("所在国家")){
					cell.setCellValue(stuInfor.getStuNation());
				}else if(ids[a].equals("生源省市")){
					cell.setCellValue(stuInfor.getStuBirth());
				}else if(ids[a].equals("校友类型")){
					cell.setCellValue(stuInfor.getStuType());
				}else if(ids[a].equals("通信邮编")){
					cell.setCellValue(stuInfor.getStuPostcode());
				}else if(ids[a].equals("最后学历及学校")){
					cell.setCellValue(stuInfor.getLastXl());
				}else if(ids[a].equals("最后学位及学校")){
					cell.setCellValue(stuInfor.getLastXw());
				}else if(ids[a].equals("荣誉奖励")){
					cell.setCellValue(stuInfor.getSruHonour());
				}else if(ids[a].equals("个人简历")){
					cell.setCellValue(stuInfor.getStuResume());
				}else if(ids[a].equals("医师职称")){
					cell.setCellValue(stuInfor.getDocProtitle().getDocProtitleName());
				}else if(ids[a].equals("教师职称")){
					cell.setCellValue(stuInfor.getTeaProtitle().getTeaProtitleName());
				}
			}
		}
		/*
		 * 以上就生成了所需的excel文件
		 *下面写另外一个方法直接不产生临时文件，就在内存中
		*/
		ByteArrayOutputStream os=new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content=os.toByteArray();
		InputStream is=new ByteArrayInputStream(content);
		return is;
		
	}
	
	private String getHql(String idStuStr){
		String[] stus = idStuStr.split("-");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< stus.length; i++){
			sb.append(stus[i]);
			if(i!= (stus.length-1)){
				sb.append(",");
			}
			//System.out.println(sb.toString());
		}
		String hql = "from StuInfor as stu where stu.id in ("+sb.toString()+")";
		return hql;
	}
	@Override
	public int getEyeNums(String city, String showType, String address, int searchType, String searchContext, Integer classesId, String sourceCity, String major, String majorName, Integer docProtitleId, Integer teaProtitleId) {
		String hql = stuInforDAO.getHQL(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		if(hql.contains("where")){	
			hql = hql + " and stu.major.majorName = '"+majorName+"'";
		}else{
			hql = hql + " where stu.major.majorName = '"+majorName+"'";
		}
		return stuInforDAO.getStuInforListByHQL(hql).size();
	}

	@Override
	public List<StuInfor> getStuInforList(String city, String major, String showType, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId) {
		String hql = stuInforDAO.getHQL(city, showType, major, address, searchType, searchContext, classesId, sourceCity, docProtitleId, teaProtitleId);
		System.out.println("hql语句为" + hql);
		return stuInforDAO.getStuInforListByHQL(hql);
	}

	@Override
	public StuInfor getStuInforByNum(String stuNum) {
		return stuInforDAO.getStuInforByNum(stuNum);
	}
	@Override
	public List<StuInfor> getClassesStu(int classesId) {
		String hql = "from StuInfor as stu where stu.classes.classesId = "+classesId+"";
		return stuInforDAO.findListByHQL(hql);
	}

	@Override
	public int getWorkNumsByCity(Integer type, String city) {
		String hql = null;
		if(type == 0){				//表示就业分布
			hql = "from StuInfor as stu where stu.stuWorkAddress like '%"+city+"%'";
		}else if(type == 1){		//表示生源分布
			hql = "from StuInfor as stu where stu.stuBirth like '%"+city+"%'";
		}
		
		return stuInforDAO.findListByHQL(hql).size();
	}

	@Override
	public void authorization(String idStr, String authorization) {
		String[] ids = idStr.split("-");
		for(String id: ids){
			StuInfor stuInfor = getInforById(Integer.valueOf(id));
			log.info("授权校友，被授权的校友姓名为  "+stuInfor.getStuName()+", 学号为  "+stuInfor.getStuNum()+", 被授权为  "+authorization);
			stuInfor.setStuType(authorization);
			update(stuInfor);
		}
	}

	@Override
	public List<StuInfor> getStuInforList() {
		String hql = "from StuInfor as stu where (stu.stuSfzh !='' and stu.stuSfzh is not null) and (stu.stuPhotoPath = '0' or stu.stuPhotoPath is null)";
		return stuInforDAO.getStuInforListByHQL(hql);
	}

	@Override
	public StuInfor getInforBySfz(String sfz) {
		String hql = "from StuInfor as stu where stu.stuSfzh = '"+sfz+"'";
		return stuInforDAO.getStuInforListByHQL(hql).get(0);
	}

	@Override
	public String getStuName(String type, Integer id) {
		String data = null;
		if("普通管理员".equals(type)|| "超级管理员".equals(type)){
			data = adminDAO.findById(id).getAdminNum();
		}else if("联络员".equals(type)|| "理事".equals(type)|| "普通校友".equals(type)){
			data = stuInforDAO.findById(id).getStuNum();
		}
		return data;
	}

	@Override
	public void delete(Integer id) {
		stuInforDAO.delete(id);
	}

	@Override
	public int saveBackId(StuInfor stuInfor) {
		stuInforDAO.makePersistenceBackId(stuInfor);
		return stuInfor.getStuId();
	}

	@Override
	public Map getStuInfo(int stuId) {
		// TODO Auto-generated method stub
		System.out.println("当前用户的学号"+stuId);
		StuInfor stuinfo=stuInforDAO.getInforById(stuId);//通过id获取到stuinfo
		if(stuinfo==null){
			return new HashMap();
		}
		Map<String, String> map=new HashMap();//定义存放信息的map
		map.put("stuName",stuinfo.getStuName() );
		map.put("stuEndTime", stuinfo.getStuEndTime());
		//获取专业名
		map.put("major", stuinfo.getMajor().getMajorName());
		map.put("qq",stuinfo.getStuQq());
		map.put("stuTelephone", stuinfo.getStuTelephone());
		map.put("stuEmail",stuinfo.getStuEmail());
		return map;
	}

}
