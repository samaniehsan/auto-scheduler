package org.txstate.auto_batcher;

import java.util.Collection;
import java.lang.UnsupportedOperationException; 


public class MultiStudentScheduleInvoker {
    
    StudentScheduleInvoker singleScheduler;
    public MultiStudentScheduleInvoker(StudentScheduleInvoker singleScheduler) {
        this.singleScheduler =  singleScheduler; 
    }

    public void scheduleAll(Collection<Student> students) {
        throw new UnsupportedOperationException("Derek please loop header");
    }
}