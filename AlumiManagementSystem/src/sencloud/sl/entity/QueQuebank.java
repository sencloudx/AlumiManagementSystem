package sencloud.sl.entity;

/**
 * QueQuebank entity. @author MyEclipse Persistence Tools
 */

public class QueQuebank implements java.io.Serializable {

	// Fields

	private Integer id;
	private Questionnaire questionnaire;
	private QuestionBank questionBank;

	// Constructors

	/** default constructor */
	public QueQuebank() {
	}

	/** full constructor */
	public QueQuebank(Questionnaire questionnaire, QuestionBank questionBank) {
		this.questionnaire = questionnaire;
		this.questionBank = questionBank;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questionnaire getQuestionnaire() {
		return this.questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public QuestionBank getQuestionBank() {
		return this.questionBank;
	}

	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
	}

}