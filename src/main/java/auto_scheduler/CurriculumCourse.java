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
            preRequisite.equalsIgnoreCase(super.getCourseNumber())) {
            throw new IllegalArgumentException(
                "circular reference;" + preRequisite + 
                "cannot be be required by courseNumber:"+ this.getCourseNumber());
        }
        this.preRequisite = preRequisite;
    }
}
