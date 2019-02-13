package org.txstate.auto_scheduler;

public class OperationContext {
	public enum OperationCode {Schedule,Peek, Select, Cancel };
	OperationCode operationCode;
	String studentId;
	String scheduleId;
	
	public OperationContext(OperationCode operationCode, String studentId) {
		if( operationCode == OperationContext.OperationCode.Select || 
			operationCode == OperationContext.OperationCode.Cancel )
			throw new IllegalArgumentException("Select and Cancel requires scheduleId");
			
		this.operationCode = operationCode;
		this.studentId = studentId;
	}
	
	public OperationContext(OperationCode operationCode, String studentId,String scheduleId) {
		if( operationCode == OperationContext.OperationCode.Schedule || 
			operationCode == OperationContext.OperationCode.Peek )
			throw new IllegalArgumentException("No scheduleId in Schedule Peek Context");
		
		this.operationCode = operationCode;
		this.studentId = studentId;
		this.scheduleId = scheduleId;
	}
	
	public OperationCode getOperationCode() {
        return this.operationCode;
    }
	
	public String getStudentId() {
        return this.studentId;
    }
	
	public String getScheduleId() {
        return this.scheduleId;
    }
	
	
}
