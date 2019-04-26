package org.txstate.auto_scheduler;

import java.util.Collection;

public interface CoursePrioritizationService {
	public Collection<CurriculumCourse> build(
        Collection<CurriculumCourse> candidateCourses, 
        Collection<String> passedCourses);
}
