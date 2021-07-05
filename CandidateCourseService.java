package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * CandidateCourseService.java : Public Interface
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface CandidateCourseService {
	Collection<CurriculumCourse> buildList( 
        Collection<StudentRecord> coursesOnRecord, 
        Collection<CurriculumCourse> degreePlanCourses);
        
        Collection<String> getPassedCourses(
                Collection<StudentRecord> coursesOnRecord);
}
