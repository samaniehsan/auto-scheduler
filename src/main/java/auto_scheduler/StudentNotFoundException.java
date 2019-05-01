package org.txstate.auto_scheduler;

public class StudentNotFoundException extends RuntimeException {
    String studentId;

    public StudentNotFoundException(
    String studentId,
    String message, 
    Throwable cause) {
    super(message, cause);
    this.studentId = studentId;
    }

    public StudentNotFoundException(String studentId, String message) {
    super(message);
    this.studentId = studentId;
    }

    public String getStudentId() {
            return this.studentId;
    }
}
