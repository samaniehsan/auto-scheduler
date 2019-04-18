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
		StudentInfo studentInfo = studentRepo.getInfo(studentId);

		if(studentInfo == null) {
			throw new StudentNotFoundException(studentId, String.format("Student %s Not Found", studentId));	
		}
		return implementSchedule(studentInfo, studentId);
	}

	private ScheduleSet implementSchedule(
		StudentInfo studentInfo,
		String studentId) throws FileNotFoundException, IOException {

		StudentRecordRepositoryImpl gradeRepo = new StudentRecordRepositoryImpl(this.pathProvider);
		Collection<StudentRecord> records = gradeRepo.get(studentId);
		printGrades(records);
		
		DegreePlanRespositoryImpl degreePlanRespository = new DegreePlanRespositoryImpl(this.pathProvider);
		Collection<CurriculumCourse> curriculumCourses = degreePlanRespository.get(studentInfo.getMajor());
		
		printDegreePlan(curriculumCourses);
		
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

	private void printDegreePlan(Iterable<CurriculumCourse> majorCourses) {
		System.out.println("******Courses For Major******");
		if(majorCourses != null ) {
			for(CurriculumCourse course: majorCourses) {
				String courseNumber = course.getCourseNumber();
				String courseName = course.getCourseName();
				String preReq = course.getPreRequisite();
				
				System.out.format("courseNumber %s, courseName:%s, preReq:%s\n",
				courseNumber, 
				courseName,
				preReq);
			}
		}
		System.out.println("******************");
	}	
}
