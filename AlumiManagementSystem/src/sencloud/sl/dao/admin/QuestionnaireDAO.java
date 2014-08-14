package sencloud.sl.dao.admin;

import java.util.List;

import sencloud.sl.entity.Questionnaire;


public interface QuestionnaireDAO extends GenericDAO<Questionnaire>{
	/*获得题目id的集合*/
	public List<Integer> getIdList(String hql);
}	
