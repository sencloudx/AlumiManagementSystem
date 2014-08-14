package sencloud.sl.entity;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer adminId;
	private String adminNum;
	private String adminPw;
	private String adminRight;
	private String manageRange;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String adminNum, String adminPw, String adminRight) {
		this.adminNum = adminNum;
		this.adminPw = adminPw;
		this.adminRight = adminRight;
	}

	// Property accessors

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminNum() {
		return this.adminNum;
	}

	public void setAdminNum(String adminNum) {
		this.adminNum = adminNum;
	}

	public String getAdminPw() {
		return this.adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}

	public String getAdminRight() {
		return this.adminRight;
	}

	public void setAdminRight(String adminRight) {
		this.adminRight = adminRight;
	}

	public String getManageRange() {
		return manageRange;
	}

	public void setManageRange(String manageRange) {
		this.manageRange = manageRange;
	}
	
}