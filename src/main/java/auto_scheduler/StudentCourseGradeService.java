package org.txstate.auto_scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface StudentCourseGradeService {
	boolean hasCourse(String studentId,String courseCode) throws FileNotFoundException, IOException;
}
