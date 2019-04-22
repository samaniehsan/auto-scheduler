package org.txstate.auto_scheduler;


import org.junit.Test;
import org.txstate.auto_scheduler.CourseGrade;
import org.txstate.auto_scheduler.StudentRecord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class CandidateCourseServiceImplTest {

    @Test(expected = NullPointerException.class)
    public void testbuildListShouldThrowNullPointerException() {
        CandidateCourseServiceImpl sut = new CandidateCourseServiceImpl();
        sut.buildList(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testbuildListShouldThrowIllegalArgumentException() {
        CandidateCourseServiceImpl sut = new CandidateCourseServiceImpl();
        ArrayList<CurriculumCourse> degreePlanCourses = new ArrayList<CurriculumCourse>();
        sut.buildList(null, degreePlanCourses);
    }

    private ArrayList<CurriculumCourse> getDegreeCourses() {
        CurriculumCourse course1 = new CurriculumCourse();
        course1.setCourseNumber("X11");

        CurriculumCourse course2 = new CurriculumCourse();
        course2.setCourseNumber("Y12");

        CurriculumCourse course3 = new CurriculumCourse();
        course3.setCourseNumber("Z13");

        CurriculumCourse course4 = new CurriculumCourse();
        course4.setCourseNumber("D14");
        
        ArrayList<CurriculumCourse> degreePlanCourses = new ArrayList<CurriculumCourse>();
        degreePlanCourses.add(course1);
        degreePlanCourses.add(course2);
        degreePlanCourses.add(course3);
        degreePlanCourses.add(course4);

        return degreePlanCourses;
    }

    @Test
    public void testbuildListShouldReturnDegreePlanCoursesWhenStudentRecoredIsNull() {
        CandidateCourseServiceImpl sut = new CandidateCourseServiceImpl();
        ArrayList<CurriculumCourse> degreePlanCourses = getDegreeCourses();

        Collection<CurriculumCourse> candidateCourses = sut.buildList(null, degreePlanCourses);
        assertEquals(degreePlanCourses, candidateCourses);
    }

    @Test
    public void testbuildListShouldReturnDegreePlanCoursesWhenStudentRecoredIsEmpty() {
        CandidateCourseServiceImpl sut = new CandidateCourseServiceImpl();
        ArrayList<CurriculumCourse> degreePlanCourses = getDegreeCourses();
        
        ArrayList<StudentRecord> studentRecords = new ArrayList<StudentRecord>();
        Collection<CurriculumCourse> candidateCourses = sut.buildList(studentRecords, degreePlanCourses);
        assertEquals(degreePlanCourses, candidateCourses);
    }

    private ArrayList<StudentRecord> getStudentRecords() {
        ArrayList<StudentRecord> studentRecords = new ArrayList<StudentRecord>();
        StudentRecord classFailed1 = new StudentRecord();
        classFailed1.setCourseCode("X11");
        classFailed1.setGrade(CourseGrade.F);

        StudentRecord classFailed2 = new StudentRecord();
        classFailed2.setCourseCode("X11");
        classFailed2.setGrade(CourseGrade.I);
        
        StudentRecord classFailed3 = new StudentRecord();
        classFailed3.setCourseCode("Y12");
        classFailed3.setGrade(CourseGrade.D);

        StudentRecord classFailed4 = new StudentRecord();
        classFailed4.setCourseCode("Y12");
        classFailed4.setGrade(CourseGrade.I);
        

        StudentRecord classFailed5 = new StudentRecord();
        classFailed5.setCourseCode("Z13");
        classFailed5.setGrade(CourseGrade.I);
        

        StudentRecord classPassed1 = new StudentRecord();
        classPassed1.setCourseCode("Z13");
        classPassed1.setGrade(CourseGrade.C);

        StudentRecord classPassed2 = new StudentRecord();
        classPassed2.setCourseCode("D14");
        classPassed2.setGrade(CourseGrade.A);
        

        studentRecords.add(classFailed1);
        studentRecords.add(classFailed2);
        studentRecords.add(classFailed3);
        studentRecords.add(classFailed4);
        studentRecords.add(classFailed5);
        studentRecords.add(classPassed1);
        studentRecords.add(classPassed2);

        return studentRecords;
    }

    @Test
    public void testbuildListShouldReturnCoursesNotPassed() {
        CandidateCourseServiceImpl sut = new CandidateCourseServiceImpl();
        
        ArrayList<CurriculumCourse> degreePlanCourses = getDegreeCourses();
        ArrayList<StudentRecord> studentRecords = getStudentRecords();

        Collection<CurriculumCourse> candidateCourses = sut.buildList(studentRecords, degreePlanCourses);
        CurriculumCourse candidateCoursesArray[] = candidateCourses.toArray(new CurriculumCourse[]{});

        assertEquals(2, candidateCourses.size());
        assertEquals("X11", candidateCoursesArray[0].getCourseNumber());
        assertEquals("Y12", candidateCoursesArray[1].getCourseNumber());
    }
}
