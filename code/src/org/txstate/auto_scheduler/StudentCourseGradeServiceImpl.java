package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;

public class StudentCourseGradeServiceImpl implements StudentCourseGradeService {	
	StudentRecordRepository recordRepository;
	
	public StudentCourseGradeServiceImpl(StudentRecordRepository recordRepository) {
		this.recordRepository = recordRepository;
	}
	
	public boolean hasCourse(String studentId,String courseCode) {
		Dictionary<String, StudentRecord> map = getMap(studentId);
		StudentRecord studentRecord = map.get(courseCode);
		if (studentRecord !=null && studentRecord.getGrade().ordinal() > CourseGrade.D.ordinal()) {
			return true;
		}
		return false;
	}
	
	Dictionary<String, StudentRecord> getMap(String studentId) {
		Collection<StudentRecord> records = recordRepository.get(studentId);
		Dictionary<String, StudentRecord> map = new Hashtable<String, StudentRecord>();
		if(records == null) {
			for(StudentRecord record : records) {
				if(record != null)
					//TODO; loop through and only add the highest grade achieved.
					map.put(record.getCourseCode(), record);
			}
		}
		return map;
	}
	
}
