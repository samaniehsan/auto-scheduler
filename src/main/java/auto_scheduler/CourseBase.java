package org.txstate.auto_scheduler;

/**
 * Represents a course for the school
 * @author Barry Rominger
 */

public abstract class CourseBase {
    protected String courseNumber;
    protected String courseName;
    
    /**
     * Gets the course number
     * @return this course number
     */

    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * Changes the course number
     * @param courseNumber
     */

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * Gets the course name
     * @return this course name
     */

    public String getCourseName() {
        return courseName;
    }

    /**
     * Changes course name
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;

    }
}

