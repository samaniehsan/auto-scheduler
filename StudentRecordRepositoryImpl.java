package org.txstate.auto_scheduler;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.txstate.auto_scheduler.StudentRecord;

/**
 * StudentScheduleRepositoryImpl.java : manages students grades and history
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentRecordRepositoryImpl implements StudentRecordRepository {
	ResourcePathProvider pathProvider;

	public StudentRecordRepositoryImpl(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}
	
	public Collection<StudentRecord> get(String studentId) throws FileNotFoundException,  IOException {
		return getGrades(getFilePath(studentId), studentId);
	}


	/**
	 * getFilePath() : Get grade CSV file, from resources
	 * @param String studentId
	 * @return gradeCSVPath
	 */
	private String getFilePath(String studentId) {
		String recordsFolderRelativePath = this.pathProvider.getRecords();
		String gradeCSVPath = recordsFolderRelativePath + "/" + studentId + "_grade.csv";
		return gradeCSVPath;

	}

	/**
	 * getGrades() : Contructor one
	 * @param String filePath, String studentId
	 * @exception FileNotFoundException,  IOException
	 * @return Collection<StudentRecord>
	 */
	private Collection<StudentRecord> getGrades(String filePath, String studentId) throws FileNotFoundException,  IOException {
		ArrayList<StudentRecord> list = new ArrayList<StudentRecord>();
		
		File file = new File(filePath);
	
		if(file.exists()) {
			Reader in = new FileReader(filePath);
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			for (CSVRecord record : records) {

				String course = record.get("CourseNumber");
				String grade = record.get("Grade");
				
				if(!course.isEmpty()) {
					StudentRecord rec = new StudentRecord();
					rec.setStudentId(studentId);
					rec.setCourseCode(course);
					rec.setGrade(getCourseGrade(grade));
					
					list.add(rec);
				}
			}
		}
		return list;		   
	}

	/**
	 * getCourseGrade() : Retrive course grade for student
	 * @param String grade
	 * @return CourseGrade
	 */
	private CourseGrade getCourseGrade(String grade) {
		try {
			CourseGrade courseGrade = CourseGrade.valueOf(grade);
			return courseGrade;
		} catch(Exception e) {
			System.err.print("error for grade:" + grade);
			e.printStackTrace(System.err);
		}
		return CourseGrade.F;
	}
}
