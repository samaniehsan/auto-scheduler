package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;

public interface CandidateCourseService {
	Collection<CurriculumCourse> buildList( 
        Collection<StudentRecord> coursesOnRecord, 
        Collection<CurriculumCourse> degreePlanCourses);
        
        Collection<String> getPassedCourses(
                Collection<StudentRecord> coursesOnRecord);
}
