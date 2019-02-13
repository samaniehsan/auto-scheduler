package org.txstate.auto_scheduler;

public interface Operator {
	ScheduleSet execute(OperationContext context);
}
