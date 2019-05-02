package org.txstate.auto_scheduler;

import java.lang.IllegalArgumentException;

public class CurriculumCourse extends CourseBase {
    private String preRequisite;

    public String getPreRequisite() {
        return this.preRequisite;
    }

    public void setPreRequisite(String preRequisite) {
        if(
            preRequisite != null && 
            preRequisite.equalsIgnoreCase(this.getCourseNumber())) {
            throw new IllegalArgumentException(
                "circular reference;" + preRequisite + 
                "cannot be be required by courseNumber:"+ this.getCourseNumber());
        }
        this.preRequisite = preRequisite;
    }

    @Override
    public void setCourseNumber(String courseNumber) {
        if(
            courseNumber != null && 
            courseNumber.equalsIgnoreCase(this.getPreRequisite())) {
            throw new IllegalArgumentException(
                "circular reference;" + courseNumber + 
                "cannot be be required by dependent on :"+ this.getCourseNumber());
        }        
        this.courseNumber = courseNumber;
    }
}
