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

public class NameTuple
{
	private String firstName;
	private String lastName;
	private String studentId;

	public NameTuple(String firstName, String lastName, String studentId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentId = studentId;
	}
	public NameTuple(NameTuple tuple){
		this(tuple.firstName,tuple.lastName, tuple.studentId);
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	
	public String getStudentId(){
		return studentId;
	}
}
