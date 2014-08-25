package sencloud.sl.service.admin;

import java.util.List;

import sencloud.sl.entity.Resume;
public interface ResumeService {
	/**
	 * 进行对象的存储
	 * */
	public Integer save(Resume Resume);
	
	/**
	 * 进行对象的修改
	 * */
	public void update(Resume Resume);
	/**
	 * 根据id获取详情
	 * */
	public Resume getResumeById(int id);
	/**
	 * 根据id获取ResumeList
	 * **/
	public List<Resume> queryResumeList(Integer currentUserId);
}
