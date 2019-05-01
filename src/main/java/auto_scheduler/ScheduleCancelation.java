package org.txstate.auto_scheduler;

import java.io.IOException;

public class ScheduleCancelation extends ScheduleSet implements ScheduleAction {
	ResourcePathProvider pathProvider;
	String filename;

	public ScheduleCancelation(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public ScheduleSet execute(OperationContext context) throws IOException {
		DefaultResourcePathProviderImpl path = new DefaultResourcePathProviderImpl();
		String studentId = context.getStudentId();
		StudentScheduleRepositoryImpl schedule = new StudentScheduleRepositoryImpl(path);
		filename = studentId + "_schedule.cvs";
		schedule.delete(studentId);
		return this;
	}

	@Override
	public String toString() {
		return "The following file were deleted " + filename +".";
	}
}
