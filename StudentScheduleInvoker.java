package org.txstate.auto_batcher;
import java.lang.UnsupportedOperationException;
import java.io.IOException;

public class StudentScheduleInvoker {
    String autoSchedulerJarPath;
    StudentScheduleInvoker(String autoSchedulerJarPath) {
        this.autoSchedulerJarPath = autoSchedulerJarPath;
    }
    
    public void schedule(String studentId) {
        String pathexe = "";
        pathexe = pathMaker(studentId);
        System.out.println("Made it");
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec(pathexe);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public String pathMaker(String id) {
        String path = "";
        path = this.autoSchedulerJarPath + "--schedule " + id;
        System.out.println(path);
        return path;
    }
}
