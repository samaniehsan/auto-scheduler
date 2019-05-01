package org.txstate.auto_scheduler;

import java.util.Collection;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.UnsupportedOperationException;


/**
 * StudentScheduleRepositoryImpl.java :  manages students suggested schedual
 * @param N/A
 * @return N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentScheduleRepositoryImpl implements StudentScheduleRepository {
    
    ResourcePathProvider resourcePathProvider;
    public StudentScheduleRepositoryImpl(ResourcePathProvider resourcePathProvider) {
        this.resourcePathProvider = resourcePathProvider;
    }

    /**
     * delete() : deletes course from student schedual/id
     * @param String studentId
     * @exception FileNotFoundException,  IOException
     * @return void
     */
    public void delete(String studentId) throws FileNotFoundException,  IOException {
        if(studentId == null || studentId.isEmpty()) 
            throw new IllegalArgumentException("studentid is required!");

        throw new UnsupportedOperationException("implment removing student schedule file!");
    }

    /**
     * get() : get section number for student id
     * @param String studentId
     * @exception FileNotFoundException,  IOException
     * @return Collection<String>
     */
    public Collection<String> get(String studentId) throws FileNotFoundException,  IOException {
        if(studentId == null || studentId.isEmpty()) 
            throw new IllegalArgumentException("studentid is required!");

        throw new UnsupportedOperationException("return sections numbers students is registered for!");
    }

    /**
     * write() : write course to student schedual
     * @param tring studentId, Collection<String> sectionNumbers
     * @exception FileNotFoundException,  IOException
     * @return void
     */
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
