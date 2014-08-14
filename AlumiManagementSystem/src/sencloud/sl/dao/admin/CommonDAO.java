package sencloud.sl.dao.admin;

import java.util.List;
/**
 * 对于一些简单的对象的操作可以直接使用该泛型类，方便操作，如果是复杂的对象操作，
 * 就需要进行另外的处理，这里的处理的是继承基类GenericDAO泛型类
 * */
public interface CommonDAO {
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
