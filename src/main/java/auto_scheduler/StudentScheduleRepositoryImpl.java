package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;



public class StudentScheduleRepositoryImpl implements StudentScheduleRepository {
    
    ResourcePathProvider resourcePathProvider;
    public StudentScheduleRepositoryImpl(ResourcePathProvider resourcePathProvider) {
        this.resourcePathProvider = resourcePathProvider;
    }
    public void write(
        String studentId,
        Collection<String> sectionNumbers) 
        throws FileNotFoundException,  IOException {
        if(studentId == null || studentId.isEmpty()) 
        throw new IllegalArgumentException("studentid is required!");
        
        if(sectionNumbers == null || sectionNumbers.size() == 0)
            throw new IllegalArgumentException("sectionNumbers are required!");
        
        throw new UnsupportedOperationException("to be implmented!");        
        // String courseScheduleFolder = this.resourcePathProvider.getClassSchedule();
        // return false;
    }
}
