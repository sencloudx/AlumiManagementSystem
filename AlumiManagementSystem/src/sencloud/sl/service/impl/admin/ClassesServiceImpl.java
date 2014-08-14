package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.ClassesDAO;
import sencloud.sl.entity.Classes;
import sencloud.sl.service.admin.ClassesService;
import sencloud.sl.util.PageUtil;


public class ClassesServiceImpl implements ClassesService {
	private ClassesDAO classesDAO;
	public ClassesDAO getClassesDAO() {
		return classesDAO;
	}

	public void setClassesDAO(ClassesDAO classesDAO) {
		this.classesDAO = classesDAO;
	}

	@Override
	public List<Classes> getClassesList(PageUtil pageUtil) {
		return classesDAO.findByPage("from Classes", pageUtil.getPageFirRecord(), pageUtil.getShowPageNum());
	}

	@Override
	public int getClassesNums() {
		return classesDAO.getCount("select count(*) from Classes");
	}

	@Override
	public void addClasses(String name, String remarks) {
		Classes classes = new Classes();
		classes.setClassesName(name);
		classes.setClassesRemarks(remarks);
		classesDAO.makePersitent(classes);
	}

	@Override
	public void deleteClasses(String idStr) {
		String[] ids = idStr.split("-");
		for(String id: ids){
			classesDAO.makeTransient(classesDAO.findById(Integer.parseInt(id)));
		}
	}

	@Override
	public Classes getClassesById(int id) {
		return classesDAO.findById(id);
	}

	@Override
	public void updateClasses(int id, String classesName, String classesRemark) {
		Classes classes = classesDAO.findById(id);
		classes.setClassesName(classesName);
		classes.setClassesRemarks(classesRemark);
		classesDAO.updateEntity(classes);
	}

	@Override
	public List<Classes> getClassesList() {
		return classesDAO.findListByHQL("from Classes");
	}

}
