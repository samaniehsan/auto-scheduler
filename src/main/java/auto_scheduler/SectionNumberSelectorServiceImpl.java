package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;


public class SectionNumberSelectorServiceImpl implements SectionNumberSelectorService {
    public Collection<Integer> build(
        String studentId,
        Collection<CourseInfo> courseInfos,
        Collection<CurriculumCourse> prioritizedCourses
    ) {
        if(studentId == null)
        throw new NullPointerException("studentId can not be null");
        if(courseInfos == null)
            throw new NullPointerException("courseInfos can not be null");
        if(prioritizedCourses == null)
            throw new NullPointerException("prioritizedCourses can not be null");
        
        int nCourses = prioritizedCourses.size();
        int nSections = courseInfos.size();
        
        if(nCourses > 0 && nSections > 0) {
            ArrayList<Integer> sectionNumbers = new ArrayList<Integer>();
            return sectionNumbers;
        } else {
            if (nCourses > 0 ) {
                throw new NoScheduleFoundException(studentId, "No courses found for the student");
            }
            throw new NoScheduleFoundException(studentId, "No Courses available this session");
        }
    }

}
