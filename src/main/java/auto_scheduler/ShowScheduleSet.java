package org.txstate.auto_scheduler;

import java.util.Collection;

public class ShowScheduleSet extends ScheduleSet {

    Collection<CourseInfo> studentSchedule;
    public ShowScheduleSet(
        String studentId,
        Collection<CourseInfo> studentSchedule) {
        super(studentId);
        this.studentSchedule = studentSchedule;
    }
    
    @Override
    public String toString() {
        String classes = "show Schedule for StudentId:" + this.getStudentId();
        classes = "CourseNumber\\CourseName\\SectionNumber\\TimeDay\n";
        for (CourseInfo course: studentSchedule) {
            classes += course.getCourseNumber() + "\\" +
                    course.getCourseName() + "\\" +
                    course.getSectionNumber() + "\\" +
                    course.getDayTime() + "\n";

        }
        return classes;
    }
}