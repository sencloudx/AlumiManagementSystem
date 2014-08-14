package sencloud.sl.dao.admin;

import java.util.List;

import sencloud.sl.entity.StuInfor;


public interface StuInforDAO extends GenericDAO<StuInfor>{
	/**
	 * 对象持久化
	 * */
	public String makePersistence(StuInfor stuInfor); 
	/**
	 * 根据hql得到集合
	 * */
	public List<StuInfor> getStuInforListByHQL(String hql);
	/**
	 * 获取集合数量
	 * */
	public int getSubNums(String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 获取集合，含分页
	 * */
	public List<StuInfor> getStuInforList(Integer PageFirRecord, Integer PageNum,String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 根据id来获取信息
	 * */
	public StuInfor getInforById(int id);
	/**
	 * 删除操作
	 * */
	public void delete(int id);
	/**
	 * 更新
	 * */
	public void update(StuInfor stuInfor);
	/**
	 * 组合hql语句
	 * */
	public String getHQL(String city, String showType, String major, String address, int searchType, String searchContext, Integer classesId, String sourceCity, Integer docProtitleId, Integer teaProtitleId);
	/**
	 * 通过学号来查找该校友
	 * */
	public StuInfor getStuInforByNum(String stuNum);
}
