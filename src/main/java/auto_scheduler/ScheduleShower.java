package org.txstate.auto_scheduler;

public class ScheduleShower implements ScheduleAction {
	ResourcePathProvider pathProvider;

	public ScheduleShower(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public ScheduleSet execute(OperationContext context)
	{
		return null;
	}
}
