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

public class Invoker
{
	private String newFile;

	public Invoker(String newFile){
		this.newFile = newFile;
	}

	public File[] runParser() throws ParseException {

    	File folder = new File(newFile);
		File[] listOfFiles = folder.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".json");
			}
		});
		return listOfFiles;

    }

}

