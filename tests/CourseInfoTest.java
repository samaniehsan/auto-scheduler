package org.txstate.auto_scheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseInfoTest {

    @Test
    public void testSetGetCourseNumber() {
        CourseInfo course = new CourseInfo();
        course.setCourse_number("XXX1234");
        assertTrue(course.getCourse_number()== "XXX1234");
    }

    @Test
    public void testSetGetCourseName() {
        CourseInfo course = new CourseInfo();
        course.setCourse_name("Course Name");
        assertTrue(course.getCourse_name()== "Course Name");
    }

    @Test
    public void testSetGetSubject() {
        CourseInfo course = new CourseInfo();
        course.setSubject("Subject");
        assertTrue(course.getSubject()== "Subject");
    }

    @Test
    public void testToString()
    {
        CourseInfo course = new CourseInfo();
        course.setCourse_number("XXX1234");
        course.setCourse_name("Course Name");
        course.setSubject("Subject");
        String expected = "Course Number = XXX1234, Course Name = Course Name, Subject = Subject\n";
        assertEquals(expected, course.toString());
    }


}