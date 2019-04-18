package org.txstate.auto_scheduler;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import auto_scheduler.CourseInfo;


public class DegreePlanRespositoryImpl {

    ResourcePathProvider pathProvider;

    public DegreePlanRespositoryImpl(ResourcePathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }

    public Collection<CourseInfo> get(String major) throws FileNotFoundException,  IOException {
        return getCourses(getFilePath(major), major);
    }

    private String getFilePath(String major) {
        String classesFolderRelativePath = this.pathProvider.getRecords();
        String classesCSVPath = classesFolderRelativePath + "/" + major + ".csv";
        return classesCSVPath;
    }

    private Collection<CourseInfo> getCourses(String filePath, String major) throws FileNotFoundException,  IOException {
        ArrayList<CourseInfo> list = new ArrayList<CourseInfo>();

        File file = new File(filePath);

        if(file.exists()) {
            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {

                String courseNumber = record.get("Course_Number");
                String courseName = record.get("Course_Name");
                String subject = record.get("Subject");
                String prereq = record.get("Prereq");

                if(!courseNumber.isEmpty()) {
                    CourseInfo course = new CourseInfo();
                    course.setCourseNumber(courseNumber);
                    course.setCourseName(courseName);
                    course.setSubject(subject);
                    course.setPrereq(prereq);
                    list.add(course);
                }
            }
        }
        return list;
    }
}
