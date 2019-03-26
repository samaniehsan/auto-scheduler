package org.txstate.auto_scheduler;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * CourseData loads the list of courses from csv files into a Arraylist
 * @author Barry Rominger
 */

public class CourseData {

    /**
     * LoadData creates a ArrayList of the CourseInfo
     * @return courses
     */

    public List<CourseInfo> loadData() {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        List<CourseInfo> courses = new ArrayList<CourseInfo>();
        String degree = "data/classes/computer_science.csv";
        addCourse(courses,degree,format);
        degree = "data/classes/criminal_justice.csv";
        addCourse(courses,degree,format);
        degree = "data/classes/psychology.csv";
        addCourse(courses,degree,format);
        return courses;
    }

    /**
     * Reads each csv file and adds each course to courses ArrayList
     * @param courses
     * @param degree
     * @param format
     */

    public static void addCourse(List<CourseInfo> courses, String degree, CSVFormat format ){
        CSVParser parser;
        ArrayList<String> cn = new ArrayList<String>();
        try {
            parser = new CSVParser(new FileReader(degree), format);
            for (CSVRecord record : parser) {
                if ( (cn.isEmpty()) ||(!cn.contains((record.get("Course_Number"))))) {
                    cn.add(record.get("Course_Number"));
                    CourseInfo cor = new CourseInfo();
                    cor.setCourse_number(record.get("Course_Number"));
                    cor.setCourse_name(record.get("Course_Name"));
                    cor.setSubject(record.get("Subject"));
                    courses.add(cor);
                }
            }
            parser.close();
        } catch (IOException e) {
            System.out.println("Failed to load class data");
            e.printStackTrace();
        }
    }
}


