package org.txstate.auto_batcher;

import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
    	JSONParser jsonParser = new JSONParser();
    	JSONArray allStudentsList;
    	String fileName;
    	File folder = new File("/auto-scheduler/src/main/resources/data/records");
    	File[] listOfFiles = folder.listFiles();


    	for (int i = 0; i < listOfFiles.length; i++) {

        	if (listOfFiles[i].isFile()) {
	            fileName = listOfFiles[i].getName();
	            // String basename = FilenameUtils.getBaseName(fileName);
        	}

	        try (FileReader reader = new FileReader(listOfFiles[i]))
	        {
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray studentList = (JSONArray) obj;
	            // System.out.println(studentList);
	             
	            for(JSONObject student : studentList){

	            	parseStudentObject(student, fileName);
	            	
	            	//add to allStudentsList

	            }
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }


        }

    }
 
    private static void parseStudentObject(JSONObject student, String fileName)
    {
        JSONObject studentObject = (JSONObject) student.get(fileName);
         //test to see if it 
        String year = (String) studentObject.get("year");   
        System.out.println(year);
         
    }
}

