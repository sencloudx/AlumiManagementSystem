package sencloud.sl.service.admin;

import java.util.List;

import sencloud.sl.entity.Major;
import sencloud.sl.util.PageUtil;


public interface MajorService {
	/**
	 * 获取所有专业的数量
	 * */
	public int getMajorNums();
	/**
	 * 获取所有专业的集合
	 * */
	public List<Major> getMajorList(PageUtil pageUtil);
	/*
	 *进行专业的添加 
	 * */
	 public void addMajor(String name, String remarks);
	 /**
	  * 不分页的获取所有班级
	  * */
	 public List<Major> getMajorList();
	 /**
	  * 对专业进行删除
	  * */
	 public void deleteMajor(String idStr);
	 /**
	  * 根据id来查找对应的专业
	  * */
	 public Major getMajorById(int id);
	 /**
	  * 根据专业名称来查找专业对象
	  * */
	 public Major getMajorByName(String name);
	 /**
	  * 对专业信息进行更新
	  * */
	 public void updateMajor(int id, String majorName, String majorRemark);
}
