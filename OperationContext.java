package org.txstate.auto_scheduler;

/**
 * OperationContext.java : Will create object OperationContex
 * @param operationCode, studentId
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
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
        return this.studentId;
    }		
}
