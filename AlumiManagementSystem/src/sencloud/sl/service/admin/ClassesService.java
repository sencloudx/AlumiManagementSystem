package sencloud.sl.service.admin;

import java.util.List;

import sencloud.sl.entity.Classes;
import sencloud.sl.util.PageUtil;


public interface ClassesService {
	/**
	 * 获取所有班级的数量
	 * */
	public int getClassesNums();
	/**
	 * 获取所有班级的集合
	 * */
	public List<Classes> getClassesList(PageUtil pageUtil);
	/**
	 * 不分页的获取所有班级
	 * */
	public List<Classes> getClassesList();
	/*
	 *进行班级的添加 
	 * */
	 public void addClasses(String name, String remarks);
	 /**
	  * 对班级进行删除
	  * */
	 public void deleteClasses(String idStr);
	 /**
	  * 根据id来查找对应的班级
	  * */
	 public Classes getClassesById(int id);
	 /**
	  * 对班级信息进行更新
	  * */
	 public void updateClasses(int id, String classesName, String classesRemark);
}
