package org.txstate.auto_scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ScheduleDryRunner implements ScheduleAction {
	ResourcePathProvider pathProvider;

	public ScheduleDryRunner(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public ScheduleSet execute(OperationContext context) throws FileNotFoundException, IOException
	{		
		Scheduler scheduler = new Scheduler(true, this.pathProvider);
		return scheduler.execute(context);		
	}
}
