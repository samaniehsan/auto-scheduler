package org.txstate.auto_scheduler;

public class DefaultResourcePathProviderImpl implements ResourcePathProvider {	
    
    public String getRecords() {
        return "resources/data/records";
    }
    
    public String getClasses() {
        return "resources/data/classes";
    }
    
    public String getClassSchedule() {
        return "resources/data/courseSchedule";
    }
}
