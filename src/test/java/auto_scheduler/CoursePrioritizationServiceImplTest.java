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
        sut.build(null);
    }
    
    @Test
    public void testThatBuildReturnsZeroIfCandicateCoursesWhereZero() {
        CoursePrioritizationServiceImpl sut = new CoursePrioritizationServiceImpl();
        ArrayList<CurriculumCourse> courses =  new ArrayList<CurriculumCourse>();
        
        Collection<CurriculumCourse> prioritizedCourses =  sut.build(courses);
        assertEquals(0, prioritizedCourses.size());
    }

    @Test
    public void testThatBuildReturnsOneIfCandicateCoursesWhereOne() {
        CoursePrioritizationServiceImpl sut = new CoursePrioritizationServiceImpl();
        ArrayList<CurriculumCourse> courses =  new ArrayList<CurriculumCourse>();
        
        CurriculumCourse course = new CurriculumCourse();
        course.setCourseNumber("XYZ");
        courses.add(course);
        
        Collection<CurriculumCourse> prioritizedCourses =  sut.build(courses);
        assertEquals(1, prioritizedCourses.size());
        assertEquals(
            course.getCourseName(), 
            prioritizedCourses.toArray(
                new CurriculumCourse[]{})[0].getCourseName());
    }

    @Test
    public void testThatBuildReturnsNoCoursesWithPrerequsites() {
        ArrayList<CurriculumCourse> courses =  new ArrayList<CurriculumCourse>();

        CurriculumCourse course0 = new CurriculumCourse();
        course0.setCourseNumber("ML");

        CurriculumCourse course1 = new CurriculumCourse();
        course1.setCourseNumber("XYZ");

        CurriculumCourse course2 = new CurriculumCourse();
        course2.setCourseNumber("abc");
        course2.setPreRequisite("XYZ");

        CurriculumCourse course3 = new CurriculumCourse();
        course3.setCourseNumber("abd");
        course3.setPreRequisite("XYZ");

        CurriculumCourse course44 = new CurriculumCourse();
        course44.setCourseNumber("NL");

        CurriculumCourse course45 = new CurriculumCourse();
        course45.setCourseNumber("BL");
        course45.setPreRequisite("NL");
        


        courses.add(course45);
        courses.add(course44);
        courses.add(course0);
        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        
        CoursePrioritizationServiceImpl sut = new CoursePrioritizationServiceImpl();        
        Collection<CurriculumCourse> prioritizedCourses =  sut.build(courses);
        System.out.print("code is here");
        assertEquals(3, prioritizedCourses.size());
        assertEquals(
            course1.getCourseName(), 
            prioritizedCourses.toArray(
                new CurriculumCourse[]{})[0].getCourseName());
        assertEquals(
            course44.getCourseName(), 
            prioritizedCourses.toArray(
            new CurriculumCourse[]{})[1].getCourseName());                
        assertEquals(
            course0.getCourseName(), 
            prioritizedCourses.toArray(
            new CurriculumCourse[]{})[2].getCourseName());
    }
}
