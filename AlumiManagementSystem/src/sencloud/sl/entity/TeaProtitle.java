package sencloud.sl.entity;

/**
 * TeaProtitle entity. @author MyEclipse Persistence Tools
 */

public class TeaProtitle implements java.io.Serializable {

	// Fields

	private Integer teaProtitleId;
	private String teaProtitleName;
	private String teaProtitleRemarks;

	// Constructors

	/** default constructor */
	public TeaProtitle() {
	}

	/** full constructor */
	public TeaProtitle(String teaProtitleName, String teaProtitleRemarks) {
		this.teaProtitleName = teaProtitleName;
		this.teaProtitleRemarks = teaProtitleRemarks;
	}

	// Property accessors

	public Integer getTeaProtitleId() {
		return this.teaProtitleId;
	}

	public void setTeaProtitleId(Integer teaProtitleId) {
		this.teaProtitleId = teaProtitleId;
	}

	public String getTeaProtitleName() {
		return this.teaProtitleName;
	}

	public void setTeaProtitleName(String teaProtitleName) {
		this.teaProtitleName = teaProtitleName;
	}

	public String getTeaProtitleRemarks() {
		return this.teaProtitleRemarks;
	}

	public void setTeaProtitleRemarks(String teaProtitleRemarks) {
		this.teaProtitleRemarks = teaProtitleRemarks;
	}

}