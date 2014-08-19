/**
 * 
 */
package sencloud.sl.entity;

/**
 * @author farryxia
 * 
 */
public class Resume {

	// Fields

	private Integer resumeId;
	private String startTM;
	private String endTM;
	private String resumeCompany;
	private String resumePost;
	private String resumeDesc;
	private Integer userId;

	public Resume() {
		super();
	}

	public Resume(Integer resumeId, String startTM, String endTM,
			String resumeCompany, String resumePost, String resumeDesc,
			Integer userId) {
		super();
		this.resumeId = resumeId;
		this.startTM = startTM;
		this.endTM = endTM;
		this.resumeCompany = resumeCompany;
		this.resumePost = resumePost;
		this.resumeDesc = resumeDesc;
		this.userId = userId;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public String getStartTM() {
		return startTM;
	}

	public void setStartTM(String startTM) {
		this.startTM = startTM;
	}

	public String getEndTM() {
		return endTM;
	}

	public void setEndTM(String endTM) {
		this.endTM = endTM;
	}

	public String getResumeCompany() {
		return resumeCompany;
	}

	public void setResumeCompany(String resumeCompany) {
		this.resumeCompany = resumeCompany;
	}

	public String getResumePost() {
		return resumePost;
	}

	public void setResumePost(String resumePost) {
		this.resumePost = resumePost;
	}

	public String getResumeDesc() {
		return resumeDesc;
	}

	public void setResumeDesc(String resumeDesc) {
		this.resumeDesc = resumeDesc;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
