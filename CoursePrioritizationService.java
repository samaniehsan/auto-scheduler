package org.txstate.auto_scheduler;

import java.util.Collection;
/**
 * CoursePrioritizationService.java : Public Interface
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface CoursePrioritizationService {
	public Collection<CurriculumCourse> build(
        Collection<CurriculumCourse> candidateCourses, 
        Collection<String> passedCourses);
}
