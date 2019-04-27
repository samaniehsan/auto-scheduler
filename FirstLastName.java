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

public class FirstLastName
{
	private String firstName;
	private String lastName;
	private String id;

	FirstLastName(String firstName, String lastName, String id){
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	public String getID(){
		return this.id;
	}
}

