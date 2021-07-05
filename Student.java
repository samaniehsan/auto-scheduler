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
 * Student.java : Will create a Student object that stores student data and Year
 * @param N/A
 * @return N/A
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class Student extends NameTuple
{
	private Long year;

	/**
	 * Student : Constructor
	 * @param NameTuple nameTuple, Long year
	 * @return N/A
	 * @exception N/A
	 */
	public Student(NameTuple nameTuple, Long year) {
		super(nameTuple);
		this.year = year;
	}

	/**
	 * getYear : Getter
	 * @param N/A
	 * @return year
	 * @exception N/A
	 */
	public Long getYear(){
		return year;
	}
}

