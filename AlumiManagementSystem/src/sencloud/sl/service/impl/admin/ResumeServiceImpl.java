package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.AdminDAO;
import sencloud.sl.dao.admin.ResumeDAO;
import sencloud.sl.entity.Resume;
import sencloud.sl.entity.StuInfor;
import sencloud.sl.service.admin.ResumeService;

public class ResumeServiceImpl implements ResumeService{
	
	private AdminDAO adminDAO;
	private ResumeDAO resumeDAO;
	
	public ResumeDAO getResumeDAO() {
		return resumeDAO;
	}

	public void setResumeDAO(ResumeDAO resumeDAO) {
		this.resumeDAO = resumeDAO;
	}

	@Override
	public Integer save(Resume resume) {
		resumeDAO.makePersistence(resume);
		return resume.getResumeId();
	}

	@Override
	public void update(Resume resume) {
		// TODO Auto-generated method stub
		resumeDAO.update(resume);
	}

	@Override
	public Resume getResumeById(int id) {
		// TODO Auto-generated method stub
		return resumeDAO.getResumeByid(id);
		}

	@Override
	public List<Resume> queryResumeList(String stuNum) {
		return resumeDAO.queryResumeList(stuNum);
	}

}
