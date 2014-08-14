package sencloud.sl.dao.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.QuestionnaireDAO;
import sencloud.sl.entity.Questionnaire;


@SuppressWarnings("unchecked")
public class QuestionnaireDAOImpl extends GenericHibernateDAO<Questionnaire>
								implements QuestionnaireDAO{

	public QuestionnaireDAOImpl() {
		super(Questionnaire.class);
	}

	@Override
	public List<Integer> getIdList(String hql) {
		return getHibernateTemplate().find(hql);
	}

}
