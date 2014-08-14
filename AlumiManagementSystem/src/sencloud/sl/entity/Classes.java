package sencloud.sl.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classesId;
	private String classesName;
	private String classesRemarks;
	private Set stuInfors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(String classesName, String classesRemarks, Set stuInfors) {
		this.classesName = classesName;
		this.classesRemarks = classesRemarks;
		this.stuInfors = stuInfors;
	}

	// Property accessors

	public Integer getClassesId() {
		return this.classesId;
	}

	public void setClassesId(Integer classesId) {
		this.classesId = classesId;
	}

	public String getClassesName() {
		return this.classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public String getClassesRemarks() {
		return this.classesRemarks;
	}

	public void setClassesRemarks(String classesRemarks) {
		this.classesRemarks = classesRemarks;
	}

	public Set getStuInfors() {
		return this.stuInfors;
	}

	public void setStuInfors(Set stuInfors) {
		this.stuInfors = stuInfors;
	}

}