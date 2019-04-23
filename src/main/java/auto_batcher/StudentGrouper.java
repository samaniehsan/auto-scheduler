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

public class StudentGrouper
{
	private Map<FirstLastName, Long> repository;
	private Random random = new Random();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	List<FirstLastName> keys;

	public StudentGrouper(Map<FirstLastName, Long> repository){
		this.repository = repository;
	}

	public void randomGrouping(){

		keys = new ArrayList<FirstLastName>(repository.keySet());

		for(int i = 0; i < repository.size(); i++){
			FirstLastName randomKey = keys.get(random.nextInt(keys.size()));
			Long value = repository.get(randomKey);
			Student student = new Student(randomKey, value);
			studentList.add(student);
		}

	}

	public ArrayList<Student> getStudentList(){
		return studentList;
	}
	
}

