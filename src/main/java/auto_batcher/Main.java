package org.txstate.auto_batcher;

import java.io.*;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World Auto Batcher!" );
        printFolders();
    }    

    public static void printFolders() {
        File folder = new File("./resources/data/records");
        if( folder != null) {
            File[] listOfFiles = folder.listFiles();
            if(listOfFiles != null ) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && listOfFiles[i] != null) {
                      System.out.println("File " + listOfFiles[i].getName());
                    } else if (listOfFiles[i].isDirectory()) {
                      System.out.println("Directory " + listOfFiles[i].getName());
                    }
                  }
            }
        }        
    }
}
