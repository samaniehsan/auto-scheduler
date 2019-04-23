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

public class StudentInfoRepo
{
	private Map<FirstLastName, Long> repository = new HashMap<FirstLastName, Long>();
	private File[] listOfFiles;

	public StudentInfoRepo(File[] listOfFiles){
		this.listOfFiles = listOfFiles;

	}

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

	public void addToRepo(JSONObject student){
  		Long year = (Long) student.get("year");  
  		String firstName = (String) student.get("firstName");
  		String lastName = (String) student.get("lastName");
  		FirstLastName name = new FirstLastName(firstName,lastName);
		repository.put(name,year);
	}

	public Map<FirstLastName, Long> getRepo(){
		return repository;
	} 

}

