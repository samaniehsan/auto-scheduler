package org.txstate.auto_scheduler;


import java.text.SimpleDateFormat;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * Creates a new StudentInfo object
 *  Searches in the json files in records using the Student Id
 */


public class StudentInfoRepositoryImpl implements StudentInfoRepository{

	ResourcePathProvider pathProvider;
	public StudentInfoRepositoryImpl(ResourcePathProvider pathProvider) {
		this.pathProvider = pathProvider;
	}

     /**
     * Searches json files in records by studentID
     * If found return StudentInfo object
     * If not found returns null
     * @param studentId
     * @return StudentInfo
     */
    public StudentInfo getInfo(String studentId) {

        String recordsFolderRelativePath = this.pathProvider.getRecords();
        String filePath = recordsFolderRelativePath + "/"+ studentId + ".json";
        
        
        File file = new File(filePath);
        if(!file.exists()) {
            System.err.println("could not find bio file for studentid:"+ studentId);
            return null;
        }
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(file.getAbsoluteFile()));
            
            if(obj != null) {
                JSONObject jsonObject = (JSONObject) obj;
                String Id = (String) jsonObject.get("studentId");

                StudentInfo student = new StudentInfo();
                if (Id.equalsIgnoreCase(studentId)) {
                    student.setStudentId(Id);
                    student.setNameFirst((String) jsonObject.get("firstName"));
                    student.setLastName((String) jsonObject.get("lastName"));
                    String date = (String) jsonObject.get("dateOfBirth");
                    student.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(date));
                    return student;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
