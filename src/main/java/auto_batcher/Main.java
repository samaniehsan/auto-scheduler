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

public class Main
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
		try {
			runParser();
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private static void runParser() throws ParseException {
		JSONParser jsonParser = new JSONParser();
    	JSONArray allStudentsList;
    	String fileName;
    	File folder = new File("resources/data/records");
		if(folder == null ) {
			return;
		}

		File[] listOfFiles = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".json");
			}
		});

		if(listOfFiles == null) {
			return;
		}

    	for (int i = 0; i < listOfFiles.length; i++) {

        	if (listOfFiles[i].isFile()) {
				fileName = listOfFiles[i].getName();
				
				try (FileReader reader = new FileReader(listOfFiles[i]))
				{
					Object obj = jsonParser.parse(reader);
		 
					JSONObject studentBio = (JSONObject) obj;
					parseStudentObject(studentBio);
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
 
    private static void parseStudentObject(JSONObject student)
    {
        Long year = (Long) student.get("year");   
        System.out.println(year);
         
    }
}

