package org.txstate.auto_scheduler;

public class OperationServiceFactory {
	
	public ScheduleAction get(OperationContext context) {
		ResourcePathProvider pathProvider = new DefaultResourcePathProviderImpl();

		OperationContext.OperationCode opCode = context.getOperationCode();
		switch (opCode) {
		case Schedule:
			return new Scheduler(pathProvider);
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
