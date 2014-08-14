package sencloud.sl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * QueType entity. @author MyEclipse Persistence Tools
 */

public class QueType implements java.io.Serializable {

	// Fields

	private Integer queTypeId;
	private String typeName;
	private Set questionBanks = new HashSet(0);

	// Constructors

	/** default constructor */
	public QueType() {
	}

	/** full constructor */
	public QueType(String typeName, Set questionBanks) {
		this.typeName = typeName;
		this.questionBanks = questionBanks;
	}

	// Property accessors

	public Integer getQueTypeId() {
		return this.queTypeId;
	}

	public void setQueTypeId(Integer queTypeId) {
		this.queTypeId = queTypeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getQuestionBanks() {
		return this.questionBanks;
	}

	public void setQuestionBanks(Set questionBanks) {
		this.questionBanks = questionBanks;
	}

}