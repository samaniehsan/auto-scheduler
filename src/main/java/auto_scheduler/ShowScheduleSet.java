package org.txstate.auto_scheduler;

import java.util.Collection;

public class ShowScheduleSet extends ScheduleResultBase {

    public ShowScheduleSet(
        String studentId,
        Collection<CourseInfo> studentSchedule) {
        super(studentId, "show Schedule", studentSchedule);
    }
}