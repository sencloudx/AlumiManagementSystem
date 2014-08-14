package sencloud.sl.service.admin;

import java.util.List;

import sencloud.sl.entity.QueType;
import sencloud.sl.entity.QuestionBank;
import sencloud.sl.util.PageUtil;


public interface QuestionBankService {
	/*获得题库集合*/
	public List<QuestionBank> getQueBankList(int typeId, String searchType, String searchContents, PageUtil pageUtil);
	
	/*获得题库的数量*/
	public int getQueBankNums(int typeId, String searchType, String searchContents);
	
	/*获得题目类型集合*/
	public List<QueType> getQueTypes();
	
	/*根据问卷编号获得相应的题目集合*/
	public List<QuestionBank> getQueByQueId(Integer questionnaireId);
}
