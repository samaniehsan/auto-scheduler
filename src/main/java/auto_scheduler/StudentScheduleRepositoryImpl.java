package org.txstate.auto_scheduler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class StudentScheduleRepositoryImpl implements StudentScheduleRepository {
    
    ResourcePathProvider resourcePathProvider;
    public StudentScheduleRepositoryImpl(ResourcePathProvider resourcePathProvider) {
        this.resourcePathProvider = resourcePathProvider;
    }

    public boolean delete(String studentId) throws FileNotFoundException,  IOException {
        if(studentId == null || studentId.isEmpty()) 
            throw new IllegalArgumentException("studentid is required!");

        ensureStudentExists(studentId);

        String filePath = resourcePathProvider.getClassSchedule() + "/" + studentId + "_schedule.csv";
        File file = new File(filePath);
        if(file.exists()) {    
            if(file.delete()){
                return true;
            }
        }
        return false;
    }

    public Collection<Integer> get(String studentId) throws FileNotFoundException,  IOException {
        if(studentId == null || studentId.isEmpty()) 
            throw new IllegalArgumentException("studentid is required!");
        ArrayList<Integer> sectionNumbers = new ArrayList<>();

        ensureStudentExists(studentId);

        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        String filePath = resourcePathProvider.getClassSchedule() + "/" + studentId + "_schedule.csv";
        File file = new File(filePath);
        if(file.exists()) {
            CSVParser parser;
            try {
                parser = new CSVParser(new FileReader(filePath), format);
                for (CSVRecord record : parser) {
                    sectionNumbers.add(Integer.parseInt(record.get("SectionNumber")));
                }
                parser.close();
    
            } catch (IOException e) {
                System.out.println("Failed to load data");
                e.printStackTrace();
            }
            return sectionNumbers;
        } else {
            throw new NoScheduleFoundException(
                studentId, 
                "No Schedule Found");
        }
    }
    
    public void write(String studentId, Collection<Integer> sectionNumbers)
        throws FileNotFoundException,  IOException {
        if(studentId == null || studentId.isEmpty()) 
            throw new IllegalArgumentException("studentid is required!");
        
        if(sectionNumbers == null || sectionNumbers.size() == 0)
            throw new IllegalArgumentException("sectionNumbers are required!");
        
        String courseScheduleFolder = this.resourcePathProvider.getClassSchedule();
        String filePath = courseScheduleFolder + "/"+ studentId + "_schedule.csv";
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("SectionNumber"));

        ) {
            for (Integer sectionNumber: sectionNumbers) {
                csvPrinter.printRecord(
                    sectionNumber);

            }
                
            csvPrinter.flush();
        }
    }

    private void ensureStudentExists(String studentId) {
        String studentBioFile = resourcePathProvider.getRecords() + "/" + studentId + ".json";
        File fileBio = new File(studentBioFile);
        if(!fileBio.exists())
            throw new StudentNotFoundException(studentId,"Student not found.");
    }
}
