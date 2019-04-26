package org.txstate.auto_scheduler;


import org.junit.Test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class CoursePrioritizationServiceImplTest {

    @Test(expected = NullPointerException.class)
    public void testbuildListShouldThrowNullPointerException() {
        CoursePrioritizationServiceImpl sut = new CoursePrioritizationServiceImpl();
        sut.build(null, null);
    }
    
    @Test
    public void testThatBuildReturnsZeroIfCandicateCoursesWhereZero() {
        CoursePrioritizationServiceImpl sut = new CoursePrioritizationServiceImpl();
        ArrayList<CurriculumCourse> courses =  new ArrayList<CurriculumCourse>();
        ArrayList<String> passedClasses = new ArrayList<String>();
        
        Collection<CurriculumCourse> prioritizedCourses =  sut.build(courses,passedClasses);
        assertEquals(0, prioritizedCourses.size());
    }

    @Test
    public void testThatBuildReturnsOneIfCandicateCoursesWhereOne() {
        CoursePrioritizationServiceImpl sut = new CoursePrioritizationServiceImpl();
        ArrayList<CurriculumCourse> courses =  new ArrayList<CurriculumCourse>();
        ArrayList<String> passedClasses = new ArrayList<String>();
        CurriculumCourse course = new CurriculumCourse();
        course.setCourseNumber("XYZ");
        courses.add(course);
        
        Collection<CurriculumCourse> prioritizedCourses =  sut.build(
            courses, 
            passedClasses);
        assertEquals(1, prioritizedCourses.size());
        assertEquals(
            course.getCourseName(), 
            prioritizedCourses.toArray(
                new CurriculumCourse[]{})[0].getCourseName());
    }
}
