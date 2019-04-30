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

public class Student extends NameTuple
{
	private Long year;

	public Student(NameTuple nameTuple, Long year) {
		super(nameTuple);
		this.year = year;
	}

	public Long getYear(){
		return year;
	}
}

