package org.txstate.auto_scheduler;

public interface ScheduleAction {
	ScheduleSet execute(OperationContext context);
}
