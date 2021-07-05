package org.txstate.auto_scheduler;

/**
 * ScheduleShower.class : class file for  ScheduleAction
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
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
