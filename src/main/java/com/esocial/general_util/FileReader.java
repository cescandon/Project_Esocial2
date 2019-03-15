package com.esocial.general_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class FileReader {
	
	static final File WEB_ROOT = new File("./ServerLocal/");
	public static final String DEFAULT_FILE = "index.html";
    public static final String FILE_NOT_FOUND = "404.html";
    public static final String METHOD_NOT_SUPPORTED = "not_supported.html"; 
	
	public static void ReadFile()
	{
		File file = new File(WEB_ROOT, METHOD_NOT_SUPPORTED);
        int fileLength = (int) file.length();

        byte[] fileData = readFileData(file, fileLength);
        String fileString = new String(fileData);
        
        System.out.println(fileString);
	}
	
	
	private static byte[] readFileData(File file, int fileLength) {
        FileInputStream fileIn = null;
        byte[] fileData = new byte[fileLength];

        try {
            fileIn = new FileInputStream(file);
            fileIn.read(fileData);
        } catch(IOException ioe){
        	System.out.println("Error reading file: " + ioe.getMessage());
        }finally {
        	try {
                if (fileIn != null) 
                    fileIn.close();
        	}catch(Exception e) {
        		System.out.println("Error closing file: " + e.getMessage());
        	}
        }
        return fileData;
	}
}

class OutputStreamDemo {
	   public static void testFile() {
	      try {
	         // create a new output stream
	         OutputStream os = new FileOutputStream("test.txt");

	         // craete a new input stream
	         InputStream is = new FileInputStream("test.txt");

	         // write something
	         os.write('A');

	         // flush the stream but it does nothing
	         os.flush();

	         // write something else
	         os.write('B');

	         // read what we wrote
	         System.out.println("" + is.available());
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	   }
	}
