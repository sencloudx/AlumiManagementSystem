package sencloud.sl.dao.admin;

import sencloud.sl.entity.Resume;
import sencloud.sl.entity.StuInfor;

public interface ResumeDAO extends GenericDAO<Resume>{
	/**
	 * 对象持久化
	 * */
	public Integer makePersistence(Resume resume); 
	/**
	 * 对象修改
	 * **/
	public void update(Resume resume);
	/**
	 * 对象修改
	 * **/
	public Resume getResumeByid(int id);
}
