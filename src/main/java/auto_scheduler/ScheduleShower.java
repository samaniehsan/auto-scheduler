package org.txstate.auto_scheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;


public class ScheduleShower implements ScheduleAction {
    ResourcePathProvider pathProvider;
    
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
        Collection<CourseInfo> courses = classes.getClasses();
        ArrayList<CourseInfo> studentSchedule = new ArrayList<>();
        for (Integer sn: sections){
            for (CourseInfo course: courses)
                if(course.getSectionNumber() == sn)
                    studentSchedule.add(course);
        }
        return new ShowScheduleSet(studentId, studentSchedule);
    }
}
