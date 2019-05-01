package org.txstate.auto_batcher;

import java.util.Collection;
import java.lang.UnsupportedOperationException;

/**
 * MultiStudentScheduleInvoker.java : Will Traverse Collection<Student> students and pass the respective year to StudentScheduleInvoker
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class MultiStudentScheduleInvoker {
    
    StudentScheduleInvoker singleScheduler;
    /**
     * MultiStudentScheduleInvoker : Will create a StudentScheduleInvoker variable for file
     * @param Collection<Student> students
     * @return N/A
     * @exception N/A
     */
    public MultiStudentScheduleInvoker(StudentScheduleInvoker singleScheduler) {
        this.singleScheduler =  singleScheduler; 
    }

    /**
     * scheduleAlla : Will Call StudentScheduleInvoker for each ID
     * @param Collection<Student> students
     * @return N/A
     * @exception N/A
     */
    public void scheduleAll(Collection<Student> students) {
        //Student -> NamTuble -> getID()
        for (Student studentExample : students) {
            //Sr
            if (studentExample.getYear() == 4){ singleScheduler.schedule(studentExample.getStudentId()); }
            //Jr
            else if (studentExample.getYear() == 3) { singleScheduler.schedule(studentExample.getStudentId()); }
            // Soph
            else if (studentExample.getYear() == 2) { singleScheduler.schedule(studentExample.getStudentId()); }
            // Fr
            else if (studentExample.getYear() == 1) { singleScheduler.schedule(studentExample.getStudentId()); }
        }
        return;
    }
}
