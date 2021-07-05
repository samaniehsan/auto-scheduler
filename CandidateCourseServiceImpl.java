package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.stream.*;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
/**
 * CandidateCourseServiceImpl.java : Will check if courses are able to be taken
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class CandidateCourseServiceImpl implements CandidateCourseService {
    /**
     * CandidateCourseServiceImpl : Will check if courses are able to be taken by sending potintal courses to getPassedCourses()
     * @param Collection<StudentRecord> coursesOnStudentRecord, Collection<CurriculumCourse> degreePlanCourses
     * @return candidateCourses
     * @exception NullPointerException, IllegalArgumentException
     */
	public Collection<CurriculumCourse> buildList( 
        Collection<StudentRecord> coursesOnStudentRecord, 
        Collection<CurriculumCourse> degreePlanCourses) {
        
        if(degreePlanCourses == null)
            throw new NullPointerException("degreePlanCourses can not be null");
        if(degreePlanCourses.size() == 0)
            throw new IllegalArgumentException("degreePlanCourses can not be empty");

        Collection<String> passedCourseCodes = getPassedCourses(coursesOnStudentRecord);
        
        List<CurriculumCourse>  candidateCourses = degreePlanCourses.stream().filter(
            course ->
            passedCourseCodes.stream().noneMatch(
                passedCourseCode -> course.getCourseNumber().equalsIgnoreCase(passedCourseCode)
                )
        ).collect(Collectors.toList());

        return candidateCourses;
    }

    /**
     * getPassedCourses : Will check a students passed courses
     * @param Collection<StudentRecord> coursesOnRecord
     * @return passedClasses
     * @exception N/A
     */
    public Collection<String> getPassedCourses(
        Collection<StudentRecord> coursesOnRecord) {
        
        if(coursesOnRecord == null)
            return new ArrayList<String>();

        List<String> passedClasses = coursesOnRecord.stream().filter(
            course -> 
            course.getGrade() == CourseGrade.C  ||
            course.getGrade() == CourseGrade.B  ||
            course.getGrade() == CourseGrade.A
        ).map(x -> x.getCourseCode()
        ).collect(Collectors.toList());
        return passedClasses;
    }
}
