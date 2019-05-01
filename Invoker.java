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
 * Invoker.java : Will gather all .json files and store them as one file
 * @param N/A
 * @return listOfFiles
 * @exception N/A
 * @version 1.0
 * @since   5-2-2019
 */
public class Invoker {
	private String newFile;

	public Invoker(String newFile) {
		this.newFile = newFile;
	}

	/**
	 * Invoker.java : Will parse folder of files
	 * @param N/A
	 * @return listOfFiles
	 * @exception ParseException
	 */
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
