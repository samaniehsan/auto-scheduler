package org.txstate.auto_scheduler;

/**
 * StudentNotFoundException.java : Student Id not found
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentNotFoundException extends RuntimeException {
    String studentId;

	/**
	 * StudentNotFoundException() : Contructor one
	 * @param String studentId, String message, Throwable cause
	 * @return N/A
	 */
	public StudentNotFoundException(
        String studentId,
        String message, 
        Throwable cause) {
        super(message, cause);
        this.studentId = studentId;
	}

	/**
	 * StudentNotFoundException() : Contructor two
	 * @param String studentId, String message
	 * @return N/A
	 */
	public StudentNotFoundException(String studentId, String message) {
        super(message);
        this.studentId = studentId;
	}

	public String getStudentId() {
		return this.studentId;
	}
}
