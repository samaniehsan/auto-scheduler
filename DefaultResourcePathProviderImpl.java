package org.txstate.auto_scheduler;
/**
 * DefaultResourcePathProviderImpl.class : Header (class) file, used to display functions in class DefaultResourcePathProviderImpl
 * @param N/A
 * @return "resources/data/records" default
 * @version 1.0
 * @since   5-2-2019
 */
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
