package org.txstate.auto_scheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseInfoTest {

    @Test
    public void testSetGetCourseNumber() {
        CourseInfo course = new CourseInfo();
        course.setCourseNumber("XXX1234");
        assertTrue(course.getCourseNumber()== "XXX1234");
    }

    @Test
    public void testSetGetCourseName() {
        CourseInfo course = new CourseInfo();
        course.setCourseName("Course Name");
        assertTrue(course.getCourseName()== "Course Name");
    }

    @Test
    public void testSetGetSubject() {
        CourseInfo course = new CourseInfo();
        course.setSubject("Subject");
        assertTrue(course.getSubject()== "Subject");
    }

    @Test
    public void testSetGettimeDay() {
        CourseInfo course = new CourseInfo();
        course.setDayTime("0:00 - 0:00 D");
        assertTrue(course.getDayTime()== "0:00 - 0:00 D");
    }

    @Test
    public void testSetGetRoomNumber() {
        CourseInfo course = new CourseInfo();
        course.setRoomNumber(1234);
        assertTrue(course.getRoomNumber()== 1234);
    }

    @Test
    public void testSetGetSectionNumber() {
        CourseInfo course = new CourseInfo();
        course.setSectionNumber(0);
        assertTrue(course.getRoomNumber()== 0);
    }

    @Test
    public void testIsFull() {
        CourseInfo course = new CourseInfo();
        course.setCapacity(10);
        assertFalse(course.isFull());
        
        course.setEnrolled(10);
        assertTrue(course.isFull());
    }

    @Test
    public void testToString()
    {
        CourseInfo course = new CourseInfo();
        course.setCourseNumber("XXX1234");
        course.setCourseName("Course Name");
        course.setSubject("Subject");
        course.setDayTime("0:00 - 0:00 D");
        course.setRoomNumber(1234);
        String expected = 
                "Course Number: XXX1234" +
                "\nSection Number: 0" +
                "\nCourse Name: Course Name" +
                "\nSubject: Subject" +
                "\nTime/Day: 0:00 - 0:00 D" +
                "\nRoom Number: 1234" + 
                "\nCapcacity: 0" +
                "\nEnrolled: 0" +
                "\n";
        assertEquals(expected, course.toString());
    }
}
