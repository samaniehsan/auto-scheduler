package org.txstate.auto_scheduler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.*;

public class Scheduler implements ScheduleAction {
	ResourcePathProvider pathProvider;
	boolean readonlyMode = false;

	public Scheduler(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	public Scheduler(boolean readonlyMode, ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
		this.readonlyMode = readonlyMode;
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
		
		printDegreePlan("Courses For Major", curriculumCourses);
		
		CandidateCourseService candiateCourseService = new CandidateCourseServiceImpl();
		Collection<CurriculumCourse>  candidateCourses = candiateCourseService.buildList(records, curriculumCourses);
        
		printDegreePlan("Candidate Courses", candidateCourses);

		CoursePrioritizationService prioritizationService = new CoursePrioritizationServiceImpl(); 
		Collection<CurriculumCourse> prioritizedCourses = prioritizationService.build(candidateCourses);
		printDegreePlan("Prioritized Courses", prioritizedCourses);

		CourseScheduleRepository courseScheduleRepository = new CourseScheduleRepositoryImpl(this.pathProvider);
		Collection<CourseInfo> courseInfos = courseScheduleRepository.getClasses();

		SectionNumberSelectorService sectionNumberSelectionService = new SectionNumberSelectorServiceImpl();
		Collection<Integer> sectionNumbers = sectionNumberSelectionService.build(
			studentId,
			courseInfos,
			prioritizedCourses);
		
		printSectionNumbers(sectionNumbers);

		if(!readonlyMode) {
			StudentScheduleRepository studentScheduleRepository = new StudentScheduleRepositoryImpl(this.pathProvider);
			//waitin on Barry's pr to get merged to change this to write section numbers.
			studentScheduleRepository.write(
				studentId,
				sectionNumbers);
			courseScheduleRepository.incrementEnrolledCount(sectionNumbers);
			Collection<CourseInfo> registeredCourses = filterCourseInfoBySectionNumbers(courseInfos, sectionNumbers);
			return new ScheduleTaskResult(
				studentId,
				registeredCourses);
		} else {
			Collection<CourseInfo> registeredCourses = filterCourseInfoBySectionNumbers(courseInfos, sectionNumbers);
			return new DryRunTaskResult(
				studentId,
				registeredCourses);
		}
	}

	private Collection<CourseInfo> filterCourseInfoBySectionNumbers(
		Collection<CourseInfo> courseInfos,
		Collection<Integer> sectionNumbers) {
		
		Collection<CourseInfo> courses = courseInfos.stream().filter(
				courseInfo ->
				sectionNumbers.stream().noneMatch(
					sectionNumber -> 
					courseInfo.getSectionNumber() == sectionNumber.intValue()
					)
			).collect(Collectors.toList());
		return courses;
	}

	private void printSectionNumbers(Collection<Integer> sectionNumbers) {
		System.out.println("******"+ "sections" + "******");
		if(sectionNumbers != null ) { 
			for(Integer sectionNumber: sectionNumbers) {
				System.out.format("Section %d\n",sectionNumber);
			}
		}
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
