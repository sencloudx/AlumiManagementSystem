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
	private String resumeTitle;
	private String resumeDesc;
	private String resumeMark;
	private Integer userId;

	public Resume(Integer resumeId, String timeInterval, String resumeTitle,
			String resumeDesc, String resumeMark, Integer user) {
		super();
		this.resumeId = resumeId;
		this.timeInterval = timeInterval;
		this.resumeTitle = resumeTitle;
		this.resumeDesc = resumeDesc;
		this.resumeMark = resumeMark;
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
		return resumeTitle;
	}

	public void setResumeTitle(String resumeTitle) {
		this.resumeTitle = resumeTitle;
	}

	public String getResumeDesc() {
		return resumeDesc;
	}

	public void setResumeDesc(String resumeDesc) {
		this.resumeDesc = resumeDesc;
	}

	public String getResumeMark() {
		return resumeMark;
	}

	public void setResumeMark(String resumeMark) {
		this.resumeMark = resumeMark;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
