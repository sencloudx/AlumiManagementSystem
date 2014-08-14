package sencloud.sl.action.survey;

import java.util.List;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.QueType;
import sencloud.sl.entity.QuestionBank;
import sencloud.sl.util.PageUtil;


public class QuestionBankAction extends BaseAction{
	/**
	 * 调查问卷题库相关
	 */
	private static final long serialVersionUID = 1L;
	private int typeId;
	private String searchType;
	private String searchContents;
	private List<QuestionBank> queBankList;
	private List<QueType> queTypeList_;
	private String title;
	private String option;
	private String key_;
	
	
	/*获得题库集合*/
	public String getQueList(){
		//注意一个问题，如果这里的typeId是Integer的，而方法getQueBankNums()中参数typeId是int类型，会出问题，因为typeId可能为null
		totalRecord = queBankService.getQueBankNums(typeId, searchType, searchContents);
		PageUtil pageUtil = new PageUtil(currentPage,totalRecord);
		totalPages = pageUtil.getTotalPages();
		queBankList = queBankService.getQueBankList(typeId, searchType, searchContents, pageUtil);
		return SUCCESS;
	}
	
	/*获得题目类型集合*/
	public String getQueTypeList(){
		queTypeList_ = queBankService.getQueTypes();
		return SUCCESS;
	}
	
	/*添加题目*/
	public String addQue(){
		try{
			QuestionBank questionBank = new QuestionBank();
			questionBank.setQueTitle(title);
			questionBank.setQueOption(option);
			questionBank.setKey_(key_);
			questionBank.setQueType(commonService.findById(QueType.class, typeId));
			commonService.sava(questionBank);
			response = "{success:true,msg:'恭喜：添加成功'}";
		}catch(Exception e){
			response = "{success:false,reason:'sorry：添加失败'}";
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	
	
	
	public int getTypeId() {
		return typeId;
	}


	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}


	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchContents() {
		return searchContents;
	}

	public void setSearchContents(String searchContents) {
		this.searchContents = searchContents;
	}

	public List<QuestionBank> getQueBankList() {
		return queBankList;
	}

	public void setQueBankList(List<QuestionBank> queBankList) {
		this.queBankList = queBankList;
	}

	public List<QueType> getQueTypeList_() {
		return queTypeList_;
	}

	public void setQueTypeList_(List<QueType> queTypeList) {
		queTypeList_ = queTypeList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKey_() {
		return key_;
	}

	public void setKey_(String key) {
		key_ = key;
	}
	
	
}
