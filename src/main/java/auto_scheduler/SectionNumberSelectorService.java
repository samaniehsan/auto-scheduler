package org.txstate.auto_scheduler;

import java.util.Collection;

public interface SectionNumberSelectorService {
    Collection<Integer> build(
        String StudentId,
        Collection<CourseInfo> courseInfos,
        Collection<CurriculumCourse> prioritizedCourses
    );
}
