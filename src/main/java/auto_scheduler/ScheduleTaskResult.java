package org.txstate.auto_scheduler;

import java.util.Collection;

public class ScheduleTaskResult extends ScheduleResultBase {
    public ScheduleTaskResult(
        String studentId,
        Collection<CourseInfo> studentSchedule) {
        super(studentId, "schedule", studentSchedule);
    }
}