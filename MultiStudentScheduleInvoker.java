package org.txstate.auto_batcher;

import java.util.Collection;
import java.lang.UnsupportedOperationException; 


public class MultiStudentScheduleInvoker {
    
    StudentScheduleInvoker singleScheduler;
    public MultiStudentScheduleInvoker(StudentScheduleInvoker singleScheduler) {
        this.singleScheduler =  singleScheduler; 
    }

    public void scheduleAll(Collection<Student> students) {
        for (Student studentExample : students) {
            System.out.println(studentExample.getID());

            //Sr
            if (studentExample.getYear() == 4){ singleScheduler.schedule(studentExample.getID()); }
            //Jr
            else if (studentExample.getYear() == 3) { singleScheduler.schedule(studentExample.getID()); }
            // Soph
            else if (studentExample.getYear() == 2) { singleScheduler.schedule(studentExample.getID()); }
            // Fr
            else if (studentExample.getYear() == 1) { singleScheduler.schedule(studentExample.getID()); }

        }
        return;
    }
}
