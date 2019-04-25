package org.txstate.auto_scheduler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;



public class courseScheduleWriter {

    //private static final String COURSES = "./resources/courseSchedule.csv";

    //Delimiter used in CSV file
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final Object [] FILE_HEADER = {"Course_Number", "Section_Number", "Course_Name","Time_Slot","Time_Day","Room_Number","Capacity","Enrolled"};

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = null;

        CSVPrinter csvPrinter = null;

        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);

        try {

            //initialize FileWriter object
            fileWriter = new FileWriter("resources/data/courseSchedule/courseSchedule.csv") ;

            //initialize CSVPrinter object
            csvPrinter = new CSVPrinter(fileWriter, csvFileFormat);

            //Create CSV file header
            csvPrinter.printRecord(FILE_HEADER);
            CourseData getCourses = new CourseData();
            List<CourseInfo> courses = getCourses.loadData();
            for (int i = 0; i < (courses.size()); i++)
                csvPrinter.printRecord(courses.get(i).getCourseNumber(),
                        courses.get(i).getSectionNumber(),
                        courses.get(i).getCourseName(),
                        courses.get(i).getTimeSlot(),
                        courses.get(i).getDayTime(),
                        courses.get(i).getRoomNumber(),
                        courses.get(i).getCapacity(),
                        courses.get(i).getEnrolled());

            csvPrinter.flush();


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvPrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }



    }
}
