package org.txstate.auto_scheduler;

public class OperationServiceFactory {
	
	public ScheduleAction get(OperationContext context) {
		ResourcePathProvider pathProvider = new DefaultResourcePathProviderImpl();

		OperationContext.OperationCode opCode = context.getOperationCode();
		switch (opCode) {
		case Schedule:
			return new Scheduler(pathProvider);
		case DryRun:
			return new ScheduleDryRunner(pathProvider);
		case Show:
			return new ScheduleShower(pathProvider);			
		case Cancel:
			return new ScheduleCancelation(pathProvider);
		}			
		return null;
	}
	
}
