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

public class Student
{
	private FirstLastName name;
	private Long year;

	public Student(FirstLastName name, Long year){
		this.name = name;
		this.year = year;
	}
	
	public String getFirstName(){
		return name.getFirstName();
	}

	public String getLastName(){
		return name.getLastName();
	}

	public Long getYear(){
		return year;
	}



}

