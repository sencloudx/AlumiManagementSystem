package sencloud.sl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Questionnaire entity. @author MyEclipse Persistence Tools
 */

public class Questionnaire implements java.io.Serializable {

	// Fields

	private Integer questionnaireId;
	private Admin admin;
	private String questionnaireTitle;
	private String questionnaireDes;
	private String remarks;
	private String queDate;
	private Set queQuebanks = new HashSet(0);

	// Constructors

	/** default constructor */
	public Questionnaire() {
	}

	/** full constructor */
	public Questionnaire(Admin admin, String questionnaireTitle,
			String questionnaireDes, String remarks, Set queQuebanks) {
		this.admin = admin;
		this.questionnaireTitle = questionnaireTitle;
		this.questionnaireDes = questionnaireDes;
		this.remarks = remarks;
		this.queQuebanks = queQuebanks;
	}

	// Property accessors

	public Integer getQuestionnaireId() {
		return this.questionnaireId;
	}

	public void setQuestionnaireId(Integer questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getQuestionnaireTitle() {
		return this.questionnaireTitle;
	}

	public void setQuestionnaireTitle(String questionnaireTitle) {
		this.questionnaireTitle = questionnaireTitle;
	}
	
	public String getQuestionnaireDes() {
		return questionnaireDes;
	}

	public void setQuestionnaireDes(String questionnaireDes) {
		this.questionnaireDes = questionnaireDes;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Set getQueQuebanks() {
		return this.queQuebanks;
	}

	public void setQueQuebanks(Set queQuebanks) {
		this.queQuebanks = queQuebanks;
	}

	public String getQueDate() {
		return queDate;
	}

	public void setQueDate(String queDate) {
		this.queDate = queDate;
	}
	
}