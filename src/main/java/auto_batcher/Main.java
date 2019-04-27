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

public class Main {
	public static void main(String[] args) {
		try {

			MultiStudentScheduleInvoker multiStudentInvoker = null;
			if(args !=null && args.length > 0 ) {
				String autoSchedulerPath = args[0];
				StudentScheduleInvoker invoker = new StudentScheduleInvoker(autoSchedulerPath);
				multiStudentInvoker = new MultiStudentScheduleInvoker(invoker);
			}

			ArrayList<Student> groupedStudents = new ArrayList();

			String newFile = "resources/data/records";

			Invoker invoker = new Invoker(newFile);

			File[] files = invoker.runParser();
			if (files !=null && files.length != 0) {

				StudentInfoRepo studentInfoRepo = new StudentInfoRepo(files);
				studentInfoRepo.obtainJSON();
				StudentGrouper studenGrouper = new StudentGrouper(studentInfoRepo.getRepo());
				groupedStudents = studenGrouper.randomGrouping();

				if(multiStudentInvoker != null ) { 
					multiStudentInvoker.scheduleAll(groupedStudents);
				}
			}

			for(Student s : groupedStudents){
				System.out.println(s.getFirstName()+" "+s.getLastName()+" "+s.getYear());
			}

		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}
