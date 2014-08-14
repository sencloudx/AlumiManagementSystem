package sencloud.sl.action.survey;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sencloud.sl.base.BaseAction;
import sencloud.sl.entity.Admin;
import sencloud.sl.entity.QueQuebank;
import sencloud.sl.entity.QuestionBank;
import sencloud.sl.entity.Questionnaire;
import sencloud.sl.util.FormatDate;


import com.opensymphony.xwork2.ActionContext;

public class QuestionnaireAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String describe;
	private String queStr;
	
	private List<Integer> queIdList = new ArrayList<Integer>();
	
	private List<Questionnaire> questionnaireList;
	private Integer questionnaireId;
	private Questionnaire questionnaire;
	private List<QuestionBank> questionBankList;
	
	/*添加问卷*/
	public String addQuestionnaire(){
		try{
			Integer adminId = (Integer)ActionContext.getContext().getSession().get("userId");
			Admin admin = commonService.findById(Admin.class, adminId);
			//1.先保存问卷的基本信息
			Questionnaire questionnaire = new Questionnaire();
			questionnaire.setQuestionnaireTitle(title);
			questionnaire.setQuestionnaireDes(describe);
			questionnaire.setAdmin(admin);
			questionnaire.setQueDate(FormatDate.getCurrentDate());
			commonService.sava(questionnaire);
			//2.根据各类题目的数量进行随机的抽取题目
			String queryString = "";
			String[] queList = queStr.split("-");
			for (int i = 0; i < queList.length; i++) {
				if (!queList[i].equals("0")) {
					switch (i % 3) {
					case 0:								//表示单选题
						//根据各类题目的数量进行随机的取题
						queryString = "select que.queId from QuestionBank as que where que.queType.typeName='单选题'";
						break;
					case 1:								//多选题
						queryString = "select que.queId from QuestionBank as que where que.queType.typeName='多选题'";
						break;
					case 2:								//问答题
						queryString = "select que.queId from QuestionBank as que where que.queType.typeName='问答题'";
						break;
					}
					makeIdRandom(questionnaireService.getIdList(queryString), Integer.valueOf(queList[i]));
				}
			}
			//3.将选出的题保存到关系表中
			for(int i = 0; i< queIdList.size(); i++){
				QueQuebank que = new QueQuebank();
				que.setQuestionBank(commonService.findById(QuestionBank.class, queIdList.get(i)));
				que.setQuestionnaire(questionnaire);
				commonService.sava(que);
			}
			response="{success:true,msg:'添加调查问卷成功'}";
		}catch(Exception e){
			e.printStackTrace();
			response="{success:false,reason:'添加调查问卷失败'}";
		}
		
		return SUCCESS;
	}
	
	//取单选题随机数
	private void makeIdRandom(List<Integer> list,int subNum){
		Random random = new Random();
		for (int i = 0; i < subNum; ++i) {
	    	int rand = random.nextInt(list.size());		//利用nextInt 产生随机数
	    	int tempId = list.get(rand);				//题目的编号
	    	queIdList.add(Integer.valueOf(tempId));
	    	list.remove(rand);
	    }
	}
	
	
	/*获得问卷列表*/
	public String questionnaireList(){
		questionnaireList = commonService.findAll(Questionnaire.class);
		return SUCCESS;
	}
	
	/*显示问卷视图*/
	public String questionnaireDetail(){
		//1.基本问卷信息
		questionnaire = commonService.findById(Questionnaire.class, questionnaireId);
		//2.问卷的题目
		questionBankList = queBankService.getQueByQueId(questionnaireId);
		return SUCCESS;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getQueStr() {
		return queStr;
	}

	public void setQueStr(String queStr) {
		this.queStr = queStr;
	}

	public List<Integer> getQueIdList() {
		return queIdList;
	}

	public void setQueIdList(List<Integer> queIdList) {
		this.queIdList = queIdList;
	}

	public List<Questionnaire> getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List<Questionnaire> questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public Integer getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<QuestionBank> getQuestionBankList() {
		return questionBankList;
	}

	public void setQuestionBankList(List<QuestionBank> questionBankList) {
		this.questionBankList = questionBankList;
	}
	
	
}
