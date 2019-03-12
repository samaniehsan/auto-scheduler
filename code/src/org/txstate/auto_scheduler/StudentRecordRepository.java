package org.txstate.auto_scheduler;

import java.util.Collection;

public interface StudentRecordRepository {
	Collection<StudentRecord> get(String studentId);  
}
