package org.txstate.auto_scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class ScheduleShower implements ScheduleAction {
    ResourcePathProvider pathProvider;
    ArrayList<CourseInfo> studentSchedule = new ArrayList<>();

    public ScheduleShower(ResourcePathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }
    public ScheduleSet execute(OperationContext context)throws IOException
    {
        DefaultResourcePathProviderImpl path = new DefaultResourcePathProviderImpl();
        String studentId = context.getStudentId();
        StudentScheduleRepositoryImpl schedule = new StudentScheduleRepositoryImpl(path);
        Collection<Integer> s = schedule.get(studentId);
        ArrayList<Integer> sections = new ArrayList<>(s);
        CourseScheduleRepositoryImpl classes = new CourseScheduleRepositoryImpl(path);
        Collection<CourseInfo> c = classes.getClasses();
        ArrayList<CourseInfo> courses = new ArrayList<>(c);
        for (Integer sn: sections){
            for (CourseInfo course: courses)
                if(course.getSectionNumber() == sn)
                    studentSchedule.add(course);
        }
        System.out.println(this);
        return null;
    }

    @Override
    public String toString() {
        String classes = "CourseNumber\\CourseName\\SectionNumber\\TimeDay\n";
        for (CourseInfo course: studentSchedule) {
            classes += course.getCourseNumber() + "\\" +
                    course.getCourseName() + "\\" +
                    course.getSectionNumber() + "\\" +
                    course.getDayTime() + "\n";

        }
        return classes;
    }
}
