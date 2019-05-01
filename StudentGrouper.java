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
/**
 * StudentGrouper.java : Will group students by year
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class StudentGrouper
{
	private Map<NameTuple, Long> repository;
	private Random random = new Random();
	private ArrayList<Student> studentList = new ArrayList<Student>();
	List<NameTuple> keys;

	public StudentGrouper(Map<NameTuple, Long> repository){
		this.repository = repository;
	}

	/**
	 * Student : check is a student has been grouped already
	 * @param Student student
	 * @return Boolean
	 * @exception N/A
	 */
	public boolean isDuplicate(Student student) {

		for(Student s : studentList){

			if(s.getFirstName() == student.getFirstName() && s.getLastName() == student.getLastName() && s.getYear() == student.getYear()){

				return true;
			}

		}

		return false;


    }
	/**
	 * randomGrouping : Will group students according to year
	 * @param N/A
	 * @return studentList
	 * @exception N/A
	 */
	public ArrayList<Student> randomGrouping(){

		Student student;
		keys = new ArrayList<NameTuple>(repository.keySet());

		for(int i = 0; i < repository.size(); i++){

			do{
				NameTuple randomKey = keys.get(random.nextInt(keys.size()));
				Long value = repository.get(randomKey);
				student = new Student(randomKey, value);

			}while(isDuplicate(student) == true && !studentList.isEmpty());

			studentList.add(student);
		}

		studentList = studentList.stream().sorted((p1, p2)->p2.getYear().compareTo(p1.getYear())).collect(Collectors.toCollection(ArrayList::new));
		return studentList;
	}
	
}

