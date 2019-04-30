package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

public interface StudentScheduleRepository {
	void delete(String studentId)  throws FileNotFoundException,  IOException;
	Collection<Integer> get(String studentId) throws FileNotFoundException,  IOException;
	void write(String studentId,Collection<Integer> sectionNumbers) throws FileNotFoundException,  IOException;
}
