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
        JSONParser parser = new JSONParser();
        File folder = new File(recordsFolderRelativePath);
        File[] listOfFiles = folder.listFiles();
        
        for (File file : listOfFiles) {
            System.out.println("file:" + file.getName());
            if ((file.isFile()) && (file.getName().contains("json"))) {
                try {
                    Object obj = parser.parse(new FileReader(file.getAbsoluteFile()));
                    
                    if(obj != null) {
                        JSONObject jsonObject = (JSONObject) obj;
                        String Id = (String) jsonObject.get("studentId");
                        
                        System.out.println("studentid" + Id);
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
            }
        }
        return null;
    }

}
