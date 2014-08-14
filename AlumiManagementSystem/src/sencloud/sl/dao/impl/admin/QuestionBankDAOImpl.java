package sencloud.sl.dao.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.QuestionBankDAO;
import sencloud.sl.entity.QuestionBank;


@SuppressWarnings("unchecked")
public class QuestionBankDAOImpl extends GenericHibernateDAO<QuestionBank> implements QuestionBankDAO{

	public QuestionBankDAOImpl() {
		super(QuestionBank.class);
	}

	@Override
	public List getListByHQL(String hql) {
		return getHibernateTemplate().find(hql);
	}

}
