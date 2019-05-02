package org.txstate.auto_scheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurriculumCourseTest {

    @Test
    public void testThatPrereqCanBeNull() {
        CurriculumCourse course = new CurriculumCourse();
        course.setPreRequisite(null);
        assertNull(course.getPreRequisite());
    }

    @Test(expected= IllegalArgumentException.class)
    public void testThatCourseNumberCannotBeSameAsPrereq() {
        CurriculumCourse course = new CurriculumCourse();
        course.setPreRequisite("X");
        course.setCourseNumber("X");        
    }

    @Test(expected= IllegalArgumentException.class)
    public void testThatPrereqCannotBeSameCourseNumber() {
        CurriculumCourse course = new CurriculumCourse();
        course.setCourseNumber("X");
        course.setPreRequisite("X");
    }
}
