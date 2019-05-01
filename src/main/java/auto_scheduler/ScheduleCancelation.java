package org.txstate.auto_scheduler;

import java.io.IOException;

public class ScheduleCancelation implements ScheduleAction {
	ResourcePathProvider pathProvider;

	public ScheduleCancelation(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public ScheduleSet execute(OperationContext context) throws IOException {
		DefaultResourcePathProviderImpl path = new DefaultResourcePathProviderImpl();
		String studentId = context.getStudentId();
		StudentScheduleRepositoryImpl schedule = new StudentScheduleRepositoryImpl(path);
		boolean success = schedule.delete(studentId);
		return new CacenlationScheduleSet(studentId, success);
	}
}
