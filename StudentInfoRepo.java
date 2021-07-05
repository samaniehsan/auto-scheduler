package org.txstate.auto_batcher;

import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * StudentInfoRepo.java : Will read through all files and add them into a single unit
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentInfoRepo
{
	private Map<NameTuple, Long> repository = new HashMap<NameTuple, Long>();
	private File[] listOfFiles;

	public StudentInfoRepo(File[] listOfFiles){
		this.listOfFiles = listOfFiles;

	}

	/**
	 * obtainJSON : Will get JSON object and send to addToRepo
	 * @param N/A
	 * @return N/A
	 * @exception FileNotFoundException, IOException, ParseException
	 */
	public void obtainJSON(){

		JSONParser jsonParser = new JSONParser();


		for (int i = 0; i < listOfFiles.length; i++) {

        	if (listOfFiles[i].isFile()) {
				
				try (FileReader reader = new FileReader(listOfFiles[i]))
				{
					Object obj = jsonParser.parse(reader);
		 
					JSONObject studentBio = (JSONObject) obj;
					addToRepo(studentBio);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
        	}

        }

	}

	/**
	 * addToRepo : Will break down JSON file and create object
	 * @param JSONObject student
	 * @return N/A
	 * @exception N/A
	 */
	public void addToRepo(JSONObject student){
  		Long year = (Long) student.get("year");  
  		String firstName = (String) student.get("firstName");
		String lastName = (String) student.get("lastName");
		String studentId = (String) student.get("studentId");
  		NameTuple name = new NameTuple(firstName,lastName,studentId);
		repository.put(name,year);
	}

	public Map<NameTuple, Long> getRepo(){
		return repository;
	} 

}

