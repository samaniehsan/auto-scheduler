package org.txstate.auto_scheduler;

/**
 * Represents a course for the school
 * @author Barry Rominger
 */

public class CourseInfo {
    private String courseNumber;
    private String courseName;
    private String subject;
    private String timeDay;
    private boolean full;
    private int roomNumber;
    private int sectionNumber;

    /**
     * Gets the section number
     * @return this section number
     */
    public int getSectionNumber() {
        return sectionNumber;
    }

    /**
     * Changes the course number
     * @param section_number
     */

    public void setSectionNumber(int section_number) {
        this.sectionNumber = section_number;
    }

    /**
     * Gets the course number
     * @return this course number
     */

    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * Changes the course number
     * @param course_number
     */

    public void setCourseNumber(String course_number) {
        this.courseNumber = course_number;
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
     * @param course_name
     */
    public void setCourseName(String course_name) {
        this.courseName = course_name;
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
     * Gets subject
     * @return timeDay
     */
    public String getDayTime() {
        return timeDay;
    }
    /**
     * Changes timeDay
     * @param timeDay
     */

    public void setDayTime(String timeDay) {
        this.timeDay = timeDay;
    }

    /**
     * checks if class is full
     * @return full
     */

    public boolean isFull() {
        return full;
    }
    /**
     * Changes course to full
     * @param full
     */

    public void setFull(boolean full) {
        this.full = full;
    }
    /**
     * Gets roomNumber
     * @return roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }
    /**
     * Changes roomNumber
     * @param room_number
     */

    public void setRoomNumber(int room_number) {
        this.roomNumber = room_number;
    }

    /**
     * Overrides toString
     * @return String with courseNumber, sectionNumber, courseName, subject , timeDay , roomNumber
     */
    @Override
    public String toString(){
        return "Course Number: "+ courseNumber +
                "\nSection Number: " + sectionNumber +
                "\nCourse Name: " + courseName +
                "\nSubject: " + subject +
                "\nTime/Day: " + timeDay +
                "\nRoom Number: " + roomNumber +
                "\n";
    }

}

