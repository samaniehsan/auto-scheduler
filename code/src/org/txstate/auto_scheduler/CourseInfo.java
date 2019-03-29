package org.txstate.auto_scheduler;

/**
 * Represents a course for the school
 * @author Barry Rominger
 */

public class CourseInfo {
    private String course_number;
    private String course_name;
    private String subject;
    private String timeDay;
    private boolean full;
    private int room_number;
    private int section_number;

    /**
     * Gets the section number
     * @return this section number
     */
    public int getSectionNumber() {
        return section_number;
    }

    /**
     * Changes the course number
     * @param section_number
     */

    public void setSectionNumber(int section_number) {
        this.section_number = section_number;
    }

    /**
     * Gets the course number
     * @return this course number
     */

    public String getCourseNumber() {
        return course_number;
    }

    /**
     * Changes the course number
     * @param course_number
     */

    public void setCourseNumber(String course_number) {
        this.course_number = course_number;
    }

    /**
     * Gets the course name
     * @return this course name
     */

    public String getCourseName() {
        return course_name;
    }

    /**
     * Changes course name
     * @param course_name
     */
    public void setCourseName(String course_name) {
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
     * Gets room_number
     * @return room_number
     */
    public int getRoomNumber() {
        return room_number;
    }
    /**
     * Changes room_number
     * @param room_number
     */

    public void setRoomNumber(int room_number) {
        this.room_number = room_number;
    }

    /**
     * Overrides toString
     * @return String with course_number, section_number, course_name, subject , timeDay , room_number
     */
    @Override
    public String toString(){
        return "Course Number: "+ course_number +
                "\nSection Number: " + section_number +
                "\nCourse Name: " + course_name +
                "\nSubject: " + subject +
                "\nTime/Day: " + timeDay +
                "\nRoom Number: " + room_number +
                "\n";
    }

}

