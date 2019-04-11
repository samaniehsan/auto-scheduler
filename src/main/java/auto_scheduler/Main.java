package org.txstate.auto_scheduler;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.*;
import org.apache.commons.csv.CSVFormat;

public class Main {

	public Main () {
	}

	private void test2() {
		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
	}
	public void test() throws FileNotFoundException, IOException {
		System.out.println("Ehsan Current Working Directory = " +
        System.getProperty("user.dir"));
		URL url = getClass().getResource("/data/records/a12345679.json");

		if(url == null ) {
			System.out.println("url is null");
		}

		ClassLoader cl = getClass().getClassLoader();
        File file = new File(url.getFile());
		String fileName = url.getFile();
		
		System.out.println("fileName:" + fileName);


		FileInputStream fis = new FileInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
	 
		System.out.println("Reading File line by line using BufferedReader");
	 
		String line = reader.readLine();
		while(line != null){
			System.out.println(line);
			line = reader.readLine();
		}          

	}
	public static void main(String[] args) {
		
		try {
			Main main = new Main();
			//main.test();
			main.test2();
	
			// OperationContextParser parser = new OperationContextParser();
			// OperationContext opContext = parser.getOperationContext(args);
			
			// if(opContext == null)
			// 	printUsage();
			// else {
			// 	OperationServiceFactory factory = new OperationServiceFactory();
			// 	factory.get(opContext).execute(opContext);
			// }
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}	
	
	
	private static void printUsage() {
		System.out.println("java org.txstate.auto_scheduler usage");
		System.out.println("java org.txstate.auto_scheduler --schedule AXYZID");
		System.out.println("java org.txstate.auto_scheduler --peek AXYZID");
		System.out.println("java org.txstate.auto_scheduler --select AXYZID Set1");
		System.out.println("java org.txstate.auto_scheduler --cancel AXYZID Set1");
	}
}
