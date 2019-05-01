package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * StudentScheduleRepository.class : Public interface
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface StudentScheduleRepository {
	void delete(String studentId)  throws FileNotFoundException,  IOException;
	Collection<String> get(String studentId) throws FileNotFoundException,  IOException;
	void write(String studentId,Collection<String> sectionNumbers) throws FileNotFoundException,  IOException;
}
