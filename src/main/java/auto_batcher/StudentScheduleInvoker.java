package org.txstate.auto_batcher;
import java.lang.UnsupportedOperationException; 

public class StudentScheduleInvoker {
    String autoSchedulerJarPath;
    StudentScheduleInvoker(String autoSchedulerJarPath) {
        this.autoSchedulerJarPath = autoSchedulerJarPath;
    }
    
    public void schedule(String studentId) {
        throw new UnsupportedOperationException("Derek please implment");
    }
}