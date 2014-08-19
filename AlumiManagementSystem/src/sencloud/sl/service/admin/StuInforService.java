package sencloud.sl.service.admin;

import java.io.InputStream;
import java.util.List;

import sencloud.sl.entity.StuInfor;
import sencloud.sl.util.PageUtil;


public interface StuInforService {
	/**
	 * 进行对象的存储
	 * */
	public String save(StuInfor stuInfor);
	/**
	 * 获取总的数量
	 * */
	public int getStuInforNums(String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 获取各专业的人数
	 * */
	public int getEyeNums(String city, String showType, String address, int searchType, String searchContext, Integer classesId, String sourceCity, String major, String majorName, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 获取集合
	 * */
	public List<StuInfor> getStuInforList(PageUtil pageUtil, String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 根据省份和专业获取学生
	 * */
	public List<StuInfor> getStuInforList(String city, String major, String showType, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 根据id获取详情
	 * */
	public StuInfor getInforById(int id);
	/**
	 * 对信息进行彻底的删除
	 * */
	public void thoroughDelete(Integer[] ids);
	/**
	 * 对信息进行更新
	 * */
	public void update(StuInfor stuInfor);
	/**
	 * 更新删除字段
	 * */
	public void updateDeleteSign(String idStr, String type);
	/**
	 * 检索操作
	 * */
	public List<StuInfor> search(int searchType, String searchContext);
	/**
	 * 进行excel的导出
	 * */
	public InputStream getInputStream(String city, String major, String showType, String address, String idStr, String idStuStr, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 通过学号进行查找
	 * */
	public StuInfor getStuInforByNum(String stuNum);
	 /**
	  * 获取班级的学生
	  * */
	 public List<StuInfor> getClassesStu(int classesId);
	 /**
	  * 显示各个省市的就业人数
	  * */
	 public int getWorkNumsByCity(Integer type, String city);
	 /**
	  * 对校友进行授权，就是更新校友类型
	  * */
	 public void  authorization(String idStr, String authorization);
	 /**
	  * 获得所有含有身份证号但还没有完成照片上传的
	  * */
	 public List<StuInfor> getStuInforList();
	 /**
	  * 根据身份证号得到学生
	  * */
	 public StuInfor getInforBySfz(String sfz);
	 /**
	  * 根据类型和编号查找学生
	  * */
	 public String getStuName(String type, Integer id);
	 
	 public void delete(Integer id);
	 /**
	 * 进行对象的存储
	 * */
	public int saveBackId(StuInfor stuInfor);
}
