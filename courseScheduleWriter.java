package org.txstate.auto_scheduler;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * courseScheduleWriter.java (main): Will write available course schedule into CSV file
 * @param String[] args
 * @return N/A
 * @exception IOException
 * @version 1.0
 * @since   5-2-2019
 */
public class courseScheduleWriter {

    private static final String COURSES = "./data/courseSchedule.csv";

    public static void main(String[] args) throws IOException {

        CourseData getCourses = new CourseData();
        List<CourseInfo> courses = getCourses.loadData();

        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(COURSES));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Course_Number", "Section_Number", "Course_Name", "Time_Day","Room_Number","Capacity","Enrolled"));
        ) {
            for (int i = 0; i < (courses.size()); i++)
                csvPrinter.printRecord(courses.get(i).getCourseNumber(),
                        courses.get(i).getCourseNumber(),
                        courses.get(i).getSectionNumber(),
                        courses.get(i).getCourseName(),
                        courses.get(i).getDayTime(),
                        courses.get(i).getRoomNumber(),
                        courses.get(i).getCapacity(),
                        courses.get(i).getEnrolled());
            csvPrinter.flush();
        }
    }
}



