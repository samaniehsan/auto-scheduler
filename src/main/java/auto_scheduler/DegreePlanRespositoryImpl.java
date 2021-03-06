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


public class DegreePlanRespositoryImpl implements DegreePlanRespository {

    ResourcePathProvider pathProvider;

    public DegreePlanRespositoryImpl(ResourcePathProvider pathProvider) {
        this.pathProvider = pathProvider;
    }

    public Collection<CurriculumCourse> get(String major) throws FileNotFoundException,  IOException {
        return getCourses(getFilePath(major), major);
    }    

	private String getFilePath(String major) {
		String recordsFolderRelativePath = this.pathProvider.getClasses();
		String curriculumPath = recordsFolderRelativePath + "/" + major + ".csv";
		return curriculumPath;
	}	

    private Collection<CurriculumCourse> getCourses(String filePath, String major) throws FileNotFoundException,  IOException {
        File file = new File(filePath);

        if(file.exists()) {
            ArrayList<CurriculumCourse> list = new ArrayList<CurriculumCourse>();
            Reader in = new FileReader(filePath);
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {

                String courseNumber = record.get("Course_Number");
                String courseName = record.get("Course_Name");
                String prereq = record.get("Prereq");

                if(!courseNumber.isEmpty()) {
                    CurriculumCourse course = new CurriculumCourse();
                    course.setCourseNumber(courseNumber);
                    course.setCourseName(courseName);
                    course.setPreRequisite(prereq);
                    list.add(course);
                }
            }
            return list;
        }
        String msg = String.format(
                "Did not find major with file name %s", 
                filePath);
        throw new InvalidMajorException(
            major,
            msg
        );
    }
}
