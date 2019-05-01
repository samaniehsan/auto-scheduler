package org.txstate.auto_scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * ScheduleDryRunner.java : Dry runner path
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class ScheduleDryRunner implements ScheduleAction {
	ResourcePathProvider pathProvider;

	/**
	 * ScheduleDryRunner() : Dry runner assignment
	 * @param ResourcePathProvider pathProvider
	 * @return N/A
	 */
	public ScheduleDryRunner(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}

	/**
	 * execute() : Dry runner scheduler
	 * @param ResourcePathProvider pathProvider
	 * @return ScheduleSet
	 */
	public ScheduleSet execute(OperationContext context) throws FileNotFoundException, IOException
	{		
		Scheduler scheduler = new Scheduler(true, this.pathProvider);
		return scheduler.execute(context);		
	}
}
