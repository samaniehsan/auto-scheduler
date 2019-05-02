package org.txstate.auto_batcher;
import java.lang.UnsupportedOperationException;
import java.io.IOException;
/**
 * StudentScheduleInvoker.java : Will compaile the Student ID into a java command to run auto_scheduler
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 * */
public class StudentScheduleInvoker {
    String autoSchedulerJarPath;
    StudentScheduleInvoker(String autoSchedulerJarPath) {
        this.autoSchedulerJarPath = autoSchedulerJarPath;
    }

    /**
     * MultiStudentScheduleInvoker : Will enter a custom command for the respective id
     * @param Collection<Student> students
     * @return N/A
     * @exception IOException
     */
    public void schedule(String studentId) throws java.lang.InterruptedException {
        // Example command:
        // java auto_scheduler-1.0.jar --schedule AXYZID
        String javaExecutablePrefix = "java -jar ";
        String pathexe = javaExecutablePrefix + pathMaker(studentId);
        System.out.println("Made it");
        System.out.println(this.autoSchedulerJarPath);
        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(pathexe);
            int exitVal = proc.waitFor();
            System.out.println("scheduler exitValue: " + exitVal);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return;
    }
    /**
     * pathMaker : Will create a path to be exectured
     * @param String id
     * @return String Path
     * @exception N/A
     */
    public String pathMaker(String id) {
        String path = "";
        path = this.autoSchedulerJarPath + " --schedule " + id;
        return path;
    }
}
