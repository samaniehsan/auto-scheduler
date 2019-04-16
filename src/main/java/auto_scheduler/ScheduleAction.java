package org.txstate.auto_scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ScheduleAction {
	ScheduleSet execute(OperationContext context) throws FileNotFoundException, java.io.IOException;;
}
