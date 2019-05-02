package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
import java.lang.Integer;
import java.util.Map;
import java.util.Set;

public class SectionNumberSelectorServiceImpl implements SectionNumberSelectorService {
    final int maxClasses = 5;
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
            Map<String, List<CourseInfo>> courseMapping = getRelevantClasses(
                courseInfos, 
                prioritizedCourses);
            Collection<Integer> sectionNumbers = getRelevantClasses(courseMapping);
            return sectionNumbers;
        } else {
            if (nCourses > 0 ) {
                throw new NoScheduleFoundException(studentId, "No courses found for the student");
            }
            throw new NoScheduleFoundException(studentId, "No Courses available this session");
        }
    }

    private Collection<Integer> getRelevantClasses(
        Map<String, List<CourseInfo>> courseNumberMap
    ) {
        Map<Integer,Integer> usedSlots = new Hashtable<Integer,Integer>();
        Set<String> keys = courseNumberMap.keySet();
        for(String key: keys) {
            List<CourseInfo> courseInfos = courseNumberMap.get(key);
            if(courseInfos != null) {
                for(CourseInfo courseInfo:courseInfos) {
                    Integer timeSlotLookedup = usedSlots.get(courseInfo.getTimeSlot());
                    if(timeSlotLookedup == null) {
                        usedSlots.put(
                            courseInfo.getTimeSlot(),
                            courseInfo.getSectionNumber());
                        break;
                    }
                }
            }
            if(maxClasses == usedSlots.size()) {
                break;
            }
        }
        return usedSlots.values();
    }
    private Map<String, List<CourseInfo>> getRelevantClasses(
        Collection<CourseInfo> courseInfos,
        Collection<CurriculumCourse> prioritizedCourses
    ) {
        Collection<CourseInfo> filteredCourses = courseInfos.stream().filter(
            courseInfo ->
            courseInfo.getEnrolled() < courseInfo.getCapacity()
        ).filter(
            course ->
            prioritizedCourses.stream().noneMatch(
                prioritizedCourse ->
                prioritizedCourse.getCourseNumber().equalsIgnoreCase(course.getCourseNumber())
            )
        ).sorted(
            (scheduleCourse1, scheduleCourse2 ) 
            -> 
            (
                new Integer(
                scheduleCourse1.getTimeSlot()
                )
            ).
            compareTo(
                new Integer(
                    scheduleCourse2.getTimeSlot()
                )
            )
        ).collect(Collectors.toList());
        
        Map<String, List<CourseInfo>> slotsPerCourse = 
        filteredCourses.stream().collect(
            Collectors.groupingBy(CourseInfo::getCourseNumber)
        );

        return slotsPerCourse;
    }
}
