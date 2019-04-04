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
    private int capacity;
    private int enrolled;
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
     * @param sectionNumber
     */

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
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


    /**
     * Gets roomNumber
     * @return roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }
    /**
     * Changes roomNumber
     * @param roomNumber
     */

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
                "\nCapcacity: " + capacity +
                "\nEnrolled: " + enrolled +
                "\n";
    }

}

