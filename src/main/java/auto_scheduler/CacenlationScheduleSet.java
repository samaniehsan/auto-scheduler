package org.txstate.auto_scheduler;

public class CacenlationScheduleSet extends ScheduleSet {
    
    boolean success;
    public CacenlationScheduleSet(
        String studentId, 
        boolean success) {
        super(studentId);
        this.success = success;
    }
    
	@Override
	public String toString() {
		return String.format(
            "Cancelation for StudentId:%s Result:%b",
            this.getStudentId(),
            success);
	}
}