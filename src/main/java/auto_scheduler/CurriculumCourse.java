package org.txstate.auto_scheduler;

public class CurriculumCourse extends CourseBase {
    private String preRequisite;

    public String getPreRequisite() {
        return this.preRequisite;
    }

    public void setPreRequisite(String preRequisite) {
        this.preRequisite = preRequisite;
    }
}
