package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

public interface StudentScheduleRepository {
	void write(String studentId,Collection<String> sectionNumbers) throws FileNotFoundException,  IOException;
}
