package org.txstate.auto_scheduler;

import java.util.Date;

public class StudentInfo {
	
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
	private String studentId;
	private int year;
	private String major;
    
	public String getNameFirst() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	public String getStudentId() {
		return this.studentId;
	}

	public int getYear() {
		return this.year;
	}

	public String getMajor() {
		return this.major;
	}
	
	public void setNameFirst(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}	
	public void setYear(int year) {
		this.year = year;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
