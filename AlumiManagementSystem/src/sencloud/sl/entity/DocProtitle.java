package sencloud.sl.entity;

/**
 * DocProtitle entity. @author MyEclipse Persistence Tools
 */

public class DocProtitle implements java.io.Serializable {

	// Fields

	private Integer docProtitleId;
	private String docProtitleName;
	private String docProtitleRemarks;

	// Constructors

	/** default constructor */
	public DocProtitle() {
	}

	/** full constructor */
	public DocProtitle(String docProtitleName, String docProtitleRemarks) {
		this.docProtitleName = docProtitleName;
		this.docProtitleRemarks = docProtitleRemarks;
	}

	// Property accessors

	public Integer getDocProtitleId() {
		return this.docProtitleId;
	}

	public void setDocProtitleId(Integer docProtitleId) {
		this.docProtitleId = docProtitleId;
	}

	public String getDocProtitleName() {
		return this.docProtitleName;
	}

	public void setDocProtitleName(String docProtitleName) {
		this.docProtitleName = docProtitleName;
	}

	public String getDocProtitleRemarks() {
		return this.docProtitleRemarks;
	}

	public void setDocProtitleRemarks(String docProtitleRemarks) {
		this.docProtitleRemarks = docProtitleRemarks;
	}

}