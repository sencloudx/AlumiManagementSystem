package sencloud.sl.dao.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.ResumeDAO;
import sencloud.sl.entity.Contacts;
import sencloud.sl.entity.Resume;
import sencloud.sl.entity.StuInfor;

public class ResumeDAOImpl extends GenericHibernateDAO<Resume> implements ResumeDAO{

	public ResumeDAOImpl() {
		super(Resume.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer makePersistence(Resume resume) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(resume);
		return resume.getResumeId();
	}

	@Override
	public void update(Resume resume) {
		this.getHibernateTemplate().update(resume);
	}

	@Override
	public Resume getResumeByid(int id) {
		return (Resume) this.getHibernateTemplate().get(Resume.class, id);
	}

	@Override
	public List<Resume> queryResumeList(String stuNum) {
		String hql = "from Resume as res where res.stuNum = '"+stuNum+"'";
		List<Resume> resumeList = findListByHQL(hql);
		return resumeList;
	}

}
