package org.txstate.auto_scheduler;

public class ShowScheduleSet extends ScheduleSet {

    Collection<CourseInfo> studentSchedule;
    public ShowScheduleSet(
        String studentId,
        Collection<CourseInfo> studentSchedule) {
        super(studentId);
        this.success = success;
        this.studentSchedule = studentSchedule;
    }
    
    @Override
    public String toString() {
        String classes = "StudentId:" + this.getStudentId();
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