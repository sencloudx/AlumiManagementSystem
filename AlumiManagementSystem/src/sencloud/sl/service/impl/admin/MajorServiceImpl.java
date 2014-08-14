package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.MajorDAO;
import sencloud.sl.entity.Major;
import sencloud.sl.service.admin.MajorService;
import sencloud.sl.util.PageUtil;


public class MajorServiceImpl implements MajorService {
	private MajorDAO majorDAO;
	public MajorDAO getMajorDAO() {
		return majorDAO;
	}

	public void setMajorDAO(MajorDAO majorDAO) {
		this.majorDAO = majorDAO;
	}
	
	@Override
	public List<Major> getMajorList(PageUtil pageUtil) {
		return majorDAO.findByPage("from Major", pageUtil.getPageFirRecord(), pageUtil.getShowPageNum());
	}

	@Override
	public int getMajorNums() {
		return majorDAO.getCount("select count(*) from Major");
	}

	@Override
	public void addMajor(String name, String remarks) {
		Major major = new Major();
		major.setMajorName(name);
		major.setMajorRemarks(remarks);
		majorDAO.makePersitent(major);
	}

	@Override
	public void deleteMajor(String idStr) {
		String[] ids = idStr.split("-");
		for(String id: ids){
			majorDAO.makeTransient(majorDAO.findById(Integer.parseInt(id)));
		}
	}

	@Override
	public Major getMajorById(int id) {
		return majorDAO.findById(id);
	}

	@Override
	public void updateMajor(int id, String majorName, String majorRemark) {
		Major major = majorDAO.findById(id);
		major.setMajorName(majorName);
		major.setMajorRemarks(majorRemark);
		majorDAO.updateEntity(major);
	}

	@Override
	public List<Major> getMajorList() {
		return majorDAO.findListByHQL("from Major");
	}

	@Override
	public Major getMajorByName(String name) {
		List<Major> majorList = majorDAO.findListByHQL("from Major as major where major.majorName = '"+name+"'");
		return majorList.get(0);
	}
}
