package org.txstate.auto_scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Scheduler implements ScheduleAction {
	ResourcePathProvider pathProvider;
	
	public Scheduler(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	
	public ScheduleSet execute(OperationContext context) throws FileNotFoundException, IOException
	{
		String studentId = context.getStudentId();
		StudentInfoRepositoryImpl studentRepo = new StudentInfoRepositoryImpl(this.pathProvider);

		StudentRecordRepositoryImpl gradeRepo = new StudentRecordRepositoryImpl(this.pathProvider);
		Collection<StudentRecord> records = gradeRepo.get(studentId);
		
		printGrades(records);
		return null;
	}

	private void printGrades(Iterable<StudentRecord> records) {
		System.out.println("******Grades******");
		if(records != null ) {
			for(StudentRecord record: records) {
				String studentId = record.getStudentId();
				String courseNumber = record.getCourseCode();
				CourseGrade courseGrde = record.getGrade();
				System.out.format("StudnetId %s, coureNumber:%s, CourseGrade:%s\n",studentId, courseNumber, courseGrde);
			}
		}
		System.out.println("******************");
	}
}
