package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.QuestionnaireDAO;
import sencloud.sl.service.admin.QuestionnaireService;


public class QuestionnaireServiceImpl implements QuestionnaireService{
	
	private QuestionnaireDAO questionnaireDAO;

	public QuestionnaireDAO getQuestionnaireDAO() {
		return questionnaireDAO;
	}

	public void setQuestionnaireDAO(QuestionnaireDAO questionnaireDAO) {
		this.questionnaireDAO = questionnaireDAO;
	}

	@Override
	public List<Integer> getIdList(String hql) {
		return questionnaireDAO.getIdList(hql);
	}
	
}
