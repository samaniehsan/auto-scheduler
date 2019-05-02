package org.txstate.auto_scheduler;

import java.util.Collection;

public class DryRunTaskResult extends ScheduleResultBase {
    public DryRunTaskResult(
        String studentId,
        Collection<CourseInfo> studentSchedule) {
        super(studentId, "dry-run", studentSchedule);
    }
}