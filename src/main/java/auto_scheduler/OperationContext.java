package org.txstate.auto_scheduler;

public class OperationContext {
	public enum OperationCode {Schedule,DryRun, Show, Cancel };
	OperationCode operationCode;
	String studentId;

	
	public OperationContext(OperationCode operationCode, String studentId) {
		if( studentId == null || studentId.isEmpty() )
			throw new IllegalArgumentException("studnetid required");
			
		this.operationCode = operationCode;
		this.studentId = studentId;
	}

	public OperationCode getOperationCode() {
        return this.operationCode;
    }
	
	public String getStudentId() {
		return 
		this.studentId != null ? 
		this.studentId.toLowerCase() :
		null ;
    }		
}
