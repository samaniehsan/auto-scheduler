package org.txstate.auto_scheduler;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
/**
 * CourseScheduleRepositoryImpl.java : Will handle enrolled count, course's and time slots available
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class CourseScheduleRepositoryImpl implements CourseScheduleRepository {

    ResourcePathProvider resourcePathProvider;
    public CourseScheduleRepositoryImpl(ResourcePathProvider resourcePathProvider) {
        this.resourcePathProvider = resourcePathProvider;
    }
    /**
     * getClasses() : Will add course to course records
     * @param N/A
     * @return schedule
     * @exception FileNotFoundException,  IOException
     */
    public Collection<CourseInfo> getClasses() throws FileNotFoundException,  IOException {
        List<CourseInfo> schedule = new ArrayList<>();
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        String filePath = resourcePathProvider.getClassSchedule() + "/" + "courseSchedule.csv";
        File file = new File(filePath);
        CSVParser parser;
        try {
            parser = new CSVParser(new FileReader(filePath), format);
            for (CSVRecord record : parser) {
                CourseInfo course = new CourseInfo();
                course.setCourseNumber(record.get("CourseNumber"));
                course.setSectionNumber(Integer.parseInt(record.get("SectionNumber")));
                course.setCourseName(record.get("CourseName"));
                course.setDayTime(record.get("TimeDay"));
                course.setRoomNumber(Integer.parseInt(record.get("RoomNumber")));
                course.setCapacity(Integer.parseInt(record.get("Capacity")));
                course.setEnrolled(Integer.parseInt(record.get("Enrolled")));
                schedule.add(course);
            }
            parser.close();

        } catch (IOException e) {
            System.out.println("Failed to load class data");
            e.printStackTrace();
        }
        timeSlotCreater(schedule);
        return schedule;
    }
    /**
     * incrementEnrolledCount() : Will parse CSV records and increment enrolled based on students registration
     * @param Collection<Integer> sectionNumbers
     * @return N/A
     * @exception FileNotFoundException,  IOException
     */
    public void incrementEnrolledCount(Collection<Integer> sectionNumbers) throws FileNotFoundException,  IOException {
        if(sectionNumbers == null || sectionNumbers.size() == 0)
            throw new IllegalArgumentException("sectionNumbers are required!");
        List<CourseInfo> schedule = new ArrayList<>();
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        String filePath = resourcePathProvider.getClassSchedule() + "/" + "courseSchedule.csv";
        File file = new File(filePath);
        CSVParser parser;
        try {
            parser = new CSVParser(new FileReader(filePath), format);
            for (CSVRecord record : parser) {
                CourseInfo course = new CourseInfo();
                course.setCourseNumber(record.get("CourseNumber"));
                course.setSectionNumber(Integer.parseInt(record.get("SectionNumber")));
                course.setCourseName(record.get("CourseName"));
                course.setDayTime(record.get("TimeDay"));
                course.setRoomNumber(Integer.parseInt(record.get("RoomNumber")));
                course.setCapacity(Integer.parseInt(record.get("Capacity")));
                course.setEnrolled(Integer.parseInt(record.get("Enrolled")));
                schedule.add(course);
            }
            parser.close();

        } catch (IOException e) {
            System.out.println("Failed to load class data");
            e.printStackTrace();
        }

        for (CourseInfo course:schedule){
            if(sectionNumbers.contains(course.getSectionNumber())){
                    course.setEnrolled(course.getEnrolled()+1);
            }
        }
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("CourseNumber", "SectionNumber", "CourseName", "TimeDay","RoomNumber","Capacity","Enrolled"));
        ) {
            for (int i = 0; i < (schedule.size()); i++)
                csvPrinter.printRecord(
                        schedule.get(i).getCourseNumber(),
                        schedule.get(i).getSectionNumber(),
                        schedule.get(i).getCourseName(),
                        schedule.get(i).getDayTime(),
                        schedule.get(i).getRoomNumber(),
                        schedule.get(i).getCapacity(),
                        schedule.get(i).getEnrolled());
            csvPrinter.flush();
        }
    }
    /**
     * timeSlotCreater() : Creates time slots for courses
     * @param List<CourseInfo> schedule
     * @return N/A
     * @exception N/A
     */
    public static void timeSlotCreater(List<CourseInfo> schedule){
        Map<Integer, Integer> time = new LinkedHashMap<>();
        Map<String, Integer> day = new LinkedHashMap<>();
        for (CourseInfo course: schedule){
            String[] dayTimeSplit = course.getDayTime().split(" ");
            String[] timeSplit = course.getDayTime().split(":");
            time.put(Integer.parseInt(timeSplit[0]),0);
            day.put(dayTimeSplit[1],0);
        }
        Map<Integer, Integer> timeMap = new TreeMap<>(time);
        Map<String, Integer> dayMap = new TreeMap<>(day);
        int i = 0;
        for (Integer key : timeMap.keySet()) {
            timeMap.put(key, i);
            i++;
        }
        i = 100;
        for (String key : dayMap.keySet()) {
            dayMap.put(key, i);
            i += 100;
        }
        for (CourseInfo course: schedule){
            String[] dayTimeSplit = course.getDayTime().split(" ");
            String[] timeSplit = course.getDayTime().split(":");
            course.setTimeSlot(timeMap.get(Integer.parseInt(timeSplit[0])) + dayMap.get(dayTimeSplit[1]));
        }
    }
}
