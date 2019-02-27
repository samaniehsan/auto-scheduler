package org.txstate.auto_scheduler;

import java.util.Collection;
import java.util.Dictionary;
import java.util.Hashtable;

public class StudentRecordSet {
	Collection<StudentRecord> records;
	
	public StudentRecordSet(Collection<StudentRecord> records) {
		this.records = records;
	}
	
	Dictionary<String, StudentRecord> getMap() {
		Dictionary<String, StudentRecord> map = new Hashtable<String, StudentRecord>();
		if(records == null) {
			for(StudentRecord record : this.records) {
				//TODO; loop through and only add the highest grade achieved.
				map.put(record.getCourseCode(), record);
			}
		}
		return map;
	}
}
