package org.txstate.auto_batcher;

import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.util.Collection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.*;
import java.util.Collections;

public class StudentGrouper
{
	private Map<FirstLastName, Long> repository;
	private Random random = new Random();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	List<FirstLastName> keys;

	public StudentGrouper(Map<FirstLastName, Long> repository){
		this.repository = repository;
	}

	public boolean isDuplicate(Student student) {

		for(Student s : studentList){

			if(s.getFirstName() == student.getFirstName() && s.getLastName() == student.getLastName() && s.getYear() == student.getYear()){

				return true;
			}

		}

		return false;


    }

	public ArrayList<Student> randomGrouping(){

		Student student;
		keys = new ArrayList<FirstLastName>(repository.keySet());

		for(int i = 0; i < repository.size(); i++){

			do{
				FirstLastName randomKey = keys.get(random.nextInt(keys.size()));
				Long value = repository.get(randomKey);
				student = new Student(randomKey, value);

			}while(isDuplicate(student) == true && !studentList.isEmpty());

			studentList.add(student);
		}

		studentList = studentList.stream().sorted((p1, p2)->p2.getYear().compareTo(p1.getYear())).collect(Collectors.toCollection(ArrayList::new));
		return studentList;
	}
	
}

