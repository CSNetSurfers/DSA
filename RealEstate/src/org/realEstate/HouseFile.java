/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.realEstate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class HouseFile {
    
  
    
        private static BufferedReader readFile;
	private static PrintWriter writeFile;
	private static boolean readFileOpen = false;
	private static boolean writeFileOpen = false;
	
	// Holds "next" line from file
	private static String line =""; 
	
	// Equals null if at end of file
	public static void reset() throws IOException
	// Reset file for reading
	{
	if (readFileOpen) readFile.close();
	if (writeFileOpen) writeFile.close();
	
	File file=new File("houses.txt");
	
	//Creates a new file called houses.dat, if there is no such file existing.
	if(!(file.exists())){
		file.createNewFile();
	}
	
	//Reads the file
	readFile = new BufferedReader(new FileReader("houses.txt"));
	readFileOpen = true;
	line = readFile.readLine();
	}
	
	// Reset file for writing
	public static void rewrite() throws IOException
	{
	if (readFileOpen) readFile.close();
	if (writeFileOpen) writeFile.close();
	writeFile = new PrintWriter(new FileWriter("houses.txt"));
	writeFileOpen = true;
	}
	

	// Returns true if file open for reading and there is still more house
	// information available in it
	public static boolean moreHouses()
	{
	if (!readFileOpen || (line == null))
	return false;
	else return true;
	}
	

	// Gets and returns house information from the house info file
	public static ListHouse getNextHouse() throws IOException
	{
	int lotNumber = 0;
	String firstName = "";
	String lastName = "";
	int price = 0;
	int squareFeet = 0;
	int bedRooms =0;
	lotNumber = Integer.parseInt(line);
        firstName = readFile.readLine();
        lastName = readFile.readLine();
	price = Integer.parseInt(readFile.readLine());
	squareFeet = Integer.parseInt(readFile.readLine());
	bedRooms = Integer.parseInt(readFile.readLine());
	line = readFile.readLine();
	ListHouse house = new ListHouse(lotNumber, firstName, lastName, price,
	squareFeet, bedRooms);
	return house;
	}
	

	// Puts parameter house information into the house info file
	public static void writeToFile(ListHouse house) throws IOException
	{
        writeFile.println(house.getLotNumber());    
	writeFile.println(house.getFirstName());
	writeFile.println(house.getLastName());
	writeFile.println(house.getPrice());
	writeFile.println(house.getSquareFeet());
	writeFile.println(house.getBedRooms());
	}
	

	// Closes house info file
	public static void close() throws IOException
	{
	if (readFileOpen) readFile.close();
	if (writeFileOpen) writeFile.close();
	readFileOpen = false;
	writeFileOpen = false;
	}
}
    
       

