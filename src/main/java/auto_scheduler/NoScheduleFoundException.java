package org.txstate.auto_scheduler;

public class NoScheduleFoundException extends StudentNotFoundException {

    public NoScheduleFoundException(
    String studentId,
    String message, 
    Throwable cause) {
    super(studentId, message, cause);
    }

    public NoScheduleFoundException(String studentId, String message) {
    super(studentId, message);
    }

    public NoScheduleFoundException(String studentId) {
        super(studentId, String.format("No Schedule Found For StudentId:%s",studentId));
    }
}
