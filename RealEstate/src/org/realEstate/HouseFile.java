package org.realEstate;

import java.io.*;

public class HouseFile {

	private static BufferedReader readFile;
	private static PrintWriter writeFile;
	private static boolean readFileOpen = false;
	private static boolean writeFileOpen = false;
	
	// Holds "next" line from file
	private static String readString =""; 
	
	// Equals null if at end of file
	public static void reset() throws IOException
	
	// Reset file for reading
	{
	if (readFileOpen) readFile.close();
	if (writeFileOpen) writeFile.close();
	
	File file=new File("houses.dat");
	
	//Creates a new file called houses.dat, if there is no such file existing.
	if(!(file.exists())){
		file.createNewFile();
	}
	
	//Reads the file
	readFile = new BufferedReader(new FileReader("houses.dat"));
	readFileOpen = true;
	readString = readFile.readLine();
	}
	
	// Reset file for writing
	public static void rewrite() throws IOException
	{
	if (readFileOpen) readFile.close();
	if (writeFileOpen) writeFile.close();
	writeFile = new PrintWriter(new FileWriter("houses.dat"));
	writeFileOpen = true;
	}
	

	// Returns true if file open for reading and there is still more house
	// information available in it
	public static boolean moreHouses()
	{
	if (!readFileOpen || (readString == null))
	return false;
	else return true;
	}
	

	// Gets and returns house information from the house info file
	public static ListHouse getNextHouse() throws IOException
	{
	String lastName = "xxxxx";
	String firstName = "xxxxx";
	int lotNumber = 0;
	int price = 0;
	int squareFeet = 0;
	int bedRooms =0;
	
	lastName = readString;
	firstName = readFile.readLine();
	lotNumber = Integer.parseInt(readFile.readLine());
	price = Integer.parseInt(readFile.readLine());
	squareFeet = Integer.parseInt(readFile.readLine());
	bedRooms = Integer.parseInt(readFile.readLine());
	
	readString = readFile.readLine();
	ListHouse house = new ListHouse(lastName, firstName, lotNumber, price,	squareFeet, bedRooms);
	return house;
	}
	

	// Puts parameter house information into the house info file
	public static void putToFile(ListHouse house) throws IOException
	{
	writeFile.println(house.lastName());
	writeFile.println(house.firstName());
	writeFile.println(house.lotNumber());
	writeFile.println(house.price());
	writeFile.println(house.squareFeet());
	writeFile.println(house.bedRooms());
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
