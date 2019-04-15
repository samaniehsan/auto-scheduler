package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

public interface StudentRecordRepository {
	Collection<StudentRecord> get(String studentId) throws FileNotFoundException,  IOException;  
}
