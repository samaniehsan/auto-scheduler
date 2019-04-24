package org.txstate.auto_scheduler;

public class ScheduleCancelation implements ScheduleAction {
	ResourcePathProvider pathProvider;

	public ScheduleCancelation(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public ScheduleSet execute(OperationContext context)
	{
		return null;
	}
}
