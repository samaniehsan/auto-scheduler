package org.txstate.auto_scheduler;

/**
 * Represents a course for the school
 * @author Barry Rominger
 */

public class CourseInfo {
    private String course_number;
    private String course_name;
    private String subject;

    /**
     * Gets the course number
     * @return this course number
     */

    public String getCourse_number() {
        return course_number;
    }

    /**
     * Changes the course number
     * @param course_number
     */

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    /**
     * Gets the course name
     * @return this course name
     */

    public String getCourse_name() {
        return course_name;
    }

    /**
     * Changes course name
     * @param course_name
     */
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    /**
     * Gets subject
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Changes subject
     * @param subject
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Overrides toString
     * @return String with course_number, course_name, subject
     */

    @Override
    public String toString(){
        return "Course Number = "+ course_number + ", Course Name = " + course_name + ", Subject = " + subject + "\n";
    }
}
