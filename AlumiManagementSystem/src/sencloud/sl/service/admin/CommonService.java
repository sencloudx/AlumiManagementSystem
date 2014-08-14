package sencloud.sl.service.admin;

import java.util.List;

public interface CommonService {
	/**
	 * 对象的保存
	 * */
	public <T> void sava(T entity);										
	/**
	 * 对象的删除
	 * */
	public <T> void remove(T entity);									
	/**
	 * 更新对象
	 * */
	public <T> void update(T entity);									
	/**
	 * 通过id查找某个对象
	 * */
	public <T> T findById(Class<T> entityClass, Integer id);			
	/**
	 * 查询所有的同一类型对象信息
	 * */
	public <T> List<T> findAll(Class<T> entityclass);
}
