package sencloud.sl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Major entity. @author MyEclipse Persistence Tools
 */

public class Major implements java.io.Serializable {

	// Fields

	private Integer majorId;
	private String majorName;
	private String majorRemarks;
	private Set stuInfors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Major() {
	}

	/** full constructor */
	public Major(String majorName, String majorRemarks, Set stuInfors) {
		this.majorName = majorName;
		this.majorRemarks = majorRemarks;
		this.stuInfors = stuInfors;
	}

	// Property accessors

	public Integer getMajorId() {
		return this.majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public String getMajorName() {
		return this.majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorRemarks() {
		return this.majorRemarks;
	}

	public void setMajorRemarks(String majorRemarks) {
		this.majorRemarks = majorRemarks;
	}

	public Set getStuInfors() {
		return this.stuInfors;
	}

	public void setStuInfors(Set stuInfors) {
		this.stuInfors = stuInfors;
	}

}