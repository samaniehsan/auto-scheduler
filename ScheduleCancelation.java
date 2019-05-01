package org.txstate.auto_scheduler;

/**
 * ScheduleCancelation.java : Manages if a schedual is canceled
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
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
