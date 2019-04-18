package org.txstate.auto_scheduler;

public class CurriculumCourse {
    private String courseNumber;
    private String courseName;
    private String preRequisite;

    public String getCourseNumber() {
        return this.courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getPreRequisite() {
        return this.preRequisite;
    }

    public void setPreRequisite(String preRequisite) {
        this.preRequisite = preRequisite;
    }
}
