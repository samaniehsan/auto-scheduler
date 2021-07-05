package org.txstate.auto_scheduler;


/**
 * StudentRecord.class : Class header
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentRecord {
	private String studentId;
	private String courseCode;
	private CourseGrade grade;
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
		
	public CourseGrade getGrade() {
		return this.grade;
	}
	
	public void setGrade(CourseGrade grade) {
		this.grade = grade;
	}
	
}
