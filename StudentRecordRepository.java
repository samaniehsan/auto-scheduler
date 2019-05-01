package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * StudentRecordRepository.java : Public interface
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface StudentRecordRepository {
	Collection<StudentRecord> get(String studentId) throws FileNotFoundException,  IOException;  
}
