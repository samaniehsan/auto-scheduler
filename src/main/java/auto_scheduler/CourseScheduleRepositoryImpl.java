package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;

public class CourseScheduleRepositoryImpl implements CourseScheduleRepository {    
    
    ResourcePathProvider resourcePathProvider;
    public CourseScheduleRepositoryImpl(ResourcePathProvider resourcePathProvider) {
        this.resourcePathProvider = resourcePathProvider;
    }

    public Collection<CourseInfo> getClasses() throws FileNotFoundException,  IOException {
        String courseScheduleFolder = this.resourcePathProvider.getClassSchedule();
        throw new UnsupportedOperationException("to be implmented!");
    }
    public void incrementEnrolledCount(Collection<String> sectionNumbers) throws FileNotFoundException,  IOException {
        if(sectionNumbers == null || sectionNumbers.size() == 0)
            throw new IllegalArgumentException("sectionNumbers are required!");

        throw new UnsupportedOperationException("to be implmented!");
        //String courseScheduleFolder = this.resourcePathProvider.getClassSchedule();
    }
}
