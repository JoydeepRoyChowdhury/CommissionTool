package com.simpsoft.salesCommission.app.XMLReader;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteXMLFile {
	
	public static void main( String[] args )
	   {	
	      try{
	    	
	    	 String content = new String(Files.readAllBytes(Paths.get("WebContent/WEB-INF/resources/XMLFile/employee.xml")));
		     System.out.println(content);
	        //Specify the file name and path here
	    	File file =new File("WebContent/WEB-INF/resources/XMLFile/file.xml");

	    	/* This logic is to create the file if the
	    	 * file is not already present
	    	 */
	     /*	if(!file.exists()){
	    	   file.createNewFile();
	    	} */

	    	//Here true is to append the content to file
	    	FileWriter fw = new FileWriter(file,true);
	    	//BufferedWriter writer give better performance
	    	BufferedWriter bw = new BufferedWriter(fw);
	    	bw.write(content);
	    	//Closing BufferedWriter Stream
	    	bw.close();

		System.out.println("Data successfully appended at the end of file");

	      }catch(IOException ioe){
	         System.out.println("Exception occurred:");
	    	 ioe.printStackTrace();
	       }
	      
	    //Method to delete the content of a file
		/*	PrintWriter pw = new PrintWriter("WebContent/WEB-INF/resources/XMLFile/file.xml");
			pw.close(); */
	   }
	
}