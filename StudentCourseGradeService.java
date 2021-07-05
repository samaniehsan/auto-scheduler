package org.txstate.auto_scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * StudentCourseGradeService.java : Public Interface
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface StudentCourseGradeService {
	boolean hasCourse(String studentId,String courseCode) throws FileNotFoundException, IOException;
}
