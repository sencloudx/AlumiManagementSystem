package sencloud.sl.dao.admin;

import java.util.List;

import sencloud.sl.entity.QuestionBank;


public interface QuestionBankDAO extends GenericDAO<QuestionBank>{
	/*根据hql获得相应的集合*/
	@SuppressWarnings("unchecked")
	public List getListByHQL(String hql);
}
