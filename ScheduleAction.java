package org.txstate.auto_scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * ScheduleAction.java : Public interface
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public interface ScheduleAction {
	ScheduleSet execute(OperationContext context) throws FileNotFoundException, java.io.IOException;;
}
