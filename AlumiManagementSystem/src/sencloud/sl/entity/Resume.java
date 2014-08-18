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
	private String timeInterval;
	private String resumeCompany;
	private String resumePost;
	private String resumeDesc;
	private Integer userId;

	public Resume(Integer resumeId, String timeInterval, String resumeTitle,
			String resumeDesc, String resumeMark, Integer user) {
		super();
		this.resumeId = resumeId;
		this.timeInterval = timeInterval;
		this.resumeCompany = resumeTitle;
		this.resumePost = resumeDesc;
		this.resumeDesc = resumeMark;
		this.userId = userId;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getResumeTitle() {
		return resumeCompany;
	}

	public void setResumeTitle(String resumeTitle) {
		this.resumeCompany = resumeTitle;
	}

	public String getResumeDesc() {
		return resumePost;
	}

	public void setResumeDesc(String resumeDesc) {
		this.resumePost = resumeDesc;
	}

	public String getResumeMark() {
		return resumeDesc;
	}

	public void setResumeMark(String resumeMark) {
		this.resumeDesc = resumeMark;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
