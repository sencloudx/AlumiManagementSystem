package sencloud.sl.entity;

/**
 * QuestionBank entity. @author MyEclipse Persistence Tools
 */

public class QuestionBank implements java.io.Serializable {

	// Fields

	private Integer queId;
	private QueType queType;
	private String queTitle;
	private String queOption;
	private String key_;
	private String recycleBin;

	// Constructors

	/** default constructor */
	public QuestionBank() {
	}

	/** full constructor */
	public QuestionBank(QueType queType, String queTitle, String queOption,
			String key_, String recycleBin) {
		this.queType = queType;
		this.queTitle = queTitle;
		this.queOption = queOption;
		this.key_ = key_;
		this.recycleBin = recycleBin;
	}

	// Property accessors

	public Integer getQueId() {
		return this.queId;
	}

	public void setQueId(Integer queId) {
		this.queId = queId;
	}

	public QueType getQueType() {
		return this.queType;
	}

	public void setQueType(QueType queType) {
		this.queType = queType;
	}

	public String getQueTitle() {
		return this.queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getQueOption() {
		return this.queOption;
	}

	public void setQueOption(String queOption) {
		this.queOption = queOption;
	}

	public String getKey_() {
		return key_;
	}

	public void setKey_(String key) {
		key_ = key;
	}

	public String getRecycleBin() {
		return this.recycleBin;
	}

	public void setRecycleBin(String recycleBin) {
		this.recycleBin = recycleBin;
	}

}