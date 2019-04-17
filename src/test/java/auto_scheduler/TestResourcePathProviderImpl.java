package org.txstate.auto_scheduler;

public class TestResourcePathProviderImpl implements ResourcePathProvider {	
    
    public String getRecords() {
        return "../src/main/resources/data/records";
    }
    
    public String getClasses() {
        return "../src/main/resources/data/classes";
    }
    
    public String getClassSchedule() {
        return "../src/main/resources/data/records/courseSchedule";
    }
}
