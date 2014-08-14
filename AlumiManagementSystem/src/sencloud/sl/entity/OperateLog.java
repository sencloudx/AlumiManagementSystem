package sencloud.sl.entity;

/**
 * OperateLog entity. @author MyEclipse Persistence Tools
 */

public class OperateLog implements java.io.Serializable {

	// Fields

	private Long logId;
	private String class_;
	private String method;
	private String createtime;
	private String loglevel;
	private String logmsg;
	private String userType;
	private Long userId;

	// Constructors

	/** default constructor */
	public OperateLog() {
	}

	/** full constructor */
	public OperateLog(String class_, String method, String createtime,
			String loglevel, String logmsg, String userType, Long userId) {
		this.class_ = class_;
		this.method = method;
		this.createtime = createtime;
		this.loglevel = loglevel;
		this.logmsg = logmsg;
		this.userType = userType;
		this.userId = userId;
	}

	// Property accessors

	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public String getLoglevel() {
		return this.loglevel;
	}

	public void setLoglevel(String loglevel) {
		this.loglevel = loglevel;
	}

	public String getLogmsg() {
		return this.logmsg;
	}

	public void setLogmsg(String logmsg) {
		this.logmsg = logmsg;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}