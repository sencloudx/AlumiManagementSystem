package sencloud.sl.dao.admin;

import java.util.List;

import sencloud.sl.entity.Contacts;
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
	/**
	 * 查询当前学生的所有履历List
	 * @return
	 */
	public List<Resume> queryResumeList(String stuNum);
}
