package org.txstate.auto_scheduler;

public class OperationServiceFactory {
	
	public ScheduleAction get(OperationContext context) {
		OperationContext.OperationCode opCode = context.getOperationCode();
		switch (opCode) {
		case Schedule:
			return new Scheduler();
		case Select:
			return new SchedulerSelector();
		case Cancel:
			return new ScheduleCancelation();
		case Peek:
			return new SchedulePeeker();
		}
			
		return null;
	}
	
}
