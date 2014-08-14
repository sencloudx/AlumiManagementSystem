package sencloud.sl.service.impl.admin;

import java.util.List;

import sencloud.sl.dao.admin.QuestionBankDAO;
import sencloud.sl.entity.QueType;
import sencloud.sl.entity.QuestionBank;
import sencloud.sl.service.admin.QuestionBankService;
import sencloud.sl.util.PageUtil;


public class QuestionBankServiceImpl implements QuestionBankService {
	
	private QuestionBankDAO questionBankDAO;

	public QuestionBankDAO getQuestionBankDAO() {
		return questionBankDAO;
	}

	public void setQuestionBankDAO(QuestionBankDAO questionBankDAO) {
		this.questionBankDAO = questionBankDAO;
	}

	@Override
	public List<QuestionBank> getQueBankList(int typeId, String searchType,
			String searchContents, PageUtil pageUtil) {
		return questionBankDAO.findByPage(getHQL(typeId, searchType, searchContents), pageUtil.getPageFirRecord(), pageUtil.getShowPageNum());
	}

	@Override
	public int getQueBankNums(int typeId, String searchType,
			String searchContents) {
		return questionBankDAO.findByPage(getHQL(typeId, searchType, searchContents), 0, 0).size();	
	}
	
	private String getHQL(int typeId, String searchType,
			String searchContents){
		String hql = "from QuestionBank as que order by que.queId desc";
		if(typeId != 0){
			hql = "from QuestionBank as que where que.queType.queTypeId = "+typeId+" order by que.queId desc";
		}
		return hql;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QueType> getQueTypes() {
		String hql = "from QueType";
		return questionBankDAO.getListByHQL(hql);
	}

	@Override
	public List<QuestionBank> getQueByQueId(Integer questionnaireId) {
		String hql = "from QuestionBank as que where que.queId in (select queq.questionBank.queId from QueQuebank as queq where queq.questionnaire.questionnaireId = "+questionnaireId+")";
		return questionBankDAO.findByPage(hql, 0, 0);
	}
}
