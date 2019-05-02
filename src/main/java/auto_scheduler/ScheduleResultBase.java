package org.txstate.auto_scheduler;

import java.util.Collection;

public abstract class ScheduleResultBase extends ScheduleSet {

    private String resultType;
    Collection<CourseInfo> studentSchedule;
	public ScheduleResultBase(
        String studentId,
        String resultType,
        Collection<CourseInfo> studentSchedule
    ) {
        super(studentId);
        this.resultType  = resultType;
        this.studentSchedule = studentSchedule;
	}
	
    @Override
    public String toString() {
        String classes = String.format(
            "%s for StudentId:%s",
            this.resultType, 
            this.getStudentId());
        classes += "CourseNumber\\CourseName\\SectionNumber\\TimeDay\n";
        for (CourseInfo course: studentSchedule) {
            classes += course.getCourseNumber() + "\\" +
                    course.getCourseName() + "\\" +
                    course.getSectionNumber() + "\\" +
                    course.getDayTime() + "\n";

        }
        return classes;
    }
}
