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
 * NameTuple.java : Will create a NameTuple object that stores student data
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class NameTuple
{
	private String firstName;
	private String lastName;
	private String studentId;

	/**
	 * NameTuple.java : Constructor
	 * @param String firstName, String lastName, String studentId
	 * @return N/A
	 * @exception N/A
	 */
	public NameTuple(String firstName, String lastName, String studentId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}


	/**
	 * NameTuple.java : Constructor
	 * @param String firstName, String lastName, String studentId
	 * @return N/A
	 * @exception N/A
	 * @since   5-2-2019
	 */
	public NameTuple(NameTuple tuple){
		this(tuple.firstName,tuple.lastName, tuple.studentId);
	}

	/**
	 * getFirstName : Getter
	 * @param N/A
	 * @return firstName
	 * @exception N/A
	 * @since   5-2-2019
	 */
	public String getFirstName(){
		return firstName;
	}

	/**
	 * getLastName : Constructor
	 * @param N/Av
	 * @return lastName
	 * @exception N/A
	 * @since   5-2-2019
	 */
	public String getLastName(){
		return lastName;
	}

	/**
	 * getStudentId : Constructor
	 * @param N/A
	 * @return studentId
	 * @exception N/A
	 * @since   5-2-2019
	 */
	public String getStudentId(){ return studentId; }
}
