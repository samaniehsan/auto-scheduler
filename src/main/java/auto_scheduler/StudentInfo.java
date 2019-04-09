package org.txstate.auto_scheduler;

import java.util.Date;

public class StudentInfo {
	
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String studentId;
    
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
}
