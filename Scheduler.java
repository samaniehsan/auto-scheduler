package org.txstate.auto_scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Scheduler.java : Will schedual students, and print grades
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class Scheduler implements ScheduleAction {
	ResourcePathProvider pathProvider;
	boolean readonlyMode = false;


	public Scheduler(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	/**
	 * Scheduler() : Constructor
	 * @param N/A
	 * @return N/A
	 */
	public Scheduler(boolean readonlyMode, ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
		this.readonlyMode = readonlyMode;
	}

	/**
	 * execute() : gathers student data, from various functions and files
	 * @param StudentInfo studentInfo, String studentId
	 * @exception FileNotFoundException, IOException
	 * @return ScheduleSet
	 */
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

	/**
	 * implementSchedule() : implements schedular useing functions from Scheduler.java
	 * @param StudentInfo studentInfo, String studentId
	 * @exception FileNotFoundException, IOException
	 * @return NUll
	 */
	private ScheduleSet implementSchedule(
		StudentInfo studentInfo,
		String studentId) throws FileNotFoundException, IOException {

		StudentRecordRepositoryImpl gradeRepo = new StudentRecordRepositoryImpl(this.pathProvider);
		Collection<StudentRecord> records = gradeRepo.get(studentId);
		printGrades(records);
		
		DegreePlanRespositoryImpl degreePlanRespository = new DegreePlanRespositoryImpl(this.pathProvider);
		Collection<CurriculumCourse> curriculumCourses = degreePlanRespository.get(studentInfo.getMajor());
		
		printDegreePlan("Courses For Major", curriculumCourses);
		
		CandidateCourseService candiateCourseService = new CandidateCourseServiceImpl();
		Collection<CurriculumCourse>  candidateCourses = candiateCourseService.buildList(records, curriculumCourses);
		printDegreePlan("Candidate Courses", candidateCourses);
		

		return null;
	}

	/**
	 * printGrades() :Prints grades to display
	 * @param Iterable<StudentRecord> records
	 * @return N/A
	 */
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

	/**
	 * printDegreePlan() :  prints degree plan to display
	 * @param String tagName, Iterable<CurriculumCourse> majorCourses
	 * @return N/A
	 */
	private void printDegreePlan(String tagName, Iterable<CurriculumCourse> majorCourses) {
		System.out.println("******"+ tagName  + "******");
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
