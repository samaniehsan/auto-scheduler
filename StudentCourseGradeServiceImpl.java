package org.txstate.auto_scheduler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;
/**
 * StudentCourseGradeService.java : Checks the history of students courses
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentCourseGradeServiceImpl implements StudentCourseGradeService {	
	StudentRecordRepository recordRepository;
	
	public StudentCourseGradeServiceImpl(StudentRecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}
	/**
	 * hasCourse() : Checks is course had been schedualed or taken
	 * @param String studentId,String courseCode
	 * @return boolean
	 * @exception FileNotFoundException, IOException
	 */
	public boolean hasCourse(String studentId,String courseCode) throws FileNotFoundException, IOException {
		Dictionary<String, StudentRecord> map = getMap(studentId);
		StudentRecord studentRecord = map.get(courseCode);
		if (studentRecord !=null && studentRecord.getGrade().ordinal() > CourseGrade.D.ordinal()) {
			return true;
		}
		return false;
	}
	/**
	 * getMap() : Add grades to student records
	 * @param String studentId
	 * @return Dictionary<String, StudentRecord> map
	 * @exception FileNotFoundException, IOException
	 */
	Dictionary<String, StudentRecord> getMap(String studentId) throws FileNotFoundException, IOException {
		Collection<StudentRecord> records = recordRepository.get(studentId);
		Dictionary<String, StudentRecord> map = new Hashtable<String, StudentRecord>();
		if(records != null) {
			for(StudentRecord record : records) {
				if(record != null)
					//TODO; loop through and only add the highest grade achieved.
					map.put(record.getCourseCode(), record);
			}
		}
		return map;
	}
	
}
