package org.txstate.auto_scheduler;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.lang.Object; 
import java.lang.Class;
import java.lang.ClassLoader;
import java.io.File;
import java.io.*;
import java.net.URL;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 * Reads the csv files and creates a list of CourseInfo with
 * section, time, day and room number
 * @author Barry Rominger
 */

public class CourseData {

    private static int section = 11000;
    
    /**
     * LoadData creates a ArrayList of the CourseInfo
     *
     * @return courses
     */

    public List<CourseInfo> loadData() throws FileNotFoundException, IOException {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        List<CourseInfo> courses = new ArrayList<CourseInfo>();
        String degree = "/data/classes/computer_science.csv";
        addCourse(courses, degree, format);
        degree = "/data/classes/criminal_justice.csv";
        addCourse(courses, degree, format);
        degree = "/data/classes/psychology.csv";
        addCourse(courses, degree, format);
        createSection(courses);
        addRoomTimeDay(courses);
        enrolled(courses);
        return courses;
    }

    public static void enrolled(List<CourseInfo> courses){
        Random enrolled = new Random();
        for (int i = 0; i < (courses.size());i++) {
            courses.get(i).setCapacity(20);
            courses.get(i).setEnrolled(enrolled.nextInt(21));
       }

    }

    }
    /**
     * Reads each csv file and adds each course to courses ArrayList
     *
     * @param courses
     * @param degree
     * @param format
     */

    public static void addCourse(List<CourseInfo> courses, String degree, CSVFormat format) throws FileNotFoundException, IOException  {
        CSVParser parser;
        ArrayList<String> cn = new ArrayList<String>();
        //Get file from resources folder
        // ClassLoader classLoader = CourseData.class.getClassLoader();
        // URL url = classLoader.getResource(degree);
        URL url = CourseData.class.getResource(degree);
        System.out.print("url:");
        String filePath = url.getFile();
        System.out.print("filepath:"+filePath);
        File file = new File(filePath);
        parser = new CSVParser(new FileReader(file), format);
        for (CSVRecord record : parser) {
            if ((cn.isEmpty()) || (!cn.contains((record.get("Course_Number"))))) {
                cn.add(record.get("Course_Number"));
                CourseInfo cor = new CourseInfo();
                cor.setCourseNumber(record.get("Course_Number"));
                cor.setCourseName(record.get("Course_Name"));
                cor.setSubject(record.get("Subject"));
                courses.add(cor);
            }
        }
        parser.close();    
    }

    /** Creates copy of courses with unique section Numbers
     *
     * @param courses
     * @param course
     */

    public static void addCourse(List<CourseInfo> courses, CourseInfo course) {

        CourseInfo t  = new CourseInfo();
        t.setSubject(course.getSubject());
        t.setCourseName(course.getCourseName());
        t.setCourseNumber(course.getCourseNumber());
        t.setSectionNumber(section);
        section++;
        courses.add(t);

    }

    /**
     * Add section number to the course and depending on course level create addition
     * copies of course
     * @param courses
     */

    public static void createSection(List<CourseInfo> courses) {

        String tempStr;
        char ch;
        int size = courses.size();

        for (int i = 0; i < size; i++) {
            tempStr = courses.get(i).getCourseNumber();
            for (int j = 0; j < tempStr.length(); j++) {
                ch = tempStr.charAt(j);
                if (Character.isDigit(ch)) {
                    int n = Character.getNumericValue(ch);
                    courses.get(i).setSectionNumber(section);
                    section++;
                    if (n == 1 || n == 2) {
                        for (int l = 0; l < 2; l++)
                            addCourse(courses, courses.get(i));

                    } else if (n == 3 || n == 4) {
                            addCourse(courses, courses.get(i));
                    }
                    break;
                }
            }
        }
    }

    /**
     * Randomly sdds time, day and room number to CourseInfo
     * @param courses
     */

    public static void addRoomTimeDay(List<CourseInfo> courses) {
        List<String> TimeDay = new ArrayList<String>(Arrays.asList(
                "8:00 - 9:20 MW"
                ,"9:30 - 10:50 MW"
                ,"11:00 - 12:20 MW"
                ,"12:30 - 1:50 MW"
                ,"2:00 - 3:20 MW"
                ,"3:30 - 5:00 MW"
                ,"8:00 - 9:20 TTh"
                ,"9:30 - 10:50 TTh"
                ,"11:00 - 12:20 TTh"
                ,"12:30 - 1:50 TTh"
                ,"2:00 - 3:20 TTh"
                ,"3:30 - 5:00 TTh"));
        
        int TimeSlot[] = {100,101,102,103,104,105,200,201,202,203,204,205};

        int i;
        int c= 0;
        int room1 = 1000;
        ArrayList<Integer> list = courseRandomnizer(courses.size());
        for (i = 0; i < (courses.size()/12)+ 1;i++) {
            for (int j = 0; j < 12; j++) {
                if (c == (courses.size())){
                    break;
                } else {
                    courses.get(list.get(c)).setRoomNumber(room1);
                    courses.get(list.get(c)).setDayTime(TimeDay.get(j));
                    courses.get(list.get(c)).setTimeSlot(TimeSlot[j]);
                    c++;

                }
            }
            room1++;
        }
    }

    /**
     * Creates a list of random numbers to assign classroom number and time
     * @param r
     * @return
     */

    public static ArrayList<Integer> courseRandomnizer(int r){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<r; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

}




