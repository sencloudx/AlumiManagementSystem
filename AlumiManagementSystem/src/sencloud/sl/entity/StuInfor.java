package sencloud.sl.entity;

/**
 * StuInfor entity. @author MyEclipse Persistence Tools
 */

public class StuInfor implements java.io.Serializable {

	// Fields

	private Integer stuId;
	private Classes classes;
	private DocProtitle docProtitle;
	private TeaProtitle teaProtitle;
	private Major major;
	private String stuNum;
	private String stuName;
	private String stuJg;
	private Integer majorId;
	private String stuWorkPlace;
	private String stuWorkPost;
	private String stuWorkAddress;
	private String stuWorkZc;
	private String stuPhone;
	private String stuTelephone;
	private String stuQq;
	private String stuCommAddress;
	private String stuAddress;
	private String stuEmail;
	private String stuSex;
	private String stuStartTime;
	private String stuEndTime;
	private String stuPhotoPath;
	private String stuSfzh;
	private String stuNation;
	private String stuBirth;
	private String stuPostcode;
	private String lastXl;
	private String lastXw;
	private String sruHonour;
	private String stuResume;
	private String stuType;
	private String deleteType;
	private String password;

	// Constructors

	/** default constructor */
	public StuInfor() {
	}
	/** full constructor */
	public StuInfor(Classes classes, Major major, String stuNum,
			String stuName, String stuJg, Integer majorId, String stuWorkPlace,
			String stuWorkPost, String stuWorkAddress, String stuWorkZc,
			String stuPhone, String stuTelephone, String stuQq,
			String stuCommAddress, String stuAddress, String stuEmail,
			String stuSex, String stuStartTime, String stuEndTime,
			String stuPhotoPath, String stuSfzh, String stuNation,
			String stuBirth, String stuPostcode, String lastXl, String lastXw,
			String sruHonour, String stuResume, String stuType,
			String deleteType,String password) {
		this.classes = classes;
		this.major = major;
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuJg = stuJg;
		this.majorId = majorId;
		this.stuWorkPlace = stuWorkPlace;
		this.stuWorkPost = stuWorkPost;
		this.stuWorkAddress = stuWorkAddress;
		this.stuWorkZc = stuWorkZc;
		this.stuPhone = stuPhone;
		this.stuTelephone = stuTelephone;
		this.stuQq = stuQq;
		this.stuCommAddress = stuCommAddress;
		this.stuAddress = stuAddress;
		this.stuEmail = stuEmail;
		this.stuSex = stuSex;
		this.stuStartTime = stuStartTime;
		this.stuEndTime = stuEndTime;
		this.stuPhotoPath = stuPhotoPath;
		this.stuSfzh = stuSfzh;
		this.stuNation = stuNation;
		this.stuBirth = stuBirth;
		this.stuPostcode = stuPostcode;
		this.lastXl = lastXl;
		this.lastXw = lastXw;
		this.sruHonour = sruHonour;
		this.stuResume = stuResume;
		this.stuType = stuType;
		this.deleteType = deleteType;
		this.password = password;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Major getMajor() {
		return this.major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getStuNum() {
		return this.stuNum;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	
	public DocProtitle getDocProtitle() {
		return docProtitle;
	}
	public void setDocProtitle(DocProtitle docProtitle) {
		this.docProtitle = docProtitle;
	}
	public TeaProtitle getTeaProtitle() {
		return teaProtitle;
	}
	public void setTeaProtitle(TeaProtitle teaProtitle) {
		this.teaProtitle = teaProtitle;
	}
	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuJg() {
		return this.stuJg;
	}

	public void setStuJg(String stuJg) {
		this.stuJg = stuJg;
	}

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getStuWorkPlace() {
		return this.stuWorkPlace;
	}

	public void setStuWorkPlace(String stuWorkPlace) {
		this.stuWorkPlace = stuWorkPlace;
	}

	public String getStuWorkPost() {
		return this.stuWorkPost;
	}

	public void setStuWorkPost(String stuWorkPost) {
		this.stuWorkPost = stuWorkPost;
	}

	public String getStuWorkAddress() {
		return this.stuWorkAddress;
	}

	public void setStuWorkAddress(String stuWorkAddress) {
		this.stuWorkAddress = stuWorkAddress;
	}

	public String getStuWorkZc() {
		return this.stuWorkZc;
	}

	public void setStuWorkZc(String stuWorkZc) {
		this.stuWorkZc = stuWorkZc;
	}

	public String getStuPhone() {
		return this.stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}

	public String getStuTelephone() {
		return this.stuTelephone;
	}

	public void setStuTelephone(String stuTelephone) {
		this.stuTelephone = stuTelephone;
	}

	public String getStuQq() {
		return this.stuQq;
	}

	public void setStuQq(String stuQq) {
		this.stuQq = stuQq;
	}

	public String getStuCommAddress() {
		return this.stuCommAddress;
	}

	public void setStuCommAddress(String stuCommAddress) {
		this.stuCommAddress = stuCommAddress;
	}

	public String getStuAddress() {
		return this.stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getStuEmail() {
		return this.stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}

	public String getStuSex() {
		return this.stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuStartTime() {
		return this.stuStartTime;
	}

	public void setStuStartTime(String stuStartTime) {
		this.stuStartTime = stuStartTime;
	}

	public String getStuEndTime() {
		return this.stuEndTime;
	}

	public void setStuEndTime(String stuEndTime) {
		this.stuEndTime = stuEndTime;
	}

	public String getStuPhotoPath() {
		return this.stuPhotoPath;
	}

	public void setStuPhotoPath(String stuPhotoPath) {
		this.stuPhotoPath = stuPhotoPath;
	}

	public String getStuSfzh() {
		return this.stuSfzh;
	}

	public void setStuSfzh(String stuSfzh) {
		this.stuSfzh = stuSfzh;
	}

	public String getStuNation() {
		return this.stuNation;
	}

	public void setStuNation(String stuNation) {
		this.stuNation = stuNation;
	}

	public String getStuBirth() {
		return this.stuBirth;
	}

	public void setStuBirth(String stuBirth) {
		this.stuBirth = stuBirth;
	}

	public String getStuPostcode() {
		return this.stuPostcode;
	}

	public void setStuPostcode(String stuPostcode) {
		this.stuPostcode = stuPostcode;
	}

	public String getLastXl() {
		return this.lastXl;
	}

	public void setLastXl(String lastXl) {
		this.lastXl = lastXl;
	}

	public String getLastXw() {
		return this.lastXw;
	}

	public void setLastXw(String lastXw) {
		this.lastXw = lastXw;
	}

	public String getSruHonour() {
		return this.sruHonour;
	}

	public void setSruHonour(String sruHonour) {
		this.sruHonour = sruHonour;
	}

	public String getStuResume() {
		return this.stuResume;
	}

	public void setStuResume(String stuResume) {
		this.stuResume = stuResume;
	}

	public String getStuType() {
		return this.stuType;
	}

	public void setStuType(String stuType) {
		this.stuType = stuType;
	}

	public String getDeleteType() {
		return this.deleteType;
	}

	public void setDeleteType(String deleteType) {
		this.deleteType = deleteType;
	}

}